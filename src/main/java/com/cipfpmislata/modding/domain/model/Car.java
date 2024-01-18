package com.cipfpmislata.modding.domain.model;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
public class Car {
    int id;
    String model;
    String brand;
    int maxSpeed;
    Owner owner;
    List<Modification> modifications;
}
