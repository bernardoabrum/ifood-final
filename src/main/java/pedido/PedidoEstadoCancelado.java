package pedido;

public class PedidoEstadoCancelado extends PedidoEstado {
    private PedidoEstadoCancelado() {
    }

    private static PedidoEstadoCancelado instance = new PedidoEstadoCancelado();

    public static PedidoEstadoCancelado getInstance() {
        return instance;
    }

    public String getEstadoPedido() {
        return "Pedido cancelado";
    }
}