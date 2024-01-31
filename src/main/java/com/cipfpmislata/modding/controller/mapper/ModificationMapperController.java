package com.cipfpmislata.modding.controller.mapper;

import org.springframework.stereotype.Component;

import com.cipfpmislata.modding.controller.model.modification.ModificationDetailWeb;
import com.cipfpmislata.modding.controller.model.modification.ModificationListWeb;
import com.cipfpmislata.modding.domain.model.Modification;

@Component
public class ModificationMapperController {
    public static ModificationListWeb toModificationListWeb(Modification modification){
        if(modification == null){
            return null;
        }

        ModificationListWeb modificationListWeb = new ModificationListWeb();

        modificationListWeb.setName(modification.getName());

        return modificationListWeb;
    }

    public static ModificationDetailWeb toModificationDetailWeb(Modification modification){
        if(modification == null){
            return null;
        }

        ModificationDetailWeb modificationDetailWeb = new ModificationDetailWeb();

        modificationDetailWeb.setId(modification.getId());
        modificationDetailWeb.setName(modification.getName());
        modificationDetailWeb.setSpeed(modification.getSpeed());

        return modificationDetailWeb;
    }
}
