package ourbusinessproject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ourbusinessproject.service.InitializationService;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;

@Component
@Transactional
public class Bootstrap {
    @Autowired
    private InitializationService initializationService;

    public Bootstrap(InitializationService initializationService) {
        this.initializationService = initializationService;
    }
    @PostConstruct
    public void init() {
        try{
            initializationService.initProjects();
            initializationService.initPartnerships();
        }catch (RuntimeException e){

        }

    }

    public InitializationService getInitializationService() {

        return initializationService;
    }
}
