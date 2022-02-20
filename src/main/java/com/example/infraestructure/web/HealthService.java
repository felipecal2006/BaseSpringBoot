package com.example.infraestructure.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HealthService {
    @GetMapping("/healthService")
    public String salud(){
        return "Ok";
    }

}
