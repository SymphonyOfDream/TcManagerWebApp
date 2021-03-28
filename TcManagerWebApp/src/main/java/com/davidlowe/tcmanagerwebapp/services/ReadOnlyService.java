package com.davidlowe.tcmanagerwebapp.services;


import java.util.List;
import java.util.Optional;


public interface ReadOnlyService<T, ID>
{
    /**
     * Returns all objects from the DB.
     * @return Object having the specified Primary Key from the DB
     */
    List<T> getAll();

    /**
     * Returns the object having the specified Primary Key from the DB
     * @param id
     * @return
     */
    Optional<T> get(ID id);



}
