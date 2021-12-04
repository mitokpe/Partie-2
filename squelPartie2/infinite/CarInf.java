package infinite;

import gameCommons.Game;
import graphicalElements.Element;
import util.Case;

import java.awt.*;

public class CarInf {
    public class Car {
        private Game game;
        private Case leftPosition;
        private boolean leftToRight;
        private int length;
        private Color colorLtR = Color.BLACK;
        private Color colorRtL = Color.BLUE;

        //TODO Constructeur(s)

        public Car(Game game, Case firstCase, Boolean leftToRight) {
            this.game = game;
            this.leftPosition = new Case(leftToRight ? firstCase.abs - this.length : firstCase.abs, firstCase.ord);
            this.leftToRight = leftToRight;
            this.length = length;
            this.colorLtR = Color.BLACK;
            this.colorRtL = Color.BLUE;
        }

        //TODO : ajout de methodes

        public void move(boolean b) {
            if (b) {
                this.leftPosition = new Case(leftToRight ? this.leftPosition.abs + 1 : this.leftPosition.abs + 1 , this.leftPosition.ord);
            }

            this.addToGraphics();
        }

        public boolean dansLaVoie () {
            return this.leftPosition.abs + this.length > 0 && this.leftPosition.abs < this.game.width;
        }

        public boolean verification (Case case1) {
            if (case1.ord != this.leftPosition.ord) {
                return false;
            } else {
                return case1.abs >= this.leftPosition.abs && case1.abs < this.leftPosition.abs + this.length;
            }
        }

        /* Fourni : addToGraphics() permettant d'ajouter un element graphique correspondant a la voiture*/
        private void addToGraphics() {
            for (int i = 0; i < length; i++) {
                Color color = colorRtL;
                if (this.leftToRight){
                    color = colorLtR;
                }
                game.getGraphic()
                        .add(new Element(leftPosition.abs + i, leftPosition.ord, color));
            }
        }

    }

}
