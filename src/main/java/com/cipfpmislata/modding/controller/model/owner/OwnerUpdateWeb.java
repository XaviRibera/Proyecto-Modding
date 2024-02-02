package com.cipfpmislata.modding.controller.model.owner;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class OwnerUpdateWeb {
    String name;
    String address;
    int phone;
}