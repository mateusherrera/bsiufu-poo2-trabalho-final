package PadraoAbstractFactory.Medieval;

import Chars.Enemies.*;
import Chars.Player.Player;
import PadraoAbstractFactory.CONST_ABSTRACTFACTORY;

public interface Arqueiro {
    // Methods //

    public static Player getArqueiroPlayer(int x, int y) {
        return new Player(x, y);
    }

    public static Enemies getArqueiroEnemy(int x, int y, int tipo) {
        Enemies arqueiro;

        if(tipo < CONST_ABSTRACTFACTORY.ENEMY_TYPE1)
            tipo = CONST_ABSTRACTFACTORY.ENEMY_TYPE1;

        else if(tipo > CONST_ABSTRACTFACTORY.ENEMY_TYPE5)
            tipo = CONST_ABSTRACTFACTORY.ENEMY_TYPE5;

        if(tipo == CONST_ABSTRACTFACTORY.ENEMY_TYPE1)
            arqueiro = new Enemy1(x, y);

        else if(tipo == CONST_ABSTRACTFACTORY.ENEMY_TYPE2)
            arqueiro = new Enemy2(x, y);

        else if(tipo == CONST_ABSTRACTFACTORY.ENEMY_TYPE3)
            arqueiro = new Enemy3(x, y);

        else if(tipo == CONST_ABSTRACTFACTORY.ENEMY_TYPE4)
            arqueiro = new Enemy4(x, y);

        else
            arqueiro = new Enemy5(x, y);

        return arqueiro;
    }
}
