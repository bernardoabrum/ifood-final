package cliente;

public class ClientePremium extends Cliente {
    public ClientePremium(String nome) {
        super(nome);
        tipoCompras.add(ComDesconto.getInstance());
    }
}
