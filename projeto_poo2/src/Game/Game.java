package Game;

import Chars.Enemies.Enemies;
import Chars.Player.Player;
import Game.Coordenadas.CONST_COORD;
import PadraoAbstractFactory.CONST_ABSTRACTFACTORY;
import PadraoAbstractFactory.FuturistaFactory;
import PadraoAbstractFactory.GameFamiliesFactory;
import PadraoAbstractFactory.MedievalFactory;
import PadraoCommand.*;
import PadraoStrategy.Ataques.PadraoDecorator.Poder2;
import PadraoStrategy.Corridas.CorridaLenta;
import PadraoStrategy.Corridas.CorridaMedia;
import PadraoStrategy.Corridas.CorridaVeloz;
import PadraoStrategy.Pulos.PuloAlto;
import PadraoStrategy.Pulos.PuloBaixo;
import PadraoStrategy.Pulos.PuloMedio;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

public abstract class Game extends JPanel {
    // Fields //

    private Player player;
    private ArrayList<Enemies> inimigos;
    private int dificuldade;
    private GameFamiliesFactory family;
    private Controle controle;

    // Constructor //

    public Game() {
        KeyListener listener = new MyKeyListener();
        addKeyListener(listener);
        setFocusable(true);
        controle = new Controle();
    }

    // MyKeyListener class //

    public class MyKeyListener implements KeyListener {
        @Override
        public void keyTyped(KeyEvent keyEvent) {
        }

        @Override
        public void keyReleased(KeyEvent keyEvent) {
        }

        private boolean estaPerto(Player player, Enemies inimigo) {
            return Math.abs(player.getX() - inimigo.getX()) <= 10 &&
                    Math.abs(player.getY() - inimigo.getY()) <= 10;
        }

        @Override
        public void keyPressed(KeyEvent keyEvent) {
            if (keyEvent.getKeyCode() == KeyEvent.VK_UP)
                controle.pressionar(0);

            if (keyEvent.getKeyCode() == KeyEvent.VK_DOWN)
                controle.pressionar(1);

            if (keyEvent.getKeyCode() == KeyEvent.VK_LEFT)
                controle.pressionar(2);

            if (keyEvent.getKeyCode() == KeyEvent.VK_RIGHT)
                controle.pressionar(3);

            if(keyEvent.getKeyCode() == KeyEvent.VK_A)
                controle.pressionar(4);

            if(keyEvent.getKeyCode() == KeyEvent.VK_D)
                controle.pressionar(5);

            if(keyEvent.getKeyCode() == KeyEvent.VK_S)
                controle.pressionar(6);

            if(keyEvent.getKeyCode() == KeyEvent.VK_W)
                controle.pressionar(7);

            if (keyEvent.getKeyCode() == KeyEvent.VK_SPACE) {
                for(int i = 0; i < dificuldade; ++i) {
                    if(estaPerto(player, inimigos.get(i))) {
                        if(!inimigos.get(i).isDead()) {
                            controle.pressionar(i + 8);

                            if(inimigos.get(i).isDead() ) {
                                player.deleteObserver(inimigos.get(i));

                                if(i == 0)
                                    player.addNovoEscudo(family.createDefesa(CONST_ABSTRACTFACTORY.SHD_TYPE1));

                                else if(i == 1)
                                    player.addNovoEscudo(family.createDefesa(CONST_ABSTRACTFACTORY.SHD_TYPE2));

                                else
                                    player.addNovoEscudo(family.createDefesa(CONST_ABSTRACTFACTORY.SHD_TYPE3));

                                player.setAtaque(new Poder2(player.getAtaque()));
                            }
                        }
                    }
                }
            }
        }
    }

    // Methods //

    @Override
    public void paint(Graphics g) {
        super.paint(g);

        Graphics2D g2d = (Graphics2D) g;
        String life_player = "Player Life: " + player.getLife() + " (" + player.getLifePerc() + "%).";

        g2d.setColor(Color.WHITE);
        g2d.drawString(life_player, CONST_COORD.MAX_X - 150, CONST_COORD.MIN_Y + 20);
        g2d.fillOval(player.getX(), player.getY(), 20, 20);

        ArrayList<Color> colors = new ArrayList<Color>();
        colors.add(Color.RED);
        colors.add(Color.GREEN);
        colors.add(Color.BLUE);

        for(int i = 0; i < dificuldade; ++i) {
            g2d.setColor(colors.get(i));
            g2d.drawString(inimigos.get(i).getLife() + " hits de vida.",
                    inimigos.get(i).getX(), inimigos.get(i).getY());
            g2d.fillOval(inimigos.get(i).getX(), inimigos.get(i).getY(), 20, 20);
        }
    }

