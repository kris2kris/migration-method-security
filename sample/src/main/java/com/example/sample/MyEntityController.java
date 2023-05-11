package com.example.sample;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/entities")
public class MyEntityController {

    private final MyEntittyService myEntittyService;

    public MyEntityController(MyEntittyService myEntittyService) {
        this.myEntittyService = myEntittyService;
    }

    @GetMapping
    public List findAll() {
        return myEntittyService.findAll("").collect(Collectors.toList());
    }
}
