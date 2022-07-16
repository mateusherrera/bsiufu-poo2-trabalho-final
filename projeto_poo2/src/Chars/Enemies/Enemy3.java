package Chars.Enemies;

import PadraoStrategy.Ataques.AtaqueForte;
import PadraoStrategy.Corridas.CorridaVeloz;
import PadraoStrategy.Pulos.PuloBaixo;

public class Enemy3 extends Enemies {
    // Constructor //

    public Enemy3(int x, int y) {
        super(x, y);
        this.setAtaque(AtaqueForte.getInstance());
        this.setCorrida(CorridaVeloz.getInstance());
        this.setPulo(PuloBaixo.getInstance());
    }
}
