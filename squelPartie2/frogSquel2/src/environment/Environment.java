package environment;

import gameCommons.Game;
import gameCommons.IEnvironment;
import givenEnvironment.Lane;
import util.Case;

import java.util.ArrayList;
import java.util.Iterator;

public abstract class Environment implements IEnvironment {
		
	//TODO

    public class Environment implements IEnvironment {
        private ArrayList<givenEnvironment.Lane> road;
        private Game game;

        public Environment(Game game) {
            this.game = game;
            this.road = new ArrayList();
            this.road.add(new givenEnvironment.Lane(game, 0, 0.0D));

            for(int i = 1; i < game.height - 1; ++i) {
                this.road.add(new Environment.Lane(game, i));
            }

            this.road.add(new Lane(game, game.height - 1, 0.0D));
        }

    @Override
    public boolean isSafe(Case c) {
        ((Lane)this.road.get(c.ord)).isSafe(c);
    }

    @Override
    public boolean isWinningPosition(Case c) {
        return c.ord == this.game.height - 1;
        }

    @Override
    public void update() {
        Iterator line = this.road.iterator();

        while(line.hasNext()) {
            Lane lane = (Lane)line.next();
            lane.update();
        }

    }
    }
}
