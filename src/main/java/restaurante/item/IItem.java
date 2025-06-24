package restaurante.item;

import java.util.List;

public interface IItem {
    float getPreco();

    List<String> getIngredienteAdicionado();

    List<String> getIngredienteRemovido();

    String getDescricao();
}
