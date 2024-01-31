package com.cipfpmislata.modding.domain.service;

import java.util.List;

import com.cipfpmislata.modding.domain.model.Car;

public interface CarService {
    List<Car> getAll();
    List<Car> getAll(int page, int pageSize);
    long getTotalNumberOfRecords();
    Car findById(int id);
    Car save(Car car, int ownerId, List<Integer> modificationIdList);
}
