package com.zentry.sed.presentation.controllers.alumnos;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

// Podemos restringir el acceso a un metodo usando @PreAuthorize

// @PreAuthorize("isAuthenticated()"), permite que cualquier usuario autenticado pueda ingresar

// @PreAuthorize("hasRole('COMISION')"), solo el que tenga el rol comision podra acceder

//  @PreAuthorize("hasAnyRole('COMISION','DOCENTE')"), solo el que sea DOCENTE o COMISION podra ingresar

@Controller
@RequestMapping("/alumno")
public class AlumnoController {
    
    @GetMapping("/home")
    public String alumnoIndex(){
        return "alumno/home";
    } 
}
