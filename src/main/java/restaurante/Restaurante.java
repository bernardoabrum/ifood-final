package restaurante;

import pedido.Pedido;
import restaurante.avaliacao.IAvaliacao;

public abstract class Restaurante {

    protected IAvaliacao avaliacao;
    protected float mediaValor;

    public Restaurante(float mediaValor) {
        this.mediaValor = mediaValor;
    }

    public void setAvaliacao(IAvaliacao avaliacao) {
        this.avaliacao = avaliacao;
    }

    public void setMediaValor(float mediaValor) {
        this.mediaValor = mediaValor;
    }

    public abstract float calcularMediaValor();

    public abstract boolean aceitarPedido(Pedido pedido);

    public abstract boolean negarPedido(Pedido pedido);

    public abstract boolean prepararPedido(Pedido pedido);

    public abstract boolean enviarPedido(Pedido pedido);

    public abstract boolean entregarPedido(Pedido pedido);

    public abstract boolean cancelarPedido(Pedido pedido);
}
