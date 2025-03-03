package com.example.itemsapi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controlador REST que expone endpoints para manejar operaciones CRUD sobre la entidad Items.
 */
@RestController
@RequestMapping("/api")
public class APIController {

    /**
     * Repositorio de Items que provee acceso a las operaciones con la base de datos.
     */
    @Autowired
    private ItemRepository itemsRepository;

    /**
     * Devuelve todos los Items disponibles en la base de datos.
     *
     * @return una lista con todos los Items.
     */
    @GetMapping("/items")
    public List<Items> all() {
        return itemsRepository.findAll();
    }

    /**
     * Busca y devuelve una lista de Items por un ID específico.
     * <p>
     * Si no se encuentran resultados, se retorna {@code null}.
     *
     * @param id el ID del Item que se desea buscar.
     * @return una lista de Items que coinciden con el ID o {@code null} si no se encuentra ninguno.
     */
    @GetMapping("/id/{id}")
    public List<Items> findById(@PathVariable Integer id) {
        if (itemsRepository.findItemsById(id).isEmpty()) {
            return null;
        }
        return itemsRepository.findItemsById(id);
    }

    /**
     * Crea un nuevo Item en la base de datos.
     *
     * @param item objeto de tipo Items que se desea persistir.
     * @return el Item recién creado.
     */
    @PostMapping("/items")
    public Items create(@RequestBody Items item) {
        itemsRepository.save(item);
        return item;
    }

    /**
     * Busca y devuelve una lista de Items según la categoría especificada.
     * <p>
     * Si la categoría es igual a "jewelery", se retorna {@code null} como ejemplo de lógica
     * particular (aunque no es muy común retornar {@code null} en vez de una lista vacía).
     *
     * @param category categoría de los Items a buscar.
     * @return una lista de Items que coinciden con la categoría o {@code null} si la categoría es "jewelery".
     */
    @GetMapping("/items/{category}")
    public List<Items> findByCategory(@PathVariable String category) {
        if (itemsRepository.findItemsByCategory(category).equals("jewelery")) {
            return null;
        }
        return itemsRepository.findItemsByCategory(category);
    }

    /**
     * Elimina uno o varios Items de la base de datos por su ID.
     * <p>
     * Si los Items con el ID especificado existen, se eliminan todos los que coincidan.
     *
     * @param id el ID de los Items que se desean eliminar.
     */
    @DeleteMapping("/items/{id}")
    public void deleteItem(@PathVariable Integer id) {
        List<Items> itemsAEliminar = itemsRepository.findItemsById(id);
        if (!itemsAEliminar.isEmpty()) {
            itemsRepository.deleteAll(itemsAEliminar);
        }
    }
}
