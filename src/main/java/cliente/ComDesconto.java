package cliente;

public class ComDesconto implements TipoCompra {
    private ComDesconto() {
    }

    private static final ComDesconto instancia = new ComDesconto();

    public static ComDesconto getInstance() {
        return instancia;
    }
}
