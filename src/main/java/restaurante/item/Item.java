package restaurante.item;

import java.util.ArrayList;
import java.util.List;

public class Item implements IItem {
    public String descricao;
    public float preco;
    public List<String> adicionado;
    public List<String> removido;

    public Item(String descricao, float preco) {
        this.descricao = descricao;
        this.preco = preco;
        this.adicionado = new ArrayList<>();
        this.removido = new ArrayList<>();
    }

    public float getPreco() {
        return preco;
    }

    public String getDescricao() {
        return descricao;
    }

    public List<String> getIngredienteAdicionado() {
        return adicionado;
    }

    public List<String> getIngredienteRemovido() {
        return removido;
    }
}
