package com.fundamentosplatzi.sprintboot.fundamentos.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class TestController {
    @RequestMapping
    public ResponseEntity<String> function(){
        return new ResponseEntity<>("Hello controller cambio", HttpStatus.OK);
    }
}
