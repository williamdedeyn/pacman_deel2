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
	
	/**
	 * @basic
	 */
	@Override
	public int getSize() {return size;}
	
	/**
	 * @throws IllegalArgumentException | square == null
	 * 
	 * @post | getSquare() == square
	 * @post | getSize() == 1
	 */
	public Dot(Square square) {
		if (square == null)
			throw new IllegalArgumentException("`square` is null");
		this.square = square;
		size = 1;
	}
	
	@Override
	public void eatenByPacman(Maze maze) {return;} // nieuw
	

}
