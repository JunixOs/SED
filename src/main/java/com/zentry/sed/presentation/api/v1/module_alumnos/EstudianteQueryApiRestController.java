package com.zentry.sed.presentation.api.v1.module_alumnos;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.zentry.sed.presentation.models.mappers.VerCursosPorSemestreMapper;
import com.zentry.sed.presentation.models.mappers.VerPerfilMapper;
import com.zentry.sed.presentation.models.responseDTO.GeneralResponseDTO;
import com.zentry.sed.presentation.models.responseDTO.module_alumnos.VerCursosPorSemestreResponseDTO;
import com.zentry.sed.presentation.models.responseDTO.module_alumnos.VerPerfilResponseDTO;
import com.zentry.sed.services.module_alumnos.EstudianteQueryService;
import com.zentry.sed.utils.AuthUtils;


import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;

// Podemos restringir el acceso a un metodo usando @PreAuthorize

// @PreAuthorize("isAuthenticated()"), permite que cualquier usuario autenticado pueda ingresar

// @PreAuthorize("hasRole('COMISION')"), solo el que tenga el rol comision podra acceder

//  @PreAuthorize("hasAnyRole('COMISION','DOCENTE')"), solo el que sea DOCENTE o COMISION podra ingresar

@RestController
@RequestMapping("/api/v1/module_alumnos")
public class EstudianteQueryApiRestController {

    private final EstudianteQueryService estudianteQueryService;

    public EstudianteQueryApiRestController(EstudianteQueryService estudianteQueryService){
        this.estudianteQueryService = estudianteQueryService;
    }

    @GetMapping({"/dashboard" , ""})
    @PreAuthorize("hasRole('ALUMNO')")
    public String alumnoIndex(Model model){

        model.addAttribute("userId" , AuthUtils.getCurrentUserId());

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        System.out.println("Principal class: " + auth.getPrincipal().getClass());
        System.out.println("Auth name: " + auth.getName());

        return "alumno/dashboard";
    }

    @GetMapping("/profile/{usuarioId}")
    @PreAuthorize("hasRole('ALUMNO')")
    public ResponseEntity<GeneralResponseDTO<?>> verPerfil(
        @PathVariable(name = "usuarioId") String usuarioId
    ) {

        if(usuarioId.isBlank()){
            GeneralResponseDTO<Map<String , String>> response = new GeneralResponseDTO<Map<String , String>>(
                false,
                "Ocurrio un error",
                Map.of(
                    "usuarioId" , "Debe especificar el id del usuario."
                )
            );
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
        }

        try {
            VerPerfilResponseDTO verPerfilResponseDTO = VerPerfilMapper.domainToResponse(estudianteQueryService.verPerfil(usuarioId));
            return ResponseEntity.status(HttpStatus.OK).body(
                new GeneralResponseDTO<>(
                    true , 
                    "Operacion exitosa",
                    verPerfilResponseDTO
                )
            );
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(
                new GeneralResponseDTO<>(
                    false, 
                    "Ocurrio un error al procesar la solicitud.", 
                    null
                )
            );
        }
    }

    @GetMapping("/show-courses")
    @PreAuthorize("hasRole('ALUMNO')")
    public ResponseEntity<GeneralResponseDTO<?>> verCursos(
        @RequestParam(name = "usuarioId" , required = true) String usuarioId
    ) {
        if (usuarioId.isBlank()) {

            GeneralResponseDTO<Map<String , String>> generalResponseDTO = new GeneralResponseDTO<Map<String , String>>(
                false,
                "Debe especificar al usuario",
                Map.of(
                    "usuarioId" , "Debe especificar el id del usuario."
                ) // Map.of me permite crear HashMap rapidos sin tener que crear variables nuevas
            );

            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(generalResponseDTO);
        }

        try {
            List<VerCursosPorSemestreResponseDTO> coursesList = estudianteQueryService.verCursosPorSemestre(usuarioId)
            .stream()
            .map(VerCursosPorSemestreMapper::domaintoResponse)
            .collect(Collectors.toList());

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
