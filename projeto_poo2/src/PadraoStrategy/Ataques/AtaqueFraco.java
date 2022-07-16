package PadraoStrategy.Ataques;

public class AtaqueFraco extends Ataque {
    // Fields //

    private static final AtaqueFraco INSTANCE = new AtaqueFraco();

    // Constructor //

    private AtaqueFraco() {}

    // Methods //

    public static AtaqueFraco getInstance() {
        return INSTANCE;
    }

    @Override
    public int ataca() {
        return CONST_ATAQUES.ATQ_FRACO;
    }
}
