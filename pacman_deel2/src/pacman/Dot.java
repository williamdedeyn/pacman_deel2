package pacman;

/**
 * Each instance of this class represents a dot, located at a fixed position in a Pac-Man maze.
 * A dot serves as the food for Pac-Man.
 * 
 * @invar | getSquare() != null
 * @invar | getSize() == 1
 * 
 * @immutable
 */
public class Dot extends FoodItem {
	
	/**
	 * @invar | square != null
	 * @invar | size == 1
	 */
	private Square square;
	private int size;
	
	/**
	 * @basic
	 */
	@Override
	public Square getSquare() { return square; }
	
	@Override
	public int getSize() {return size;}
	
	/**
	 * @throws IllegalArgumentException | square == null
	 * 
	 * @post | getSquare() == square
	 */
	public Dot(Square square) {
		if (square == null)
			throw new IllegalArgumentException("`square` is null");
		size = 1;
		this.square = square;
	}
	
	@Override
	public void eatenByPacman(Maze maze) {return;} // nieuw
	

}
