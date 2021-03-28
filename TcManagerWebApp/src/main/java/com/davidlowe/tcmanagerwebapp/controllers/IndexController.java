package com.davidlowe.tcmanagerwebapp.controllers;


import com.davidlowe.tcmanagerwebapp.models.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;


@Controller
public class IndexController
{
    @RequestMapping({"", "/", "index", "index.html"})
    public String index(Model model, HttpSession session)
    {
        return "index";
    }
}
