package com.cipfpmislata.modding.domain.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cipfpmislata.modding.common.exception.ResourceNotFoundException;
import com.cipfpmislata.modding.domain.model.Owner;
import com.cipfpmislata.modding.domain.persistance.OwnerRepository;
import com.cipfpmislata.modding.domain.service.OwnerService;

import static com.cipfpmislata.modding.common.validation.Validation.validate;

@Service
public class OwnerServiceImpl implements OwnerService{

    @Autowired
    private OwnerRepository ownerRepository;

    @Override
    public List<Owner> getAll(){
        return ownerRepository.getAll(null,null);
    }

    @Override
    public List<Owner> getAll(int page, int pageSize){
        return ownerRepository.getAll(page, pageSize);
    }

    @Override
    public long getTotalNumberOfRecords(){
        return ownerRepository.getTotalNumberOfRecords();
    }

    @Override
    public Owner findById(int id){
        return ownerRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Propietario no encontrado con el id: " + id));
    }

    @Override
    public Owner save(Owner owner){
        validate(owner);
        return ownerRepository.save(owner);
    }

    @Override
    public void delete(int id){
        ownerRepository.delete(id);
    }

    @Override
    public Owner update(Owner owner, int id){
        validate(owner);
        owner.setId(id);
        return ownerRepository.update(owner);
    }
}
