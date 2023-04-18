package com.example.examen.controllers.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.lang.NonNull;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PlatoRequest {

    @Pattern(regexp = "^[0-9a-f]{8}-[0-9a-f]{4}-[1-5][0-9a-f]{3}-[89ab][0-9a-f]{3}-[0-9a-f]{12}$", message = "Formato incorecto")
    private String id;
    @NotEmpty
    @NotNull(message = "Color es requerido")
    private String color;
    @NonNull
    private LocalDate fechaInicioActividad;
    @Pattern(regexp = "\\b\\w+\\b\\s+\\b\\w+\\b", message = "El nombre tiene que tener al menos dos palabras")
    @NotNull(message = "Color es requerido")
    private String nombre;
    @NotNull(message = "Color es requerido")
    private BigDecimal precio;
    @NotNull(message = "Color es requerido")
    private String campos;
    @NotNull(message = "Color es requerido")
    private Boolean oferta;
}


