package environment;

import java.awt.*;
import java.util.ArrayList;

import graphicalElements.Element;
import util.Case;
import gameCommons.Game;
import gameCommons.IEnvironment;

public abstract class Environment implements IEnvironment {
		
	//TODO

    @Override
    public boolean isSafe(Case c) {
        return false;
    }

    @Override
    public boolean isWinningPosition(Case c) {
        return false;
    }

    @Override
    public void update() {

    }
    }
}
