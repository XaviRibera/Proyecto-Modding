package com.cipfpmislata.modding.persistance.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cipfpmislata.modding.persistance.mapper.OwnerMapperPersistance;
import com.cipfpmislata.modding.domain.model.Owner;
import com.cipfpmislata.modding.domain.persistance.OwnerRepository;
import com.cipfpmislata.modding.persistance.DAO.OwnerDAO;
import com.cipfpmislata.modding.persistance.model.OwnerEntity;

@Repository
public class OwnerRepositoryImpl implements OwnerRepository{

    @Autowired
    private OwnerDAO ownerDAO;

    @Override
    public List<Owner> getAll(){

        List<OwnerEntity> ownerEntities = ownerDAO.findAll();

        List<Owner> owners = ownerEntities.stream()
                        .map(ownerEntity -> OwnerMapperPersistance.toOwner(ownerEntity))
                        .toList();

        return owners;
    }
}
