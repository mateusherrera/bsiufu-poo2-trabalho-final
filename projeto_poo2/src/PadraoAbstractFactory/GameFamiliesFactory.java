package PadraoAbstractFactory;

import Chars.Enemies.Enemies;
import Chars.Player.Player;
import PadraoChain.Shield;
import PadraoStrategy.Ataques.Ataque;

public abstract class GameFamiliesFactory {
    // Methods //

    public abstract Player createPlayer(int x, int y);
    public abstract Enemies createEnemy(int x, int y, int tipo);
    public abstract Shield createDefesa(int tipo);
    public abstract Ataque createArma(int tipo);
}
