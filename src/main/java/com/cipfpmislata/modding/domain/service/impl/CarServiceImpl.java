package com.cipfpmislata.modding.domain.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cipfpmislata.modding.domain.model.Car;
import com.cipfpmislata.modding.domain.persistance.CarRepository;
import com.cipfpmislata.modding.domain.service.CarService;

@Service
public class CarServiceImpl implements CarService{
    @Autowired
    CarRepository carRepository;

    @Override
    public List<Car> getAll(){
        return carRepository.getAll();
    }
}
