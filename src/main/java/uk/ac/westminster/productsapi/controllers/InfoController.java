package uk.ac.westminster.productsapi.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class InfoController {

    @GetMapping("/info")
    public String getInfo(){
        return "This application is about REST API Endpoints";
    }


}
