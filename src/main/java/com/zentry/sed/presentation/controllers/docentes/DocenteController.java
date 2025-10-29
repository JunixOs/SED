package com.zentry.sed.presentation.controllers.docentes;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/docente")
public class DocenteController {

    @GetMapping({"/dashboard" , ""})
    public String docenteIndex(){
        return "docente/dashboard";
    } 
}
