package com.cipfpmislata.modding.controller.mapper;

import com.cipfpmislata.modding.controller.model.owner.OwnerDetailWeb;
import com.cipfpmislata.modding.controller.model.owner.OwnerListWeb;
import com.cipfpmislata.modding.domain.model.Owner;

public class OwnerMapperController {
    public static OwnerListWeb toOwnerListWeb(Owner owner){
        if(owner == null){
            return null;
        }

        OwnerListWeb ownerListWeb = new OwnerListWeb();

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
}
