package com.cipfpmislata.modding.controller.mapper;

import org.springframework.stereotype.Component;

import com.cipfpmislata.modding.controller.model.modification.ModificationCreateWeb;
import com.cipfpmislata.modding.controller.model.modification.ModificationDetailWeb;
import com.cipfpmislata.modding.controller.model.modification.ModificationListWeb;
import com.cipfpmislata.modding.controller.model.modification.ModificationUpdateWeb;
import com.cipfpmislata.modding.domain.model.Modification;

@Component
public class ModificationMapperController {
    public static ModificationListWeb toModificationListWeb(Modification modification){
        if(modification == null){
            return null;
        }

        ModificationListWeb modificationListWeb = new ModificationListWeb();

        modificationListWeb.setId(modification.getId());
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

    public static Modification toModification(ModificationCreateWeb modificationCreateWeb){
        if(modificationCreateWeb == null){
            return null;
        }

        Modification modification = new Modification();

        modification.setName(modificationCreateWeb.getName());
        modification.setSpeed(modificationCreateWeb.getSpeed());

        return modification;
    }

    public static Modification toModification(ModificationUpdateWeb modificationUpdateWeb){
        if(modificationUpdateWeb == null){
            return null;
        }

        Modification modification = new Modification();

        modification.setName(modificationUpdateWeb.getName());
        modification.setSpeed(modificationUpdateWeb.getSpeed());

        return modification;
    }
}
