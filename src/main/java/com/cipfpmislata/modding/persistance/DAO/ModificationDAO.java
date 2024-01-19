package com.cipfpmislata.modding.persistance.DAO;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cipfpmislata.modding.persistance.model.ModificationEntity;

@Repository
public interface ModificationDAO extends JpaRepository<ModificationEntity,Integer>{
    List<ModificationEntity> findAll();
}
