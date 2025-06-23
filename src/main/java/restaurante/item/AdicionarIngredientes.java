package restaurante.item;

import java.util.ArrayList;
import java.util.List;

public class AdicionarIngredientes extends ItemDecorator {
    private String ingrediente;
    private float precoAdicional;

    public AdicionarIngredientes(IItem item, String ingrediente, float precoAdicional) {
        super(item);
        this.ingrediente = ingrediente;
        this.precoAdicional = precoAdicional;
    }

    public float getPreco() {
        return super.getPreco() + precoAdicional;
    }

    public List<String> getAdicional() {
        List<String> adicionais = new ArrayList<>(super.getAdicionarIngrediente());
        adicionais.add(ingrediente);
        return adicionais;
    }

    public String getRemovidos() {
        return "";
    }
}
