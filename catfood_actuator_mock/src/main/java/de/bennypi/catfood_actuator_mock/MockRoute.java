package de.bennypi.catfood_actuator_mock;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MockRoute {

    private Log LOG = LogFactory.getLog(MockRoute.class);

    @GetMapping("/food")
    public void giveFood(){
        LOG.info("Received food request");
    }
}
