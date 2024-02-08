package com.cipfpmislata.modding.domain.model;

import java.util.List;

import jakarta.annotation.Nullable;
import jakarta.validation.constraints.Min;
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

    @Min(value = 0, message = "No puede tener velocidad negativa")
    int maxSpeed;

    @Nullable
    @Min( value = 0, message = "Las modificaciones le quitan demasiada velocidad")
    int maxSpeedWithModifications;

    @Nullable
    Owner owner;

    @Nullable
    List<Modification> modifications;
}
