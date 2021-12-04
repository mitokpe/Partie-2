package environment;

import gameCommons.Game;
import gameCommons.IFrog;
import util.Case;
import util.Direction;

public class FrogInf implements IFrog {

    private Game game;
    private Direction direction;
    private Case cases;

    public FrogInf(Game game){
        this.game = game;
        this.direction = Direction.up;
        this.cases = new Case (this.game.width / 2,  0);
    }

    public Case getPosition() { return this.cases; }

    public Direction getDirection() { return this.direction; }




    public void move(Direction key) {
        switch (key) {
        case up:
            this.position = new Case(this.position.absc, this.position.ord + 1);
            this.direction = Direction.up;
            this.game.scoreMin++;
            this.game.setScore();
            break;
            case down:
                this.position = new Case(this.position.absc, this.position.ord - 1);
                this.direction = Direction.down;
                this.game.scoreMin--;
                this.game.setScore();
                break;
            case left:
                this.position = new Case(this.position.absc - 1, this.position.ord);
                this.direction = Direction.left;
                break;
            case right:
                this.position = new Case(this.position.absc + 1, this.position.ord);
                this.direction = Direction.right;
                break;
        }
}
