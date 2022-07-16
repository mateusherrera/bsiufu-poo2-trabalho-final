package PadraoComposite;

import Game.Game;
import Game.CONST_GAME;
import PadraoFactory.AdvancedGame;
import PadraoFactory.SimpleGame;

public class Fase {
    // Fields //

    private String nome;
    private Fase esq;
    private Fase dir;
    private int vel;
    private int qtd;

    // Constructor //

    public Fase(String nome, Fase esq, Fase dir, int vel, int qtd) {
        this.nome = nome;
        this.esq = esq;
        this.dir = dir;
        this.vel = vel;
        this.qtd = qtd;
    }

    // Getters //

    public String getNome() {
        return nome;
    }

    public Fase getEsq() {
        return esq;
    }

    public Fase getDir() {
        return dir;
    }
    // Methods //

    public void jogarFase(double complexidade, double periodo) throws InterruptedException {
        Game game;

        if (complexidade <= 0.5) {
            System.out.println("simple game running...");
            game = SimpleGame.getInstance();

        } else {
            System.out.println("advanced game running...");
            game = AdvancedGame.getInstance();
        }

        if(periodo <= 0.5) {
            System.out.println("futurist...");
            game.jogar(game, CONST_GAME.FUTIRISTA, qtd, vel, nome);

        } else {
            System.out.println("medieval...");
            game.jogar(game, CONST_GAME.MEDIEVAL, qtd, vel, nome);
        }
    }

    public Fase Escolha(int escolha) {
        if(escolha <= CONST_FASE.ESQUERDA)
            return esq;

        else
            return dir;
    }
}
