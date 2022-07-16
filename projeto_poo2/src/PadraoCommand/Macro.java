package PadraoCommand;

import java.util.ArrayList;

public class Macro extends Comando {
    // Fields

    private ArrayList<Comando> macro = new ArrayList<Comando>();

    // Methods

    public void addComando(Comando comando) {
        macro.add(comando);
    }

    public void execute() {
        for(Comando comando : macro)
            comando.execute();
    }
}
