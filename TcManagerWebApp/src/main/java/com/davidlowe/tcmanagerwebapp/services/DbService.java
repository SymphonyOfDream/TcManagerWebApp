package com.davidlowe.tcmanagerwebapp.services;


import com.davidlowe.tcmanagerwebapp.TcManager;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;

import java.io.Reader;
import java.util.List;
import java.util.Optional;
import java.util.Properties;


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
