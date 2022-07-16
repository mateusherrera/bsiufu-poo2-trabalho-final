package PadraoState.PlayerStates;

import Chars.Player.Player;
import PadraoStrategy.Ataques.AtaqueForte;
import PadraoStrategy.Ataques.AtaqueMedio;
import PadraoStrategy.Corridas.CorridaMedia;
import PadraoStrategy.Corridas.CorridaVeloz;
import PadraoStrategy.Pulos.PuloAlto;
import PadraoStrategy.Pulos.PuloMedio;

public class Forte extends PlayerState {
    // Fields //

    private static Forte instance = null;

    // Constructor //

    private Forte() {}

    // Methods //

    public static synchronized Forte getInstance() {
        if(instance == null)
            instance = new Forte();

        return instance;
    }

    @Override
    public void updateEstado(Player player) {
        if(player.getLifePerc() <= CONST_PLAYERSTATES.LIM_NORMAL) {
            player.setEstadoAtual(Normal.getInstance());

            player.setAtaque(AtaqueMedio.getInstance());
            player.setCorrida(CorridaMedia.getInstance());
            player.setPulo(PuloMedio.getInstance());

            player.getEstadoAtual().updateEstado(player);
        }
    }
}
