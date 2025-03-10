package com.example.itemsapi;

/**
 * Clase principal para ejecutar la generación de reportes.
 * Llama a los métodos de la clase {@link GeneradorReportes} para generar diferentes tipos de reportes.
 */
public class Main {

    /**
     * Método principal que inicia la generación de reportes.
     *
     * @param args Argumentos de la línea de comandos (no se utilizan en este caso).
     */
    public static void main(String[] args) {

        GeneradorReportes.generateListadoCompleto();
    }
}
