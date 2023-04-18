package com.example.examen.controllers;

import com.example.examen.controllers.dto.PlatoRequest;
import com.example.examen.controllers.dto.PlatoResponse;
import com.example.examen.services.PlatosService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import javax.validation.constraints.Pattern;
import java.util.List;

@RestController
@RequestMapping("/api/v1")
@AllArgsConstructor
@Validated
public class PlatoController {
    private PlatosService service;
    @GetMapping("/platos")
    public ResponseEntity<List<PlatoResponse>> getList(){

      return ResponseEntity.ok(service.getPlatos());
    }

    @PostMapping("/platos")
    public ResponseEntity crear(@Valid @RequestBody PlatoRequest request){

       service.crear(request);
       return new ResponseEntity(HttpStatus.CREATED);
    }

    @PutMapping("/platos/{id}")
    public ResponseEntity actulizar(
            @Valid
            @Pattern(regexp = "^[0-9a-f]{8}-[0-9a-f]{4}-[1-5][0-9a-f]{3}-[89ab][0-9a-f]{3}-[0-9a-f]{12}$", message = "Formato incorecto")
            @PathVariable String id,
            @RequestBody PlatoRequest request){

        service.modificar(id,request);
        return new ResponseEntity(HttpStatus.OK);
    }

    @DeleteMapping("/platos/{id}")
    public ResponseEntity eliminar(
            @Valid
            @Pattern(regexp = "^[0-9a-f]{8}-[0-9a-f]{4}-[1-5][0-9a-f]{3}-[89ab][0-9a-f]{3}-[0-9a-f]{12}$", message = "Formato incorecto")
            @PathVariable String id){

        service.eliminar(id);
        return new ResponseEntity(HttpStatus.OK);
    }
}
