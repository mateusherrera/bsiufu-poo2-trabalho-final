package Chars;

import Game.Coordenadas.CONST_COORD;
import PadraoStrategy.Ataques.Ataque;
import PadraoStrategy.Corridas.Corrida;
import PadraoStrategy.Pulos.Pulo;

import java.util.Observable;

public abstract class Char extends Observable {
    // Fields //

    private Ataque ataque;
    private Corrida corrida;
    private Pulo pulo;
    private int x;
    private int y;

    // Constructor //

    public Char(int x, int y) {
        this.setX(x);
        this.setY(y);
    }

    // Getters and Setters //

    public Ataque getAtaque() {
        return ataque;
    }

    public void setAtaque(Ataque ataque) {
        this.ataque = ataque;
    }

    public Corrida getCorrida() {
        return corrida;
    }

    public void setCorrida(Corrida corrida) {
        this.corrida = corrida;
    }

    public Pulo getPulo() {
        return pulo;
    }

    public void setPulo(Pulo pulo) {
        this.pulo = pulo;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        if(x > CONST_COORD.MAX_X)
            this.x = CONST_COORD.MAX_X;

        else if(x < CONST_COORD.MIN_X)
            this.x = CONST_COORD.MIN_X;

        else
            this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        if(y > CONST_COORD.MAX_Y)
            this.y = CONST_COORD.MAX_Y;

        else if(y < CONST_COORD.MIN_Y)
            this.y = CONST_COORD.MIN_Y;

        else
            this.y = y;
    }

    // Methods //

    public void show() {
        setChanged();
        notifyObservers();
    }
}
