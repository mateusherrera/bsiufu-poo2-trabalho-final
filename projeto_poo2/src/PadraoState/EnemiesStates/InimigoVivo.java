package PadraoState.EnemiesStates;

import Chars.Enemies.Enemies;
import PadraoStrategy.Ataques.AtaqueMorto;
import PadraoStrategy.Corridas.CorridaMorto;
import PadraoStrategy.Pulos.PuloMorto;

public class InimigoVivo extends EnemiesState {
    // Fields //

    private static final InimigoVivo INSTANCE = new InimigoVivo();

    // Constructor //

    private InimigoVivo() {}

    // Methods //

    public static InimigoVivo getInstance() {
        return INSTANCE;
    }

    @Override
    public void updateEstado(Enemies inimigo) {
        if(inimigo.getLife() <= CONST_ENEMIESTATES.MORTO) {
            inimigo.setEstadoAtual(InimigoMorto.getInstance());

            inimigo.setAtaque(AtaqueMorto.getInstance());
            inimigo.setCorrida(CorridaMorto.getInstance());
            inimigo.setPulo(PuloMorto.getInstance());
        }
    }
}
