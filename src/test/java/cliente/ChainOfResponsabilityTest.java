package cliente;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


public class ChainOfResponsabilityTest {

    ClienteComum clienteComum;
    ClientePremium clientePremium;

    @BeforeEach
    void setUp() {
        clienteComum = new ClienteComum("ClienteComum");
        clientePremium = new ClientePremium("ClientePremium");
        clienteComum.setProximoCliente(clientePremium);
    }

    @Test
    public void ClienteComumDeveRealizarPedidoCompraSemDesconto() {
      Compra compra1 = new Compra(SemDesconto.getInstance());
      assertEquals("Pedido realizado", clienteComum.validarPedido("A", compra1));
    }

    @Test
    public void ProximoClienteDeveRealizarPedidoComDesconto() {
        Compra compra1 = new Compra(ComDesconto.getInstance());
        compra1.setCompraAtual(ComDesconto.getInstance());
        assertEquals("Pedido realizado", clienteComum.validarPedido("A", compra1));
    }

    @Test
    public void NaoDeveRealizarPedido() {
        TipoCompra compraficticia = new TipoCompra() {};
        Compra compra2 = new Compra(compraficticia);
        assertEquals("Desconto não autorizado", clienteComum.validarPedido("A", compra2));
        assertEquals("Desconto não autorizado", clientePremium.validarPedido("A", compra2));
    }
}
