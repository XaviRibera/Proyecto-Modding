package com.cipfpmislata.modding.persistance.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.cipfpmislata.modding.domain.model.Modification;
import com.cipfpmislata.modding.domain.persistance.ModificationRepository;
import com.cipfpmislata.modding.persistance.DAO.ModificationDAO;
import com.cipfpmislata.modding.persistance.mapper.ModificationMapperPersistance;
import com.cipfpmislata.modding.persistance.model.ModificationEntity;

@Repository
public class ModificationRespositoryImpl implements ModificationRepository{
    @Autowired
    ModificationDAO modificationDAO;

    @Override
    public List<Modification> getAll(Integer page, Integer pageSize){
        List<ModificationEntity> modificationEntities;
        if(page != null && page > 0){
            Pageable pageable = PageRequest.of(page -1, pageSize);
            modificationEntities = modificationDAO.findAll(pageable).toList();
        }else{
            modificationEntities = modificationDAO.findAll();
        }
        List<Modification> modifications = modificationEntities.stream()
                                                                .map(modificationEntity -> ModificationMapperPersistance.toModification(modificationEntity))
                                                                .toList();
        return modifications;
    }

    @Override
    public long getTotalNumberOfRecords(){
        return modificationDAO.count();
    }

    @Override
    public Optional<Modification> findById(int id){
        return Optional.of(ModificationMapperPersistance.toModification(modificationDAO.findById(id).get()));
    }

    @Override
    @Transactional
    public void delete(int id){
        modificationDAO.deleteById(id);
    }

    @Override
    @Transactional
    public Modification save(Modification modification){
        return ModificationMapperPersistance.toModification(modificationDAO.save(ModificationMapperPersistance.tModificationEntity(modification)));
    }

    @Override
    @Transactional
    public Modification update(Modification modification){
        return ModificationMapperPersistance.toModification(modificationDAO.save(ModificationMapperPersistance.tModificationEntity(modification)));
    }
}
