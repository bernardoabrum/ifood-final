import org.junit.jupiter.api.Test;
import restaurante.item.IItem;
import restaurante.item.Item;
import restaurante.item.RemoverIngredientes;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class DecoratorTest {

    @Test
    void deveCriarItem() {
        Item item = new Item(20.0f);
        assertEquals(20.0f, item.getPreco());
        assertEquals("", item.getRemoverIngrediente());
    }

    @Test
    void deveRemoverIngrediente() {
        IItem item = new Item(20.0f);
        assertEquals(20.0f, item.getPreco());
        IItem novoItem = new RemoverIngredientes(item, "Milho");
        assertEquals("Ingredientes pra remover: Milho", novoItem.getRemoverIngrediente());
    }
}
