package PadraoAbstractFactory;

import Chars.Enemies.Enemies;
import Chars.Player.Player;
import PadraoAbstractFactory.Futurista.CampoMagnetico;
import PadraoAbstractFactory.Futurista.RaioParalisante;
import PadraoAbstractFactory.Futurista.Robo;
import PadraoChain.Shield;
import PadraoStrategy.Ataques.Ataque;

public class FuturistaFactory extends GameFamiliesFactory {
    // Fields //

    private static FuturistaFactory instance = null;

    // Constructor //

    private FuturistaFactory() {}

    // Methods //

    public static synchronized FuturistaFactory getInstance() {
        if(instance == null)
            instance = new FuturistaFactory();

        return instance;
    }

    @Override
    public Player createPlayer(int x, int y) {
        return Robo.getRoboPlayer(x, y);
    }

    @Override
    public Enemies createEnemy(int x, int y, int tipo) {
        return Robo.getRoboEnemy(x, y, tipo);
    }

    @Override
    public Shield createDefesa(int tipo) {
        return CampoMagnetico.getCampoMagnetico(tipo);
    }

    @Override
    public Ataque createArma(int tipo) {
        return RaioParalisante.getRaioParalisante(tipo);
    }
}
