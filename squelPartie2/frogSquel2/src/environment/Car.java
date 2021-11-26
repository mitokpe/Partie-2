package environment;

import util.Case;
import gameCommons.Game;
import graphicalElements.Element;

import java.awt.*;

public class Car {
	private Game game;
	private Case leftPosition;
	private boolean leftToRight;
	private int length;
	private Color colorLtR = Color.BLACK;
	private Color colorRtL = Color.BLUE;

	//TODO Constructeur(s)
	
	public Car (Game game, Case firstCase, Boolean leftToRight, int length) {
		this.game = game;
		this.leftPosition = new Case(leftToRight ? firstCase.absc - this.length : firstCase.absc, firstCase.ord);
		this.leftToRight = leftToRight;
		this.length = length;
		this.colorLtR = Color.BLACK;
		this.colorRtL = Color.BLUE;
	}
	
	//TODO : ajout de methodes

	public void move(boolean b) {
		if (b) {
			this.leftPosition = new Case(leftToRight ? this.leftPosition.absc + 1 : this.leftPosition.absc + 1 , this.leftPosition.ord);
		}

		this.addToGraphics();
	}

	public boolean dansLaVoie () {
		return this.leftPosition.absc + this.length > 0 && this.leftPosition.absc < this.game.width;
	}

	public boolean verification (Case case1) {
		if (case1.ord != this.leftPosition.ord) {
			return false;
		} else {
			return case1.absc >= this.leftPosition.absc && case1.absc < this.leftPosition.absc + this.length;
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
					.add(new Element(leftPosition.absc + i, leftPosition.ord, color));
		}
	}

}
