package com.cipfpmislata.modding.persistance.DAO;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cipfpmislata.modding.persistance.model.OwnerEntity;

@Repository
public interface OwnerDAO extends JpaRepository<OwnerEntity,Integer> {
    List<OwnerEntity> findAll();
}
