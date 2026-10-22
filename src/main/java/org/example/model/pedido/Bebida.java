package org.example.model.pedido;

public class Bebida extends Producto{
    private SIZE size;
    public Bebida(int id, String nombre, double precio, SIZE size) {
        super(id, nombre, precio);
        this.size = size;
    }
}
