package com.cipfpmislata.modding.domain.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
public class Owner {
    int id;
    String name;
    String address;
    int phone;
}
