package com.cipfpmislata.modding.controller.model.owner;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
public class OwnerDetailWeb {
    int id;
    String name;
    String address;
    int phone;
}
