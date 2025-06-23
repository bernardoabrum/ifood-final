package restaurante.item;

import java.util.List;

public abstract class ItemDecorator implements IItem {

    private IItem item;
//    public float preco;

    public ItemDecorator(IItem item) {
        this.item = item;
    }

    public float getPreco() {
        return item.getPreco();
    }

    public abstract String getRemovidos();

    public String getRemoverIngrediente() {
        return "Ingredientes pra remover: " + this.getRemovidos();
    }
}