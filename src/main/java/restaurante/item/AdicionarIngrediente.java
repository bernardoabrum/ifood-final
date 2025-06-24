package restaurante.item;

import java.util.List;

public class AdicionarIngrediente extends ItemDecorator {

    private final List<String> ingrediente;

    public AdicionarIngrediente(IItem item, List<String> ingrediente) {
        super(item);
        this.ingrediente = ingrediente;
    }

    public List<String> getAlterarItem() {
        return ingrediente;
    }

    public float getNovoPreco() {
        return getItem().getPreco() + (3.0f * ingrediente.size());
    }

    public String getDescricao() {
        return ingrediente.toString();
    }
}
