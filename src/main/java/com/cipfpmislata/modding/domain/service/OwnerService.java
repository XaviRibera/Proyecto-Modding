package com.cipfpmislata.modding.domain.service;

import java.util.List;

import com.cipfpmislata.modding.domain.model.Owner;

public interface OwnerService {
    List<Owner> getAll();
    Owner findById(int id);
}
