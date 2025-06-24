package restaurante.avaliacao;

public class UmaEstrela implements IAvaliacao {

    public float porcentagemAumento() {
        return 0.1f;
    }

    public String descricao() {
        return "Uma estrela";
    }
}
