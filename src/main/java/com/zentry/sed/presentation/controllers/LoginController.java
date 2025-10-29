package com.zentry.sed.presentation.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.zentry.sed.presentation.models.dto.UsuarioDTO;
import com.zentry.sed.presentation.models.mappers.UsuarioMapper;
import com.zentry.sed.services.exceptions.LoginUserException;
import com.zentry.sed.services.usecases.LoginUserService;

import jakarta.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;



@Controller
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private LoginUserService loginUserService;

    @GetMapping("")
    public String showLoginPage(Model model, HttpServletRequest request) {
        String errorMessage = (String) request.getSession().getAttribute("errorMessage");
        model.addAttribute("msjErrorLogin", errorMessage);

        return "login"; // tu plantilla login.html
    }
}
