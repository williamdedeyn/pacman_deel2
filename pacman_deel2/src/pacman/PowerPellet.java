package pacman;

/**
 * @invar | getSquare() != null
 * @invar | getSize() == 2
 *
 *@immutable
 */
public class PowerPellet extends FoodItem{
	
	/**
	 * @invar | square != null
	 * @invar | size == 2
	 */
	private Square square;
	private int size;
	
	/**
	 * @throws IllegalArgumentException | square == null
	 * 
	 * @post | getSquare() == square
	 */
	public PowerPellet(Square square) {
		if (square == null)
			throw new IllegalArgumentException("`square` is null");
		this.square = square; 
		size = 2;
	}
	
	/**
	 * @basic
	 */
	@Override
	public Square getSquare() {return square;}
	
	/**
	 * @basic
	 */
	@Override
	public int getSize() {return size;}
	
	@Override
	public void eatenByPacman(Maze maze) {
		Ghost ghosts[] = maze.getGhosts();
		for(Ghost ghost: ghosts) {
			if (!ghost.isVulnerable())
				ghost.pacManAtePowerPellet();
		}
	} // nieuw
}
