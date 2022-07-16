package PadraoAbstractFactory.Medieval;

import PadraoAbstractFactory.CONST_ABSTRACTFACTORY;
import PadraoChain.Shield;
import PadraoChain.ShieldForte;
import PadraoChain.ShieldFraco;
import PadraoChain.ShieldMedio;

public interface Escudo {
    // Methods //

    public static Shield getEscudo(int tipo) {
        Shield escudo;

        if(tipo < CONST_ABSTRACTFACTORY.SHD_TYPE1)
            tipo = CONST_ABSTRACTFACTORY.SHD_TYPE1;

        else if(tipo > CONST_ABSTRACTFACTORY.SHD_TYPE3)
            tipo = CONST_ABSTRACTFACTORY.ATQ_TYPE3;

        if(tipo == CONST_ABSTRACTFACTORY.SHD_TYPE1)
            escudo = new ShieldFraco();

        else if(tipo == CONST_ABSTRACTFACTORY.SHD_TYPE2)
            escudo = new ShieldMedio();

        else
            escudo = new ShieldForte();

        return escudo;
    }
}
