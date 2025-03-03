package com.example.itemsapi;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "items")
@Data

public class Items {
    @Id
    private String _id;
    private Integer id;
    private String title;
    private Double price;
    private String category;
    private String description;
    private Double rate;
    private Integer count;
    private String image;
}





