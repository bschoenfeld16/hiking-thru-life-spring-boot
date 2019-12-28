package com.schoen.hikingthrulife.controllers;

import com.schoen.hikingthrulife.services.S3Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;


@RestController
public class HelloWorldController {

    private static final Logger LOGGER = LoggerFactory.getLogger(HelloWorldController.class);

    private final S3Service s3Service;

    public HelloWorldController(S3Service s3Service) {
        this.s3Service = s3Service;
    }

    @GetMapping("/")
    public String helloWorld() {
        return "Hello World";
    }

    @GetMapping("/react")
    public String getReactApp() {
        try {
            return s3Service.getS3ObjectContent("hiking-thru-life-react", "index.html");
        } catch (IOException e) {
            LOGGER.error(e.getMessage(), e);
            return null;
        }
    }
}
