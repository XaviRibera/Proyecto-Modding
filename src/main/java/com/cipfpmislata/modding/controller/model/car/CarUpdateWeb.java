package com.cipfpmislata.modding.controller.model.car;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CarUpdateWeb {
    String model;
    String brand;
    int maxSpeed;
    int ownerId;
    List<Integer> modificationIdList;
}