package restaurante;

public class RestauranteFactory {
    private RestauranteFactory() {}
    private static RestauranteFactory instance = new RestauranteFactory();
    public static RestauranteFactory getInstance() {
        return instance;
    }

    public static Restaurante obterRestaurante(String restaurante) {
        Class classe = null;
        Object objeto = null;

        try {
            classe = Class.forName("restaurante.Restaurante" + restaurante);
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