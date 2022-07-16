package Chars.Enemies;

import PadraoStrategy.Ataques.AtaqueForte;
import PadraoStrategy.Corridas.CorridaVeloz;
import PadraoStrategy.Pulos.PuloAlto;

public class Enemy5 extends Enemies {
    // Constructor //

    public Enemy5(int x, int y) {
        super(x, y);
        this.setAtaque(AtaqueForte.getInstance());
        this.setCorrida(CorridaVeloz.getInstance());
        this.setPulo(PuloAlto.getInstance());
    }
}
