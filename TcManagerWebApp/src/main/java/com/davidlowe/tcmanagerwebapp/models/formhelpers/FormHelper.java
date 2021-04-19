package com.davidlowe.tcmanagerwebapp.models.formhelpers;


import java.util.ArrayList;
import java.util.List;


public class FormHelper
{
    private List<String> errors = new ArrayList<>();

    public void addError(String error)
    {
        errors.add(error);
    }

    public void clearErrors()
    {
        errors.clear();
    }

    public boolean hasErrors()
    {
        return !errors.isEmpty();
    }

    /**
     * Returns all errors. NOTE: this should only be used by thymeleaf
     * @return All errors, or empty list.
     */
    public List<String> getErrors()
    {
        return errors;
    }
}
