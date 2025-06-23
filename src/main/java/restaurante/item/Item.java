package restaurante.item;

import java.util.ArrayList;
import java.util.List;

public class Item implements IItem {
    public float preco;
    public List<String> adicionado;
    public List<String> removido;

    public Item(float preco) {
        this.preco = preco;
        this.adicionado = new ArrayList<>();
        this.removido = new ArrayList<>();
    }

    public float getPreco() {
        return preco;
    }

    public List<String> getIngredienteAdicionado() {
        return adicionado;
    }

    public List<String> getIngredienteRemovido() {
        return removido;
    }
}
