package com.davidlowe.tcmanagerwebapp.controllers;


import com.davidlowe.tcmanagerwebapp.models.User;
import com.davidlowe.tcmanagerwebapp.models.formhelpers.LoginInfo;
import com.davidlowe.tcmanagerwebapp.models.formhelpers.RegistrationInfo;
import com.davidlowe.tcmanagerwebapp.services.UserService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


@Controller
public class SecurityController
{
    // If you change the values of *_KEY variables here, you will need to find
    // this value across ALL html pages/fragments and change it there, too.
    public static final String SESSION_LOGGED_IN_USER_KEY = "LoggedInUser";
    private final String LOGIN_INFO_KEY = "LoginInfo";
    private final String REGISTRATION_INFO_KEY = "RegistrationInfo";

    private final UserService _userService;

    public SecurityController(UserService userService)
    {
        _userService = userService;
    }


    @GetMapping({"/security", "/security/login", "/security/login.html"})
    public String loginForm(Model model, HttpSession session)
    {
        // Is user already logged in?
        if (session.getAttribute(SESSION_LOGGED_IN_USER_KEY) != null)
        {
            session.removeAttribute(LOGIN_INFO_KEY);
            return "redirect:/index";
        }

        LoginInfo loginInfo;
        if ((loginInfo = (LoginInfo)session.getAttribute(LOGIN_INFO_KEY)) != null)
        {
            session.removeAttribute(LOGIN_INFO_KEY);
        }

        if (loginInfo == null)
        {
            loginInfo = (LoginInfo) model.getAttribute(LOGIN_INFO_KEY);
        }

        model.addAttribute(LOGIN_INFO_KEY, loginInfo == null ? new LoginInfo() : loginInfo);

        return "security/login";
    }


    @PostMapping("/security/processLogin")
    public String processLogin(@ModelAttribute LoginInfo loginInfo, HttpServletRequest request, HttpSession session)
    {
        // Is user already logged in?
        if (session.getAttribute(SESSION_LOGGED_IN_USER_KEY) != null)
        {
            session.removeAttribute(LOGIN_INFO_KEY);
            return "redirect:/index";
        }

        // Make sure our login info is correct.
        if (loginInfo == null)
        {
            loginInfo = new LoginInfo();
            loginInfo.addError("SYSTEM ERROR");
        }
        else if (   StringUtils.isBlank(loginInfo.getUsername())
                 || StringUtils.isBlank(loginInfo.getPassword()))
        {
            // Make sure any previous errors are cleared before potentially
            // adding new errors.
            loginInfo.clearErrors();

            loginInfo.setPassword("");
            loginInfo.addError("Both User name and password are required");
        }

        if (loginInfo.hasErrors())
        {
            session.setAttribute(LOGIN_INFO_KEY, loginInfo);
            return "redirect:/security/login";
        }
        // We know loginInfo is not null, and has data in username and password.

        User loggedInUser = _userService.getUserForLogin(loginInfo.getUsername(), loginInfo.getPassword(), request.getRemoteAddr());
        // Did attempted login fail?
        if (loggedInUser == null)
        {
            loginInfo.setPassword("");
            loginInfo.addError("User name and/or password are incorrect");
            session.setAttribute(LOGIN_INFO_KEY, loginInfo);
            return "redirect:/security/login";
        }

        session.removeAttribute(LOGIN_INFO_KEY);

        // Successful login, so add User object to Session.
        session.setAttribute(SESSION_LOGGED_IN_USER_KEY, loggedInUser);

        return "redirect:/index";
    }


    @GetMapping({"/security/registration", "/security/registration.html"})
    public String registration(Model model, HttpSession session)
    {
        // Is user already logged in?
        if (session.getAttribute(SESSION_LOGGED_IN_USER_KEY) != null)
        {
            session.removeAttribute(REGISTRATION_INFO_KEY);
            return "redirect:/index";
        }

        RegistrationInfo registrationInfo;
        if ((registrationInfo = (RegistrationInfo)session.getAttribute(REGISTRATION_INFO_KEY)) != null)
        {
            session.removeAttribute(REGISTRATION_INFO_KEY);
        }

        if (registrationInfo == null)
        {
            registrationInfo = (RegistrationInfo) model.getAttribute(REGISTRATION_INFO_KEY);
        }

        model.addAttribute(REGISTRATION_INFO_KEY, registrationInfo == null ? new RegistrationInfo() : registrationInfo);

        return "security/registration";
    }


    @PostMapping("/security/processRegistration")
    public String processRegistration(@ModelAttribute RegistrationInfo registrationInfo, HttpSession session)
    {
        // Is user already logged in?
        if (session.getAttribute(SESSION_LOGGED_IN_USER_KEY) != null)
        {
            session.removeAttribute(REGISTRATION_INFO_KEY);
            return "redirect:/index";
        }

        // Make sure our registration info is correct.
        if (registrationInfo == null)
        {
            registrationInfo = new RegistrationInfo();
            registrationInfo.addError("SYSTEM ERROR");
        }
        else
        {
            // Make sure any previous errors are cleared before potentially
            // adding new errors.
            registrationInfo.clearErrors();

            if (StringUtils.isBlank(registrationInfo.getEmail()))
                registrationInfo.addError("Email is required.");

            if (StringUtils.isBlank(registrationInfo.getDesiredUsername()))
                registrationInfo.addError("User name is required.");

            if (StringUtils.isBlank(registrationInfo.getFirstName()))
                registrationInfo.addError("First name is required.");

            if (StringUtils.isBlank(registrationInfo.getLastName()))
                registrationInfo.addError("Last name is required.");

            if (StringUtils.isBlank(registrationInfo.getPhone()))
                registrationInfo.addError("Phone is required.");

            if (StringUtils.isBlank(registrationInfo.getPassword1()))
                registrationInfo.addError("Passwords 1&2 are required, and must match.");
            else if (!StringUtils.equals(registrationInfo.getPassword1(), registrationInfo.getPassword2()))
                registrationInfo.addError("Passwords 1&2 do not match.");
        }

        if (registrationInfo.hasErrors())
        {
            session.setAttribute(REGISTRATION_INFO_KEY, registrationInfo);
            return "redirect:/security/registration";
        }
        // We know registrationInfo is not null, and has valid data.

        User newUser = new User();
        newUser
            .setUserName(registrationInfo.getDesiredUsername())
            .setPassword(registrationInfo.getPassword1())
            .setFirstName(registrationInfo.getFirstName())
            .setMiddleInitial(registrationInfo.getMiddleInitial())
            .setLastName(registrationInfo.getLastName())
            .setEmail(registrationInfo.getEmail())
            .setPhone(registrationInfo.getPhone())
            .isPhoneCell(registrationInfo.isPhoneIsCell());

        try
        {
            _userService.insert(newUser);
            session.setAttribute(SecurityController.SESSION_LOGGED_IN_USER_KEY, newUser);
        }
        catch (Exception e)
        {
            registrationInfo.addError(e.toString());
            session.setAttribute(REGISTRATION_INFO_KEY, registrationInfo);

            return "redirect:/security/registration";
        }

        return "redirect:/index";
    }


    @GetMapping({"/security/logout", "/security/logout.html"})
    public String logout(HttpSession session)
    {
        session.removeAttribute(SESSION_LOGGED_IN_USER_KEY);
        session.invalidate();
        return "redirect:/index";
    }

}