package com.davidlowe.tcmanagerwebapp.services.impl;


import com.davidlowe.tcmanagerwebapp.models.Person;
import com.davidlowe.tcmanagerwebapp.services.AddressService;
import com.davidlowe.tcmanagerwebapp.services.DbService;
import com.davidlowe.tcmanagerwebapp.services.PersonService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class PersonServiceImpl implements PersonService
{
    private final DbService<Person> _dbService;
    private final AddressService _addressService;


    public PersonServiceImpl(DbService<Person> dbService, AddressService addressService)
    {
        _dbService = dbService;
        _addressService = addressService;
    }


    @Override
    public List<Person> getAll()
    {
        return _dbService.selectList("map.Person.list");
    }

    @Override
    public Optional<Person> get(Integer personId)
    {
        return _dbService.selectOne("map.Person.get", personId);
    }


    @Override
    public void insert(Person person)
            throws Exception
    {
        if (person.getId() < 1 && person.getCreatorUser() != null && person.getCreatorUser().getId() > 0)
        {
            // Create operation
            if (person.getAddress() != null)
                _addressService.insert(person.getAddress());

            try
            {
                _dbService.insert("map.Person.create", person);
            }
            catch (Exception ex)
            {
                if (person.getAddress() != null)
                    _addressService.delete(person.getAddress());
            }
        }
        else
        {
            if (person.getCreatorUser() == null || person.getCreatorUser().getId() < 1)
            {
                throw new Exception("Person object does not have a Creator.");
            }
            else
            {
                throw new Exception("Person already has a primary key and cannot be inserted.");
            }
        }
    }

    @Override
    public void update(Person person)
            throws Exception
    {
        if (person.getId() > 0)
        {
            boolean addressWasInserted = false;
            if (person.getAddress() != null)
            {
                if (person.getAddress().getId() < 1)
                {
                    _addressService.insert(person.getAddress());
                    addressWasInserted = true;
                }
                else
                {
                    _addressService.update(person.getAddress());
                }
            }

            try
            {
                _dbService.update("map.Person.update", person);
            }
            catch (Exception ex)
            {
                if (addressWasInserted)
                {
                    _addressService.delete(person.getAddress());
                }
            }
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
