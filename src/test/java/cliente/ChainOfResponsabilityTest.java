package cliente;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import restaurante.Restaurante;
import restaurante.RestauranteFactory;
import restaurante.item.Item;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


public class ChainOfResponsabilityTest {

    ClienteComum clienteComum;
    ClientePremium clientePremium;
    Restaurante restauranteA;
    List<Item> listaItens;

    @BeforeEach
    void setUp() {
        clienteComum = new ClienteComum("ClienteComum");
        clientePremium = new ClientePremium("ClientePremium");
        clienteComum.setProximoCliente(clientePremium);
        restauranteA = RestauranteFactory.obterRestaurante("A");
        Item item1 = new Item("Hamburguer", 30.00f);
        Item item2 = new Item("Refrigerante", 10.00f);
        Item item3 = new Item("Refrigerante", 10.00f);
        listaItens = Arrays.asList(item1, item2, item3);
    }

    @Test
    public void ClienteComumDeveRealizarPedidoCompraSemDesconto() {
        Compra compra1 = new Compra(SemDesconto.getInstance());
        assertEquals("Compra validada", clienteComum.validarPedido(restauranteA, compra1, listaItens));
    }

    @Test
    public void ProximoClienteDeveRealizarPedidoComDesconto() {
        Compra compra1 = new Compra(ComDesconto.getInstance());
        assertEquals("Compra validada", clienteComum.validarPedido(restauranteA, compra1, listaItens));
    }

    @Test
    public void NaoDeveRealizarPedido() {
        TipoCompra compraficticia = new TipoCompra() {
        };
        Compra compra2 = new Compra(compraficticia);
        assertEquals("Desconto não autorizado", clienteComum.validarPedido(restauranteA, compra2, listaItens));
        assertEquals("Desconto não autorizado", clientePremium.validarPedido(restauranteA, compra2, listaItens));
    }
}
