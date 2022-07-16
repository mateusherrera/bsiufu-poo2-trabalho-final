package PadraoState.PlayerStates;

import Chars.Player.Player;
import PadraoStrategy.Ataques.AtaqueMedio;
import PadraoStrategy.Ataques.AtaqueMorto;
import PadraoStrategy.Corridas.CorridaMedia;
import PadraoStrategy.Corridas.CorridaMorto;
import PadraoStrategy.Pulos.PuloMedio;
import PadraoStrategy.Pulos.PuloMorto;

public class Perigo extends PlayerState {
    // Fields //

    private static final Perigo INSTANCE = new Perigo();

    // Constructor //

    private Perigo() {}

    // Methods //

    public static Perigo getInstance() {
        return INSTANCE;
    }

    @Override
    public void updateEstado(Player player) {
        if(player.getLifePerc() <= CONST_PLAYERSTATES.LIM_MORTO) {
            player.setEstadoAtual(Morto.getInstance());

            player.setAtaque(AtaqueMorto.getInstance());
            player.setCorrida(CorridaMorto.getInstance());
            player.setPulo(PuloMorto.getInstance());

            player.getEstadoAtual().updateEstado(player);
        }

        else if(player.getLifePerc() > CONST_PLAYERSTATES.LIM_PERIGO) {
            player.setEstadoAtual(Normal.getInstance());

            player.setAtaque(AtaqueMedio.getInstance());
            player.setCorrida(CorridaMedia.getInstance());
            player.setPulo(PuloMedio.getInstance());

            player.getEstadoAtual().updateEstado(player);
        }
    }
}
