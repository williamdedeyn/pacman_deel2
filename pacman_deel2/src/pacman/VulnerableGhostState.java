package pacman;

import java.util.Random;

public class VulnerableGhostState extends GhostState {
	
	private int counter = 0;
	public GhostState move(Ghost ghost, Random random) {
		while(counter < 6) {
		if(ghost.getMoveDelay() == 1) {
			ghost.decrementMoveDelay();
			return ghost.getGhostState();}
		else {
			ghost.reallyMove(random);
			counter++;
			ghost.incrementMoveDelay();
			return ghost.getGhostState();}}
		ghost.setGhostState(new RegularGhostState());
		return ghost.getGhostState();
		}
	
	public GhostState hitBy(Ghost ghost, PacMan pacman) {
		ghost.setGhostState(new RegularGhostState());
		ghost.setSquare(ghost.getSpawn());
		return ghost.getGhostState();
	}
}
