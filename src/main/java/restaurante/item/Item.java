package restaurante.item;

import java.util.ArrayList;
import java.util.List;

public class Item implements IItem{
    public float preco;
    public List<String> adicional;
    public String remover;

    public Item(float preco) {
        this.preco = preco;
        this.adicional = new ArrayList<>();
        this.remover = "";
    }

    @Override
    public float getPreco() {
        return preco;
    }

    @Override
    public List<String> getAdicionarIngrediente() {
        return adicional;
    }

    @Override
    public String getRemoverIngrediente() {
        return remover;
    }
}
