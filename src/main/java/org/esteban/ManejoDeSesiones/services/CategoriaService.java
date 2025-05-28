package org.esteban.ManejoDeSesiones.services;

import org.esteban.ManejoDeSesiones.models.Categoría;

import java.util.List;
import java.util.Optional;

public interface CategoriaService {
    List<Categoría> listar();
    Optional<Categoría> porId(Long id);
}
