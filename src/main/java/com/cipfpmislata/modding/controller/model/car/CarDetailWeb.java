package com.cipfpmislata.modding.controller.model.car;

import java.util.List;

import com.cipfpmislata.modding.controller.model.modification.ModificationListWeb;
import com.cipfpmislata.modding.controller.model.owner.OwnerListWeb;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
public class CarDetailWeb {
    int id;
    String model;
    String brand;
    String maxSpeed;
    OwnerListWeb ownerListWeb;
    List<ModificationListWeb> modifications;
}
