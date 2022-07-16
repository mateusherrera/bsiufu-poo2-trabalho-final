package PadraoState.EnemiesStates;

import Chars.Enemies.Enemies;

public class InimigoMorto extends EnemiesState {
    // Fields //

    private static InimigoMorto instance = null;

    // Constructor //

    private InimigoMorto() {}

    // Methods //

    public static synchronized InimigoMorto getInstance() {
        if(instance == null)
            instance = new InimigoMorto();

        return instance;
    }

    @Override
    public void updateEstado(Enemies inimigo) {
    }
}
