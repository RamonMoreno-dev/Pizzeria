package org.example.ficheros;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.example.model.pedido.Pizza;
import org.example.model.pedido.Producto;



import java.io.File;
import java.io.IOException;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    public static void exportarProductos(List<Producto> productos) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.enable(SerializationFeature.INDENT_OUTPUT);

        objectMapper.writeValue(new File("productos.json"), productos);
        System.out.println("Producto exportado exitosamente a productos.json");
    }
    public static void importarProductos(List<Producto> productos) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        File fichero = new File("productos.json");

        objectMapper.readValue(fichero, Producto.class);
        System.out.println("Producto exportado exitosamente a productos.json");
    }

}