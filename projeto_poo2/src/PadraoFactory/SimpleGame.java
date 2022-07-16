package PadraoFactory;

import Game.Game;
import Chars.Enemies.*;
import PadraoAbstractFactory.CONST_ABSTRACTFACTORY;
import PadraoAbstractFactory.GameFamiliesFactory;

public class SimpleGame extends Game {
    // Fields //

    private static SimpleGame instance = null;

    // Constructor //

    private SimpleGame() {}

    // Methods //

    public static synchronized SimpleGame getInstance() {
        if(instance == null)
            instance = new SimpleGame();

        return instance;
    }

    @Override
    protected Enemies createInimigo(GameFamiliesFactory family, double tipo, int x, int y) {
        if(tipo <= CONST_FACTORY.PSG_1)
            return family.createEnemy(x, y, CONST_ABSTRACTFACTORY.ENEMY_TYPE1);

        else if(tipo <= CONST_FACTORY.PSG_2)
            return family.createEnemy(x, y, CONST_ABSTRACTFACTORY.ENEMY_TYPE2);

        else if(tipo <= CONST_FACTORY.PSG_3)
            return family.createEnemy(x, y, CONST_ABSTRACTFACTORY.ENEMY_TYPE3);

        else if(tipo <= CONST_FACTORY.PSG_4)
            return family.createEnemy(x, y, CONST_ABSTRACTFACTORY.ENEMY_TYPE4);

        else
            return family.createEnemy(x, y, CONST_ABSTRACTFACTORY.ENEMY_TYPE5);
    }
}

