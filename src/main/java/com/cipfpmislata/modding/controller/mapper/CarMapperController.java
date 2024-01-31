package com.cipfpmislata.modding.controller.mapper;

import java.util.List;

import org.springframework.stereotype.Component;

import com.cipfpmislata.modding.controller.model.car.CarCreateWeb;
import com.cipfpmislata.modding.controller.model.car.CarDetailWeb;
import com.cipfpmislata.modding.controller.model.car.CarListWeb;
import com.cipfpmislata.modding.controller.model.modification.ModificationListWeb;
import com.cipfpmislata.modding.domain.model.Car;
import com.cipfpmislata.modding.domain.model.Modification;

@Component
public class CarMapperController {
    public static CarListWeb toCarListWeb(Car car){
        if(car == null){
            return null;
        }

        CarListWeb carListWeb = new CarListWeb();

        carListWeb.setBrand(car.getBrand());
        carListWeb.setModel(car.getModel());

        return carListWeb;
    }

    public static CarDetailWeb toCarDetailWeb(Car car){
        if(car == null){
            return null;
        }

        CarDetailWeb carDetailWeb = new CarDetailWeb();

        carDetailWeb.setId(car.getId());
        carDetailWeb.setModel(car.getModel());
        carDetailWeb.setBrand(car.getBrand());
        carDetailWeb.setMaxSpeed(car.getMaxSpeed());
        carDetailWeb.setOwnerListWeb(OwnerMapperController.toOwnerListWeb(car.getOwner()));
        carDetailWeb.setModificationsDetailWeb(mapModificationsToModificationsListWeb(car.getModifications()));


        return carDetailWeb;
    }

    private static List<ModificationListWeb> mapModificationsToModificationsListWeb(List<Modification> modifications){
        return modifications.stream()
                            .map(modification -> ModificationMapperController.toModificationListWeb(modification))
                            .toList();
    }

    public static Car toCar(CarCreateWeb carCreateWeb){
        if(carCreateWeb == null){
            return null;
        }

        Car car = new Car();

        car.setBrand(carCreateWeb.getBrand());
        car.setModel(carCreateWeb.getModel());
        car.setMaxSpeed(carCreateWeb.getMaxSpeed());

        return car;
    }
}
