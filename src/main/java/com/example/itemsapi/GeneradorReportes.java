package com.example.itemsapi;

import net.sf.jasperreports.engine.*;
import java.util.HashMap;
import java.util.Map;
import java.sql.Connection;

/**
 * Clase responsable de generar reportes en formato PDF utilizando JasperReports.
 * Proporciona métodos genéricos y específicos para la creación de distintos tipos de reportes.
 */
public class GeneradorReportes {

    /**
     * Genera un reporte en formato PDF a partir de un archivo JasperReports.
     *
     * @param reportPath     Ruta del archivo .jasper que define el diseño del reporte.
     * @param parameters     Map de parámetros utilizados por el reporte para filtrar o personalizar la información.
     * @param outputFilePath Ruta del archivo de salida donde se generará el PDF.
     */
    public static void generateReport(String reportPath, Map<String, Object> parameters, String outputFilePath) {
        try {
            // Llenar el reporte con datos y parámetros
            JasperPrint jasperPrint = JasperFillManager.fillReport(reportPath, parameters);

            // Exportar el reporte a un archivo PDF
            JasperExportManager.exportReportToPdfFile(jasperPrint, outputFilePath);

            System.out.println("Reporte generado en: " + outputFilePath);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Genera un listado completo de todas las películas.
     * El reporte no incluye filtros ni parámetros dinámicos.
     */
    public static void generateListadoCompleto() {
        String reportPath = "C:/Users/AlbertoLopezCabello/IdeaProjects/ItemsApi/Examen.jasper"; // Localizacion del jasper que he compilado (cojo el archivo compilado, acaba en .jasper)
        Map<String, Object> parameters = new HashMap<>(); // Sin parámetros dinámicos
        String outputFilePath = "C:/Users/AlbertoLopezCabello/IdeaProjects/ItemsApi/Items/Items.pdf"; //ListadoCompleto es el nombre de la carpeya donde esta y Pelis.pdf el nombre del pdf con la informacion del jasper

        generateReport(reportPath, parameters, outputFilePath);
    }
}
