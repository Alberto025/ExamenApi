package com.example.itemsapi;

import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 * Controlador encargado de gestionar las rutas web de la aplicación.
 * Utiliza plantillas para mostrar y editar información de Items.
 */
@Controller
@RequestMapping("/web")
public class WebController {

    /**
     * Repositorio de Items para el acceso a la base de datos.
     */
    @Autowired
    ItemRepository itemsRepository;

    /**
     * Muestra la página principal con el listado de todos los Items.
     *
     * @param session la sesión HTTP actual (no se utiliza en este ejemplo, pero está disponible).
     * @param model   el modelo que se envía a la vista.
     * @return el nombre de la plantilla "index".
     */
    @GetMapping("/")
    public String index(HttpSession session, Model model) {
        var items = itemsRepository.findAll();
        model.addAttribute("titulo", "LISTADO DE ITEMS");
        model.addAttribute("items", items);
        return "index";
    }

    /**
     * Muestra la vista de un Item específico.
     * <p>
     * Si el ID no existe en la base de datos, retorna una plantilla "404".
     *
     * @param model la referencia al modelo para pasar datos a la vista.
     * @param id    el identificador del Item.
     * @return el nombre de la plantilla a mostrar ("single" si existe, o "404" si no existe).
     */
    @GetMapping("/{id}")
    public String single(Model model, @PathVariable Integer id) {
        var items = itemsRepository.findById(id);
        if (items.isEmpty()) {
            return "404";
        } else {
            model.addAttribute("items", items.get());
            return "single";
        }
    }

    /**
     * Muestra el formulario para crear un nuevo Item.
     *
     * @param model el modelo que se envía a la vista.
     * @return el nombre de la plantilla "new".
     */
    @GetMapping("/new")
    public String mostrarFormularioNuevoItem(Model model) {
        model.addAttribute("item", new Items());
        return "new";
    }

    /**
     * Procesa el envío del formulario para crear un nuevo Item.
     *
     * @param item el objeto Item que se recibe desde el formulario.
     * @return una redirección a la ruta principal "/web/".
     */
    @PostMapping("/new")
    public String crearItem(@ModelAttribute Items item) {
        itemsRepository.save(item);
        return "redirect:/web/";
    }

    /**
     * Muestra el formulario de edición de un Item existente.
     * <p>
     * Si el Item no existe, se lanza una excepción {@link IllegalArgumentException}.
     *
     * @param id    el identificador del Item a editar.
     * @param model el modelo para pasar datos a la vista.
     * @return el nombre de la plantilla "edit".
     */
    @GetMapping("{id}/edit")
    public String mostrarFormularioEdicion(@PathVariable Integer id, Model model) {
        Items items = itemsRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("ID de item no válido: " + id));
        model.addAttribute("items", items);
        return "edit";
    }

    /**
     * Procesa la actualización de los datos de un Item.
     * <p>
     * Si el Item no existe, se lanza una excepción {@link IllegalArgumentException}.
     *
     * @param id    el identificador del Item a actualizar.
     * @param items el objeto con los datos actualizados.
     * @return una redirección a la ruta principal "/web/".
     */
    @PutMapping("{id}/edit")
    public String actualizarItem(@PathVariable Integer id, @ModelAttribute Items items) {
        Items itemExistente = itemsRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("ID de item no válido: " + id));

        // Actualizar campos del item
        itemExistente.setTitle(items.getTitle());
        itemExistente.setPrice(items.getPrice());
        itemExistente.setDescription(items.getDescription());
        itemExistente.setCategory(items.getCategory());
        itemExistente.setImage(items.getImage());
        itemExistente.setRate(items.getRate());
        itemExistente.setCount(items.getCount());

        itemsRepository.save(itemExistente);

        return "redirect:/web/";
    }

    /**
     * Elimina un Item por su ID numérico a través de una petición DELETE.
     * <p>
     * Si el Item con el ID indicado existe, se procede a su eliminación.
     * Finalmente, se redirige al listado principal de Items.
     *
     * @param id el identificador (Integer) del Item a eliminar.
     * @return una redirección a la ruta principal "/web/".
     */
    @DeleteMapping("/{id}/delete")
    public String deleteItem(@PathVariable Integer id) {
        var optionalItem = itemsRepository.findById(id);
        optionalItem.ifPresent(items -> itemsRepository.delete(items));
        return "redirect:/web/";
    }
}
