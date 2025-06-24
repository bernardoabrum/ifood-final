package restaurante.avaliacao;

public class DuasEstrelas implements IAvaliacao {

    public float porcentagemAumento() {
        return 0.2f;
    }

    public String descricao() {
        return "Duas estrelas";
    }
}
