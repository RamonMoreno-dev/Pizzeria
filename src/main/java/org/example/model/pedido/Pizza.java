package org.example.model.pedido;

public class Pizza extends Producto{

    private SIZE size;

    public void setSize(SIZE size) {
        this.size = size;
    }

    public SIZE getSize() {
        return size;
    }
    public Pizza() {
        super();
    }

    public Pizza(int id, String nombre, double precio, SIZE size) {
        super(id, nombre, precio);
        this.size = size;
    }

    @Override
    public String toString() {
        return "Pizza{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", precio=" + precio +
                ", size=" + size +
                '}';
    }
}
