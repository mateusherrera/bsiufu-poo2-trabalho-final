package PadraoChain;

public class ShieldForte extends Shield {
    // Methods //

    @Override
    public int reduzDano(int dano) {
        int novo_dano = dano - CONST_ESCUDO.DEFESA_ESCUDO_FORTE;

        if(novo_dano <= 0)
            return 0;

        else if(this.getNxEscudo() != null)
            return this.getNxEscudo().reduzDano(novo_dano);

        else
            return novo_dano;
    }
}
