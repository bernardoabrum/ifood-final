package restaurante;

public class RestauranteFactory {

    public static Restaurante obterRestaurante(String restaurante) {
        Class classe = null;
        Object objeto = null;

        try {
            classe = Class.forName("restaurante" + restaurante);
            objeto = classe.newInstance();
        } catch (Exception e) {
            throw new IllegalArgumentException("Restaurante inexistente");
        }

        if (!(objeto instanceof Restaurante)) {
            throw new IllegalArgumentException("Restaurante inválido");
        } else {
            return (Restaurante) objeto;
        }
    }
}