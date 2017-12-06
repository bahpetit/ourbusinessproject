package ourbusinessproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import ourbusinessproject.domaine.Project;
import ourbusinessproject.service.EnterpriseProjectService;

import java.util.List;

@RestController
public class ProjectController {
    @Autowired
    private EnterpriseProjectService enterpriseProjectService;

    public ProjectController(EnterpriseProjectService enterpriseProjectService) {
        this.enterpriseProjectService = enterpriseProjectService;
    }
    @RequestMapping(value = "/projectsWithEnterprises", method = RequestMethod.GET)
    public  String findAllProjectsWithEnterprises() {
        return this.enterpriseProjectService.findAllProjects().toString();
    }
}
