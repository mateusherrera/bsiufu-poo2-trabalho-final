package PadraoState.PlayerStates;

import Chars.Player.Player;
import PadraoStrategy.Ataques.AtaqueFraco;
import PadraoStrategy.Ataques.AtaqueMorto;
import PadraoStrategy.Corridas.CorridaLenta;
import PadraoStrategy.Corridas.CorridaMorto;
import PadraoStrategy.Pulos.PuloBaixo;
import PadraoStrategy.Pulos.PuloMorto;

public class Morto extends PlayerState {
    // Fields //

    private static Morto instance = null;

    // Constructor //

    private Morto() {}

    // Methods //

    public static synchronized Morto getInstance() {
        if(instance == null)
            instance = new Morto();

        return instance;
    }

    @Override
    public void updateEstado(Player player) {
        if(player.getLifePerc() > CONST_PLAYERSTATES.LIM_MORTO) {
            player.setEstadoAtual(Perigo.getInstance());

            player.setAtaque(AtaqueFraco.getInstance());
            player.setCorrida(CorridaLenta.getInstance());
            player.setPulo(PuloBaixo.getInstance());

            player.getEstadoAtual().updateEstado(player);
        }
    }
}
