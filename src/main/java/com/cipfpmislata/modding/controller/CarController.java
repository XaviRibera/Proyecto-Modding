package com.cipfpmislata.modding.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping(CarController.CARS)
@RestController
public class CarController {
    public static final String CARS = "/cars";
}
