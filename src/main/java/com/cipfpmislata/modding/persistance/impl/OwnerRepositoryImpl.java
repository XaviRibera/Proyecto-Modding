package com.cipfpmislata.modding.persistance.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
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
    public List<Owner> getAll(Integer page, Integer pageSize){
        List<OwnerEntity> ownerEntities;
        if(page != null && page > 0){
            Pageable pageable = PageRequest.of(page -1, pageSize);
            ownerEntities = ownerDAO.findAll(pageable).stream().toList();
        }else{
            ownerEntities = ownerDAO.findAll();
        }
        return ownerEntities.stream()
                            .map(ownerEntity -> OwnerMapperPersistance.toOwner(ownerEntity))
                            .toList();
    }

    @Override
    public long getTotalNumberOfRecords(){
        return ownerDAO.count();
    }

    @Override
    public Optional<Owner> findById(int id){
        return Optional.of(OwnerMapperPersistance.toOwner(ownerDAO.findById(id).get()));
    }
}
