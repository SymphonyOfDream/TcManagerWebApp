package com.davidlowe.tcmanagerwebapp.services.impl;


import com.davidlowe.tcmanagerwebapp.models.Listing;
import com.davidlowe.tcmanagerwebapp.models.Person;
import com.davidlowe.tcmanagerwebapp.services.DbService;
import com.davidlowe.tcmanagerwebapp.services.ListingService;

import java.util.List;
import java.util.Optional;


public class ListingServiceImpl implements ListingService
{
    private final DbService<Listing> _dbService;

    
    public ListingServiceImpl(DbService<Listing> dbService)
    {
        _dbService = dbService;
    }

    @Override
    public List<Listing> getAll()
    {
        return _dbService.selectList("map.Listing.list");
    }

    @Override
    public Optional<Listing> get(Long listingId)
    {
        return _dbService.selectOne("map.Listing.get", listingId);
    }


    @Override
    public void insert(Listing listing)
            throws Exception
    {
        if (listing.getId() < 1)
        {
            // Create operation
            _dbService.insert("map.Listing.create", listing);
        }
        else
        {
            throw new Exception("Listing already has a primary key and cannot be inserted.");
        }
    }

    @Override
    public void update(Listing listing)
            throws Exception
    {
        if (listing.getId() > 0)
        {
            _dbService.update("map.Listing.update", listing);
        }
        else
        {
            throw new Exception("Listing does not have a primary key and cannot be updated.");
        }
    }

    @Override
    public void delete(Listing listing)
    {
        _dbService.delete("map.Listing.delete", listing);
        listing.setId(0);
    }
}
