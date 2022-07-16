package PadraoCommand;

public class Controle {
    // Fields

    private Comando[] comandos = new Comando[50];

    // Methods

    public void setComando(Comando comando, int i) {
        this.comandos[i] = comando;
    }

    public void pressionar(int i) {
        executa(comandos[i]);
    }

    private void executa(Comando comando) {
        comando.execute();
    }
}
