package com.cipfpmislata.modding.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;

import com.cipfpmislata.modding.controller.mapper.CarMapperController;
import com.cipfpmislata.modding.controller.model.car.CarListWeb;
import com.cipfpmislata.modding.domain.model.Car;
import com.cipfpmislata.modding.domain.service.CarService;

@RequestMapping("/cars")
@RestController
public class CarController {
    @Autowired
    CarService carService;

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("")
    public List<CarListWeb> getAll(){
        List<Car> cars = carService.getAll();
        List<CarListWeb> carsListWeb = cars.stream()
                    .map(car -> CarMapperController.toCarListWeb(car))
                    .toList();
        return carsListWeb;
    }
}
