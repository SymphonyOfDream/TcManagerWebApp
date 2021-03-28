package com.davidlowe.tcmanagerwebapp.services.impl;


import com.davidlowe.tcmanagerwebapp.models.DataInputStatus;
import com.davidlowe.tcmanagerwebapp.services.DbService;
import com.davidlowe.tcmanagerwebapp.services.DataInputStatusService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class DataInputStatusServiceImpl implements DataInputStatusService
{
    private List<DataInputStatus> dataInputStatuses = new ArrayList<>();

    private final DbService<DataInputStatus> _dbService;

    public DataInputStatusServiceImpl(DbService<DataInputStatus> dbService)
    {
        _dbService = dbService;
        init();
    }

    private void init()
    {
        dataInputStatuses = _dbService.selectList("map.DataInputStatus.list");
    }

    @Override
    public List<DataInputStatus> getAll()
    {
        return dataInputStatuses;
    }

    @Override
    public Optional<DataInputStatus> get(Long dataInputStatusId)
    {
        return dataInputStatuses.stream().filter(r -> r.getId() == dataInputStatusId).findFirst();
    }

}
