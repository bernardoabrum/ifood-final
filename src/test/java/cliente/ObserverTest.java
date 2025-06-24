package cliente;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pedido.*;

import static org.junit.jupiter.api.Assertions.*;

public class ObserverTest {

    private Pedido pedido;
    private Cliente cliente;

    @BeforeEach
    public void setUp() {
        cliente = new Cliente("Renzo");
        pedido = cliente.fazerPedido("A");
    }

    @Test
    void deveAtualizarEstadoNotificacaoEfetuado() {
        cliente.fazerPedido("A");
        assertEquals("Renzo, o estado do pedido foi alterado para: Pedido efetuado , por RestauranteA", cliente.getUltimaNotificacao());
    }

    @Test
    void deveAtualizarEstadoNotificacaoAceito() {
        pedido.setPedidoEstado(PedidoEstadoAceito.getInstance());
        assertEquals("Renzo, o estado do pedido foi alterado para: Pedido aceito , por RestauranteA", cliente.getUltimaNotificacao());
    }

    @Test
    void deveAtualizarEstadoNotificacaoNegado() {
        pedido.setPedidoEstado(PedidoEstadoNegado.getInstance());
        assertEquals("Renzo, o estado do pedido foi alterado para: Pedido negado , por RestauranteA", cliente.getUltimaNotificacao());
    }

    @Test
    void deveAtualizarEstadoNotificacaoPreparando() {
        pedido.setPedidoEstado(PedidoEstadoPreparando.getInstance());
        assertEquals("Renzo, o estado do pedido foi alterado para: Pedido sendo preparado , por RestauranteA", cliente.getUltimaNotificacao());
    }

    @Test
    void deveAtualizarEstadoNotificacaoEnviado() {
        pedido.setPedidoEstado(PedidoEstadoEnviado.getInstance());
        assertEquals("Renzo, o estado do pedido foi alterado para: Pedido enviado , por RestauranteA", cliente.getUltimaNotificacao());
    }

    @Test
    void deveAtualizarEstadoNotificacaoEntregue() {
        pedido.setPedidoEstado(PedidoEstadoEntregue.getInstance());
        assertEquals("Renzo, o estado do pedido foi alterado para: Pedido recebido , por RestauranteA", cliente.getUltimaNotificacao());
    }

    @Test
    void deveAtualizarEstadoNotificacaoCancelado() {
        pedido.setPedidoEstado(PedidoEstadoCancelado.getInstance());
        assertEquals("Renzo, o estado do pedido foi alterado para: Pedido cancelado , por RestauranteA", cliente.getUltimaNotificacao());
    }
}