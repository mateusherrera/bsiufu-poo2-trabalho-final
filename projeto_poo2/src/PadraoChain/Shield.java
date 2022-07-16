package PadraoChain;

public abstract class Shield {
    // Fields //

    private Shield nxShield;

    // Getters & Setters //

    public Shield getNxEscudo() {
        return nxShield;
    }

    public void setNxEscudo(Shield nxShield) {
        this.nxShield = nxShield;
    }

    // Methods //

    public abstract int reduzDano(int dano);
}
