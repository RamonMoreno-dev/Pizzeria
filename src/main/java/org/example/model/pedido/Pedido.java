package org.example.model.pedido;

import java.time.LocalDate;
import java.util.List;

public class Pedido {
    private int id;
    private LocalDate fecha;
    private float precioTotal;
    private EstadoPedido estadoPedido;
    private List<LineaPedido> lineaPedido;

    public List<LineaPedido> getLineaPedido() {
        return lineaPedido;
    }

    public void setLineaPedido(List<LineaPedido> pedido) {
        this.lineaPedido = pedido;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public float getPrecioTotal() {
        return precioTotal;
    }

    public void setPrecioTotal(float precioTotal) {
        this.precioTotal = precioTotal;
    }

    public EstadoPedido getEstado() {
        return estadoPedido;
    }

    public void setEstado(EstadoPedido estado) {
        this.estadoPedido = estado;
    }

    public void agregarLinea(LineaPedido linea) {
        lineaPedido.add(linea);
    }
}
