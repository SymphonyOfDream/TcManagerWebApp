package com.davidlowe.tcmanagerwebapp.services.impl;


import com.davidlowe.tcmanagerwebapp.models.ListingStatus;
import com.davidlowe.tcmanagerwebapp.services.DbService;
import com.davidlowe.tcmanagerwebapp.services.ListingStatusService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class ListingStatusServiceImpl implements ListingStatusService
{
    private List<ListingStatus> listingStatuses = new ArrayList<>();

    private final DbService<ListingStatus> _dbService;

    public ListingStatusServiceImpl(DbService<ListingStatus> dbService)
    {
        _dbService = dbService;
        init();
    }

    private void init()
    {
        listingStatuses = _dbService.selectList("map.ListingStatus.list");
    }

    @Override
    public List<ListingStatus> getAll()
    {
        return listingStatuses;
    }

    @Override
    public Optional<ListingStatus> get(Integer listingStatusId)
    {
        return listingStatuses.stream().filter(r -> r.getId() == listingStatusId).findFirst();
    }
}
