package PadraoState.PlayerStates;

import Chars.Player.Player;

public abstract class PlayerState {
    // Methods //

    public abstract void updateEstado(Player player);

    public void levarDano(Player player, int dano) {
        int dano_abs = Math.abs(dano);
        dano_abs = player.getEscudo().reduzDano(dano_abs * CONST_PLAYERSTATES.ATQ_DANO);

        player.setLife(player.getLife() - (dano_abs));

        // O update está sendo chamado no setLife do player
        // updateEstado(player);
    }

    public void curaVida(Player player, int cura) {
        int cura_abs = Math.abs(cura);
        player.setLife(player.getLife() + cura_abs);

        // O update está sendo chamado no setLife do player
        // updateEstado(player);
    }
}
