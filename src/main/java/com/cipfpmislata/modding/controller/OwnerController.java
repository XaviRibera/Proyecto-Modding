package com.cipfpmislata.modding.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;

import com.cipfpmislata.modding.controller.mapper.OwnerMapperController;
import com.cipfpmislata.modding.controller.model.owner.OwnerListWeb;
import com.cipfpmislata.modding.domain.model.Owner;
import com.cipfpmislata.modding.domain.service.OwnerService;

@RequestMapping("/owners")
@RestController
public class OwnerController {
    @Autowired
    private OwnerService ownerService;

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("")
    public List<OwnerListWeb> getAll(){
        List<Owner> owners = ownerService.getAll();
        List<OwnerListWeb> ownersWeb = owners.stream()
                            .map(owner -> OwnerMapperController.toOwnerListWeb(owner))
                            .toList();

        return ownersWeb;
    }
}
