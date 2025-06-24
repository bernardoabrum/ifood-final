package restaurante.avaliacao;

public class TresEstrelas implements IAvaliacao{

    public float porcentagemAumento() {
        return 0.3f;
    }

    public String descricao() {
        return "Três estrelas";
    }
}
