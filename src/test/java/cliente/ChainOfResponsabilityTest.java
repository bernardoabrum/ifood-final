package cliente;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import restaurante.Restaurante;
import restaurante.RestauranteFactory;

import static org.junit.jupiter.api.Assertions.*;


public class ChainOfResponsabilityTest {

    ClienteComum clienteComum;
    ClientePremium clientePremium;
    Restaurante restauranteA;

    @BeforeEach
    void setUp() {
        clienteComum = new ClienteComum("ClienteComum");
        clientePremium = new ClientePremium("ClientePremium");
        clienteComum.setProximoCliente(clientePremium);
        restauranteA = RestauranteFactory.obterRestaurante("A");
    }

    @Test
    public void ClienteComumDeveRealizarPedidoCompraSemDesconto() {
        Compra compra1 = new Compra(SemDesconto.getInstance());
        assertEquals("Compra validada", clienteComum.validarPedido(restauranteA, compra1));
    }

    @Test
    public void ProximoClienteDeveRealizarPedidoComDesconto() {
        Compra compra1 = new Compra(ComDesconto.getInstance());
        assertEquals("Compra validada", clienteComum.validarPedido(restauranteA, compra1));
    }

    @Test
    public void NaoDeveRealizarPedido() {
        TipoCompra compraficticia = new TipoCompra() {
        };
        Compra compra2 = new Compra(compraficticia);
        assertEquals("Desconto não autorizado", clienteComum.validarPedido(restauranteA, compra2));
        assertEquals("Desconto não autorizado", clientePremium.validarPedido(restauranteA, compra2));
    }
}
