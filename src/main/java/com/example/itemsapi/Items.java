package com.example.itemsapi;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Representa un documento de tipo "items" en la base de datos MongoDB.
 * Se mapeará a la colección "items" y utiliza Lombok para generar
 * automáticamente getters, setters, métodos equals, hashCode y toString.
 */
@Document(collection = "items")
@Data
public class Items {

    /**
     * Campo identificador único en MongoDB.
     */
    @Id
    private String _id;

    /**
     * ID numérico de la entidad Item (puede utilizarse como clave de negocio).
     */
    private Integer id;

    /**
     * Título o nombre del item.
     */
    private String title;

    /**
     * Precio del item.
     */
    private Double price;

    /**
     * Categoría a la que pertenece el item.
     */
    private String category;

    /**
     * Descripción detallada del item.
     */
    private String description;

    /**
     * Calificación o puntuación del item (puede representar una media de valoraciones).
     */
    private Double rate;

    /**
     * Cantidad disponible del item.
     */
    private Integer count;

    /**
     * URL o ruta a la imagen que representa el item.
     */
    private String image;
}
