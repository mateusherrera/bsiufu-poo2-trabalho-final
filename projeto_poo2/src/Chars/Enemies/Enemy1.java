package Chars.Enemies;

import PadraoStrategy.Ataques.AtaqueForte;
import PadraoStrategy.Corridas.CorridaMedia;
import PadraoStrategy.Pulos.PuloMedio;

public class Enemy1 extends Enemies {
    // Constructor //

    public Enemy1(int x, int y) {
        super(x, y);
        this.setAtaque(AtaqueForte.getInstance());
        this.setCorrida(CorridaMedia.getInstance());
        this.setPulo(PuloMedio.getInstance());
    }
}
