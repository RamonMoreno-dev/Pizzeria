package org.example.controlador;


import org.example.model.Cliente;

import java.lang.ref.Cleaner;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ControladorCliente {
    private List<Cliente> clientes;

    public static Cliente login(Cliente cliente, List<Cliente> listaCliente){
        if(cliente == null ){
            return null;
        }

        return listaCliente.stream().filter(c -> c.getEmail().equalsIgnoreCase(cliente.getEmail()) && c.getPassword().equals(cliente.getPassword())).findFirst().orElse(null);

    }
    public static boolean signUp(Cliente registro,  List<Cliente> listaUsuario) throws Exception {

        for(Cliente c : listaUsuario){
            if(c.getEmail().equalsIgnoreCase(registro.getEmail())){
                throw new IllegalArgumentException();
            }
        }
        listaUsuario.add(registro);
        return true;
    }
    public static boolean actualizarCliente(Cliente cliente, List<Cliente> listaCliente){

        if (cliente == null){
            return false;
        }

        for(Cliente c : listaCliente){
            if(c.getId() ==  cliente.getId()){
                listaCliente.remove(c);
                listaCliente.add(cliente);
                return true;
            }
        }
        return false;
    }

    public List<Cliente> listarClientes() {
        return new ArrayList<>(clientes);
    }


}
