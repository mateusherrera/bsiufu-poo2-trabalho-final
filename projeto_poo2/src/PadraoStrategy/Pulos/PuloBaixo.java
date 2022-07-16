package PadraoStrategy.Pulos;

public class PuloBaixo extends Pulo {
    // Fields //

    private static final PuloBaixo INSTANCE = new PuloBaixo();

    // Constructor //

    private PuloBaixo() {}

    // Methods //

    public static PuloBaixo getInstance() {
        return INSTANCE;
    }

    @Override
    public int pula() {
        return CONST_PULOS.PULO_BAIXO;
    }
}
