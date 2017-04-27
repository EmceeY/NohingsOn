package com.github.EmceeY.controllers;

import com.github.EmceeY.models.User;
import com.github.EmceeY.models.data.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

/**
 * Created by User on 4/23/17.
 */
@Controller
public class UserController {

    @Autowired
    private UserDao userDao;

    @RequestMapping(value="")
    public String index(Model model){
        model.addAttribute("title", "Nothing's On");
        return "user/index";
    }

    @RequestMapping(value="add", method = RequestMethod.GET)
    public String add(Model model){
        model.addAttribute(new User());
        model.addAttribute("title", "Find something to watch!");
        return "user/add";
    }

    @RequestMapping(value="add", method = RequestMethod.POST)
    public String add(Model model, @ModelAttribute @Valid User user, Errors errors){
        if(errors.hasErrors()){
            model.addAttribute("title", "Find something to watch!");
            return "user/add";
        }
        userDao.save(user);
        return "redirect:view/" + user.getId();
    }

    @RequestMapping(value="view/{userId}", method=RequestMethod.GET)
    public String viewUser(Model model, @PathVariable int userId){
        User user =  userDao.findOne(userId);
        model.addAttribute("user", user);
        model.addAttribute("userId", user.getId());
        return "user/view";
    }

    @RequestMapping(value="login", method = RequestMethod.GET)
    public String login(Model model){
        model.addAttribute("title", "Welcome back!");
        return "user/login";
    }

    @RequestMapping(value="login", method=RequestMethod.POST)
    public String login(Model model, @ModelAttribute @Valid User user, Errors errors){
        if(errors.hasErrors()){
            model.addAttribute("title", "Welcome back!");
            return "user/login";
        }

        User loginAttempt = userDao.findOne(user.getId());

        if(loginAttempt.getPassword() == user.getPassword()){
            model.addAttribute("title", "Welcome " + user.getName() + " !");
            return "redirect:view/" + user.getId();
        }
        else{
            model.addAttribute("error", "Incorrect password!");
            return "user/login";
        }
    }


}
