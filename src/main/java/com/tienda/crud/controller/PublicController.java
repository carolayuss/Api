package com.tienda.crud.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Login")
@RequiredArgsConstructor
public class PublicController {
    @GetMapping("/api")
    public String api(){
        return "bienvenido";
    }
}
