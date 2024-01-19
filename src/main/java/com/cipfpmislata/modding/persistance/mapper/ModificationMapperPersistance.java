package com.cipfpmislata.modding.persistance.mapper;

import com.cipfpmislata.modding.domain.model.Modification;
import com.cipfpmislata.modding.persistance.model.ModificationEntity;

public class ModificationMapperPersistance {
    public static Modification toModification(ModificationEntity modificationEntity){
        if(modificationEntity == null){
            return null;
        }

        Modification modification = new Modification();

        modification.setId(modificationEntity.getId());
        modification.setName(modificationEntity.getName());
        modification.setSpeed(modificationEntity.getSpeed());

        return modification;
    }
}
