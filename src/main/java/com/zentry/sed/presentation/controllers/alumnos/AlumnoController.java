package com.zentry.sed.presentation.controllers.alumnos;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zentry.sed.utils.AuthUtils;
import org.springframework.security.core.Authentication;

// Podemos restringir el acceso a un metodo usando @PreAuthorize

// @PreAuthorize("isAuthenticated()"), permite que cualquier usuario autenticado pueda ingresar

// @PreAuthorize("hasRole('COMISION')"), solo el que tenga el rol comision podra acceder

//  @PreAuthorize("hasAnyRole('COMISION','DOCENTE')"), solo el que sea DOCENTE o COMISION podra ingresar

@Controller
@RequestMapping("/alumno")
public class AlumnoController {

    @GetMapping({"/dashboard" , ""})
    public String alumnoIndex(Model model){

        model.addAttribute("userId" , AuthUtils.getCurrentUserId());

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        System.out.println("Principal class: " + auth.getPrincipal().getClass());
        System.out.println("Auth name: " + auth.getName());
        
        return "alumno/dashboard";
    }

    @GetMapping("/profile/{userId}")
    public String showProfile(Model model , @PathVariable(name = "userId") String userId) {
        /* model.addAttribute("alumno", alumnoService.getById(id));
        model.addAttribute("cursos", cursoService.getCursosAlumno(id));
        model.addAttribute("evaluacionesCount", 5);
        model.addAttribute("cursosEvaluados", 3);
        model.addAttribute("cursosCount", 4);  */
        // esto se debe terminar tambien
       
        return "alumno/profile";
    }
}
