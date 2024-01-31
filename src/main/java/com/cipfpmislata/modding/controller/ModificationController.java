package com.cipfpmislata.modding.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.cipfpmislata.modding.controller.mapper.ModificationMapperController;
import com.cipfpmislata.modding.controller.model.modification.ModificationListWeb;
import com.cipfpmislata.modding.domain.model.Modification;
import com.cipfpmislata.modding.domain.service.ModificationService;
import com.cipfpmislata.modding.http_response.Response;

@RequestMapping("/mods")
@RestController
public class ModificationController {
    @Autowired
    ModificationService modificationService;

    @Value("${page.size}")
    private int LIMIT;

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("")
    public Response getAll(@RequestParam(required = false) Integer page, @RequestParam(required = false) Integer pageSize){
        pageSize = (pageSize != null)? pageSize : LIMIT;
        List<Modification> modifications = (page != null)? modificationService.getAll(page,pageSize) : modificationService.getAll();
        List<ModificationListWeb> modificationsListWeb = modifications.stream()
                                                                        .map(modification -> ModificationMapperController.toModificationListWeb(modification))
                                                                        .toList();
        long totalRecords = modificationService.getTotalNumberOfRecords();
        return Response.builder()
                        .data(modificationsListWeb)
                        .totalRecords(totalRecords)
                        .build();
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("{id}")
    public Response findById(@PathVariable("id") int id){
        return Response.builder()
                        .data(ModificationMapperController.toModificationDetailWeb(modificationService.findById(id)))
                        .build();
    }
}
