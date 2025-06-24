package cliente;

public class Compra {
    private TipoCompra compraAtual;

    public Compra(TipoCompra compraAtual) {
        this.compraAtual = compraAtual;
    }

    public TipoCompra getCompraAtual() {
        return compraAtual;
    }

    public void setCompraAtual(TipoCompra compraAtual) {
        this.compraAtual = compraAtual;
    }
}
