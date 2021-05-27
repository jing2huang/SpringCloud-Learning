package com.study.service.feign;

import org.springframework.stereotype.Component;

@Component
public class SchedualServiceHelloHystric implements SchedualServiceHello {

    @Override
    public String sayHelloFromClientOne(String name) {
        return "sorry " + name + ", Get info with some errors!";
    }

}