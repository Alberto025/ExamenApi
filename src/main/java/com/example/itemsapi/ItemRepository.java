package com.example.itemsapi;

import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.List;

/**
 * Repositorio de datos para la entidad {@link Items}, que extiende de MongoRepository
 * para proporcionar métodos de acceso y manipulación en la base de datos MongoDB.
 */
public interface ItemRepository extends MongoRepository<Items, String> {

    /**
     * Retorna todos los objetos de tipo {@link Items} almacenados en la base de datos.
     *
     * @return una lista con todos los Items.
     */
    List<Items> findAll();

    /**
     * Retorna una lista de objetos {@link Items} que coinciden con el ID especificado.
     *
     * @param id el ID único del Item.
     * @return una lista de Items con el ID indicado.
     */
    List<Items> findItemsById(Integer id);

    /**
     * Retorna una lista de objetos {@link Items} que pertenecen a la categoría especificada.
     *
     * @param category la categoría del Item.
     * @return una lista de Items que coinciden con la categoría indicada.
     */
    List<Items> findItemsByCategory(String category);

}
