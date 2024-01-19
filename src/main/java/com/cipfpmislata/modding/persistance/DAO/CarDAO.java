package com.cipfpmislata.modding.persistance.DAO;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cipfpmislata.modding.persistance.model.CarEntity;

@Repository
public interface CarDAO extends JpaRepository<CarEntity,Integer>{
    List<CarEntity> findAll();
}
