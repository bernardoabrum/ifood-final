package pedido;

public class PedidoEstadoPreparando extends PedidoEstado {
    private PedidoEstadoPreparando() {
    }

    private static PedidoEstadoPreparando instance = new PedidoEstadoPreparando();

    public static PedidoEstadoPreparando getInstance() {
        return instance;
    }

    public String getEstadoPedido() {
        return "Pedido sendo preparado";
    }

    public boolean enviarPedido(Pedido pedido) {
        pedido.setPedidoEstado(PedidoEstadoEnviado.getInstance());
        return true;
    }

    public boolean cancelarPedido(Pedido pedido) {
        pedido.setPedidoEstado(PedidoEstadoCancelado.getInstance());
        return true;
    }
}