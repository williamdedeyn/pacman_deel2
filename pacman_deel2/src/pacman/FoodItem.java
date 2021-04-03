package pacman;

public abstract class FoodItem {

	public abstract Square getSquare();
	
	public abstract int getSize();
	
	public abstract void eatenByPacman(Maze maze);
}
