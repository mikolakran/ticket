package com.web.dao;

import com.web.exception.LoginException;
import com.web.exception.MyException;

public interface DAO<T,K> {
    T save(T t) ;

    T get(K k);

    void update(T t);

    void delete(K k);
}
