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
@Table(name = "modificacion")
@Data
@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
public class ModificationEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_modificacion")
    int id;

    @Column(name = "nombre_modificacion")
    String name;

    @Column(name = "velocidad")
    int speed;
}
