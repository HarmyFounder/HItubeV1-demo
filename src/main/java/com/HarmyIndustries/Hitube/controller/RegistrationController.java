package com.HarmyIndustries.Hitube.controller;

import com.HarmyIndustries.Hitube.model.Role;
import com.HarmyIndustries.Hitube.model.User;
import com.HarmyIndustries.Hitube.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Collections;

@Controller
public class RegistrationController {

    @Autowired
    private UserRepository userRepository;


    @GetMapping("/registration")
    public String registration(){
        return "registration";
    }

    @PostMapping("/registration")
    public String addUser(User user, Model model){
    User userFromDb = userRepository.findByUsername(user.getUsername());

    if(userFromDb != null){
        model.addAttribute("message","user exists!");
        return "registration";
    }

    user.setActive(true);
    user.setRoles(Collections.singleton(Role.USER));

    userRepository.save(user);
        return "redirect:/login";
    }


}
