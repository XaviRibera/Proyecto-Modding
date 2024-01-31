package com.cipfpmislata.modding.domain.persistance;

import java.util.List;
import java.util.Optional;

import com.cipfpmislata.modding.domain.model.Modification;

public interface ModificationRepository {
    List<Modification> getAll(Integer page, Integer pageSize);
    long getTotalNumberOfRecords();
    Optional<Modification> findById(int id);
    Modification save(Modification modification);
    Modification update(Modification modification);
}
