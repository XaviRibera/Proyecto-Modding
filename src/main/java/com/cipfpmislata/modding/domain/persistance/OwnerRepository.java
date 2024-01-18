package com.cipfpmislata.modding.domain.persistance;

import java.util.List;

import com.cipfpmislata.modding.domain.model.Owner;

public interface OwnerRepository {
    List<Owner> getAll();
}
