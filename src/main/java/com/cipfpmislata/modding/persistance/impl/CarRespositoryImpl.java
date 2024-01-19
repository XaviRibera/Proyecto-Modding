package com.cipfpmislata.modding.persistance.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cipfpmislata.modding.domain.model.Car;
import com.cipfpmislata.modding.domain.persistance.CarRepository;
import com.cipfpmislata.modding.persistance.DAO.CarDAO;
import com.cipfpmislata.modding.persistance.mapper.CarMapperPersistance;
import com.cipfpmislata.modding.persistance.model.CarEntity;

@Repository
public class CarRespositoryImpl implements CarRepository{
    @Autowired
    CarDAO carDAO;

    @Override
    public List<Car> getAll(){
        List<CarEntity> carsEntities = carDAO.findAll();

        List<Car> cars = carsEntities.stream()
                    .map(carEntity -> CarMapperPersistance.toCar(carEntity))
                    .toList();
        
        return cars;
    }
}
