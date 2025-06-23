package pedido;

public class PedidoEstadoAceito extends PedidoEstado {
    private PedidoEstadoAceito() {
    }

    private static PedidoEstadoAceito instance = new PedidoEstadoAceito();

    public static PedidoEstadoAceito getInstance() {
        return instance;
    }

    public String getEstadoPedido() {
        return "Pedido aceito";
    }

    public boolean prepararPedido(Pedido pedido) {
        pedido.setPedidoEstado(PedidoEstadoPreparando.getInstance());
        return true;
    }

    public boolean cancelarPedido(Pedido pedido) {
        pedido.setPedidoEstado(PedidoEstadoCancelado.getInstance());
        return true;
    }
}