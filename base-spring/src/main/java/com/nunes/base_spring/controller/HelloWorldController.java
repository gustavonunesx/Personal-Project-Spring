package com.nunes.base_spring.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/hello")
public class HelloWorldController {

//    @GetMapping
//    public String helloWorld(){
//        return "HEllo World";
//    }

//    @GetMapping
//    public ResponseEntity<String> helloWorld() {
//        return ResponseEntity.ok("Hello World");
//
//    }

    @GetMapping("/{id}")
    public ResponseEntity<String> getById(@PathVariable String id){
        return ResponseEntity.ok("Hello World " + id);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public String getParam(@RequestParam(value = "name", required = false) String name){
        return "Hello World " + name;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public String post(@RequestBody String name){
        return "Hello World " + name;
    }

}
