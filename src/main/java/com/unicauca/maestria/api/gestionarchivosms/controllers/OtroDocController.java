package com.unicauca.maestria.api.gestionarchivosms.controllers;

import com.unicauca.maestria.api.gestionarchivosms.dtos.OtroDocCrearDto;
import com.unicauca.maestria.api.gestionarchivosms.dtos.OtroDocListarDto;
import com.unicauca.maestria.api.gestionarchivosms.services.documento.OtroDocService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/otros")
public class OtroDocController {

    private final OtroDocService service;

    @PostMapping
    public ResponseEntity<OtroDocListarDto> crearOtroDoc(@Valid @RequestBody OtroDocCrearDto otroDoc, BindingResult result){
        return ResponseEntity.status(HttpStatus.CREATED).body(service.crear(otroDoc, result));
    }

    @GetMapping
    public ResponseEntity<List<OtroDocListarDto>> listarTodos(){
        return ResponseEntity.status(HttpStatus.OK).body(service.listarTodos());
    }
}
