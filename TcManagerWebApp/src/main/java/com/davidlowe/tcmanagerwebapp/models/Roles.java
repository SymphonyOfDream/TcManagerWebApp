package com.davidlowe.tcmanagerwebapp.models;


import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public enum Roles
{
    ADMIN(1, "Admin", "System administrator."),
    MGR(2, "Mgr", "Manager of Transaction Coordinators."),
    USER(3, "User", "Transaction Coordinator/Normal User.");

    private final int id;
    private final String name;
    private final String description;

    private Roles(int id, String name, String description)
    {
        this.id = id;
        this.name = name;
        this.description = description;
    }


    public int getId()
    {
        return id;
    }


    public String getName()
    {
        return name;
    }


    public String getDescription()
    {
        return description;
    }


    public static Roles get(int id)
    {
        if (id > 0 && id <= Roles.values().length)
        {
            return Roles.values()[id - 1];
        }

        return null;
    }


    public static List<Roles> getAll()
    {
        return Stream.of(Roles.ADMIN, Roles.MGR, Roles.USER).collect(Collectors.toList());
    }


    @Override
    public String toString()
    {
        return name;
    }

}
