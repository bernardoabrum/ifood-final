package restaurante;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import restaurante.avaliacao.DuasEstrelas;
import restaurante.avaliacao.IAvaliacao;
import restaurante.avaliacao.TresEstrelas;
import restaurante.avaliacao.UmaEstrela;

import static org.junit.jupiter.api.Assertions.*;

public class RestauranteTest {

    private Restaurante restauranteA;
    private Restaurante restauranteB;

    @BeforeEach
    public void setUp() {
        restauranteA = RestauranteFactory.obterRestaurante("A");
        restauranteB = RestauranteFactory.obterRestaurante("B");
    }

    @Test
    public void deveRetornarNomeRestaurante() {
        assertEquals("RestauranteA", restauranteA.getNome());
        assertEquals("RestauranteB", restauranteB.getNome());
    }

    @Test
    public void DeveCalcularAvaliacaoUmaEstrela() {
        IAvaliacao avaliacao = new UmaEstrela();
        assertEquals(200.0f, restauranteA.getMediaValor());
        restauranteA.setAvaliacao(avaliacao);
        assertEquals(220.0f, restauranteA.calcularMediaValor(), 0.01f);
    }

    @Test
    public void DeveCalcularAvaliacaoDuasEstrelas() {
        IAvaliacao avaliacao = new DuasEstrelas();
        assertEquals(200.0f, restauranteA.getMediaValor());
        restauranteA.setAvaliacao(avaliacao);
        assertEquals(240.0f, restauranteA.calcularMediaValor(), 0.01f);
    }

    @Test
    public void DeveCalcularAvaliacaoTresEstrelas() {
        IAvaliacao avaliacao = new TresEstrelas();
        assertEquals(200.0f, restauranteA.getMediaValor());
        restauranteA.setAvaliacao(avaliacao);
        assertEquals(260.0f, restauranteA.calcularMediaValor(), 0.01f);
    }

    @Test
    public void DeveCalcularAvaliacaoUmaEstrelaB() {
        IAvaliacao avaliacao = new UmaEstrela();
        assertEquals(400.0f, restauranteB.getMediaValor());
        restauranteB.setAvaliacao(avaliacao);
        assertEquals(440.0f, restauranteB.calcularMediaValor(), 0.01f);
    }

    @Test
    public void DeveCalcularAvaliacaoDuasEstrelasB() {
        IAvaliacao avaliacao = new DuasEstrelas();
        assertEquals(400.0f, restauranteB.getMediaValor());
        restauranteB.setAvaliacao(avaliacao);
        assertEquals(480.0f, restauranteB.calcularMediaValor(), 0.01f);
    }

    @Test
    public void DeveCalcularAvaliacaoTresEstrelasB() {
        IAvaliacao avaliacao = new TresEstrelas();
        assertEquals(400.0f, restauranteB.getMediaValor());
        restauranteB.setAvaliacao(avaliacao);
        assertEquals(520.0f, restauranteB.calcularMediaValor(), 0.01f);
    }

    @Test
    void deveRetornarExcecaoParaRestauranteInexistente() {
        try {
            Restaurante restaurante = RestauranteFactory.obterRestaurante("D");
            fail();
        } catch (IllegalArgumentException e) {
            assertEquals("Restaurante inexistente", e.getMessage());
        }
    }

    @Test
    void deveRetornarExcecaoParaRestauranteInvalido() {
        try {
            Restaurante restaurante = RestauranteFactory.obterRestaurante("C");
            fail();
        } catch (IllegalArgumentException e) {
            assertEquals("Restaurante inválido", e.getMessage());
        }
    }

    @Test
    public void deveCriarInstanciaDeRestauranteA() {
        RestauranteFactory factory = RestauranteFactory.getInstance();
        Restaurante restaurante = factory.obterRestaurante("A");
        assertNotNull(restaurante);
        assertInstanceOf(Restaurante.class, restaurante);
    }
}
