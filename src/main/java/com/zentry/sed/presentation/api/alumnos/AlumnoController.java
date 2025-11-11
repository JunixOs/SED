package com.zentry.sed.presentation.api.alumnos;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zentry.sed.presentation.models.requestDTO.module_alumnos.VerCursosPorSemestreRequestDTO;
import com.zentry.sed.presentation.models.responseDTO.GeneralResponseDTO;
import com.zentry.sed.presentation.models.responseDTO.module_alumnos.VerCursosPorSemestreResponseDTO;
import com.zentry.sed.services.module_alumnos.EstudianteService;
import com.zentry.sed.utils.AuthUtils;

import jakarta.validation.Valid;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;

// Podemos restringir el acceso a un metodo usando @PreAuthorize

// @PreAuthorize("isAuthenticated()"), permite que cualquier usuario autenticado pueda ingresar

// @PreAuthorize("hasRole('COMISION')"), solo el que tenga el rol comision podra acceder

//  @PreAuthorize("hasAnyRole('COMISION','DOCENTE')"), solo el que sea DOCENTE o COMISION podra ingresar

@Controller
@RequestMapping("/alumno")
public class AlumnoController {

    private final EstudianteService estudianteService;

    public AlumnoController(EstudianteService estudianteService){
        this.estudianteService = estudianteService;
    }

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

    @GetMapping("/show-courses")
    public ResponseEntity<GeneralResponseDTO<?>> verCursos(
        @Valid @ModelAttribute("verCursosPorSemestreRequestDTO") VerCursosPorSemestreRequestDTO verCursosPorSemestreRequestDTO , 
        BindingResult bindingResult
    ) {
        if (bindingResult.hasErrors()) {

            // Tengo que convertirlo a un "hashmap" antes para poder enviarlo.
            Map<String , String> errorMessages = new HashMap<>();

            bindingResult.getFieldErrors().forEach(
                errorField -> errorMessages.put(errorField.getField() , errorField.getDefaultMessage())
            );

            GeneralResponseDTO<Map<String , String>> generalResponseDTO = new GeneralResponseDTO<>(
                false,
                "",
                errorMessages
            );

            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(generalResponseDTO);
        }

        try {
            List<VerCursosPorSemestreResponseDTO> coursesList = estudianteService.verCursosPorSemestre(verCursosPorSemestreRequestDTO);

            GeneralResponseDTO<List<VerCursosPorSemestreResponseDTO>> responseDTO = new GeneralResponseDTO<List<VerCursosPorSemestreResponseDTO>>(
                true,
                "Operacion exitosa", 
                coursesList
            ); 

            return ResponseEntity.status(HttpStatus.OK).body(responseDTO);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
                new GeneralResponseDTO<>(
                    false, 
                    "Ocurrio un error al procesar la consulta.", 
                    null
                )
            );
        }
    }
    
}
