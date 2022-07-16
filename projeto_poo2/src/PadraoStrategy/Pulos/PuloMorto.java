package PadraoStrategy.Pulos;

public class PuloMorto extends Pulo {
    // Fields //

    private static final PuloMorto INSTANCE = new PuloMorto();

    // Constructor //

    private PuloMorto() {}

    // Methods //

    public static PuloMorto getInstance() {
        return INSTANCE;
    }

    @Override
    public int pula() {
        return CONST_PULOS.PULO_MORTO;
    }
}
