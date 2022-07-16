package PadraoCommand;

import Chars.Player.Player;

public class MoverCima extends Comando {
    // Fields

    private Player player;

    // Constructor

    public MoverCima(Player player) {
        this.player = player;
    }

    // Methods

    @Override
    public void execute() {
        player.moverCima();
    }
}
