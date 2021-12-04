package frog;

import gameCommons.*;
import util.*;

public class Frog implements IFrog {
	
	private Game game;
	private Direction direction;
	private Case cases;

	public Frog(Game game){
		this.game = game;
		this.direction = Direction.up;
		this.cases = new Case (this.game.width / 2,  0);
	}

	public Case getPosition() { return this.cases; }

	public Direction getDirection() { return this.direction; }

	public void move(Direction key) {
		this.direction = key;

		if (key == Direction.up && this.cases.ord + 1 < this.game.height) {
			this.cases = new Case (this.cases.abs,  this.cases.ord + 1);
		}

		if (key == Direction.down && this.cases.ord  > 0) {
			this.cases = new Case (this.cases.abs, this.cases.ord - 1);
		}

		if (key == Direction.left && this.cases.abs > 0) {
			this.cases = new Case (this.cases.abs - 1, this.cases.ord);
		}

		if (key == Direction.right && this.cases.abs + 1 < this.game.width) {
			this.cases = new Case (this.cases.abs + 1, this.cases.ord);
		}

		this.game.testLose();
		this.game.testWin();
	}


}
