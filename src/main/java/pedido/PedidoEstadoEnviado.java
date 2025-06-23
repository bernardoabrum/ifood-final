package pedido;

public class PedidoEstadoEnviado extends PedidoEstado {
    private PedidoEstadoEnviado() {
    }

    private static PedidoEstadoEnviado instance = new PedidoEstadoEnviado();

    public static PedidoEstadoEnviado getInstance() {
        return instance;
    }

    public String getEstadoPedido() {
        return "Pedido enviado";
    }

    public boolean cancelarPedido(Pedido pedido) {
        pedido.setPedidoEstado(PedidoEstadoCancelado.getInstance());
        return true;
    }

    public boolean entregarPedido(Pedido pedido) {
        pedido.setPedidoEstado(PedidoEstadoEntregue.getInstance());
        return true;
    }
}