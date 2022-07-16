package Chars.Enemies;

import PadraoStrategy.Ataques.AtaqueMedio;
import PadraoStrategy.Corridas.CorridaVeloz;
import PadraoStrategy.Pulos.PuloAlto;

public class Enemy2 extends Enemies {
    // Constructor //

    public Enemy2(int x, int y) {
        super(x, y);
        this.setAtaque(AtaqueMedio.getInstance());
        this.setCorrida(CorridaVeloz.getInstance());
        this.setPulo(PuloAlto.getInstance());
    }
}
