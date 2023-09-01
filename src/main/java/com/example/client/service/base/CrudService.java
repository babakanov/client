package com.example.client.service.base;

import com.example.client.exception.NotFoundException;

import javax.validation.constraints.NotNull;
import java.util.Collection;
import java.util.List;

public interface CrudService<T, P> {

    T get(@NotNull P id) throws NotFoundException;

    Collection<T> get(@NotNull List<P> ids) throws NotFoundException;

    T saveOrUpdate(@NotNull T t);

    void saveOrUpdate(@NotNull Collection<T> t);
}
