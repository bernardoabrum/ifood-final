package pedido;

import restaurante.Restaurante;

import java.util.Observable;

public class Pedido extends Observable {
    private PedidoEstado pedidoEstado;
    private Restaurante restaurante;

    public Pedido(Restaurante restaurante) {
        this.restaurante = restaurante;
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

    public void setPedidoEstado(PedidoEstado pedidoEstado) {
        this.pedidoEstado = pedidoEstado;
        notificarMudanca();
    }

    public Restaurante getRestaurante() {
        return restaurante;
    }

    public void setRestaurante(Restaurante restaurante) {
        this.restaurante = restaurante;
    }

    private void notificarMudanca() {
        setChanged();
        notifyObservers("o estado do pedido foi alterado para: " + pedidoEstado.getEstadoPedido() + " , por " + restaurante.getNome());
    }
}