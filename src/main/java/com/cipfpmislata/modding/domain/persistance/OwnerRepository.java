package com.cipfpmislata.modding.domain.persistance;

import java.util.List;
import java.util.Optional;

import com.cipfpmislata.modding.domain.model.Owner;

public interface OwnerRepository {
    List<Owner> getAll(Integer page, Integer pageSize);
    Optional<Owner> findById(int id);
    long getTotalNumberOfRecords();
    Owner save(Owner owner);
}
