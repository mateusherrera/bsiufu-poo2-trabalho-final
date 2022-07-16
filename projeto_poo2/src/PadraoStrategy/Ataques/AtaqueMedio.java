package PadraoStrategy.Ataques;

public class AtaqueMedio extends Ataque {
    // Fields //

    private static final AtaqueMedio INSTANCE = new AtaqueMedio();

    // Constructor //

    private AtaqueMedio() {}

    // Methods //

    public static AtaqueMedio getInstance() {
        return INSTANCE;
    }

    @Override
    public int ataca() {
        return CONST_ATAQUES.ATQ_MEDIO;
    }
}
