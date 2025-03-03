package com.example.itemsapi;
import org.springframework.data.mongodb.repository.MongoRepository;


import java.util.List;

public interface ItemRepository extends MongoRepository<Items, String>  {
    List<Items> findAll();
    List<Items> findItemsById(Integer id);
    List<Items> findItemsByCategory(String category);


    }


