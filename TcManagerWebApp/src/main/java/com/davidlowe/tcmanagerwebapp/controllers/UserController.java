package com.davidlowe.tcmanagerwebapp.controllers;


import com.davidlowe.tcmanagerwebapp.models.User;
import com.davidlowe.tcmanagerwebapp.models.formhelpers.LoginInfo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;


@Controller
public class UserController
{

    @GetMapping({"/security/user_profile", "/security/user_profile.html"})
    public String userProfileForm(Model model, HttpSession session)
    {
        // Is user NOT logged in?
        User loggedInUser = (User)session.getAttribute(SecurityController.SESSION_LOGGED_IN_USER_KEY);
        if (loggedInUser == null)
        {
            return "redirect:/security/login";
        }

        model.addAttribute(SecurityController.SESSION_LOGGED_IN_USER_KEY, loggedInUser);

        return "security/user_profile";
    }

    @PostMapping(value = "/security/process_user_profile")
    public String processUserProfile(Model model, HttpSession session)
    {
        // Is user NOT logged in?
        User loggedInUser = (User)session.getAttribute(SecurityController.SESSION_LOGGED_IN_USER_KEY);
        if (loggedInUser == null)
        {
            return "redirect:/security/login";
        }

        return "redirect:/index";
    }


}
