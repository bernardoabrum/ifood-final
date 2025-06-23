package restaurante.item;

import java.util.List;

public class RemoverIngrediente extends ItemDecorator {

    private final List<String> ingrediente;

    public RemoverIngrediente(IItem item, List<String> ingrediente) {
        super(item);
        this.ingrediente = ingrediente;
    }

    public List<String> getAlterarItem() {
        return ingrediente;
    }

    public float getNovoPreco() {
        return getItem().getPreco();
    }
}
