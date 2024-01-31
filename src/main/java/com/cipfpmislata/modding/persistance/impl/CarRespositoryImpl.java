package com.cipfpmislata.modding.persistance.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import com.cipfpmislata.modding.domain.model.Car;
import com.cipfpmislata.modding.domain.persistance.CarRepository;
import com.cipfpmislata.modding.persistance.DAO.CarDAO;
import com.cipfpmislata.modding.persistance.mapper.CarMapperPersistance;
import com.cipfpmislata.modding.persistance.model.CarEntity;

import jakarta.transaction.Transactional;

@Repository
public class CarRespositoryImpl implements CarRepository{
    @Autowired
    CarDAO carDAO;

    @Override
    public List<Car> getAll(Integer page, Integer pageSize){
        List<CarEntity> carsEntities;
        if(page != null && page > 0){
            Pageable pageable = PageRequest.of(page -1, pageSize);
            carsEntities = carDAO.findAll(pageable).stream().toList();
        }else{
            carsEntities = carDAO.findAll();
        }
        List<Car> cars = carsEntities.stream()
                    .map(carEntity -> CarMapperPersistance.toCar(carEntity))
                    .toList();
        return cars;
    }

    @Override
    public long getTotalNumberOfRecords(){
        return carDAO.count();
    }

    @Override
    public Optional<Car> findById(int id){
        return Optional.of(CarMapperPersistance.toCar(carDAO.findById(id).get()));
    }

    @Override
    @Transactional
    public Optional<Car> save(Car car){
        CarEntity carEntity = CarMapperPersistance.toCarEntity(car);
        return Optional.of(CarMapperPersistance.toCar(carDAO.save(carEntity)));
    }
}
