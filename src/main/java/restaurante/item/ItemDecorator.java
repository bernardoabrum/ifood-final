package restaurante.item;

import java.util.List;

public abstract class ItemDecorator implements IItem {

    private IItem item;

    public ItemDecorator(IItem item) {
        this.item = item;
    }

    public IItem getItem() {
        return item;
    }

    public float getPreco() {
        return getNovoPreco();
    }

    public abstract List<String> getAlterarItem();

    public abstract float getNovoPreco();

    public List<String> getRemoverIngrediente() {
        return this.getAlterarItem();
    }

    public List<String> getAdicionarIngrediente() {
        return this.getAlterarItem();
    }
}