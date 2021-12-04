package infinite;

import gameCommons.Game;
import gameCommons.IEnvironment;
import givenEnvironment.Lane;

import java.util.ArrayList;

public abstract class EnvironmentInf implements IEnvironment {

    private ArrayList<LaneInf> road;
    private Game game;

    public EnvironmentInf(Game game) {
        this.game = game;
        this.road = new ArrayList();

        //Depart
        this.road.add(new LaneInf(this.game, 0, 0.0));
        this.road.add(new LaneInf(this.game, 1, 0.0));

        //Les voies infinies
        for (int i = 2; i < this.game.height; i++) {
            this.road.add(new LaneInf(game, i));
        }
    }

}
