package com.schoen.hikingthrulife.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


@RestController
public class HelloWorldController {

    private static final Logger LOGGER = LoggerFactory.getLogger(HelloWorldController.class);

    @GetMapping("/")
    public String helloWorld() {
        return "Hello World";
    }

    @GetMapping("/react")
    public String getReactApp() {
        return new RestTemplate().getForEntity("https://hiking-thru-life-react.s3-us-west-2.amazonaws.com/index.html", String.class).getBody();
    }
}
