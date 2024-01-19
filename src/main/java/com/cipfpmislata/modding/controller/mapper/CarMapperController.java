package com.cipfpmislata.modding.controller.mapper;

import org.springframework.stereotype.Component;

import com.cipfpmislata.modding.controller.model.car.CarListWeb;
import com.cipfpmislata.modding.domain.model.Car;

@Component
public class CarMapperController {
    
    public static CarListWeb toCarListWeb(Car car){
        CarListWeb carListWeb = new CarListWeb();

        carListWeb.setBrand(car.getBrand());
        carListWeb.setModel(car.getModel());

        return carListWeb;
    }
}
