package com.davidlowe.tcmanagerwebapp.services.impl;


import com.davidlowe.tcmanagerwebapp.models.Address;
import com.davidlowe.tcmanagerwebapp.models.Person;
import com.davidlowe.tcmanagerwebapp.services.AddressService;
import com.davidlowe.tcmanagerwebapp.services.DbService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class AddressServiceImpl implements AddressService
{
    private final DbService<Address> _dbService;
    public AddressServiceImpl(DbService<Address> dbService)
    {
        _dbService = dbService;
    }


    @Override
    public List<Address> getAll()
    {
        return _dbService.selectList("map.Address.list");
    }


    @Override
    public Optional<Address> get(Long addressId)
    {
        if (addressId != null)
        {
            return _dbService.selectOne("map.Address.get", addressId);
        }

        return Optional.empty();
    }


    @Override
    public void insert(Address address)
            throws Exception
    {
        if (address != null)
        {
            if (address.getId() < 1)
            {
                // Create operation
                _dbService.insert("map.Address.create", address);
            }
            else
            {
                throw new Exception("Address already has a primary key and cannot be inserted.");
            }
        }
    }


    @Override
    public void update(Address address)
            throws Exception
    {
        if (address != null)
        {
            if (address.getId() > 0)
            {
                _dbService.update("map.Address.update", address);
            }
            else
            {
                throw new Exception("Address does not have a primary key and cannot be updated.");
            }
        }
    }


    @Override
    public void delete(Address address)
    {
        if (address != null)
        {
            _dbService.delete("map.Address.delete", address);
            address.setId(0);
        }
    }


    @Override
    public void deleteAddressForPerson(Person person)
    {
        if (person != null && person.getAddress() != null)
        {
            _dbService.delete("map.Address.deleteAddressForPerson", person.getAddress());
            person.getAddress().setId(0);
            person.setAddress(null);
        }
    }
}
