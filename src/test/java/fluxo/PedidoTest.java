package fluxo;

import cliente.*;
import pedido.*;
import restaurante.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import restaurante.avaliacao.DuasEstrelas;
import restaurante.avaliacao.IAvaliacao;
import restaurante.avaliacao.UmaEstrela;

import static org.junit.jupiter.api.Assertions.*;

public class PedidoTest {

    Cliente clienteComum;
    Cliente clientePremium;
    Restaurante restauranteA;
    Restaurante restauranteB;
    Compra compraSemDesconto;
    Compra compraComDesconto;
    Pedido pedido;
    IAvaliacao avaliacaoUmaEstrela;
    IAvaliacao avaliacaoDuasEstrelas;

    @BeforeEach
    public void setUp() {
        clienteComum = new ClienteComum("Bernardo");
        clientePremium = new ClientePremium("Renzo");
        clienteComum.setProximoCliente(clientePremium);
        // instancia os restaurantes usando factory method
        restauranteA = RestauranteFactory.obterRestaurante("A");
        restauranteB = RestauranteFactory.obterRestaurante("B");
        compraSemDesconto = new Compra(SemDesconto.getInstance());
        compraComDesconto = new Compra(ComDesconto.getInstance());
        avaliacaoUmaEstrela = new UmaEstrela();
        avaliacaoDuasEstrelas = new DuasEstrelas();
        restauranteA.setAvaliacao(avaliacaoUmaEstrela);
    }

    @Test
    public void deveRealizarPedido() {
        // Verifica avaliação e média de valor do restaurante
        assertEquals("Uma estrela", restauranteA.getAvaliacao().descricao());
        assertEquals(220.0f, restauranteA.calcularMediaValor(), 0.01f);

        // Seta restaurante com nova avaliação de duas estrelas e verifica nova média de valor
        restauranteA.setAvaliacao(avaliacaoDuasEstrelas);
        assertEquals("Duas estrelas", restauranteA.getAvaliacao().descricao());
        assertEquals(240.0f, restauranteA.calcularMediaValor(), 0.01f);

        // Chain verifica se o tipo de compra é validado pelo cliente comum
        clienteComum.validarPedido(restauranteA, compraSemDesconto);
        assertEquals("Compra validada", clienteComum.validarPedido(restauranteA, compraSemDesconto));

        // Verifica o estado inicial do pedido, e se o observer notifica o cliente com pedido efetuado
        pedido = clienteComum.fazerPedido(restauranteA);
        assertEquals("Pedido efetuado", pedido.getPedidoEstado().getEstadoPedido());
        assertEquals("Bernardo, o estado do pedido foi alterado para: Pedido efetuado, por RestauranteA", clienteComum.getUltimaNotificacao());

        // Verifica se o restaurante aceitou o pedido
        restauranteA.aceitarPedido(pedido);
        assertEquals("Bernardo, o estado do pedido foi alterado para: Pedido aceito, por RestauranteA", clienteComum.getUltimaNotificacao());

        // Próximas atualizações do restaurante

        restauranteA.prepararPedido(pedido);
        restauranteA.enviarPedido(pedido);
        restauranteA.entregarPedido(pedido);
        assertEquals("Bernardo, o estado do pedido foi alterado para: Pedido recebido, por RestauranteA", clienteComum.getUltimaNotificacao());
    }
}
