package com.davidlowe.tcmanagerwebapp.services.impl;


import com.davidlowe.tcmanagerwebapp.models.PropertyType;
import com.davidlowe.tcmanagerwebapp.services.DbService;
import com.davidlowe.tcmanagerwebapp.services.PropertyTypeService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class PropertyTypeServiceImpl implements PropertyTypeService
{
    private List<PropertyType> propertyTypes = new ArrayList<>();

    private final DbService<PropertyType> _dbService;

    public PropertyTypeServiceImpl(DbService<PropertyType> dbService)
    {
        _dbService = dbService;
        init();
    }

    private void init()
    {
        propertyTypes = _dbService.selectList("map.PropertyType.list");
    }

    @Override
    public List<PropertyType> getAll()
    {
        return propertyTypes;
    }

    @Override
    public Optional<PropertyType> get(Integer propertyTypeId)
    {
        return propertyTypes.stream().filter(r -> r.getId() == propertyTypeId).findFirst();
    }
}
