package com.zentry.sed.presentation.api;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zentry.sed.utils.AuthUtils;

@Controller
@RequestMapping("/")
public class IndexController {
    
    @GetMapping(path = "")
    public String root(Model model) {
        model.addAttribute("userLogged", AuthUtils.isAuthenticated());

        return "index";
    }
}
