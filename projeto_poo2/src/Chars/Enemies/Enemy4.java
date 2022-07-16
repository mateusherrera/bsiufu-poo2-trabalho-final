package Chars.Enemies;

import PadraoStrategy.Ataques.AtaqueFraco;
import PadraoStrategy.Corridas.CorridaLenta;
import PadraoStrategy.Pulos.PuloBaixo;

public class Enemy4 extends Enemies {
    // Constructor //

    public Enemy4(int x, int y) {
        super(x, y);
        this.setAtaque(AtaqueFraco.getInstance());
        this.setCorrida(CorridaLenta.getInstance());
        this.setPulo(PuloBaixo.getInstance());
    }
}
