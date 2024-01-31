package com.cipfpmislata.modding.domain.service;

import java.util.List;

import com.cipfpmislata.modding.domain.model.Modification;

public interface ModificationService {
    List<Modification> getAll();
    List<Modification> getAll(int page, int pageSIze);
    long getTotalNumberOfRecords();
    Modification findById(int id);
    Modification save(Modification modification);
}
