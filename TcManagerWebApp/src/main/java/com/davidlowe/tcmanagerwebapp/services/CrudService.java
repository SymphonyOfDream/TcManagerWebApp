package com.davidlowe.tcmanagerwebapp.services;


import java.util.List;


public interface CrudService<T, ID> extends ReadOnlyService<T, ID>
{
    /**
     * Saves the specified object to the DB. Populates the object's Id property when finished.
     * @param object Object to save.
     */
    void insert(T object) throws Exception;

    /**
     * Updates the specified object in the DB.
     * @param object Object to update.
     */
    void update(T object) throws Exception;

    /**
     * Deletes the specified object from the DB.
     * @param object Object to delete.
     */
    void delete(T object);
}
