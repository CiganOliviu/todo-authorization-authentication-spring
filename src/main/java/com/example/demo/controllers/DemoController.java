package com.example.demo.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/app-health-testing")
public class DemoController {

    @GetMapping
    public ResponseEntity<String> getString() {
        return ResponseEntity.ok("The app is healthy!");
    }
}
