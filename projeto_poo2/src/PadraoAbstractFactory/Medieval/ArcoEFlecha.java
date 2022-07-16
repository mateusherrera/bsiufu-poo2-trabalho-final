package PadraoAbstractFactory.Medieval;

import PadraoAbstractFactory.CONST_ABSTRACTFACTORY;
import PadraoStrategy.Ataques.Ataque;
import PadraoStrategy.Ataques.AtaqueForte;
import PadraoStrategy.Ataques.AtaqueFraco;
import PadraoStrategy.Ataques.AtaqueMedio;

public interface ArcoEFlecha {
    // Methods //

    public static Ataque getArcoEFlecha(int tipo) {
        Ataque arcoEFlecha;

        if(tipo < CONST_ABSTRACTFACTORY.ATQ_TYPE1)
            tipo = CONST_ABSTRACTFACTORY.ATQ_TYPE1;

        else if(tipo > CONST_ABSTRACTFACTORY.ATQ_TYPE3)
            tipo = CONST_ABSTRACTFACTORY.ATQ_TYPE3;

        if(tipo == CONST_ABSTRACTFACTORY.ATQ_TYPE1)
            arcoEFlecha = AtaqueFraco.getInstance();

        else if(tipo == CONST_ABSTRACTFACTORY.ATQ_TYPE2)
            arcoEFlecha = AtaqueMedio.getInstance();

        else
            arcoEFlecha = AtaqueForte.getInstance();

        return arcoEFlecha;
    }
}
