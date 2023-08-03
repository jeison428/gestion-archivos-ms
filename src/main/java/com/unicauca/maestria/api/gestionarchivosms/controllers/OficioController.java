package com.unicauca.maestria.api.gestionarchivosms.controllers;

import com.unicauca.maestria.api.gestionarchivosms.dtos.OficioCrearDto;
import com.unicauca.maestria.api.gestionarchivosms.dtos.OficioListarDto;
import com.unicauca.maestria.api.gestionarchivosms.services.documento.OficioService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/oficios")
public class OficioController {

    private final OficioService service;

    @PostMapping
    public ResponseEntity<OficioListarDto> crearOficio(@Valid @RequestBody OficioCrearDto oficio, BindingResult result){
        return ResponseEntity.status(HttpStatus.CREATED).body(service.crear(oficio, result));
    }

    @GetMapping
    public ResponseEntity<List<OficioListarDto>> listarTodos(){
        return ResponseEntity.status(HttpStatus.OK).body(service.listarTodos());
    }
}