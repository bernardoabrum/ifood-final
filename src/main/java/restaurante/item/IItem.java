package restaurante.item;

import java.util.List;

public interface IItem {
    float getPreco();
    List<String> getAdicionarIngrediente();
    String getRemoverIngrediente();
}
