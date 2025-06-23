package restaurante.item;

public class RemoverIngredientes extends ItemDecorator {

    private final String ingrediente;

    public RemoverIngredientes(IItem item, String ingrediente) {
        super(item);
        this.ingrediente = ingrediente;
    }

    public String getRemovidos() {
        return ingrediente;
    }
}
