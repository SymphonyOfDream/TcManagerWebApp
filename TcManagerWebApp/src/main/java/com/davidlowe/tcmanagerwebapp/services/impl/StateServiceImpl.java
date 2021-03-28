package com.davidlowe.tcmanagerwebapp.services.impl;


import com.davidlowe.tcmanagerwebapp.models.State;
import com.davidlowe.tcmanagerwebapp.services.DbService;
import com.davidlowe.tcmanagerwebapp.services.StateService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class StateServiceImpl implements StateService
{
    private List<State> states = new ArrayList<>();

    private final DbService<State> _dbService;

    public StateServiceImpl(DbService<State> dbService)
    {
        _dbService = dbService;
        init();
    }

    private void init()
    {
        states = _dbService.selectList("map.State.list");
    }

    @Override
    public List<State> getAll()
    {
        return states;
    }

    @Override
    public Optional<State> get(String stateId)
    {
        return states.stream().filter(r -> r.getId() == stateId).findFirst();
    }
}
