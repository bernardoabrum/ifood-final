package cliente;

public class ClienteComum extends Cliente {
    public ClienteComum(String nome) {
        super(nome);
        tipoCompras.add(SemDesconto.getInstance());
    }
}
