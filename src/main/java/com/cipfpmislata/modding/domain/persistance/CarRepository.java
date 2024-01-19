package com.cipfpmislata.modding.domain.persistance;

import java.util.List;

import com.cipfpmislata.modding.domain.model.Car;

public interface CarRepository {
    List<Car> getAll();
}
