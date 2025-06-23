package pedido;

public class Pedido {
    private PedidoEstado pedidoEstado;

    public Pedido() {
        this.pedidoEstado = PedidoEstadoEfetuado.getInstance();
    }

    public void setPedidoEstado(PedidoEstado pedidoEstado) {
        this.pedidoEstado = pedidoEstado;
    }

    public boolean efetuarPedido() {
        return pedidoEstado.efetuarPedido(this);
    }

    public boolean aceitarPedido() {
        return pedidoEstado.aceitarPedido(this);
    }

    public boolean negarPedido() {
        return pedidoEstado.negarPedido(this);
    }

    public boolean prepararPedido() {
        return pedidoEstado.prepararPedido(this);
    }

    public boolean enviarPedido() {
        return pedidoEstado.enviarPedido(this);
    }

    public boolean entregarPedido() {
        return pedidoEstado.entregarPedido(this);
    }

    public boolean cancelarPedido() {
        return pedidoEstado.cancelarPedido(this);
    }

    public PedidoEstado getPedidoEstado() {
        return pedidoEstado;
    }
}