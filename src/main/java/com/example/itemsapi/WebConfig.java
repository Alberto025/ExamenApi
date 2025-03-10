package com.example.itemsapi;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.filter.HiddenHttpMethodFilter;

/**
 * Configuración para habilitar el soporte de métodos HTTP ocultos en formularios HTML.
 * Esto permite que los formularios HTML puedan enviar solicitudes con métodos como PUT y DELETE,
 * utilizando un campo oculto <input type="hidden" name="_method" value="PUT">.
 */
@Configuration
public class WebConfig {

    /**
     * Define un filtro para permitir el uso de métodos HTTP como PUT y DELETE en formularios HTML.
     *
     * @return Instancia de {@link HiddenHttpMethodFilter}, que habilita el uso de métodos HTTP ocultos.
     */
    @Bean
    public HiddenHttpMethodFilter hiddenHttpMethodFilter() {
        return new HiddenHttpMethodFilter();
    }
}
