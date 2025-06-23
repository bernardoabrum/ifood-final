package restaurante.item;

import java.util.ArrayList;
import java.util.List;

public class Item implements IItem {
    public float preco;
    public List<String> adicional;
    public List<String> removido;

    public Item(float preco) {
        this.preco = preco;
        this.adicional = new ArrayList<>();
        this.removido = new ArrayList<>();
    }

    public float getPreco() {
        return preco;
    }

    public List<String> getAdicionarIngrediente() {
        return adicional;
    }

    public List<String> getRemoverIngrediente() {
        return removido;
    }
}
