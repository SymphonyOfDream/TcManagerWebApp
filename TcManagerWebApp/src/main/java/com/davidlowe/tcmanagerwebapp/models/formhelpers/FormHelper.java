package com.davidlowe.tcmanagerwebapp.models.formhelpers;


import java.util.ArrayList;
import java.util.List;


public class FormHelper
{
    private List<String> errors = new ArrayList<>();

    public List<String> getErrors()
    {
        return errors;
    }

    public void setErrors(List<String> errors)
    {
        this.errors = errors;
    }

}
