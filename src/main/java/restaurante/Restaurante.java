package restaurante;

import pedido.Pedido;
import restaurante.avaliacao.IAvaliacao;

public abstract class Restaurante {

    public abstract String getNome();

    public IAvaliacao avaliacao;

    public abstract float getMediaValor();

    public IAvaliacao getAvaliacao() {
        return avaliacao;
    };

    public void setAvaliacao(IAvaliacao avaliacao) {
        this.avaliacao = avaliacao;
    }

    public float calcularMediaValor() {
        return getMediaValor() * (1 + avaliacao.porcentagemAumento());
    }

    public abstract boolean aceitarPedido(Pedido pedido);

    public abstract boolean negarPedido(Pedido pedido);

    public abstract boolean prepararPedido(Pedido pedido);

    public abstract boolean enviarPedido(Pedido pedido);

    public abstract boolean entregarPedido(Pedido pedido);

    public abstract boolean cancelarPedido(Pedido pedido);
}
