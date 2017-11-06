package de.bennypi.catfood.controller;

import de.bennypi.catfood.actuator_connector.Connector;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@org.springframework.stereotype.Controller
public class Controller {

    private final Connector connector;

    @Autowired
    public Controller(Connector connector) {
        this.connector = connector;
    }

    @GetMapping("/")
    public String index(){
        return "index";
    }

    @PostMapping("/feed")
    public String feed(){
        boolean success = connector.deployFood();
        return null;
    }

}
