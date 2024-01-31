package com.cipfpmislata.modding.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;

import com.cipfpmislata.modding.controller.mapper.OwnerMapperController;
import com.cipfpmislata.modding.controller.model.owner.OwnerDetailWeb;
import com.cipfpmislata.modding.controller.model.owner.OwnerListWeb;
import com.cipfpmislata.modding.domain.model.Owner;
import com.cipfpmislata.modding.domain.service.OwnerService;
import com.cipfpmislata.modding.http_response.Response;

@RequestMapping("/owners")
@RestController
public class OwnerController {
    @Autowired
    private OwnerService ownerService;

    @Value("${page.size}")
    private int LIMIT;

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("")
    public Response getAll(@RequestParam(required = false) Integer page, @RequestParam(required = false) Integer pageSize){
        pageSize = (pageSize != null)? pageSize : LIMIT;
        List<Owner> owners = (page != null)? ownerService.getAll(page, pageSize): ownerService.getAll();
        List<OwnerListWeb> ownersWeb = owners.stream()
                            .map(owner -> OwnerMapperController.toOwnerListWeb(owner))
                            .toList();
        long totalRecords = ownerService.getTotalNumberOfRecords();
        return Response.builder()
                .data(ownersWeb)
                .totalRecords(totalRecords)
                .build();
    }

    @GetMapping("/{id}")
    public OwnerDetailWeb findById(@PathVariable("id") int id){
        return OwnerMapperController.toOwnerDetailWeb(ownerService.findById(id));
    }
}
