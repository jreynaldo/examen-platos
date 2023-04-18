package com.example.examen.services;

import com.example.examen.controllers.dto.PlatoRequest;
import com.example.examen.controllers.dto.PlatoResponse;

import java.util.List;

public interface PlatosService {
     List<PlatoResponse> getPlatos();

     void crear(PlatoRequest request);

     void modificar(String id, PlatoRequest request);

     void eliminar(String id);
}
