package PadraoAbstractFactory.Futurista;

import PadraoAbstractFactory.CONST_ABSTRACTFACTORY;
import PadraoStrategy.Ataques.Ataque;
import PadraoStrategy.Ataques.AtaqueForte;
import PadraoStrategy.Ataques.AtaqueFraco;
import PadraoStrategy.Ataques.AtaqueMedio;

public interface RaioParalisante {
    // Methods //

    public static Ataque getRaioParalisante(int tipo) {
        Ataque raioParalisante;

        if(tipo < CONST_ABSTRACTFACTORY.ATQ_TYPE1)
            tipo = CONST_ABSTRACTFACTORY.ATQ_TYPE1;

        else if(tipo > CONST_ABSTRACTFACTORY.ATQ_TYPE3)
            tipo = CONST_ABSTRACTFACTORY.ATQ_TYPE3;

        if(tipo == CONST_ABSTRACTFACTORY.ATQ_TYPE1)
            raioParalisante = AtaqueFraco.getInstance();

        else if(tipo == CONST_ABSTRACTFACTORY.ATQ_TYPE2)
            raioParalisante = AtaqueMedio.getInstance();

        else
            raioParalisante = AtaqueForte.getInstance();

        return raioParalisante;
    }
}
