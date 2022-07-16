package PadraoChain;

import PadraoState.PlayerStates.CONST_PLAYERSTATES;
import PadraoStrategy.Ataques.CONST_ATAQUES;

public interface CONST_ESCUDO {
    public static final int DEFESA_ESCUDO_FRACO = (int) Math.round(CONST_ATAQUES.ATQ_FRACO * CONST_PLAYERSTATES.ATQ_DANO
            * 0.2);
    public static final int DEFESA_ESCUDO_MEDIO = (int) Math.round(CONST_ATAQUES.ATQ_MEDIO * CONST_PLAYERSTATES.ATQ_DANO
            * 0.2);
    public static final int DEFESA_ESCUDO_FORTE = (int) Math.round(CONST_ATAQUES.ATQ_FORTE * CONST_PLAYERSTATES.ATQ_DANO
            * 0.2);
    public static final int DEFESA_ESCUDO_ENEMY = 1;
}
