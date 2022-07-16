package PadraoStrategy.Pulos;

public class PuloAlto extends Pulo {
    // Fields //

    private static final PuloAlto INSTANCE = new PuloAlto();

    // Constructor //

    private PuloAlto() {}

    // Methods //

    public static PuloAlto getInstance() {
        return INSTANCE;
    }

    @Override
    public int pula() {
        return CONST_PULOS.PULO_ALTO;
    }
}
