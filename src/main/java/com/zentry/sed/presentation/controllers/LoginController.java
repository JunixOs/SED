package com.zentry.sed.presentation.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.zentry.sed.services.exceptions.LoginUserException;
import com.zentry.sed.services.usecases.LoginUserService;


import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private LoginUserService loginUserService;

    @GetMapping("")
    public String showLoginPage() {
        return "login"; // tu plantilla login.html
    }

    @PostMapping("")
    public String loginProcess(
        Model model ,
        @RequestParam(name = "correo") String correo , 
        @RequestParam(name = "password") String password
    ) {

        try {
            this.loginUserService.login(correo, password);
        } catch (LoginUserException e) {
            // TODO: handle exception
            model.addAttribute("msgErrorLogin", e.getMessage());
            return "login";
        }
        //TODO: process POST request
        
        return "redirect:/";
    }
    

}
