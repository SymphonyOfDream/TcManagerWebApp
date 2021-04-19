package com.davidlowe.tcmanagerwebapp.controllers;


import com.davidlowe.tcmanagerwebapp.models.User;
import com.davidlowe.tcmanagerwebapp.models.formhelpers.LoginInfo;
import com.davidlowe.tcmanagerwebapp.models.formhelpers.RegistrationInfo;
import com.davidlowe.tcmanagerwebapp.models.formhelpers.UserProfileInfo;
import com.davidlowe.tcmanagerwebapp.services.UserService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;
import java.util.Optional;


@Controller
public class UserController
{
    private final String USER_PROFILE_INFO_KEY = "UserProfileInfo";

    private final UserService _userService;


    public UserController(UserService userService)
    {
        _userService = userService;
    }


    @GetMapping({"/security/user_profile", "/security/user_profile.html"})
    public String userProfileForm(Model model, HttpSession session)
    {
        // Is user NOT logged in?
        User loggedInUser = (User) session.getAttribute(SecurityController.SESSION_LOGGED_IN_USER_KEY);
        if (loggedInUser == null)
        {
            session.removeAttribute(USER_PROFILE_INFO_KEY);
            return "redirect:/security/login";
        }

        // If we are here from processUserProfile, then our UserProfileInfo will be in the session.
        UserProfileInfo userProfileInfo;
        if ((userProfileInfo = (UserProfileInfo) session.getAttribute(USER_PROFILE_INFO_KEY)) != null)
        {
            // Now that we got the object, we remove it from the session.
            session.removeAttribute(USER_PROFILE_INFO_KEY);
        }

        // If we did not get the info from the session, we try to get it from the model.
        if (userProfileInfo == null)
        {
            userProfileInfo = (UserProfileInfo) model.getAttribute(USER_PROFILE_INFO_KEY);
        }

        // If the model did not have our info, then we just create a new info.
        if (userProfileInfo == null)
        {
            userProfileInfo = new UserProfileInfo(loggedInUser);
        }

        // Add User profile info object to the model so our page can use it.
        model.addAttribute(SecurityController.SESSION_LOGGED_IN_USER_KEY, userProfileInfo);

        return "security/user_profile";
    }


    @PostMapping(value = "/security/process_user_profile")
    public String processUserProfile(@ModelAttribute UserProfileInfo userProfileInfo, HttpSession session)
    {
        // Is user NOT logged in?
        User loggedInUser = (User) session.getAttribute(SecurityController.SESSION_LOGGED_IN_USER_KEY);
        if (loggedInUser == null)
        {
            session.removeAttribute(USER_PROFILE_INFO_KEY);
            return "redirect:/security/login";
        }

        // Make sure our registration info is correct.
        if (userProfileInfo == null)
        {
            session.removeAttribute(USER_PROFILE_INFO_KEY);
            userProfileInfo = new UserProfileInfo(loggedInUser);
            userProfileInfo.addError("SYSTEM ERROR");
        }
        else
        {
            if (StringUtils.isBlank(userProfileInfo.getEmail()))
            {
                userProfileInfo.addError("Email is required.");
            }

            if (!StringUtils.isBlank(userProfileInfo.getNewPassword1())
                    || !StringUtils.isBlank(userProfileInfo.getNewPassword2()))
            {
                // If they entered any new password info, then the new passwords must be the same
                if (!StringUtils.equals(userProfileInfo.getNewPassword1(), userProfileInfo.getNewPassword2()))
                {
                    userProfileInfo.addError("New passwords do not match.");
                }
                else
                {
                    // Passwords entered and they match, the user MUST provide current password.
                    if (StringUtils.isBlank(userProfileInfo.getCurrentPassword()))
                    {
                        userProfileInfo.addError("You must supply your current password in order to change it.");
                    }
                    else
                    {
                        Optional<User> fullUser = _userService.get(loggedInUser.getId());
                        if (fullUser.isPresent())
                        {
                            if (!StringUtils.equals(fullUser.get().getPassword(), userProfileInfo.getCurrentPassword()))
                            {
                                userProfileInfo.setCurrentPassword("");
                                userProfileInfo.addError("Entered password is not correct.");
                            }
                        }
                        else
                        {
                            userProfileInfo.addError("SYSTEM ERROR.");
                        }
                    }
                }
            }

            if (StringUtils.isBlank(userProfileInfo.getFirstName()))
            {
                userProfileInfo.addError("First name is required.");
            }

            if (StringUtils.isBlank(userProfileInfo.getLastName()))
            {
                userProfileInfo.addError("Last name is required.");
            }

            if (StringUtils.isBlank(userProfileInfo.getPhone()))
            {
                userProfileInfo.addError("Phone is required.");
            }
        }

        if (userProfileInfo.hasErrors())
        {
            session.setAttribute(USER_PROFILE_INFO_KEY, userProfileInfo);
            return "redirect:/security/registration";
        }

        session.removeAttribute(USER_PROFILE_INFO_KEY);

        loggedInUser.updateFrom(userProfileInfo);
        session.setAttribute(SecurityController.SESSION_LOGGED_IN_USER_KEY, loggedInUser);
        return "redirect:/index";
    }


}
