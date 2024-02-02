package com.cipfpmislata.modding.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;

import com.cipfpmislata.modding.controller.mapper.CarMapperController;
import com.cipfpmislata.modding.controller.model.car.CarCreateWeb;
import com.cipfpmislata.modding.controller.model.car.CarDetailWeb;
import com.cipfpmislata.modding.controller.model.car.CarListWeb;
import com.cipfpmislata.modding.controller.model.car.CarUpdateWeb;
import com.cipfpmislata.modding.domain.model.Car;
import com.cipfpmislata.modding.domain.service.CarService;
import com.cipfpmislata.modding.http.response.Response;

@RequestMapping("/cars")
@RestController
public class CarController {
    @Autowired
    CarService carService;

    @Value("${page.size}")
    private int LIMIT;

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("")
    public Response getAll(@RequestParam(required = false) Integer page, @RequestParam(required = false) Integer pageSize){
        pageSize = (pageSize != null)? pageSize : LIMIT;
        List<Car> cars = (page != null)? carService.getAll(page,pageSize):carService.getAll();
        List<CarListWeb> carsListWeb = cars.stream()
                    .map(car -> CarMapperController.toCarListWeb(car))
                    .toList();
        long totalRecords = carService.getTotalNumberOfRecords();
        return Response.builder()
                        .data(carsListWeb)
                        .totalRecords(totalRecords)
                        .build();
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/{id}")
    public Response findById(@PathVariable("id") int id){
        return Response.builder()
                        .data(CarMapperController.toCarDetailWeb(carService.findById(id)))
                        .build();
    }

    @PostMapping("")
    public Response save(@RequestBody CarCreateWeb carCreateWeb){
        CarDetailWeb carDetailWeb = CarMapperController.toCarDetailWeb(carService.save(CarMapperController.toCar(carCreateWeb),carCreateWeb.getOwnerId(),carCreateWeb.getModificationIdList()));

        return Response.builder()
                        .data(carDetailWeb)
                        .build();
    }

    @ResponseStatus(HttpStatus.OK)
    @PutMapping("{id}")
    public Response update(@RequestBody CarUpdateWeb carUpdateWeb, @PathVariable("id") int id){
        CarDetailWeb carDetailWeb = CarMapperController.toCarDetailWeb(carService.update(CarMapperController.toCar(carUpdateWeb), id, carUpdateWeb.getOwnerId(), carUpdateWeb.getModificationIdList()));
        return Response.builder()
                        .data(carDetailWeb)
                        .build();
    }

    @ResponseStatus(HttpStatus.OK)
    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") int id){
        carService.delete(id);
    }
}
