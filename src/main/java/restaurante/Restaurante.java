package restaurante;

import pedido.Pedido;

public abstract class Restaurante {

    public abstract boolean aceitarPedido(Pedido pedido);

    public abstract boolean negarPedido(Pedido pedido);

    public abstract boolean prepararPedido(Pedido pedido);

    public abstract boolean enviarPedido(Pedido pedido);

    public abstract boolean entregarPedido(Pedido pedido);

    public abstract boolean cancelarPedido(Pedido pedido);
}
