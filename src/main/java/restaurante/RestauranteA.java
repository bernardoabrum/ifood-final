package restaurante;

import pedido.Pedido;

public class RestauranteA extends Restaurante {

    public boolean aceitarPedido(Pedido pedido) {
        return pedido.aceitarPedido();
    }

    public boolean negarPedido(Pedido pedido) {
        return pedido.negarPedido();
    }

    public boolean prepararPedido(Pedido pedido) {
        return pedido.prepararPedido();
    }

    public boolean enviarPedido(Pedido pedido) {
        return pedido.enviarPedido();
    }

    public boolean entregarPedido(Pedido pedido) {
        return pedido.entregarPedido();
    }

    public boolean cancelarPedido(Pedido pedido) {
        return pedido.cancelarPedido();
    }
}
