package pacman;

import java.util.Arrays;
import java.util.Random;

public class Maze {

	private Random random;
	private MazeMap map;
	private PacMan pacMan;
	private Ghost[] ghosts;
	private FoodItem[] fooditems;
	
	public MazeMap getMap() { return map; }
	
	public PacMan getPacMan() { return pacMan; }
	
	public Ghost[] getGhosts() { return ghosts.clone(); }
	
	public FoodItem[] getFoodItems() { return fooditems.clone(); }
	
	public Maze(Random random, MazeMap map, PacMan pacMan, Ghost[] ghosts, FoodItem[] fooditems) {
		this.random = random;
		this.map = map;
		this.pacMan = pacMan;
		this.ghosts = ghosts.clone();
		this.fooditems = fooditems.clone();
	}
	
	public boolean isCompleted() {
		return fooditems.length == 0;
	}
	
	private void checkPacManDamage() {
		for (Ghost ghost : ghosts)
			if (ghost.getSquare().equals(pacMan.getSquare()))
				pacMan.die();
	}
	
	public void moveGhosts() {
		for (Ghost ghost : ghosts)
			ghost.move(random);
		checkPacManDamage();
	}
	
	private void removeFoodItemAtIndex(int index) {
		FoodItem[] newFooditems = new FoodItem[fooditems.length - 1];
		System.arraycopy(fooditems, 0, newFooditems, 0, index);
		System.arraycopy(fooditems, index + 1, newFooditems, index, newFooditems.length - index);
		fooditems = newFooditems;
	}
	
	private void removeFoodItemAtSquare(Square square) {
		for (int i = 0; i < fooditems.length; i++) {
			if (fooditems[i].getSquare().equals(square)) {
				fooditems[i].eatenByPacman(this); // nieuw
				removeFoodItemAtIndex(i);
				return;
			}
		}
	}
	
	public void movePacMan(Direction direction) {
		Square newSquare = pacMan.getSquare().getNeighbor(direction);
		if (newSquare.isPassable()) {
			pacMan.setSquare(newSquare);
			removeFoodItemAtSquare(newSquare);
			checkPacManDamage();
		}
	}
	
}
