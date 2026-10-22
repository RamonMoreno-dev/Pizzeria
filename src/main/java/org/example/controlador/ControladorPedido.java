package org.example.controlador;

import org.example.model.Cliente;
import org.example.model.pedido.EstadoPedido;
import org.example.model.Pagable;
import org.example.model.pedido.Producto;
import org.example.model.pedido.LineaPedido;
import org.example.model.pedido.Pedido;

import java.util.ArrayList;
import java.util.List;

public class ControladorPedido {

    private List<Pedido> pedidos ;


    public Pedido anyadirCarrito(Cliente cliente, Producto producto, int cantidad) {

        if (cliente == null || producto == null || cantidad <= 0) {
            return null;
        }

        Pedido pedido = new Pedido();

        cliente.getPedidos().add(pedido);

        LineaPedido linea = new LineaPedido(producto, cantidad);
        pedido.agregarLinea(linea);

        // Al añadir el primer producto pasa a PENDIENTE
        pedido.setEstado(EstadoPedido.PENDIENTE);

        pedidos.add(pedido);

        return pedido;
    }

    public void agregarProducto(Pedido pedido,
                                Producto producto,
                                int cantidad) {

        if (pedido == null || producto == null || cantidad <= 0) {
            return;
        }

        if (pedido.getEstado() != EstadoPedido.PENDIENTE) {
            throw new IllegalStateException(
                    "No se pueden añadir productos a este pedido."
            );
        }

        LineaPedido linea = new LineaPedido(producto, cantidad);
        pedido.agregarLinea(linea);
    }

    public boolean finalizarPedido(Pedido pedido, Pagable pagable) {

        if (pedido == null) {
            return false;
        }

        if (pedido.getEstado() != EstadoPedido.PENDIENTE) {
            pedido.setEstado(EstadoPedido.FINALIZADO);

            return false;
        }

        System.out.println(pagable.pagar(pedido.getPrecioTotal()));

        pedido.setEstado(EstadoPedido.FINALIZADO);

        return true;
    }

    public boolean entregarPedido(Pedido pedido) {

        if (pedido == null) {
            return false;
        }

        if (pedido.getEstado() != EstadoPedido.FINALIZADO) {
            return false;
        }

        pedido.setEstado(EstadoPedido.ENTREGADO);

        return true;
    }

    public boolean cancelarPedido(Pedido pedido) {

        if (pedido == null) {
            return false;
        }

        // Solo se pueden cancelar pedidos pendientes
        if (pedido.getEstado() != EstadoPedido.PENDIENTE) {
            return false;
        }

        pedido.setEstado(EstadoPedido.CANCELADO);

        return true;
    }

    public List<Pedido> listarPedidos() {
        return new ArrayList<>(pedidos);
    }

    public List<Pedido> obtenerPedidosCliente(Cliente cliente) {
        if (cliente == null || pedidos == null) {
            return new ArrayList<>();
        }

        return cliente.getPedidos();
    }
}
