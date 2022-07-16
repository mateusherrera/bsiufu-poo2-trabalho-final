package PadraoStrategy.Corridas;

public class CorridaLenta extends Corrida {
    // Fields //

    private static final CorridaLenta INSTANCE = new CorridaLenta();

    // Constructor //

    private CorridaLenta() {}

    // Methods //

    public static CorridaLenta getInstance() {
        return INSTANCE;
    }

    @Override
    public int corre() {
        return CONST_CORRIDAS.COR_LENTA;
    }
}
