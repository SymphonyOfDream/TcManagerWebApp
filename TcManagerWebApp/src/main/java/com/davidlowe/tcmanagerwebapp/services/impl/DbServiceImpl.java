package com.davidlowe.tcmanagerwebapp.services.impl;


import com.davidlowe.tcmanagerwebapp.services.DbService;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.Reader;
import java.util.List;
import java.util.Optional;
import java.util.Properties;


@Service
public class DbServiceImpl<T> implements DbService<T>
{
    private static final Logger logger = LoggerFactory.getLogger(DbService.class);

    @Value("${datasource.full.driver}")
    private String driverFullName;
    @Value("${datasource.driver}")
    private String driverName;
    @Value("${datasource.address}")
    private String rdbmsIpAddress;
    @Value("${datasource.database}")
    private String rdbmsDbName;
    @Value("${datasource.username}")
    private String rdbmsUserName;
    @Value("${datasource.password}")
    private String rdbmsUserPassword;
    @Value("${db.configFile}")
    private String dbConfigFile;

    private static SqlSessionFactory sqlSessionFactory = null;


    public DbServiceImpl()
    {
    }

    @PostConstruct
    public void init()
    {
        if (sqlSessionFactory != null)
            return;

        try (Reader reader = Resources.getResourceAsReader(dbConfigFile))
        {
            // SqlSessionFactoryBuilder is expecting properties with the following names
            Properties properties = new Properties();
            properties.put("datasource.full.driver", driverFullName);
            properties.put("datasource.driver", driverName);
            properties.put("datasource.address", rdbmsIpAddress);
            properties.put("datasource.database", rdbmsDbName);
            properties.put("datasource.username", rdbmsUserName);
            properties.put("datasource.password", rdbmsUserPassword);

            sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader, properties);
        }
        catch (Exception ex)
        {
            logger.error("Error initializing SqlSessionFactory.", ex);
            sqlSessionFactory = null;
        }
    }


    private SqlSession getSqlSession()
    {
        // the default option is NOT auto-commit, change that to True
        return sqlSessionFactory.openSession(true);
    }


    @Override
    public Optional<T> selectOne(String map)
    {
        try (SqlSession session = getSqlSession())
        {
            return Optional.ofNullable(session.selectOne(map));
        }
    }


    @Override
    public Optional<T> selectOne(String map, Object object)
    {
        try (SqlSession session = getSqlSession())
        {
            return Optional.ofNullable(session.selectOne(map, object));
        }
    }


    @Override
    public List<T> selectList(String map)
    {
        try (SqlSession session = getSqlSession())
        {
            return session.selectList(map);
        }
    }


    @Override
    public List<T> selectList(String map, Object object)
    {
        try (SqlSession session = getSqlSession())
        {
            return session.selectList(map, object);
        }
    }


    @Override
    public int insert(String map, Object object)
    {
        int insertCount = 0;

        try (SqlSession session = getSqlSession())
        {
            insertCount = session.insert(map, object);
        }

        return insertCount;
    }


    @Override
    public int update(String map, Object object)
    {
        int updatesCount = 0;

        try (SqlSession session = getSqlSession())
        {
            updatesCount = session.update(map, object);
        }

        return updatesCount;
    }


    @Override
    public int delete(String map, Object object)
    {
        try (SqlSession session = getSqlSession())
        {
            return session.delete(map, object);
        }
    }

}
