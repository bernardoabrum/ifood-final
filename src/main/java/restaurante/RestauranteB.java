package restaurante;

import pedido.Pedido;

public class RestauranteB extends Restaurante {

    public String getNome() {
        return "RestauranteB";
    }

    public float getMediaValor() {
        return 400.00f;
    }

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

    public boolean cancelarPedido(Pedido pedido) { return pedido.cancelarPedido(); }
}
