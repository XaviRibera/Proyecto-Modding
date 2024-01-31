package com.cipfpmislata.modding.domain.service;

import java.util.List;

import com.cipfpmislata.modding.domain.model.Owner;

public interface OwnerService {
    List<Owner> getAll();
    List<Owner> getAll(int page, int pageSize);
    Owner findById(int id);
    long getTotalNumberOfRecords();
    Owner save(Owner owner);
}
