package com.web.dao;

public interface DAO<T,K> {
    T save(T t);

    T get(K k);

    void update(T t);

    void delete(K k);
}
