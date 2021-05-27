package com.study.service.ribbon.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Service
public class HelloService {
	
	@Autowired
	RestTemplate restTemplate;

	@HystrixCommand(fallbackMethod = "helloError")
	public String hello(String name) {
		return restTemplate.getForObject("http://service-hello/hello?name=" + name, String.class);
	}

    public String helloError(String name) {
        return "hello " + name + ", Get info error!";
    }
}
