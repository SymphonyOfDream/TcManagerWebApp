package com.davidlowe.tcmanagerwebapp.services;


import com.davidlowe.tcmanagerwebapp.models.Address;
import com.davidlowe.tcmanagerwebapp.models.Person;


public interface AddressService extends CrudService<Address, Integer>
{
    void deleteAddressForPerson(Person person);
}
