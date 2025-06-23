package restaurante.item;

public class RemoverIngredientes extends ItemDecorator{
    public RemoverIngredientes(IItem decoratedItem) {
        super(decoratedItem);
    }

    public String getRemoverIngrediente(String ingredienteRemovido) {
        return ingredienteRemovido;
    }
}
