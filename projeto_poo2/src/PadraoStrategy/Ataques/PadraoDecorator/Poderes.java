package PadraoStrategy.Ataques.PadraoDecorator;

import PadraoStrategy.Ataques.Ataque;
import PadraoStrategy.Ataques.CONST_ATAQUES;

public abstract class Poderes extends Ataque {
    // Fields //

    protected Ataque ataqueDecorado;

    // Constructor //

    public Poderes(Ataque ataqueDecorado) {
        this.ataqueDecorado = ataqueDecorado;
    }

    // Methods //

    public abstract int bonus_poder();

    @Override
    public int ataca() {
        return this.ataqueDecorado.ataca() + this.bonus_poder();
    }
}
