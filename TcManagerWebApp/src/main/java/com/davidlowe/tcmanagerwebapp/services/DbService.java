package com.davidlowe.tcmanagerwebapp.services;

import java.util.List;
import java.util.Optional;


public interface DbService<T>
{
    Optional<T> selectOne(String map);

    Optional<T> selectOne(String map, Object object);

    List<T> selectList(String map);

    List<T> selectList(String map, Object object);

    int insert(String map, Object object);

    int update(String map, Object object);

    int delete(String map, Object object);
}
