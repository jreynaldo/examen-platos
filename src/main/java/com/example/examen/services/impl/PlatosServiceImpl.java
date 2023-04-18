package com.example.examen.services.impl;

import com.example.examen.controllers.dto.PlatoRequest;
import com.example.examen.controllers.dto.PlatoResponse;
import com.example.examen.controllers.entities.Plato;
import com.example.examen.repositories.PlatoRepository;
import com.example.examen.services.PlatosService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class PlatosServiceImpl implements PlatosService {
    private PlatoRepository repository;

    @Override
    public List<PlatoResponse> getPlatos() {
        return repository.findAll().stream().map(this::toConvert).collect(Collectors.toList());
    }

    private PlatoResponse toConvert(Plato plato) {
        return PlatoResponse.builder()
                .id(plato.getId())
                .color(plato.getColor())
                .fechaInicioActividad(plato.getFechaInicioActividad())
                .nombre(plato.getNombre())
                .precio(plato.getPrecio())
                .campos(plato.getCampos())
                .oferta(plato.getOferta())
                .build();
    }

    @Override
    public void crear(PlatoRequest request) {

        Plato plato = Plato.builder()
                .id(request.getId())
                .color(request.getColor())
                .fechaInicioActividad(request.getFechaInicioActividad())
                .nombre(request.getNombre())
                .precio(request.getPrecio())
                .campos(request.getCampos())
                .oferta(request.getOferta())
                .build();
        repository.save(plato);
    }

    @Override
    public void modificar(String id, PlatoRequest request) {

         repository.findById(id).ifPresent((plato) -> {
             Plato platoNew = Plato.builder()
                     .id(plato.getId())
                     .color(request.getColor())
                     .fechaInicioActividad(request.getFechaInicioActividad())
                     .nombre(request.getNombre())
                     .precio(request.getPrecio())
                     .campos(request.getCampos())
                     .oferta(request.getOferta())
                     .build();
             repository.save(platoNew);

         });

    }

    @Override
    public void eliminar(String id) {
        repository.findById(id).ifPresent(plato -> {
            repository.deleteById(id);
        });
    }
}
