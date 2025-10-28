package com.zentry.sed.presentation.controllers.docentes;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/docente")
public class DocenteController {
    @GetMapping("/home")
    public String docenteIndex(){
        return "docente/home";
    } 
}
