package com.cipfpmislata.modding.persistance.model;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "coche")
@Data
@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
public class CarEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "coche_id")
    int id;

    @Column(name = "modelo")
    String model;

    @Column(name = "marca")
    String brand;

    @Column(name = "velocidad_maxima")
    int maxSpeed;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_propietario")
    OwnerEntity ownerEntity;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
        name = "coche_modificacion",
        joinColumns = @JoinColumn(name = "id_coche"),
        inverseJoinColumns = @JoinColumn(name = "id_modificacion")
    )
    List<CarEntity> modifications;
}
