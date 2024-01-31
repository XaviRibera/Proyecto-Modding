package com.cipfpmislata.modding.domain.persistance;

import java.util.List;
import java.util.Optional;

import com.cipfpmislata.modding.domain.model.Car;

public interface CarRepository {
    List<Car> getAll(Integer page, Integer pageSize);
    long getTotalNumberOfRecords();
    Optional<Car> findById(int id);
    Optional<Car> save(Car car);
}
