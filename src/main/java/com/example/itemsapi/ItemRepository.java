package com.example.itemsapi;

import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.List;
import java.util.Optional;

/**
 * Repositorio de datos para la entidad {@link Items}, que extiende de {@link MongoRepository}
 * para proporcionar métodos de acceso y manipulación en la base de datos MongoDB.
 */
public interface ItemRepository extends MongoRepository<Items, String> {

    /**
     * Retorna todos los objetos de tipo {@link Items} almacenados en la base de datos.
     *
     * @return una lista con todos los {@link Items}.
     */
    List<Items> findAll();

    /**
     * Retorna una lista de objetos {@link Items} que coinciden con el ID numérico especificado.
     *
     * @param id el ID numérico del Item (no el ID de Mongo).
     * @return una lista de {@link Items} con el ID especificado.
     */
    List<Items> findItemsById(Integer id);

    /**
     * Retorna una lista de objetos {@link Items} que pertenecen a la categoría especificada.
     *
     * @param category la categoría del Item.
     * @return una lista de {@link Items} que coinciden con la categoría dada.
     */
    List<Items> findItemsByCategory(String category);

    /**
     * Retorna un objeto {@link Items} por su ID numérico, envuelto en un {@link Optional}.
     *
     * @param id el ID numérico del Item.
     * @return un {@code Optional<Items>} que contiene el Item si existe,
     *         o {@code Optional.empty()} si no se encuentra ninguno.
     */
    Optional<Items> findById(Integer id);
}
