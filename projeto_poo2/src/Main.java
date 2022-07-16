import Game.CONST_GAME;
import PadraoComposite.Fase;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Fase fase1, fase2, fase3, fase4, fase5, fase6, fase7, atual;
        double complexidade = Math.random();
        double periodo = Math.random();
        Scanner lerInteiro = new Scanner(System.in);
        int opcao;

        fase7 = new Fase("Fase 7 - Difícil", null, null, CONST_GAME.VVELOZ, CONST_GAME.DIFICIL);
        fase6 = new Fase("Fase 6 - Médio", null, null, CONST_GAME.VMEDIO, CONST_GAME.MEDIO);
        fase5 = new Fase("Fase 5 - Médio", fase6, fase7, CONST_GAME.VMEDIO, CONST_GAME.MEDIO);
        fase4 = new Fase("Fase 4 - Fácil", null, null, CONST_GAME.VLENTO, CONST_GAME.FACIL);
        fase3 = new Fase("Fase 3 - Fácil", fase4, fase5, CONST_GAME.VLENTO, CONST_GAME.FACIL);
        fase2 = new Fase("Fase 2 - Difícil", null, null, CONST_GAME.VVELOZ, CONST_GAME.DIFICIL);
        fase1 = new Fase("Fase 1 - Fácil", fase2, fase3, CONST_GAME.VLENTO, CONST_GAME.FACIL);
        atual = fase1;

        do {
            atual.jogarFase(complexidade, periodo);

            if(atual.getDir() == null || atual.getEsq() == null)
                break;

             System.out.println("Vocẽ passou de fase!!");
            System.out.println("Deseja seguir a esquerda 1 (" + atual.getEsq().getNome() +
                    ") ou a direita 2 (" + atual.getDir().getNome() + ")?");
            opcao = lerInteiro.nextInt();
            atual = atual.Escolha(opcao);
        } while(atual != null);

        System.out.println("Você conseguiu!!!");
    }
}