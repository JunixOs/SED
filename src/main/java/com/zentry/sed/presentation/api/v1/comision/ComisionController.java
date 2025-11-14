package com.zentry.sed.presentation.api.v1.comision;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/comision")
public class ComisionController {

    @GetMapping({"/dashboard" , ""})
    public String comisionIndex(){
        return "comision/dashboard";
    } 
}
