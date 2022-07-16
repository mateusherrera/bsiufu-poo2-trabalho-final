package PadraoStrategy.Ataques.PadraoDecorator;

import PadraoStrategy.Ataques.Ataque;
import PadraoStrategy.Ataques.CONST_ATAQUES;

public class Poder2 extends Poderes {
    // Constructor //

    public Poder2(Ataque ataqueDecorado) {
        super(ataqueDecorado);
    }

    // Methods //

    @Override
    public int bonus_poder() {
        return CONST_ATAQUES.BONUS_2;
    }
}
