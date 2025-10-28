package com.zentry.sed.presentation.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.zentry.sed.presentation.models.UsuarioDTO;
import com.zentry.sed.services.usecases.RegisterUserService;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;



@Controller
@RequestMapping("/register")
public class RegisterController {

    @Autowired
    private RegisterUserService registerUserService;

    @GetMapping("")
    public String getMethodName(Model model) {
        model.addAttribute("usuarioDTO" , new UsuarioDTO());
        model.addAttribute("roles" , registerUserService.findAllRoles());

        return "register";
    }
    
    @PostMapping("")
    public String postMethodName(
        @Valid @ModelAttribute("usuarioDTO") UsuarioDTO usuarioDTO , 
        BindingResult bindingResult
    ) {
        if (bindingResult.hasErrors()) {
            return "register";
        }
        //TODO: process POST request
        
        // th:object="${usuarioDTO}"
        
        return "redirect:/";
    }
    
}
