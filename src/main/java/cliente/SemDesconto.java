package cliente;

public class SemDesconto implements TipoCompra {
    private SemDesconto() {
    }

    private static final SemDesconto instancia = new SemDesconto();

    public static SemDesconto getInstance() {
        return instancia;
    }
}
