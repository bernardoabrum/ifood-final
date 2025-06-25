package cliente;

import pedido.Pedido;
import pedido.PedidoEstadoEfetuado;
import restaurante.Restaurante;
import restaurante.item.Item;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

public abstract class Cliente implements Observer {
    private final String nome;
    private String ultimaNotificacao;
    protected List<TipoCompra> tipoCompras = new ArrayList<>();
    protected Cliente proximoCliente;

    public Cliente(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return this.nome;
    }

    public void setProximoCliente(Cliente proximoCliente) {
        this.proximoCliente = proximoCliente;
    }

    public Pedido fazerPedido(Restaurante restaurante, List<Item> itens) {
        Pedido pedido = new Pedido(restaurante, itens);
        pedido.addObserver(this);
        pedido.setPedidoEstado(PedidoEstadoEfetuado.getInstance());
        pedido.efetuarPedido();
        pedido.setItens(itens);
        return pedido;
    }

    public String validarPedido(Restaurante restaurante, Compra compra, List<Item> itens) {
        if (tipoCompras.contains(compra.getCompraAtual())) {
            this.fazerPedido(restaurante, itens);
            return "Compra validada";
        } else if (proximoCliente != null) {
            return proximoCliente.validarPedido(restaurante, compra, itens);
        } else {
            return "Desconto não autorizado";
        }
    }

    public String getUltimaNotificacao() {
        return this.ultimaNotificacao;
    }

    public void update(Observable o, Object arg) {
        this.ultimaNotificacao = getNome() + ", " + arg;
    }
}