package PadraoStrategy.Ataques;

public class AtaqueForte extends Ataque {
    // Fields //

    private static final AtaqueForte INSTANCE = new AtaqueForte();

    // Constructor //

    private AtaqueForte() {}

    // Methods //

    public static AtaqueForte getInstance() {
        return INSTANCE;
    }

    @Override
    public int ataca() {
        return CONST_ATAQUES.ATQ_FORTE;
    }
}
