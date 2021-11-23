package environment;

import java.util.ArrayList;

import util.Case;
import gameCommons.Game;

public class Lane {
	private Game game;
	private int ord;
	private int speed;
	private ArrayList<Car> cars = new ArrayList<>();
	private boolean leftToRight;
	private double density;

	// TODO : Constructeur(s)
	
	public Lane (Game game) {
		this.game = game;
		this.ord = ord;
		this.speed = speed;
		this.cars = cars;
		this.leftToRight = leftToRight;
		this.density = density;
	}

	public void update() {

		// TODO

		// Toutes les voitures se déplacent d'une case au bout d'un nombre "tic
		// d'horloge" égal à leur vitesse
		// Notez que cette méthode est appelée à chaque tic d'horloge

		// Les voitures doivent etre ajoutes a l interface graphique meme quand
		// elle ne bougent pas

		// A chaque tic d'horloge, une voiture peut être ajoutée

	}

	// TODO : ajout de methodes
	
	/**
	 * avoir la vitesse
	 */
	public int getSpeed() {
		return speed;
	}

	/**
	 * avoir la direction
	 */
	public boolean getDirection() {
		return leftToRight;
	}

	/**
	 * avoir la densite
	 */
	public int getDensity() {
		return density;
	}

	/*
	 * Fourni : mayAddCar(), getFirstCase() et getBeforeFirstCase() 
	 */

	/**
	 * Ajoute une voiture au début de la voie avec probabilité égale à la
	 * densité, si la première case de la voie est vide
	 */
	private void mayAddCar() {
		if (isSafe(getFirstCase()) && isSafe(getBeforeFirstCase())) {
			if (game.randomGen.nextDouble() < density) {
				cars.add(new Car(game, getBeforeFirstCase(), leftToRight));
			}
		}
	}

	private Case getFirstCase() {
		if (leftToRight) {
			return new Case(0, ord);
		} else
			return new Case(game.width - 1, ord);
	}

	private Case getBeforeFirstCase() {
		if (leftToRight) {
			return new Case(-1, ord);
		} else
			return new Case(game.width, ord);
	}

}
