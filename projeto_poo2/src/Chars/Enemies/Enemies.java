package Chars.Enemies;

import Chars.Char;
import Chars.Player.Player;
import PadraoState.EnemiesStates.EnemiesState;
import PadraoState.EnemiesStates.InimigoVivo;

import java.util.Observable;
import java.util.Observer;

public abstract class Enemies extends Char implements Observer {
    // Fields //

    EnemiesState estadoAtual;
    private int life;

    // Constructor //

    public Enemies(int x, int y) {
        super(x, y);
        this.setEstadoAtual(InimigoVivo.getInstance());
        this.setLife(CONST_ENEMIES.HIT_MAX);
    }

    // Getters and Setters //

    public EnemiesState getEstadoAtual() {
        return estadoAtual;
    }

    public void setEstadoAtual(EnemiesState estadoAtual) {
        this.estadoAtual = estadoAtual;
    }

    public int getLife() {
        return life;
    }

    public void setLife(int life) {
        if(life > CONST_ENEMIES.HIT_MAX)
            this.life = CONST_ENEMIES.HIT_MAX;

        else if(life < CONST_ENEMIES.HIT_MORTO)
            this.life = 0;

        else
            this.life = life;

        this.getEstadoAtual().updateEstado(this);
    }

    // Methods //

    public int ataca() {
        return this.getAtaque().ataca();
    }

    public void ataca(Player alvo) {
        alvo.getEstadoAtual().levarDano(alvo, this.ataca());
    }

    public int corre() {
        return this.getCorrida().corre();
    }

    public int pula() {
        return this.getPulo().pula();
    }

    @Override
    public void update(Observable observable, Object o) {
        Player player = (Player) observable;

        if(player.getX() - this.getX() == 0 &&
                player.getY() - this.getY() == 0)
            this.ataca(player);

        else {
            if(player.getX() > this.getX()) this.setX(this.getX() + this.corre());
            else this.setX(this.getX() - this.corre());

            if(player.getY() > this.getY()) this.setY(this.getY() + this.pula());
            else this.setY(this.getY() - this.pula());
        }
    }

    public boolean isDead() {
        if(this.getLife() == CONST_ENEMIES.HIT_MORTO)
            return true;

        else
            return false;
    }
}
