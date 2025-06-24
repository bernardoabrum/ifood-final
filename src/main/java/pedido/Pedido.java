package pedido;

import restaurante.Restaurante;
import restaurante.item.IItem;
import restaurante.item.Item;

import java.util.List;
import java.util.Observable;

public class Pedido extends Observable {
    private PedidoEstado pedidoEstado;
    private Restaurante restaurante;
    private List<Item> itens;
    private float total;

    public Pedido(Restaurante restaurante, List<Item> itens) {
        this.itens = itens;
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

    public void setItens(List<Item> itens) {
        this.itens = itens;
    }

    public String resumoPedido() {
        StringBuilder sb = new StringBuilder();
        sb.append("Resumo do pedido: ");
        for (Item item : this.itens) {
            sb.append(item.getDescricao() + ", ");
            total += item.getPreco();
        }
        sb.append("Total: R$ ").append(String.format("%.2f", total));
        return sb.toString();
    }

    private void notificarMudanca() {
        setChanged();
        notifyObservers("o estado do pedido foi alterado para: " + pedidoEstado.getEstadoPedido() + ", por " + restaurante.getNome());
    }
}