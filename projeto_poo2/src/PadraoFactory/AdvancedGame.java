package PadraoFactory;

import Game.Game;
import Chars.Enemies.*;
import PadraoAbstractFactory.CONST_ABSTRACTFACTORY;
import PadraoAbstractFactory.GameFamiliesFactory;
import PadraoStrategy.Ataques.PadraoDecorator.Poder1;
import PadraoStrategy.Ataques.PadraoDecorator.Poder2;
import PadraoStrategy.Ataques.PadraoDecorator.Poder3;

public class AdvancedGame extends Game {
    // Fields //

    private static AdvancedGame instance = null;

    // Constructor //

    private AdvancedGame() {}

    // Methods //

    public static synchronized AdvancedGame getInstance() {
        if(instance == null)
            instance = new AdvancedGame();

        return instance;
    }

    @Override
    protected Enemies createInimigo(GameFamiliesFactory family, double tipo, int x, int y) {
        Enemies inimigo;

        if(tipo <= CONST_FACTORY.PSG_1) {
            inimigo = family.createEnemy(x, y, CONST_ABSTRACTFACTORY.ENEMY_TYPE1);
            inimigo.setAtaque(new Poder1(inimigo.getAtaque()));

        } else if(tipo <= CONST_FACTORY.PSG_2) {
            inimigo = family.createEnemy(x, y, CONST_ABSTRACTFACTORY.ENEMY_TYPE2);
            inimigo.setAtaque(new Poder1(inimigo.getAtaque()));

        } else if(tipo <= CONST_FACTORY.PSG_3) {
            inimigo = family.createEnemy(x, y, CONST_ABSTRACTFACTORY.ENEMY_TYPE3);
            inimigo.setAtaque(new Poder2(inimigo.getAtaque()));

        } else if(tipo <= CONST_FACTORY.PSG_4) {
            inimigo = family.createEnemy(x, y, CONST_ABSTRACTFACTORY.ENEMY_TYPE4);
            inimigo.setAtaque(new Poder2(inimigo.getAtaque()));

        } else {
            inimigo = family.createEnemy(x, y, CONST_ABSTRACTFACTORY.ENEMY_TYPE5);
            inimigo.setAtaque(new Poder3(inimigo.getAtaque()));
        }

        return inimigo;
    }
}
