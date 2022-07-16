package Chars.Player;

import Chars.Char;
import Chars.Enemies.Enemies;
import PadraoChain.Shield;
import PadraoChain.ShieldMedio;
import PadraoState.PlayerStates.Perigo;
import PadraoState.PlayerStates.PlayerState;
import PadraoStrategy.Ataques.PadraoDecorator.Poder1;

public class Player extends Char {
    // Fields //

    private PlayerState estadoAtual;
    private int life;
    private int lifePerc;
    private Shield shield;

    // Constructor //

    public Player(int x, int y) {
        super(x, y);
        this.setEscudo(new ShieldMedio());
        this.setEstadoAtual(Perigo.getInstance());
        this.setLife((int) Math.round(CONST_PLAYER.LIFE_MAX * CONST_PLAYER.PERC_LIFE_INI));
        this.setAtaque(new Poder1(this.getAtaque()));
    }

    // Getters and Setters //

    public PlayerState getEstadoAtual() {
        return estadoAtual;
    }

    public void setEstadoAtual(PlayerState estadoAtual) {
        this.estadoAtual = estadoAtual;
    }

    public int getLife() {
        return life;
    }

    public void setLife(int life) {
        if(life < CONST_PLAYER.LIFE_MIN)
            this.life = CONST_PLAYER.LIFE_MIN;

        else if(life > CONST_PLAYER.LIFE_MAX)
            this.life = CONST_PLAYER.LIFE_MAX;

        else
            this.life = life;

        this.setLifePerc( (int) Math.round( ((double) this.life / CONST_PLAYER.LIFE_MAX) * 100 ));
        this.getEstadoAtual().updateEstado(this);
    }

    public int getLifePerc() {
        return lifePerc;
    }

    private void setLifePerc(int lifePerc) {
        this.lifePerc = lifePerc;
    }

    public Shield getEscudo() {
        return shield;
    }

    public void setEscudo(Shield shield) {
        this.shield = shield;
    }

    // Methods //

    public int ataca() {
        return this.getAtaque().ataca();
    }

    public void ataca(Enemies alvo) {
        alvo.getEstadoAtual().levarDano(alvo, this.ataca());
    }

    public int corre() {
        return this.getCorrida().corre();
    }

    public int pula() {
        return this.getPulo().pula();
    }

    public void addNovoEscudo(Shield novoShield) {
        Shield nxShield = this.getEscudo();
        this.setEscudo(novoShield);
        novoShield.setNxEscudo(nxShield);
    }

    public void moverEsquerda() {
        this.setX(this.getX() - this.corre());
    }

    public void moverDireita() {
        this.setX(this.getX() + this.corre());
    }

    public void moverBaixo() {
        this.setY(this.getY() + this.pula());
    }

    public void moverCima() {
        this.setY(this.getY() - this.pula());
    }
}
