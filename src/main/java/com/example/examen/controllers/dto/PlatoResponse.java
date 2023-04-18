package com.example.examen.controllers.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Builder
@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
public class PlatoResponse {
    private String id;
    private String color;
    private LocalDate fechaInicioActividad;
    private String nombre;
    private BigDecimal precio;
    private String campos;
    private Boolean oferta;
}
