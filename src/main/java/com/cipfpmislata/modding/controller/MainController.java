package com.cipfpmislata.modding.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/mods")
@RestController
public class MainController {
    @ResponseStatus(HttpStatus.OK)
    @GetMapping("")
    public String main(){
        return "FUNCIONA";
    }
}
