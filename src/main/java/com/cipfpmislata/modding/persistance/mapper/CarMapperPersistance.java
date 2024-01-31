package com.cipfpmislata.modding.persistance.mapper;

import java.util.List;

import com.cipfpmislata.modding.domain.model.Car;
import com.cipfpmislata.modding.domain.model.Modification;
import com.cipfpmislata.modding.persistance.model.CarEntity;
import com.cipfpmislata.modding.persistance.model.ModificationEntity;

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

    public static CarEntity toCarEntity(Car car){
        if(car == null){
            return null;
        }

        CarEntity carEntity = new CarEntity();

        carEntity.setBrand(car.getBrand());
        carEntity.setModel(car.getModel());
        carEntity.setMaxSpeed(car.getMaxSpeed());
        carEntity.setOwnerEntity(OwnerMapperPersistance.toOwnerEntity(car.getOwner()));
        carEntity.setModifications(mapModificationsToModificationsEntities(car.getModifications()));

        return carEntity;
    }

    private static List<ModificationEntity> mapModificationsToModificationsEntities(List<Modification> modifications){
        return modifications.stream()
                            .map(modification -> ModificationMapperPersistance.tModificationEntity(modification))
                            .toList();
    }
}
