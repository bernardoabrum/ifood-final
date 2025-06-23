package pedido;

public class PedidoEstadoEfetuado extends PedidoEstado {
    private PedidoEstadoEfetuado() {
    }

    private static PedidoEstadoEfetuado instance = new PedidoEstadoEfetuado();

    public static PedidoEstadoEfetuado getInstance() {
        return instance;
    }

    public String getEstadoPedido() {
        return "Pedido efetuado";
    }

    public boolean aceitarPedido(Pedido pedido) {
        pedido.setPedidoEstado(PedidoEstadoAceito.getInstance());
        return true;
    }

    public boolean negarPedido(Pedido pedido) {
        pedido.setPedidoEstado(PedidoEstadoNegado.getInstance());
        return true;
    }
}