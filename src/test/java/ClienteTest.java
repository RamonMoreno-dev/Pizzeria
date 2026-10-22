import org.example.controlador.ControladorCliente;
import org.example.model.Cliente;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class ClienteTest {
    private Cliente cliente;
    private ArrayList<Cliente> clientes = new ArrayList<>();

    @BeforeEach
    void setUp(){
        cliente = new Cliente("rm@gmail.com", "mccwaw", 0);
        clientes.add(cliente);
    }

    @Test
    void noEsVálido(){
        assertThrows(IllegalArgumentException.class, () -> ControladorCliente.signUp(cliente, clientes));
    }

}
