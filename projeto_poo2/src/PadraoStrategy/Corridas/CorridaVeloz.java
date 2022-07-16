package PadraoStrategy.Corridas;

public class CorridaVeloz extends Corrida {
    // Fields //

    private static final CorridaVeloz INSTANCE = new CorridaVeloz();

    // Constructor //

    private CorridaVeloz() {}

    // Methods //

    public static CorridaVeloz getInstance() {
        return INSTANCE;
    }

    @Override
    public int corre() {
        return CONST_CORRIDAS.COR_VELOZ;
    }
}
