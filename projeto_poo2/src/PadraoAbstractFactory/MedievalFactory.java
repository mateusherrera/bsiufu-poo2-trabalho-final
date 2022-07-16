package PadraoAbstractFactory;

import Chars.Char;
import Chars.Enemies.Enemies;
import Chars.Player.Player;
import PadraoAbstractFactory.Medieval.ArcoEFlecha;
import PadraoAbstractFactory.Medieval.Arqueiro;
import PadraoAbstractFactory.Medieval.Escudo;
import PadraoChain.Shield;
import PadraoStrategy.Ataques.Ataque;

public class MedievalFactory extends GameFamiliesFactory {
    // Fields //

    private static MedievalFactory instance = null;

    // Constructor //

    private MedievalFactory() {}

    // Methods //

    public static synchronized MedievalFactory getInstance() {
        if(instance == null)
            instance = new MedievalFactory();

        return instance;
    }

    @Override
    public Player createPlayer(int x, int y) {
        return Arqueiro.getArqueiroPlayer(x, y);
    }

    @Override
    public Enemies createEnemy(int x, int y, int tipo) {
        return Arqueiro.getArqueiroEnemy(x, y, tipo);
    }

    @Override
    public Shield createDefesa(int tipo) {
        return Escudo.getEscudo(tipo);
    }

    @Override
    public Ataque createArma(int tipo) {
        return ArcoEFlecha.getArcoEFlecha(tipo);
    }
}
