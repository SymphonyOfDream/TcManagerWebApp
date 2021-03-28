package com.davidlowe.tcmanagerwebapp.controllers;


import com.davidlowe.tcmanagerwebapp.models.LoginInfo;
import com.davidlowe.tcmanagerwebapp.models.User;
import com.davidlowe.tcmanagerwebapp.services.UserService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


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


    @PostMapping("/security/processLogin")
    public String processLogin(@ModelAttribute LoginInfo loginInfo, Model model, HttpServletRequest request, HttpSession session)
    {
        // Is user already logged in?
        if (session.getAttribute(User.class.getCanonicalName()) != null)
        {
            return "redirect:/index";
        }

        // Make sure our login info is correct.
        if (loginInfo == null || StringUtils.isBlank(loginInfo.getUsername()) || StringUtils.isBlank(loginInfo.getPassword()))
        {
            if (loginInfo == null)
            {
                loginInfo = new LoginInfo().setError(true);
            }
            loginInfo.setPassword("");

            model.addAttribute("LoginInfo", loginInfo);

            return "redirect:/security/login";
        }
        // We know loginInfo is not null, and has data in username and password.

        User loggedInUser = _userService.getUserForLogin(loginInfo.getUsername(), loginInfo.getPassword(), request.getRemoteAddr());
        // Did attempted login fail?
        if (loggedInUser == null)
        {
            loginInfo.setPassword("").setError(true);
            model.addAttribute("LoginInfo", loginInfo);
            return "redirect:/security/login";
        }

        // Successful login, so add User object to Session.
        session.setAttribute(User.class.getCanonicalName(), loggedInUser);

        return "redirect:/index";
    }


    @GetMapping(value = "/security/logout.html")
    public String logout(HttpSession session)
    {
        session.invalidate();
        return "redirect:/index";
    }

}