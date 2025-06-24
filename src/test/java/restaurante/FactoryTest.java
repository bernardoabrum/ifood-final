package restaurante;

import org.testng.annotations.Test;
import static org.junit.jupiter.api.Assertions.*;

public class FactoryTest {

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
}
