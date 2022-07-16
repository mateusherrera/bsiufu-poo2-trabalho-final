package PadraoCommand;

import Chars.Player.Player;

public class MoverEsquerda extends Comando {
    // Fields

    private Player player;

    // Constructor

    public MoverEsquerda(Player player) {
        this.player = player;
    }

    // Methods

    @Override
    public void execute() {
        player.moverEsquerda();
    }
}
