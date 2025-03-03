package com.example.itemsapi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

    @RestController
    @RequestMapping("/api")
    public class APIController {

        @Autowired
        private ItemRepository itemsRepository;

        @GetMapping("/items")
        public List<Items> all() {
            return itemsRepository.findAll();
        }


        @GetMapping("/id/{id}")
        public List<Items> findById(@PathVariable Integer id) {
            if (itemsRepository.findItemsById(id).isEmpty()) {
                return null;
            }
            return itemsRepository.findItemsById(id);
        }


        @PostMapping("/items")
        public Items create(@RequestBody Items item) {
            itemsRepository.save(item);
            return item;
        }


        @GetMapping("/items/{category}")
        public List<Items> findByCategory(@PathVariable String category) {
            if (itemsRepository.findItemsByCategory(category).equals("jewelery")) {
                return null;
            }
            return itemsRepository.findItemsByCategory(category);
        }

        @DeleteMapping("/items/{id}")
        public void deleteItem(@PathVariable Integer id) {
            List<Items> itemsAEliminar = itemsRepository.findItemsById(id);
            if (!itemsAEliminar.isEmpty()) {
                itemsRepository.deleteAll(itemsAEliminar);
            }

        }
    }



