package PadraoCommand;

import Chars.Player.Player;

public class MoverDireita extends Comando {
    // Fields

    private Player player;

    // Constructor

    public MoverDireita(Player player) {
        this.player = player;
    }

    // Methods

    @Override
    public void execute() {
        player.moverDireita();
    }
}
