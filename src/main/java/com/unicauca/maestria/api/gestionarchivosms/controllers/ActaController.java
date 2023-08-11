package com.unicauca.maestria.api.gestionarchivosms.controllers;

import com.unicauca.maestria.api.gestionarchivosms.dtos.ActaCrearDto;
import com.unicauca.maestria.api.gestionarchivosms.dtos.ActaListarDto;
import com.unicauca.maestria.api.gestionarchivosms.services.documento.ActaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/actas")
public class ActaController {

    private final ActaService service;

    @PostMapping
    public ResponseEntity<ActaListarDto> crearActa(@Valid @RequestBody ActaCrearDto acta, BindingResult result){
        return ResponseEntity.status(HttpStatus.CREATED).body(service.crear(acta, result));
    }

    @GetMapping
    public ResponseEntity<List<ActaListarDto>> listarTodos(){
        return ResponseEntity.status(HttpStatus.OK).body(service.listarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ActaListarDto> buscaarPorId(@PathVariable Long id){
        return ResponseEntity.status(HttpStatus.OK).body(service.buscarPorId(id));
    }

    @GetMapping("/estado/{estado}")
    public ResponseEntity<List<ActaListarDto>> buscarPorEstado(@PathVariable Boolean estado){
        return ResponseEntity.status(HttpStatus.OK).body(service.listarTodosByEstado(estado));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ActaListarDto> editarActa(@PathVariable Long id, @Valid @RequestBody ActaCrearDto acta, BindingResult result){
        return ResponseEntity.status(HttpStatus.OK).body(service.editarActa(id, acta, result));
    }
}
