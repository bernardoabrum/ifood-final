package pedido;

import cliente.*;
import restaurante.*;
import restaurante.item.*;
import restaurante.avaliacao.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.List;

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
    List<Item> listaItens;

    @BeforeEach
    public void setUp() {
        clienteComum = new ClienteComum("Bernardo");
        clientePremium = new ClientePremium("Renzo");
        clienteComum.setProximoCliente(clientePremium);

        avaliacaoUmaEstrela = new UmaEstrela();
        avaliacaoDuasEstrelas = new DuasEstrelas();

        // instancia os restaurantes usando factory method
        restauranteA = RestauranteFactory.obterRestaurante("A");
        restauranteB = RestauranteFactory.obterRestaurante("B");
        restauranteA.setAvaliacao(avaliacaoUmaEstrela);

        compraSemDesconto = new Compra(SemDesconto.getInstance());
        compraComDesconto = new Compra(ComDesconto.getInstance());

        // lista de itens do pedido
        Item item1 = new Item("Hamburguer", 30.00f);
        Item item2 = new Item("Refrigerante", 5.00f);
        Item item3 = new Item("Batata", 10.00f);
        listaItens = Arrays.asList(item1, item2, item3);

//        lista de itens a serem removidos
//        List<String> ingredientesRemover = Arrays.asList("Milho", "Alface");
//        IItem novoItem1 = new RemoverIngrediente(item1, ingredientesRemover);
    }

    @Test
    public void deveRealizarPedido() {
        // verifica avaliação e média de valor do restaurante
        assertEquals("Uma estrela", restauranteA.getAvaliacao().descricao());
        assertEquals(220.0f, restauranteA.calcularMediaValor(), 0.01f);

        // Seta restaurante com nova avaliação de duas estrelas e verifica nova média de valor
        restauranteA.setAvaliacao(avaliacaoDuasEstrelas);
        assertEquals("Duas estrelas", restauranteA.getAvaliacao().descricao());
        assertEquals(240.0f, restauranteA.calcularMediaValor(), 0.01f);

        // chain verifica se o tipo de compra é validado pelo cliente comum
        clienteComum.validarPedido(restauranteA, compraSemDesconto, listaItens);
        assertEquals("Compra validada", clienteComum.validarPedido(restauranteA, compraSemDesconto, listaItens));

        // verifica o estado inicial do pedido, e se o observer notifica o cliente com pedido efetuado
        pedido = clienteComum.fazerPedido(restauranteA, listaItens);
        assertEquals("Pedido efetuado", pedido.getPedidoEstado().getEstadoPedido());
        assertEquals("Bernardo, o estado do pedido foi alterado para: Pedido efetuado, por RestauranteA", clienteComum.getUltimaNotificacao());

        // verifica resumo do pedido
        assertEquals("Resumo do pedido: Hamburguer, Refrigerante, Batata, Total: R$ 45,00", pedido.resumoPedido());

        // verifica se o restaurante aceitou o pedido
        restauranteA.aceitarPedido(pedido);
        assertEquals("Bernardo, o estado do pedido foi alterado para: Pedido aceito, por RestauranteA", clienteComum.getUltimaNotificacao());

        // próximas atualizações do restaurante
        restauranteA.prepararPedido(pedido);
        restauranteA.enviarPedido(pedido);
        restauranteA.entregarPedido(pedido);

        // pedido entregue
        assertEquals("Bernardo, o estado do pedido foi alterado para: Pedido recebido, por RestauranteA", clienteComum.getUltimaNotificacao());
    }
}
