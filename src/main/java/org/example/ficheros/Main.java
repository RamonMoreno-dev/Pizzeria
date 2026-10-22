package org.example.ficheros;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.example.model.pedido.Pizza;
import org.example.model.pedido.Producto;



import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws IOException {
        List<Producto> productos = importarProductos();

        System.out.println("Lista de productos:" +  productos);
    }
    public static void exportarProductos(List<Producto> productos) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.enable(SerializationFeature.INDENT_OUTPUT);

        objectMapper.writeValue(new File("productos.json"), productos);
        System.out.println("Producto exportado exitosamente a productos.json");
    }
    public static List<Producto> importarProductos() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        File fichero = new File("productos.json");

        if (!fichero.exists()) {
            System.out.println("El fichero no existe.");
            return null;
        }

        return objectMapper.readValue(fichero, objectMapper.getTypeFactory().constructCollectionType(List.class, Producto.class));

    }

}