    protected abstract Enemies createInimigo(GameFamiliesFactory family, double tipo, int x, int y);

    private void atualizaVelocidade(Enemies inimigo, int vel) {
        if(vel == CONST_GAME.VLENTO) {
            inimigo.setCorrida(CorridaLenta.getInstance());
            inimigo.setPulo(PuloBaixo.getInstance());

        } else if(vel == CONST_GAME.VMEDIO) {
            inimigo.setCorrida(CorridaMedia.getInstance());
            inimigo.setPulo(PuloMedio.getInstance());

        } else {
            inimigo.setCorrida(CorridaVeloz.getInstance());
            inimigo.setPulo(PuloAlto.getInstance());
        }
    }

    public void jogar(Game game, int gameFamily, int dif, int vel, String nome) throws InterruptedException {
        JFrame frame = new JFrame(nome);

        ImageIcon background = new ImageIcon("background.jpg");
        JLabel label = new JLabel();
        label.setBounds(CONST_COORD.MIN_X, CONST_COORD.MIN_Y, CONST_COORD.MAX_X, CONST_COORD.MAX_Y);
        label.setIcon(background);

        game.setLayout(null);
        game.add(label);

        frame.add(game);
        frame.setSize(CONST_COORD.MAX_X, CONST_COORD.MAX_Y);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        if(gameFamily <= CONST_GAME.FUTIRISTA)
            family = FuturistaFactory.getInstance();
        else
            family = MedievalFactory.getInstance();

        dificuldade = dif;
        if(dificuldade < CONST_GAME.FACIL)
            dificuldade = CONST_GAME.FACIL;

        else if(dificuldade > CONST_GAME.DIFICIL)
            dificuldade = CONST_GAME.DIFICIL;

        if(vel < CONST_GAME.VLENTO)
            vel = CONST_GAME.VLENTO;

        else if(vel > CONST_GAME.VVELOZ)
            vel = CONST_GAME.VVELOZ;

        player = family.createPlayer(500, 250);

        inimigos = new ArrayList<Enemies>();
        int[] posicoesx = new int[3];
        int[] posicoesy = new int[3];

        posicoesx[0] = 700;
        posicoesy[0] = 250;

        posicoesx[1] = 300;
        posicoesy[1] = 250;

        posicoesx[2] = 500;
        posicoesy[2] = 50;

        for(int i = 0; i < dificuldade; ++i) {
            inimigos.add(this.createInimigo(family, Math.random(), posicoesx[i], posicoesy[i]));
            atualizaVelocidade(inimigos.get(i), vel);
            player.addObserver(inimigos.get(i));
        }

        controle.setComando(new MoverCima(player), 0);
        controle.setComando(new MoverBaixo(player), 1);
        controle.setComando(new MoverEsquerda(player), 2);
        controle.setComando(new MoverDireita(player), 3);

        Macro macro = new Macro();
        macro.addComando(new MoverEsquerda(player));
        macro.addComando(new MoverEsquerda(player));
        macro.addComando(new MoverEsquerda(player));
        controle.setComando(macro, 4);

        macro = new Macro();
        macro.addComando(new MoverDireita(player));
        macro.addComando(new MoverDireita(player));
        macro.addComando(new MoverDireita(player));
        controle.setComando(macro, 5);

        macro = new Macro();
        macro.addComando(new MoverBaixo(player));
        macro.addComando(new MoverBaixo(player));
        macro.addComando(new MoverBaixo(player));
        controle.setComando(macro, 6);

        macro = new Macro();
        macro.addComando(new MoverCima(player));
        macro.addComando(new MoverCima(player));
        macro.addComando(new MoverCima(player));
        controle.setComando(macro, 7);

        for(int i = 0; i < dificuldade; ++i)
            controle.setComando(new Atacar(player, inimigos.get(i)), i + 8);

        while(player.getLife() != 0 && player.countObservers() != 0) {
            player.show();
            game.repaint();
            Thread.sleep(50);
        }

        if(player.getLife() == 0)
            System.exit(0);
        else
            frame.dispose();
    }
}