package ourbusinessproject.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import ourbusinessproject.domaine.Enterprise;
import ourbusinessproject.domaine.Partnership;
import ourbusinessproject.domaine.Project;
import ourbusinessproject.service.EnterpriseProjectService;
import ourbusinessproject.service.PartnershipService;

import java.util.List;

@org.springframework.web.bind.annotation.RestController

public class PartnershipController {
    @Autowired
    private EnterpriseProjectService enterpriseProjectService;
    @Autowired
    private PartnershipService partnershipService;

    public PartnershipController(EnterpriseProjectService enterpriseProjectService, PartnershipService partnershipService) {
        this.enterpriseProjectService = enterpriseProjectService;
        this.partnershipService = partnershipService;
    }
    @RequestMapping(value = "/api/v1/partnerships", method = RequestMethod.POST)
    public Partnership addPartnership(@RequestParam(value ="project_id") long l, @RequestParam(value = "enterprise_id")    long l1) {
        Project project = this.enterpriseProjectService.findProjectById(l);
        Enterprise enterprise = this.enterpriseProjectService.findEnterpriseById(l1);
        Partnership partnership = new Partnership();
        partnership.setEnterprise(enterprise);
        partnership.setProject(project);
        return this.partnershipService.save(partnership);
    }

    @RequestMapping(value = "/api/v1/partnerships/projects/{project_title}/enterprises/{enterprise_name}",
            method = RequestMethod.GET)
    public List<Partnership> getPartnership(@PathVariable String project_title,
                                            @PathVariable String enterprise_name){

        return this.partnershipService.getPartnership(project_title, enterprise_name);
    }

    @RequestMapping(value = "/api/v1/partnerships", method = RequestMethod.GET)
    public List<Partnership> getAllPartnerships(){
        return partnershipService.findAllPartnerships();
    }

    
    @RequestMapping(value = "/api/v1/partnerships/projects/{project_title}",
            method = RequestMethod.GET)
    public List<Partnership> getPartnershipProject(@PathVariable String project_title){

        return partnershipService.getPartnershipsProject(project_title);
    }

    @RequestMapping(value = "/api/v1/partnerships/enterprises/{enterprise_name}",
            method = RequestMethod.GET)
    public List<Partnership> getPartnershipEnterprise(@PathVariable String enterprise_name){

        return partnershipService.getPartnershipEnterprise(enterprise_name);
    }
    @RequestMapping(value = "/api/v1/partnerships/{l}")
    public void removePartnership(@PathVariable long l) {
      Partnership partnership=this.partnershipService.findPartnershipById(l);
      this.partnershipService.remove(partnership);
    }
}
