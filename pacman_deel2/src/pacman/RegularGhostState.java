package pacman;

import java.util.Random;

public class RegularGhostState extends GhostState {

	public GhostState move(Ghost ghost, Random random) {
		ghost.reallyMove(random);
		return ghost.getGhostState();
	}
	
	public GhostState hitBy(Ghost ghost, PacMan pacman) {
		pacman.die();
		return ghost.getGhostState();
	}
	
}

