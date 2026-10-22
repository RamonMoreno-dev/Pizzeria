package org.example.model;

import org.example.model.pedido.Pedido;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Cliente {
    private int id;
    private String dni;
    private String telefono;
    private String email;
    private String password;
    private String direccion;
    private List<Pedido> pedidos;

    public List<Pedido> getPedidos() {
        return pedidos;
    }

    public void setPedidos(List<Pedido> pedidos) {
        this.pedidos = pedidos;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                ", dni='" + dni + '\'' +
                ", telefono='" + telefono + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", direccion='" + direccion + '\'' +
                '}';
    }

    private static final Pattern PATTERN = Pattern.compile("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$");

    public Cliente() {

    }
    public Cliente(String email, String password, int id){
        setEmail(email);
        this.password = password;
        this.id = id;   
    }

    public Cliente(int id, String dni, String tlf, String email, String password, String direccion)  {
        this.id = id;
        this.dni = dni;
        setEmail(email);
        this.password = password;
        this.direccion = direccion;
        this.telefono = tlf;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {

        this.telefono = telefono;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) throws IllegalArgumentException {
        Matcher m = PATTERN.matcher(email);

        if (m.matches()){
            this.email = email;
        } else {
            throw new IllegalArgumentException();
        }

    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
