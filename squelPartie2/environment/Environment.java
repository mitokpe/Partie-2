package environment;

import gameCommons.Game;
import gameCommons.IEnvironment;
import util.Case;

import java.util.ArrayList;

public class Environment implements IEnvironment {

    private final Game game;
    private final ArrayList<Lane> road;

    public Environment(Game game) {
        this.game = game;
        this.road = new ArrayList<>();
        this.road.add(new Lane(game, 0, 0.0));

        for (int i = 1; i < game.height - 1; ++i) {
            this.road.add(new Lane(game, i));
        }

        this.road.add(new Lane(game, game.height - 1, 0.0));
    }

    @Override
    public boolean isSafe(Case c) {
        return this.road.get(c.ord).isSafe(c);
    }

    @Override
    public boolean isWinningPosition(Case c) {
        return c.ord == this.game.height - 1;
    }

    @Override
    public void update() {
        for (Lane lane : this.road) {
            lane.update();
        }
    }

}
