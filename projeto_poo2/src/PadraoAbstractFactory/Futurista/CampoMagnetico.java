package PadraoAbstractFactory.Futurista;

import PadraoAbstractFactory.CONST_ABSTRACTFACTORY;
import PadraoChain.Shield;
import PadraoChain.ShieldForte;
import PadraoChain.ShieldFraco;
import PadraoChain.ShieldMedio;

public interface CampoMagnetico {
    // Methods //

    public static Shield getCampoMagnetico(int tipo) {
        Shield campoMagnetico;

        if(tipo < CONST_ABSTRACTFACTORY.SHD_TYPE1)
            tipo = CONST_ABSTRACTFACTORY.SHD_TYPE1;

        else if(tipo > CONST_ABSTRACTFACTORY.SHD_TYPE3)
            tipo = CONST_ABSTRACTFACTORY.ATQ_TYPE3;

        if(tipo == CONST_ABSTRACTFACTORY.SHD_TYPE1)
            campoMagnetico = new ShieldFraco();

        else if(tipo == CONST_ABSTRACTFACTORY.SHD_TYPE2)
            campoMagnetico = new ShieldMedio();

        else
            campoMagnetico = new ShieldForte();

        return campoMagnetico;
    }
}
