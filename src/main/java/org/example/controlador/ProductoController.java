package controlador;


import org.example.model.Cliente;
import org.example.model.pedido.Producto;
import org.example.model.pedido.Pedido;

import java.util.ArrayList;
import java.util.List;

public class ProductoController {

    private final List<Producto> productos = new ArrayList<>();



    public Producto buscarPorId(int id) {
        for (Producto producto : productos) {
            if (producto.getId() == id) {
                return producto;
            }
        }

        return null;
    }

    public List<Producto> listarProductos() {
        return new ArrayList<>(productos);
    }

    public boolean eliminarProducto(int id) {
        Producto producto = buscarPorId(id);

        if (producto == null) {
            return false;
        }

        return productos.remove(producto);
    }
    public static boolean actualizarProducto(Producto producto, List<Producto> listaProducto) {

        for(Producto p : listaProducto) {
            if(p.getId() ==  producto.getId()){
                listaProducto.remove(p);
                listaProducto.add(producto);
                return true;
            }
        }
        return false;
    }
}