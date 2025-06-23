package restaurante.item;

import java.util.List;

public abstract class ItemDecorator implements IItem{
    private IItem item;
    public float preco;

    public ItemDecorator(IItem item) {
        this.item = item;
    }

    public IItem getItem() {
        return item;
    }

    @Override
    public float getPreco() {
        return item.getPreco();
    }

    public void setPreco(float preco) {
        this.preco = preco;
    }

    @Override
    public List<String> getAdicionarIngrediente() {
        return item.getAdicionarIngrediente();
    }

    @Override
    public String getRemoverIngrediente() {
        return item.getRemoverIngrediente();
    }
}