package com.cipfpmislata.modding.persistance.mapper;

import com.cipfpmislata.modding.domain.model.Car;
import com.cipfpmislata.modding.persistance.model.CarEntity;

public class CarMapperPersistance {

    public static Car toCar(CarEntity carEntity){

        if(carEntity == null){
            return null;
        }

        Car car = new Car();

        car.setId(carEntity.getId());
        car.setModel(carEntity.getModel());
        car.setBrand(carEntity.getBrand());
        car.setMaxSpeed(carEntity.getMaxSpeed());
        car.setOwner(OwnerMapperPersistance.toOwner(carEntity.getOwnerEntity()));
        car.setModifications(carEntity.getModifications().stream().map(modificationEntity -> ModificationMapperPersistance.toModification(modificationEntity)).toList());

        return car;
    }
}
