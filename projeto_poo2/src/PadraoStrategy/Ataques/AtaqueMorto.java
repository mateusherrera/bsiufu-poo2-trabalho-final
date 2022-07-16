package PadraoStrategy.Ataques;

public class AtaqueMorto extends Ataque {
    // Fields //

    private static final AtaqueMorto INSTANCE = new AtaqueMorto();

    // Constructor //

    private AtaqueMorto() {}

    // Methods //

    public static AtaqueMorto getInstance() {
        return INSTANCE;
    }

    @Override
    public int ataca() {
        return CONST_ATAQUES.ATQ_MORTO;
    }
}
