package PadraoCommand;

import Chars.Enemies.Enemies;
import Chars.Player.Player;

public class Atacar extends Comando {
    // Fields

    private Player player;
    private Enemies inimigo;

    // Constructor

    public Atacar(Player player, Enemies inimigo) {
        this.player = player;
        this.inimigo = inimigo;
    }

    // Methods

    @Override
    public void execute() {
        player.ataca(inimigo);
    }
}
