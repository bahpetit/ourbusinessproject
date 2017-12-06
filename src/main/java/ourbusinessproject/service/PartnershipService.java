package ourbusinessproject.service;

import org.springframework.stereotype.Service;
import ourbusinessproject.domaine.Partnership;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class PartnershipService {
    @PersistenceContext
    private EntityManager entityManager;

    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public Partnership save(Partnership partnership) {
        this.entityManager.persist(partnership);
        return partnership;
    }

    public Partnership findPartnershipById(Long id) {
        return this.entityManager.find(Partnership.class, id);
    }

    public void remove(Partnership partnership) {
        Partnership removed= this.entityManager.getReference(Partnership.class, partnership.getId());
        this.entityManager.remove(removed);
    }

    public List<Partnership> findAllPartnerships() {
        Query query = this.entityManager.createQuery("SELECT p FROM Partnership p order by p.creationDate asc ");
        return (List<Partnership>) query.getResultList();
    }

    public List<Partnership> getPartnershipsProject(String project_title) {
        Query query = this.entityManager
                .createQuery("SELECT p FROM Partnership p " +
                        "where p.project.title =:title")
                .setParameter("title", project_title);
        return (List<Partnership>) query.getResultList();
    }

    public List<Partnership> getPartnership(String project_title, String enterprise_name) {

        Query query = this.entityManager
                .createQuery("SELECT p FROM Partnership p " +
                        "where p.enterprise.name =:name and " +
                        "p.project.title =:title")
                .setParameter("name", enterprise_name)
                .setParameter("title", project_title);
        return (List<Partnership>) query.getResultList();
    }

    public List<Partnership> getPartnershipEnterprise(String enterprise_name) {
        Query query = this.entityManager
                .createQuery("SELECT p FROM Partnership p " +
                        "where p.enterprise.name =:name")
                .setParameter("name", enterprise_name);
        return (List<Partnership>) query.getResultList();
    }
}
