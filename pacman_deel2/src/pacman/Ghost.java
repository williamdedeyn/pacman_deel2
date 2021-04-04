package pacman;

import java.util.Random;

/**
 * Each instance of this class represents a ghost in a Pac-Man maze,
 * located at a particular position and moving in a particular direction.
 * 
 * @invar | getSquare() != null
 * @invar | getDirection() != null
 */
public class Ghost {
	
	/**
	 * @invar | spawn != null
	 * @invar | square != null
	 * @invar | direction != null
	 */
	private int moveDelay;
	private Square spawn;
	private Square square;
	private Direction direction;
	private GhostState ghoststate;

	/**
	 * @basic
	 */
	public Square getSquare() { return square; }

	/**
	 * @basic
	 */
	public Direction getDirection() { return direction; }
	
	/**
	 * @basic
	 */
	public GhostState getGhostState() {return ghoststate;} // nieuw
	
	/**
	 * @basic
	 */
	public Square getSpawn() {return spawn;} // nieuw
	
	public int getMoveDelay() {return moveDelay;}
	
	public void decrementMoveDelay() {this.moveDelay = 0;}
	public void incrementMoveDelay() {this.moveDelay = 1;}
	
	/**
	 * Initializes this object so that its initial position is the
	 * given position and its initial direction is the given
	 * direction.
	 * 
	 * @throws IllegalArgumentException | square == null
	 * @throws IllegalArgumentException | direction == null
	 * 
	 * @post | getSquare() == square
	 * @post | getDirection() == direction
	 */
	public Ghost(Square square, Direction direction) {
		if (square == null)
			throw new IllegalArgumentException("`square` is null");
		if (direction == null)
			throw new IllegalArgumentException("`direction` is null");
		this.moveDelay = 0;
		this.spawn = square; // nieuw
		this.square = square;
		this.direction = direction;
		this.ghoststate = new RegularGhostState(); // nieuw
	}
	
	/**
	 * Sets this ghost's position.
	 * 
	 * @throws IllegalArgumentException | square == null
	 * 
	 * @mutates | this
	 * 
	 * @post | getSquare() == square
	 * @post | getDirection() == old(getDirection())
	 */
	public void setSquare(Square square) {
		if (square == null)
			throw new IllegalArgumentException("`square` is null");
		
		this.square = square;
	}
	
	/**
	 * Sets this ghost's direction.
	 * 
	 * @throws IllegalArgumentException | direction == null
	 * 
	 * @mutates | this
	 * 
	 * @post | getDirection() == direction
	 * @post | getSquare() == old(getSquare())
	 */
	public void setDirection(Direction direction) {
		if (direction == null)
			throw new IllegalArgumentException("`direction` is null");

		this.direction = direction;
	}
	
	public void setGhostState(GhostState ghoststate) {this.ghoststate = ghoststate;}
	
	public boolean isVulnerable(){
		if(getGhostState() instanceof VulnerableGhostState) // nieuw
			return true;
		return false;
	}
	
	public void pacManAtePowerPellet() {
		setDirection(getDirection().getOpposite()); // nieuw
		this.ghoststate = new VulnerableGhostState();
		this.incrementMoveDelay();
	}
	
	private static int MOVE_FORWARD_PREFERENCE = 10;
	
	// No formal documentation required.
	public Direction chooseNextMoveDirection(Random random) {
		int moveForwardPreference = getSquare().canMove(direction) ? MOVE_FORWARD_PREFERENCE : 0;
		Direction[] passableDirections = getSquare().getPassableDirectionsExcept(getDirection().getOpposite());
		if (passableDirections.length == 0)
			return getDirection().getOpposite();
		int result = random.nextInt(moveForwardPreference + passableDirections.length);
		if (result < moveForwardPreference)
			return getDirection();
		return passableDirections[result - moveForwardPreference];
	}
	
	// No formal documentation required.
	public void reallyMove(Random random) {
		setDirection(chooseNextMoveDirection(random));
		setSquare(getSquare().getNeighbor(getDirection()));
	}
	
	public void move(Random random ) {
		setGhostState(getGhostState().move(this, random));
	}
	
	public void hitBy(PacMan pacman) {
		setGhostState(getGhostState().hitBy(this, pacman));
	}
	
}
