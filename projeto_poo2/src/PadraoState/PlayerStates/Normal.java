package PadraoState.PlayerStates;

import Chars.Player.Player;
import PadraoStrategy.Ataques.AtaqueForte;
import PadraoStrategy.Ataques.AtaqueFraco;
import PadraoStrategy.Ataques.AtaqueMedio;
import PadraoStrategy.Ataques.PadraoDecorator.Poder3;
import PadraoStrategy.Corridas.CorridaLenta;
import PadraoStrategy.Corridas.CorridaMedia;
import PadraoStrategy.Corridas.CorridaVeloz;
import PadraoStrategy.Pulos.PuloAlto;
import PadraoStrategy.Pulos.PuloBaixo;
import PadraoStrategy.Pulos.PuloMedio;

public class Normal extends PlayerState {
    // Fields //

    private static Normal instance = null;

    // Constructor //

    private Normal() {}

    // Methods //

    public static synchronized Normal getInstance() {
        if(instance == null)
            instance = new Normal();

        return instance;
    }

    @Override
    public void updateEstado(Player player) {
        if(player.getLifePerc() <= CONST_PLAYERSTATES.LIM_PERIGO) {
            player.setEstadoAtual(Perigo.getInstance());

            player.setAtaque(AtaqueFraco.getInstance());
            player.setCorrida(CorridaLenta.getInstance());
            player.setPulo(PuloBaixo.getInstance());

            player.getEstadoAtual().updateEstado(player);
        }

        else if(player.getLifePerc() > CONST_PLAYERSTATES.LIM_NORMAL) {
            player.setEstadoAtual(Forte.getInstance());

            player.setAtaque(AtaqueForte.getInstance());
            player.setCorrida(CorridaVeloz.getInstance());
            player.setPulo(PuloAlto.getInstance());

            player.setAtaque(new Poder3(player.getAtaque()));
            player.getEstadoAtual().updateEstado(player);
        }
    }
}
