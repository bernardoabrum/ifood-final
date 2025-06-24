package cliente;

import pedido.Pedido;
import pedido.PedidoEstadoEfetuado;
import restaurante.Restaurante;
import restaurante.RestauranteFactory;

import java.util.Observable;
import java.util.Observer;

public class Cliente implements Observer {
    private String nome;
    private String ultimaNotificacao;

    public Cliente(String nome) {
        this.nome = nome;
    }

    public Pedido fazerPedido(String restauranteNome) {
        Restaurante restaurante = RestauranteFactory.obterRestaurante(restauranteNome);
        Pedido pedido = new Pedido(restaurante);
        pedido.addObserver(this);
        pedido.setPedidoEstado(PedidoEstadoEfetuado.getInstance());
        pedido.efetuarPedido();
        return pedido;
    }

    public String getUltimaNotificacao() {
        return this.ultimaNotificacao;
    }

    public void update(Observable o, Object arg) {
        this.ultimaNotificacao = nome + ", " + arg;
    }
}