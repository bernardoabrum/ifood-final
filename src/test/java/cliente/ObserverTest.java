package cliente;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pedido.Pedido;
import pedido.PedidoEstado;
import pedido.PedidoEstadoEfetuado;
import restaurante.Restaurante;
import restaurante.RestauranteFactory;

import static org.junit.jupiter.api.Assertions.*;

public class ObserverTest {

//    private Restaurante restauranteA;
//    @BeforeEach
//    public void setUp(){
//        restauranteA = RestauranteFactory.obterRestaurante("A");
//    }

//    @Test
//    void deveAtualizarEstadoNotificacao() {
//        Cliente cliente = new Cliente("ClienteA");
//        assertEquals(null, cliente.getUltimaNotificacao());
//    }

    @Test
    void deveAtualizarEstadoNotificacaoEfetuado() {
        Cliente cliente = new Cliente("ClienteA");
        cliente.fazerPedido("A");
        assertEquals(null, cliente.getUltimaNotificacao());
    }
}
