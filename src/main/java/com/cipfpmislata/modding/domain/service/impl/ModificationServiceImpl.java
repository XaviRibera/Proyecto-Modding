package com.cipfpmislata.modding.domain.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cipfpmislata.modding.domain.model.Modification;
import com.cipfpmislata.modding.domain.persistance.ModificationRepository;
import com.cipfpmislata.modding.domain.service.ModificationService;
import com.cipfpmislata.modding.exception.ResourceNotFoundException;

@Service
public class ModificationServiceImpl implements ModificationService{
    @Autowired
    ModificationRepository modificationRepository;

    @Override
    public List<Modification> getAll(){
        return modificationRepository.getAll(null,null);
    }

    @Override
    public List<Modification> getAll(int page, int pageSize){
        return modificationRepository.getAll(page,pageSize);
    }

    @Override
    public long getTotalNumberOfRecords(){
        return modificationRepository.getTotalNumberOfRecords();
    }

    @Override
    public Modification findById(int id){
        return modificationRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Modificacion no encontrado con el id: " + id));
    }

    @Override
    public Modification save(Modification modification){
        return modificationRepository.save(modification);
    }
}
