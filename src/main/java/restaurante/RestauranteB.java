package restaurante;

import pedido.Pedido;

public class RestauranteB extends Restaurante {

    public RestauranteB(float mediaValor) {
        super(mediaValor);
    }

    public float calcularMediaValor() {
        return this.mediaValor * (1 + this.avaliacao.porcentagemAumento());
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
