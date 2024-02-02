package com.camila.crudspringboot.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auto")
public class AutoController {

    @GetMapping
    public ResponseEntity searchAuto() {
        return ResponseEntity.ok("Found it!");
    }
}
