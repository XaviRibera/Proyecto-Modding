package com.cipfpmislata.modding.persistance.mapper;

import com.cipfpmislata.modding.domain.model.Owner;
import com.cipfpmislata.modding.persistance.model.OwnerEntity;

public class OwnerMapperPersistance {
    public static Owner toOwner(OwnerEntity ownerEntity){
        if(ownerEntity == null){
            return null;
        }

        Owner owner = new Owner();

        owner.setId(ownerEntity.getId());
        owner.setName(ownerEntity.getName());
        owner.setAddress(ownerEntity.getAddress());
        owner.setPhone(ownerEntity.getPhone());

        return owner;
    }

    public static OwnerEntity toOwnerEntity(Owner owner){
        if(owner == null){
            return null;
        }

        OwnerEntity ownerEntity = new OwnerEntity();

        ownerEntity.setId(owner.getId());
        ownerEntity.setName(owner.getName());
        ownerEntity.setAddress(owner.getAddress());
        ownerEntity.setPhone(owner.getPhone());

        return ownerEntity;
    }
}
