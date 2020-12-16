package com.codegym.service;

import java.util.List;
import java.util.Optional;

public interface BlogService<T> {

    List<T> findAll();

    T findById(Long id);

    T save(T obj);
}
