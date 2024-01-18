package com.cipfpmislata.modding.persistance.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "propietario")
@Data
@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
public class OwnerEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_propietario")
    int id;

    @Column(name = "nombre")
    String name;

    @Column(name = "direccion")
    String address;

    @Column(name = "telefono")
    int phone;
}
