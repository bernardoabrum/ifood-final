package pedido;

import cliente.Cliente;
import cliente.ClienteComum;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class StateTest {

    private Pedido pedido;

    @BeforeEach
    public void setUp() {
        Cliente cliente = new ClienteComum("Renzo");
        pedido = cliente.fazerPedido("A");
    }

    @Test
    public void deveIniciarCOmoEfetuado() {
        assertEquals("Pedido efetuado", pedido.getPedidoEstado().getEstadoPedido());
    }

    @Test
    public void deveMudarDeEfetuadoParaAceito() {
        pedido.setPedidoEstado(PedidoEstadoEfetuado.getInstance());
        pedido.aceitarPedido();
        assertEquals("Pedido aceito", pedido.getPedidoEstado().getEstadoPedido());
    }

    @Test
    public void deveMudarDeEfetuadoParaNegado() {
        pedido.setPedidoEstado(PedidoEstadoEfetuado.getInstance());
        pedido.negarPedido();
        assertEquals("Pedido negado", pedido.getPedidoEstado().getEstadoPedido());
    }

    @Test
    public void naoDeveMudarDeEfetuadoParaPreparando() {
        pedido.setPedidoEstado(PedidoEstadoEfetuado.getInstance());
        assertFalse(pedido.prepararPedido());
    }

    @Test
    public void naoDeveMudarDeEfetuadoParaEnviado() {
        pedido.setPedidoEstado(PedidoEstadoEfetuado.getInstance());
        assertFalse(pedido.enviarPedido());
    }

    @Test
    public void naoDeveMudarDeEfetuadoParaEntregue() {
        pedido.setPedidoEstado(PedidoEstadoEfetuado.getInstance());
        assertFalse(pedido.entregarPedido());
    }

    @Test
    public void naoDeveMudarDeEfetuadoParaCancelado() {
        pedido.setPedidoEstado(PedidoEstadoEfetuado.getInstance());
        assertFalse(pedido.cancelarPedido());
    }

    @Test
    public void deveMudarDeAceitoParaPreparando() {
        pedido.setPedidoEstado(PedidoEstadoAceito.getInstance());
        pedido.prepararPedido();
        assertEquals("Pedido sendo preparado", pedido.getPedidoEstado().getEstadoPedido());
    }

    @Test
    public void deveMudarDeAceitoParaCancelado() {
        pedido.setPedidoEstado(PedidoEstadoAceito.getInstance());
        pedido.cancelarPedido();
        assertEquals("Pedido cancelado", pedido.getPedidoEstado().getEstadoPedido());
    }

    @Test
    public void naoDeveMudarDeAceitoParaEfetuado() {
        pedido.setPedidoEstado(PedidoEstadoAceito.getInstance());
        assertFalse(pedido.efetuarPedido());
    }

    @Test
    public void naoDeveMudarDeAceitoParaNegado() {
        pedido.setPedidoEstado(PedidoEstadoAceito.getInstance());
        assertFalse(pedido.negarPedido());
    }

    @Test
    public void naoDeveMudarDeAceitoParaEnviado() {
        pedido.setPedidoEstado(PedidoEstadoAceito.getInstance());
        assertFalse(pedido.enviarPedido());
    }

    @Test
    public void naoDeveMudarDeAceitoParaEntregue() {
        pedido.setPedidoEstado(PedidoEstadoAceito.getInstance());
        assertFalse(pedido.entregarPedido());
    }

    @Test
    public void naoDeveMudarDeNegadoParaEfetuado() {
        pedido.setPedidoEstado(PedidoEstadoNegado.getInstance());
        assertFalse(pedido.efetuarPedido());
    }

    @Test
    public void naoDeveMudarDeNegadoParaAceito() {
        pedido.setPedidoEstado(PedidoEstadoNegado.getInstance());
        assertFalse(pedido.aceitarPedido());
    }

    @Test
    public void naoDeveMudarDeNegadoParaPreparando() {
        pedido.setPedidoEstado(PedidoEstadoNegado.getInstance());
        assertFalse(pedido.prepararPedido());
    }

    @Test
    public void naoDeveMudarDeNegadoParaEnviado() {
        pedido.setPedidoEstado(PedidoEstadoNegado.getInstance());
        assertFalse(pedido.enviarPedido());
    }

    @Test
    public void naoDeveMudarDeNegadoParaEntregue() {
        pedido.setPedidoEstado(PedidoEstadoNegado.getInstance());
        assertFalse(pedido.entregarPedido());
    }

    @Test
    public void naoDeveMudarDeNegadoParaCancelado() {
        pedido.setPedidoEstado(PedidoEstadoNegado.getInstance());
        assertFalse(pedido.cancelarPedido());
    }

    @Test
    public void deveMudarDePreparandoParaEnviado() {
        pedido.setPedidoEstado(PedidoEstadoPreparando.getInstance());
        pedido.enviarPedido();
        assertEquals("Pedido enviado", pedido.getPedidoEstado().getEstadoPedido());
    }

    @Test
    public void deveMudarDePreparandoParaCancelado() {
        pedido.setPedidoEstado(PedidoEstadoPreparando.getInstance());
        pedido.cancelarPedido();
        assertEquals("Pedido cancelado", pedido.getPedidoEstado().getEstadoPedido());
    }

    @Test
    public void naoDeveMudarDePreparandoParaEfetuado() {
        pedido.setPedidoEstado(PedidoEstadoPreparando.getInstance());
        assertFalse(pedido.efetuarPedido());
    }

    @Test
    public void naoDeveMudarDePreparandoParaAceito() {
        pedido.setPedidoEstado(PedidoEstadoPreparando.getInstance());
        assertFalse(pedido.aceitarPedido());
    }

    @Test
    public void naoDeveMudarDePreparandoParaNegado() {
        pedido.setPedidoEstado(PedidoEstadoPreparando.getInstance());
        assertFalse(pedido.negarPedido());
    }

    @Test
    public void naoDeveMudarDePreparandoParaEntregue() {
        pedido.setPedidoEstado(PedidoEstadoPreparando.getInstance());
        assertFalse(pedido.entregarPedido());
    }

    @Test
    public void deveMudarDeEnviadoParaEntregue() {
        pedido.setPedidoEstado(PedidoEstadoEnviado.getInstance());
        pedido.entregarPedido();
        assertEquals("Pedido recebido", pedido.getPedidoEstado().getEstadoPedido());
    }

    @Test
    public void deveMudarDeEnviadoParaCanceclado() {
        pedido.setPedidoEstado(PedidoEstadoEnviado.getInstance());
        pedido.cancelarPedido();
        assertEquals("Pedido cancelado", pedido.getPedidoEstado().getEstadoPedido());
    }

    @Test
    public void naoDeveMudarDeEnviadoParaEfetuado() {
        pedido.setPedidoEstado(PedidoEstadoEnviado.getInstance());
        assertFalse(pedido.efetuarPedido());
    }

    @Test
    public void naoDeveMudarDeEnviadoParaAceito() {
        pedido.setPedidoEstado(PedidoEstadoEnviado.getInstance());
        assertFalse(pedido.aceitarPedido());
    }

    @Test
    public void naoDeveMudarDeEnviadoParaNegado() {
        pedido.setPedidoEstado(PedidoEstadoEnviado.getInstance());
        assertFalse(pedido.negarPedido());
    }

    @Test
    public void naoDeveMudarDeEnviadoParaPreparado() {
        pedido.setPedidoEstado(PedidoEstadoEnviado.getInstance());
        assertFalse(pedido.prepararPedido());
    }

    @Test
    public void naoDeveMudarDeEntregueParaEfetuado() {
        pedido.setPedidoEstado(PedidoEstadoEntregue.getInstance());
        assertFalse(pedido.efetuarPedido());
    }

    @Test
    public void naoDeveMudarDeEntregueParaAceito() {
        pedido.setPedidoEstado(PedidoEstadoEntregue.getInstance());
        assertFalse(pedido.aceitarPedido());
    }

    @Test
    public void naoDeveMudarDeEntregueParaNegado() {
        pedido.setPedidoEstado(PedidoEstadoEntregue.getInstance());
        assertFalse(pedido.negarPedido());
    }

    @Test
    public void naoDeveMudarDeEntregueParaPreparado() {
        pedido.setPedidoEstado(PedidoEstadoEntregue.getInstance());
        assertFalse(pedido.prepararPedido());
    }

    @Test
    public void naoDeveMudarDeEntregueParaEnviado() {
        pedido.setPedidoEstado(PedidoEstadoEntregue.getInstance());
        assertFalse(pedido.enviarPedido());
    }

    @Test
    public void naoDeveMudarDeEntregueParaCancelado() {
        pedido.setPedidoEstado(PedidoEstadoEntregue.getInstance());
        assertFalse(pedido.cancelarPedido());
    }

    @Test
    public void naoDeveMudarDeCanceladoParaEfetuado() {
        pedido.setPedidoEstado(PedidoEstadoCancelado.getInstance());
        assertFalse(pedido.efetuarPedido());
    }

    @Test
    public void naoDeveMudarDeCanceladoParaAceito() {
        pedido.setPedidoEstado(PedidoEstadoCancelado.getInstance());
        assertFalse(pedido.aceitarPedido());
    }

    @Test
    public void naoDeveMudarDeCanceladoParaNegado() {
        pedido.setPedidoEstado(PedidoEstadoCancelado.getInstance());
        assertFalse(pedido.negarPedido());
    }

    @Test
    public void naoDeveMudarDeCanceladoParaPreparado() {
        pedido.setPedidoEstado(PedidoEstadoCancelado.getInstance());
        assertFalse(pedido.prepararPedido());
    }

    @Test
    public void naoDeveMudarDeCanceladoParaEnviado() {
        pedido.setPedidoEstado(PedidoEstadoCancelado.getInstance());
        assertFalse(pedido.enviarPedido());
    }

    @Test
    public void naoDeveMudarDeCanceladoParaEntregue() {
        pedido.setPedidoEstado(PedidoEstadoCancelado.getInstance());
        assertFalse(pedido.entregarPedido());
    }
}