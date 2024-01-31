package com.cipfpmislata.modding.domain.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cipfpmislata.modding.domain.model.Owner;
import com.cipfpmislata.modding.domain.persistance.OwnerRepository;
import com.cipfpmislata.modding.domain.service.OwnerService;
import com.cipfpmislata.modding.exception.ResourceNotFoundException;

@Service
public class OwnerServiceImpl implements OwnerService{

    @Autowired
    private OwnerRepository ownerRepository;

    @Override
    public List<Owner> getAll(){
        return ownerRepository.getAll();
    }

    @Override
    public Owner findById(int id){
        return ownerRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Pelicula no encontrado con el titulo: " + id));
    }
}
