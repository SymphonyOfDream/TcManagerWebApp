package com.davidlowe.tcmanagerwebapp.services.impl;


import com.davidlowe.tcmanagerwebapp.models.DocumentComplianceStatus;
import com.davidlowe.tcmanagerwebapp.services.DbService;
import com.davidlowe.tcmanagerwebapp.services.DocumentComplianceStatusService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class DocumentComplianceStatusServiceImpl implements DocumentComplianceStatusService
{
    private List<DocumentComplianceStatus> documentComplianceStatuses = new ArrayList<>();

    private final DbService<DocumentComplianceStatus> _dbService;

    public DocumentComplianceStatusServiceImpl(DbService<DocumentComplianceStatus> dbService)
    {
        _dbService = dbService;
        init();
    }

    private void init()
    {
        documentComplianceStatuses = _dbService.selectList("map.DocumentComplianceStatus.list");
    }

    @Override
    public List<DocumentComplianceStatus> getAll()
    {
        return documentComplianceStatuses;
    }

    @Override
    public Optional<DocumentComplianceStatus> get(Integer documentComplianceStatusId)
    {
        return documentComplianceStatuses.stream().filter(r -> r.getId() == documentComplianceStatusId).findFirst();
    }
}
