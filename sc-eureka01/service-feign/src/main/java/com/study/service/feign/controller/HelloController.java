package com.study.service.feign.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.study.service.feign.SchedualServiceHello;

@RestController
public class HelloController {

    @Autowired
    SchedualServiceHello serviceHello;

    @GetMapping(value = "/hello")
    public String sayHello(@RequestParam String name) {
        return serviceHello.sayHelloFromClientOne( name );
    }

}