package com.cipfpmislata.modding.domain.model;

import com.cipfpmislata.modding.common.validation.ValidPhoneNumber;

import jakarta.annotation.Nullable;
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

    @Nullable
    String address;

    @Nullable
    @ValidPhoneNumber
    int phone;
}
