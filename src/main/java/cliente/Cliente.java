package cliente;

import pedido.Pedido;
import pedido.PedidoEstadoEfetuado;
import restaurante.Restaurante;
import restaurante.RestauranteFactory;

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

    public Pedido fazerPedido(String restauranteNome) {
        Restaurante restaurante = RestauranteFactory.obterRestaurante(restauranteNome);
        Pedido pedido = new Pedido(restaurante);
        pedido.addObserver(this);
        pedido.setPedidoEstado(PedidoEstadoEfetuado.getInstance());
        pedido.efetuarPedido();
        return pedido;
    }

    public String validarPedido(String restauranteNome, Compra compra) {
        if (tipoCompras.contains(compra.getCompraAtual())) {
            this.fazerPedido(restauranteNome);
            return "Pedido realizado";
        } else if (proximoCliente != null) {
            return proximoCliente.validarPedido(restauranteNome, compra);
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