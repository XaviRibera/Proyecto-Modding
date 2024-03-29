package com.cipfpmislata.modding.persistance.model;

import java.util.List;

import jakarta.persistence.CascadeType;
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
    @Column(name = "id_coche")
    int id;

    @Column(name = "modelo")
    String model;

    @Column(name = "marca")
    String brand;

    @Column(name = "velocidad_maxima")
    int maxSpeed;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.REMOVE, optional = true)
    @JoinColumn(name = "id_propietario", nullable = true)
    OwnerEntity ownerEntity;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(
        name = "coche_modificacion",
        joinColumns = @JoinColumn(name = "id_coche"),
        inverseJoinColumns = @JoinColumn(name = "id_modificacion")
    )
    List<ModificationEntity> modifications;
}
