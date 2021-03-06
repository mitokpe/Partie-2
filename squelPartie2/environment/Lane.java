package environment;

import java.util.ArrayList;

import util.Case;
import gameCommons.Game;
import java.util.Iterator;

public class Lane {
	private Game game;
	private int ord;
	private int speed;
	private ArrayList<Car> cars = new ArrayList<>();
	private boolean leftToRight;
	private double density;
	private int timer;

	// TODO : Constructeur(s)
	
	public Lane (Game game, int ord, double density) {
		this.game = game;
		this.ord = ord;
		this.speed = game.randomGen.nextInt(game.minSpeedInTimerLoops) + 1;;
		this.cars = new ArrayList<>();
		this.leftToRight = game.randomGen.nextBoolean();
		this.density = density;

		for(int i = 0; i < 4 * game.width; ++i) {
			this.moveCars(true);
			this.mayAddCar();
		}
	}

	public Lane (Game game, int ord) {
		this(game, ord, game.defaultDensity);
	}

	public void update() {

		// TODO
		++this.timer;
		if (this.timer <= this.speed) {
			this.moveCars(false);
		} else {
			this.moveCars(true);
			this.mayAddCar();
			this.timer = 0;
		}
	}
		// Toutes les voitures se déplacent d'une case au bout d'un nombre "tic
		// d'horloge" égal à leur vitesse
		// Notez que cette méthode est appelée à chaque tic d'horloge

		// Les voitures doivent etre ajoutes a l interface graphique meme quand
		// elle ne bougent pas

		// A chaque tic d'horloge, une voiture peut être ajoutée

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
	 * @return
	 */
	public double getDensity() {
		return density;
	}

	private void moveCars(boolean b) {
		for (Car car : this.cars) {
			car.move(b);
		}
	}

	/*
	 * Fourni : mayAddCar(), getFirstCase() et getBeforeFirstCase() 
	 */
	public boolean isSafe(Case c) {
		for (Car car : this.cars) {
			if (car.verification(c)) {
				return false;
			}
		}

		return true;
	}

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
