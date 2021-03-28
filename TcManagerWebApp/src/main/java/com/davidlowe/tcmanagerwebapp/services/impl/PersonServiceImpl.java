package com.davidlowe.tcmanagerwebapp.services.impl;


import com.davidlowe.tcmanagerwebapp.models.Person;
import com.davidlowe.tcmanagerwebapp.services.DbService;
import com.davidlowe.tcmanagerwebapp.services.PersonService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class PersonServiceImpl implements PersonService
{
    private final DbService<Person> _dbService;
    public PersonServiceImpl(DbService<Person> dbService)
    {
        _dbService = dbService;
    }


    @Override
    public List<Person> getAll()
    {
        return _dbService.selectList("map.Person.list");
    }

    @Override
    public Optional<Person> get(Long personId)
    {
        return _dbService.selectOne("map.Person.get", personId);
    }


    @Override
    public void insert(Person person)
            throws Exception
    {
        if (person.getId() < 1)
        {
            // Create operation
            _dbService.insert("map.Person.create", person);
        }
        else
        {
            throw new Exception("Person already has a primary key and cannot be inserted.");
        }
    }

    @Override
    public void update(Person person)
            throws Exception
    {
        if (person.getId() > 0)
        {
            _dbService.update("map.Person.update", person);
        }
        else
        {
            throw new Exception("Person does not have a primary key and cannot be updated.");
        }
    }

    @Override
    public void delete(Person person)
    {
        _dbService.delete("map.Person.delete", person);
        person.setId(0);
    }

}
