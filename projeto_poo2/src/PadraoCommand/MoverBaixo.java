package PadraoCommand;

import Chars.Player.Player;

public class MoverBaixo extends Comando {
    // Fields

    private Player player;

    // Constructor

    public MoverBaixo(Player player) {
        this.player = player;
    }

    // Methods

    @Override
    public void execute() {
        player.moverBaixo();
    }
}
