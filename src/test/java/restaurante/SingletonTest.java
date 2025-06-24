package restaurante;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class SingletonTest {

    @Test
    public void deveRetornarNomeEscola() {
        RestauranteFactory factory = RestauranteFactory.getInstance();
        Restaurante restaurante =factory.obterRestaurante("A");
        assertNotNull(restaurante);
        assertInstanceOf(Restaurante.class, restaurante);
    }
}
