package com.cipfpmislata.modding.domain.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cipfpmislata.modding.common.exception.ResourceNotFoundException;
import com.cipfpmislata.modding.domain.model.Car;
import com.cipfpmislata.modding.domain.model.Modification;
import com.cipfpmislata.modding.domain.persistance.CarRepository;
import com.cipfpmislata.modding.domain.persistance.ModificationRepository;
import com.cipfpmislata.modding.domain.persistance.OwnerRepository;
import com.cipfpmislata.modding.domain.service.CarService;
import com.cipfpmislata.modding.domain.service.common.CarServiceCommon;

import jakarta.validation.ValidationException;

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
        List<Car> carList = carRepository.getAll(null,null).stream()
            .map(car -> CarServiceCommon.calculateMaxSpeedWithModification(car))
            .toList();
        return carList;
    }

    @Override
    public List<Car> getAll(int page, int pageSize){
        List<Car> carList = carRepository.getAll(page,pageSize).stream()
            .map(car -> CarServiceCommon.calculateMaxSpeedWithModification(car))
            .toList();
        return carList;
    }

    @Override
    public long getTotalNumberOfRecords(){
        return carRepository.getTotalNumberOfRecords();
    }

    @Override
    public Car findById(int id){
        Car car = carRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Coche no encontrado con el id: " + id));
        return CarServiceCommon.calculateMaxSpeedWithModification(car);
    }

    @Override
    public Car save(Car car, int ownerId, List<Integer> modificationIdList){
        car.setOwner(ownerRepository.findById(ownerId).orElseThrow(() -> new ResourceNotFoundException("Propietario no encontrado con el id: " + ownerId)));
        List<Modification> modifications = modificationIdList.stream()
            .map(modificationId -> modificationRepository.findById(modificationId).orElseThrow(() -> new ResourceNotFoundException("Modificacion no encontrado con el id: " + modificationId)))
            .toList();
        car.setModifications(modifications);
        if(!car.getModifications().isEmpty()){
            if(
                CarServiceCommon.calculateMaxSpeedWithModification(car).getMaxSpeedWithModifications() < 0
            ){
                throw new ValidationException("Las modificaciones le quitan demsiada potencia al coche");
            }
        }
        return CarServiceCommon.calculateMaxSpeedWithModification(carRepository.save(car));
    }

    @Override
    public Car update(Car car, int id, int ownerId, List<Integer> modificationIdList){
        car.setId(id);
        car.setOwner(ownerRepository.findById(ownerId).orElseThrow(() -> new ResourceNotFoundException("Propietario no encontrado con el id: " + ownerId)));
        List<Modification> modifications = modificationIdList.stream()
            .map(modificationId -> modificationRepository.findById(modificationId).orElseThrow(() -> new ResourceNotFoundException("Modificacion no encontrado con el id: " + modificationId)))
            .toList();
        car.setModifications(modifications);
        if(!car.getModifications().isEmpty()){
            if(
                CarServiceCommon.calculateMaxSpeedWithModification(car).getMaxSpeedWithModifications() < 0
            ){
                throw new ValidationException("Las modificaciones le quitan demsiada potencia al coche");
            }
        }
        return CarServiceCommon.calculateMaxSpeedWithModification(carRepository.update(car));
    }

    @Override
    public void delete(int id){
        carRepository.delete(id);
    }
}
