package PadraoAbstractFactory.Futurista;

import Chars.Enemies.*;
import Chars.Player.Player;
import PadraoAbstractFactory.CONST_ABSTRACTFACTORY;

public interface Robo {
    // Methods //

    public static Player getRoboPlayer(int x, int y) {
        return new Player(x, y);
    }

    public static Enemies getRoboEnemy(int x, int y, int tipo) {
        Enemies robo;

        if(tipo < CONST_ABSTRACTFACTORY.ENEMY_TYPE1)
            tipo = CONST_ABSTRACTFACTORY.ENEMY_TYPE1;

        else if(tipo > CONST_ABSTRACTFACTORY.ENEMY_TYPE5)
            tipo = CONST_ABSTRACTFACTORY.ENEMY_TYPE5;

        if(tipo == CONST_ABSTRACTFACTORY.ENEMY_TYPE1)
            robo = new Enemy1(x, y);

        else if(tipo == CONST_ABSTRACTFACTORY.ENEMY_TYPE2)
            robo = new Enemy2(x, y);

        else if(tipo == CONST_ABSTRACTFACTORY.ENEMY_TYPE3)
            robo = new Enemy3(x, y);

        else if(tipo == CONST_ABSTRACTFACTORY.ENEMY_TYPE4)
            robo = new Enemy4(x, y);

        else
            robo = new Enemy5(x, y);

        return robo;
    }
}
