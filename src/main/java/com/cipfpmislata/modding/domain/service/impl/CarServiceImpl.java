package com.cipfpmislata.modding.domain.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cipfpmislata.modding.domain.model.Car;
import com.cipfpmislata.modding.domain.model.Modification;
import com.cipfpmislata.modding.domain.persistance.CarRepository;
import com.cipfpmislata.modding.domain.persistance.ModificationRepository;
import com.cipfpmislata.modding.domain.persistance.OwnerRepository;
import com.cipfpmislata.modding.domain.service.CarService;
import com.cipfpmislata.modding.exception.ResourceNotFoundException;

@Service
public class CarServiceImpl implements CarService{
    @Autowired
    CarRepository carRepository;

    @Autowired
    OwnerRepository ownerRepository;

    @Autowired
    ModificationRepository modificationRepository;

    @Override
    public List<Car> getAll(){
        return carRepository.getAll(null,null);
    }

    @Override
    public List<Car> getAll(int page, int pageSize){
        return carRepository.getAll(page,pageSize);
    }

    @Override
    public long getTotalNumberOfRecords(){
        return carRepository.getTotalNumberOfRecords();
    }

    @Override
    public Car findById(int id){
        return carRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Coche no encontrado con el id: " + id));
    }

    @Override
    public Car save(Car car, int ownerId, List<Integer> modificationIdList){
        car.setOwner(ownerRepository.findById(ownerId).orElseThrow(() -> new ResourceNotFoundException("Propietario no encontrado con el id: " + ownerId)));
        List<Modification> modifications = modificationIdList.stream()
                                                                .map(modificationId -> modificationRepository.findById(modificationId).orElseThrow(() -> new ResourceNotFoundException("Modificacion no encontrado con el id: " + modificationId)))
                                                                .toList();
        car.setModifications(modifications);
        Optional<Car> carResult = carRepository.save(car);
        return carResult.orElseThrow(() -> new ResourceNotFoundException("Coche no encontrado con el id: " + carResult.get().getId()));
    }
}
