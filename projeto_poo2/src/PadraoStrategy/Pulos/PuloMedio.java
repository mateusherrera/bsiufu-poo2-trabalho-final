package PadraoStrategy.Pulos;

public class PuloMedio extends Pulo {
    // Fields //

    private static final PuloMedio INSTANCE = new PuloMedio();

    // Constructor //

    private PuloMedio() {}

    // Methods //

    public static PuloMedio getInstance() {
        return INSTANCE;
    }

    @Override
    public int pula() {
        return CONST_PULOS.PULO_MEDIO;
    }
}
