package com.study.service.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "service-hello", fallback = SchedualServiceHelloHystric.class)
public interface SchedualServiceHello {

    @GetMapping(value = "/hello")
    String sayHelloFromClientOne(@RequestParam(value = "name") String name);

}
