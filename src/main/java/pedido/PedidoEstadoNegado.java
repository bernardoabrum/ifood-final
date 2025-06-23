package pedido;

public class PedidoEstadoNegado extends PedidoEstado {
    private PedidoEstadoNegado() {
    }

    private static PedidoEstadoNegado instance = new PedidoEstadoNegado();

    public static PedidoEstadoNegado getInstance() {
        return instance;
    }

    public String getEstadoPedido() {
        return "Pedido negado";
    }
}