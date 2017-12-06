package ourbusinessproject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ourbusinessproject.domaine.Enterprise;
import ourbusinessproject.domaine.Project;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class EnterpriseProjectService {
    @PersistenceContext
    private EntityManager entityManager;
    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void save(Project project) {
                Enterprise enterprise = project.getEnterprise();
                if (enterprise != null) {
                    enterprise.addProject(project);
                    this.entityManager.persist(enterprise);
                }
                this.entityManager.persist(project);
    }

    public void save(Enterprise enterprise) {
        if(enterprise != null)
            this.entityManager.persist(enterprise);
    }

    public Project findProjectById(Long anId) {
        return this.entityManager.find(Project.class, anId);
    }

    public Enterprise findEnterpriseById(Long anId) {
        return this.entityManager.find(Enterprise.class, anId);
    }

    public EntityManager getEntityManager() {
        return entityManager;
    }

    public List<Project> findAllProjects() {
        Query query = this.entityManager.createQuery("SELECT p FROM Project p order by p.title asc ");
        return (List<Project>) query.getResultList();
    }

}
