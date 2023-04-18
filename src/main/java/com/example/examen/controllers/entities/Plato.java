package com.example.examen.controllers.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Plato {
    @Id
    private String id;
    private String color;
    private LocalDate fechaInicioActividad;
    private String nombre;
    private BigDecimal precio;
    private String campos;
    private Boolean oferta;
}
