package com.davidlowe.tcmanagerwebapp.controllers;


import com.davidlowe.tcmanagerwebapp.models.LoginInfo;
import com.davidlowe.tcmanagerwebapp.models.RegistrationInfo;
import com.davidlowe.tcmanagerwebapp.models.User;
import com.davidlowe.tcmanagerwebapp.services.UserService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;


@Controller
public class SecurityController
{
    private final UserService _userService;

    public SecurityController(UserService userService)
    {
        _userService = userService;
    }


    @GetMapping({"/security", "/security/login", "/security/login.html"})
    public String loginForm(Model model, HttpSession session)
    {
        // Is user already logged in?
        if (session.getAttribute(User.class.getCanonicalName()) != null)
        {
            return "redirect:/index";
        }

        LoginInfo loginInfo = (LoginInfo) model.getAttribute("LoginInfo");
        model.addAttribute("LoginInfo", loginInfo == null ? new LoginInfo() : loginInfo);

        return "security/login";
    }


    @GetMapping({"/security/registration", "/security/registration.html"})
    public String registration(Model model, HttpSession session)
    {
        BeanInfo info = null;
        try
        {
            info = Introspector.getBeanInfo(RegistrationInfo.class);
        }
        catch (IntrospectionException e)
        {
            e.printStackTrace();
        }
        RegistrationInfo itm = new RegistrationInfo();
        for (PropertyDescriptor pd : info.getPropertyDescriptors()) {
            System.out.println(pd.getName() + " : " + pd.getReadMethod());
        }

        // Is user already logged in?
        if (session.getAttribute(User.class.getCanonicalName()) != null)
        {
            return "redirect:/index";
        }

        RegistrationInfo registrationInfo = (RegistrationInfo) model.getAttribute("LoginInfo");
        model.addAttribute("RegistrationInfo", registrationInfo == null ? new RegistrationInfo() : registrationInfo);

        return "security/registration";
    }


    @PostMapping("/security/processRegistration")
    public String processLogin(@ModelAttribute RegistrationInfo registrationInfo, Model model, HttpServletRequest request, HttpSession session)
    {
        // Is user already logged in?
        if (session.getAttribute(User.class.getCanonicalName()) != null)
        {
            return "redirect:/index";
        }

        // Make sure our login info is correct.
        if (registrationInfo == null)
        {
            if (registrationInfo == null)
            {
                registrationInfo = new RegistrationInfo().setError(true);
            }

            model.addAttribute("RegistrationInfo", registrationInfo);

            return "redirect:/security/registration";
        }
        // We know registrationInfo is not null, and has valid data.

        //TODO: register user and automatically log them in

        return "redirect:/index";
    }


    @GetMapping(value = "/security/logout.html")
    public String logout(HttpSession session)
    {
        session.invalidate();
        return "redirect:/index";
    }

}