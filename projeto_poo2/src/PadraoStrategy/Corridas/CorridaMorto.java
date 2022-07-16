package PadraoStrategy.Corridas;

public class CorridaMorto extends Corrida {
    // Fields //

    private static final CorridaMorto INSTANCE = new CorridaMorto();

    // Constructor //

    private CorridaMorto() {}

    // Methods //

    public static CorridaMorto getInstance() {
        return INSTANCE;
    }

    @Override
    public int corre() {
        return CONST_CORRIDAS.COR_MORTO;
    }
}
