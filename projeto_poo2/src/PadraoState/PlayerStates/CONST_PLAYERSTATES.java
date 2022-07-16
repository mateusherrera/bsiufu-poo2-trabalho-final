package PadraoState.PlayerStates;

import Chars.Player.CONST_PLAYER;

public interface CONST_PLAYERSTATES {
    public static final int ATQ_DANO = CONST_PLAYER.LIFE_MAX / 25;

    public static final int LIM_MORTO  =   0;
    public static final int LIM_PERIGO =  30;
    public static final int LIM_NORMAL =  70;
}
