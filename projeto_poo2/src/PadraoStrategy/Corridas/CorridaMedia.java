package PadraoStrategy.Corridas;

public class CorridaMedia extends Corrida {
    // Fields //

    private static final CorridaMedia INSTANCE = new CorridaMedia();

    // Constructor //

    private CorridaMedia() {}

    // Methods //

    public static CorridaMedia getInstance() {
        return INSTANCE;
    }

    @Override
    public int corre() {
        return CONST_CORRIDAS.COR_MEDIA;
    }
}
