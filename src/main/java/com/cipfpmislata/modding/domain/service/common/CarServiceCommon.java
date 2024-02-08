package com.cipfpmislata.modding.domain.service.common;

import com.cipfpmislata.modding.domain.model.Car;
import com.cipfpmislata.modding.domain.model.Modification;

public class CarServiceCommon {
    public static Car calculateMaxSpeedWithModification(Car car){
        if(car.getModifications().isEmpty()){
            return car;
        }
        int maxSpeedWithModifications = 0;
        for (Modification modification : car.getModifications()) {
            maxSpeedWithModifications += modification.getSpeed();
        }
        car.setMaxSpeedWithModifications(car.getMaxSpeed() + maxSpeedWithModifications);
        return car;
    }
}
