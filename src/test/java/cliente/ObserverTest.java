package cliente;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pedido.*;
import restaurante.Restaurante;
import restaurante.RestauranteFactory;
import restaurante.item.Item;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class ObserverTest {

    private Pedido pedido;
    private Cliente cliente;
    Restaurante restauranteA;
    List<Item> listaItens;

    @BeforeEach
    public void setUp() {
        Item item1 = new Item("Hamburguer", 30.00f);
        Item item2 = new Item("Refrigerante", 10.00f);
        Item item3 = new Item("Refrigerante", 10.00f);
        listaItens = Arrays.asList(item1, item2, item3);
        restauranteA = RestauranteFactory.obterRestaurante("A");
        cliente = new ClienteComum("Renzo");
        pedido = cliente.fazerPedido(restauranteA, listaItens);
    }

    @Test
    void deveAtualizarEstadoNotificacaoEfetuado() {
        cliente.fazerPedido(restauranteA, listaItens);
        assertEquals("Renzo, o estado do pedido foi alterado para: Pedido efetuado, por RestauranteA", cliente.getUltimaNotificacao());
    }

    @Test
    void deveAtualizarEstadoNotificacaoAceito() {
        pedido.setPedidoEstado(PedidoEstadoAceito.getInstance());
        assertEquals("Renzo, o estado do pedido foi alterado para: Pedido aceito, por RestauranteA", cliente.getUltimaNotificacao());
    }

    @Test
    void deveAtualizarEstadoNotificacaoNegado() {
        pedido.setPedidoEstado(PedidoEstadoNegado.getInstance());
        assertEquals("Renzo, o estado do pedido foi alterado para: Pedido negado, por RestauranteA", cliente.getUltimaNotificacao());
    }

    @Test
    void deveAtualizarEstadoNotificacaoPreparando() {
        pedido.setPedidoEstado(PedidoEstadoPreparando.getInstance());
        assertEquals("Renzo, o estado do pedido foi alterado para: Pedido sendo preparado, por RestauranteA", cliente.getUltimaNotificacao());
    }

    @Test
    void deveAtualizarEstadoNotificacaoEnviado() {
        pedido.setPedidoEstado(PedidoEstadoEnviado.getInstance());
        assertEquals("Renzo, o estado do pedido foi alterado para: Pedido enviado, por RestauranteA", cliente.getUltimaNotificacao());
    }

    @Test
    void deveAtualizarEstadoNotificacaoEntregue() {
        pedido.setPedidoEstado(PedidoEstadoEntregue.getInstance());
        assertEquals("Renzo, o estado do pedido foi alterado para: Pedido recebido, por RestauranteA", cliente.getUltimaNotificacao());
    }

    @Test
    void deveAtualizarEstadoNotificacaoCancelado() {
        pedido.setPedidoEstado(PedidoEstadoCancelado.getInstance());
        assertEquals("Renzo, o estado do pedido foi alterado para: Pedido cancelado, por RestauranteA", cliente.getUltimaNotificacao());
    }
}