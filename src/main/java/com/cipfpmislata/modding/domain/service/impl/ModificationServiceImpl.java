package com.cipfpmislata.modding.domain.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cipfpmislata.modding.common.exception.ResourceNotFoundException;
import com.cipfpmislata.modding.domain.model.Modification;
import com.cipfpmislata.modding.domain.persistance.ModificationRepository;
import com.cipfpmislata.modding.domain.service.ModificationService;

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

    @Override
    public Modification update(Modification modification, int id){
        modification.setId(id);
        return modificationRepository.update(modification);
    }

    @Override
    public void delete(int id){
        modificationRepository.delete(id);
    }
}
