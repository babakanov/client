package com.example.client.service.base.impl;

import com.example.client.exception.NotFoundException;
import com.example.client.service.base.CrudService;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Transactional(readOnly = true)
public class DefaultCrudService<T, P extends Serializable> implements CrudService<T, P> {

    private final CrudRepository<T, P> crudRepository;

    public DefaultCrudService(@NotNull CrudRepository<T, P> crudRepository) {
        this.crudRepository = crudRepository;
    }

    @Override
    public T get(@NotNull P id) throws NotFoundException {
        return crudRepository
                .findById(id)
                .orElseThrow(() -> new NotFoundException("Запись не найдена для id: " + id));
    }

    @Override
    public List<T> get(@NotNull List<P> ids) throws NotFoundException {
        List<T> list = new ArrayList<>();

        for (P id : ids) {
            list.add(get(id));
        }

        return list;
    }

    @Override
    @Transactional
    public T saveOrUpdate(@NotNull T t) {
        return crudRepository.save(t);
    }

    @Override
    @Transactional
    public void saveOrUpdate(@NotNull Collection<T> t) {
        List<T> persisted = new ArrayList<>();

        for (T currentObject : t) {
            persisted.add(saveOrUpdate(currentObject));
        }
    }
}
