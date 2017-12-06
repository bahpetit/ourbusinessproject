package ourbusinessproject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ourbusinessproject.domaine.Enterprise;
import ourbusinessproject.domaine.Partnership;
import ourbusinessproject.domaine.Project;

import javax.transaction.Transactional;
import java.util.List;

@Service
@org.springframework.transaction.annotation.Transactional
public class InitializationService {
    private Project project1E1;
    private Project project1E2;
    private Project project2E1;
    private Enterprise enterprise1;
    private Enterprise enterprise2;
    private Partnership partnershipP1E1WithE2;
    private Partnership partnershipP1E2WithE1;
    private Partnership partnershipP2E1WithE2;

    @Autowired
    private EnterpriseProjectService enterpriseProjectService;
    @Autowired
    private PartnershipService partnershipService;

    public void initProjects() {
        this.project1E1 = new Project();
        project1E1.setTitle("project1E1");
        this.project1E2 = new Project();
        project1E2.setTitle("project1E2");
        this.project2E1 = new Project();
        project2E1.setTitle("project2E1");
        this.enterprise1 = new Enterprise();
        enterprise1.setName("enterprise1");
        enterprise1.setContactEmail("bah@gmail.com");
        enterprise1.setDescription("enterprise1");
        enterprise1.setContactName("enterprise1");
        this.enterprise2 = new Enterprise();
        enterprise2.setName("enterprise1");
        enterprise2.setContactEmail("bah@gmail.com");
        enterprise2.setDescription("enterprise1");
        enterprise2.setContactName("enterprise1");
            this.project1E1.setEnterprise(enterprise1);
            this.project1E2.setEnterprise(enterprise2);
            this.project2E1.setEnterprise(enterprise1);
            this.enterpriseProjectService.save(project1E1);
            this.enterpriseProjectService.save(project1E2);
            this.enterpriseProjectService.save(project2E1);
    }

    public void initPartnerships() {
        this.partnershipP1E2WithE1 = new Partnership();
        this.partnershipP1E2WithE1.setProject(project1E2);
        this.partnershipP1E2WithE1.setEnterprise(enterprise1);
        this.partnershipService.save(partnershipP1E2WithE1);

        this.partnershipP1E1WithE2 = new Partnership();
        this.partnershipP1E1WithE2.setProject(project1E1);
        this.partnershipP1E1WithE2.setEnterprise(enterprise2);
        this.partnershipService.save(partnershipP1E1WithE2);

        this.partnershipP2E1WithE2 = new Partnership();
        this.partnershipP2E1WithE2.setProject(project2E1);
        this.partnershipP2E1WithE2.setEnterprise(enterprise2);
        this.partnershipService.save(partnershipP2E1WithE2);
    }

    public Project getProject1E1() {
        return project1E1;
    }

    public Project getProject1E2() {
        return project1E2;
    }

    public Project getProject2E1() {
        return project2E1;
    }

    public Enterprise getEnterprise1() {
        return enterprise1;
    }

    public Enterprise getEnterprise2() {
        return enterprise2;
    }

    public Partnership getPartnershipP1E1WithE2() {
        return partnershipP1E1WithE2;
    }

    public Partnership getPartnershipP1E2WithE1() {
        return partnershipP1E2WithE1;
    }

    public Partnership getPartnershipP2E1WithE2() {
        return partnershipP2E1WithE2;
    }

}
