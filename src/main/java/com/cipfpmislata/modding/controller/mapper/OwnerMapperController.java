package com.cipfpmislata.modding.controller.mapper;

import com.cipfpmislata.modding.controller.model.owner.OwnerCreateWeb;
import com.cipfpmislata.modding.controller.model.owner.OwnerDetailWeb;
import com.cipfpmislata.modding.controller.model.owner.OwnerListWeb;
import com.cipfpmislata.modding.controller.model.owner.OwnerUpdateWeb;
import com.cipfpmislata.modding.domain.model.Owner;

public class OwnerMapperController {
    public static OwnerListWeb toOwnerListWeb(Owner owner){
        if(owner == null){
            return null;
        }

        OwnerListWeb ownerListWeb = new OwnerListWeb();

        ownerListWeb.setId(owner.getId());
        ownerListWeb.setName(owner.getName());
        ownerListWeb.setPhone(owner.getPhone());

        return ownerListWeb;
    }

    public static OwnerDetailWeb toOwnerDetailWeb(Owner owner){
        if(owner == null){
            return null;
        }

        OwnerDetailWeb ownerDetailWeb = new OwnerDetailWeb();

        ownerDetailWeb.setId(owner.getId());
        ownerDetailWeb.setName(owner.getName());
        ownerDetailWeb.setAddress(owner.getAddress());
        ownerDetailWeb.setPhone(owner.getPhone());

        return ownerDetailWeb;
    }

    public static Owner toOwner(OwnerCreateWeb ownerCreateWeb){
        if(ownerCreateWeb == null){
            return null;
        }

        Owner owner = new Owner();

        owner.setName(ownerCreateWeb.getName());
        owner.setAddress(ownerCreateWeb.getAddress());
        owner.setPhone(ownerCreateWeb.getPhone());

        return owner;
    }

    public static Owner toOwner(OwnerUpdateWeb ownerUpdateWeb){
        if(ownerUpdateWeb == null){
            return null;
        }

        Owner owner = new Owner();

        owner.setName(ownerUpdateWeb.getName());
        owner.setAddress(ownerUpdateWeb.getAddress());
        owner.setPhone(ownerUpdateWeb.getPhone());

        return owner;
    }
}
