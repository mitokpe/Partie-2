import environment.Environment;
import frog.Frog;
import gameCommons.Game;
import gameCommons.IEnvironment;
import gameCommons.IFrog;
import graphicalElements.FroggerGraphic;
import graphicalElements.IFroggerGraphics;

import javax.swing.*;

public class Main {

    public static void main(String[] args) {
        // Game parameters
        int width = 26;
        int height = 20;
        int tempo = 100;
        int minSpeedInTimerLoops = 3;
        double defaultDensity = 0.2;

        // Initializing graphics
        IFroggerGraphics graphic = new FroggerGraphic(width, height);

        // Initializing game
        Game game = new Game(graphic, width, height, minSpeedInTimerLoops, defaultDensity);

        // Linking frog
        IFrog frog = new Frog(game);

        game.setFrog(frog);
        graphic.setFrog(frog);

        // Linking environment
        IEnvironment env = new Environment(game);

        game.setEnvironment(env);

        // Main loop refreshing every "tempo" (in milliseconds)
        Timer timer = new Timer(tempo, e -> {
            game.update();
            graphic.repaint();
        });

        timer.setInitialDelay(0);
        timer.start();
    }

}
