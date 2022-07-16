package PadraoState.EnemiesStates;

import Chars.Enemies.CONST_ENEMIES;
import Chars.Enemies.Enemies;

public abstract class EnemiesState {
    // Methods //

    public abstract void updateEstado(Enemies inimigo);

    public void levarDano(Enemies inimigo, int dano) {
        int dano_abs = Math.abs(dano);
        inimigo.setLife(inimigo.getLife() - dano_abs);

        // O update está sendo chamado no setLife do inimigo
        // updateEstado(inimigo);
    }

    public void curarVida(Enemies inimigo, int cura) {
        int cura_abs = Math.abs(cura);
        inimigo.setLife(inimigo.getLife() + cura_abs);

        // O update está sendo chamado no setLife do inimigo
        // updateEstado(inimigo);
    }
}
