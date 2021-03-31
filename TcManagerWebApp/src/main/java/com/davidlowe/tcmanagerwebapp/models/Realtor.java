package com.davidlowe.tcmanagerwebapp.models;


import java.time.LocalDateTime;
import java.util.Objects;


public class Realtor extends Person
{

    private Boolean isBroker;
    private Brokerage brokerage;
    private Team team;
    private User creatorUser;
    private LocalDateTime realtorCreationDate;


    public Boolean isBroker()
    {
        return isBroker;
    }

    public Realtor isBroker(Boolean isBroker)
    {
        this.isBroker = isBroker;
        return this;
    }


    public Brokerage getBrokerage()
    {
        return brokerage;
    }

    public Realtor setBrokerage(Brokerage brokerage)
    {
        this.brokerage = brokerage;
        return this;
    }


    public Team getTeam()
    {
        return team;
    }

    public Realtor setTeam(Team team)
    {
        this.team = team;
        return this;
    }


    public User getCreatorUser()
    {
        return creatorUser;
    }

    public Realtor setCreatorUser(User creatorUser)
    {
        this.creatorUser = creatorUser;
        return this;
    }


    public LocalDateTime getRealtorCreationDate()
    {
        return realtorCreationDate;
    }

    public Realtor setRealtorCreationDate(LocalDateTime realtorCreationDate)
    {
        this.realtorCreationDate = realtorCreationDate;
        return this;
    }


    @Override
    public String toString()
    {
        return "Realtor{" +
                "isBroker=" + isBroker +
                ", brokerage=" + brokerage +
                ", team=" + team +
                ", creatorUser=" + creatorUser +
                ", creationDate=" + realtorCreationDate +
                '}';
    }


    @Override
    public boolean equals(Object o)
    {
        if (this == o)
        {
            return true;
        }
        if (o == null || getClass() != o.getClass())
        {
            return false;
        }
        if (!super.equals(o))
        {
            return false;
        }

        Realtor realtor = (Realtor) o;

        if (!Objects.equals(isBroker, realtor.isBroker))
        {
            return false;
        }
        if (!Objects.equals(brokerage, realtor.brokerage))
        {
            return false;
        }
        if (!Objects.equals(team, realtor.team))
        {
            return false;
        }
        if (!Objects.equals(creatorUser, realtor.creatorUser))
        {
            return false;
        }
        return Objects.equals(realtorCreationDate, realtor.realtorCreationDate);
    }

    @Override
    public int hashCode()
    {
        int result = super.hashCode();
        result = 31 * result + (isBroker != null ? isBroker.hashCode() : 0);
        result = 31 * result + (brokerage != null ? brokerage.hashCode() : 0);
        result = 31 * result + (team != null ? team.hashCode() : 0);
        result = 31 * result + (creatorUser != null ? creatorUser.hashCode() : 0);
        result = 31 * result + (realtorCreationDate != null ? realtorCreationDate.hashCode() : 0);
        return result;
    }
}
