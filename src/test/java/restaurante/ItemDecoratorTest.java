package restaurante;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import restaurante.item.AdicionarIngrediente;
import restaurante.item.IItem;
import restaurante.item.Item;
import restaurante.item.RemoverIngrediente;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class ItemDecoratorTest {

    private IItem item;

    @BeforeEach
    void setUp() {
        item = new Item("Item1",20.0f);
    }

    @Test
    void deveCriarItem() {
        assertEquals(20.0f, item.getPreco());
        assertTrue(item.getIngredienteAdicionado().isEmpty());
        assertTrue(item.getIngredienteRemovido().isEmpty());
    }

    @Test
    void deveRemoverIngrediente() {
        List<String> ingredientes = Arrays.asList("Milho", "Alface");
        IItem novoItem = new RemoverIngrediente(item, ingredientes);
        assertEquals(ingredientes, novoItem.getIngredienteRemovido());
        assertEquals(20.0f, novoItem.getPreco());
    }

    @Test
    void deveAdicionarIngrediente() {
        List<String> ingredientes = Arrays.asList("Queijo", "Carbe");
        IItem novoItem = new AdicionarIngrediente(item, ingredientes);
        assertEquals(ingredientes, novoItem.getIngredienteAdicionado());
        assertEquals(26.0f, novoItem.getPreco());
    }
}
