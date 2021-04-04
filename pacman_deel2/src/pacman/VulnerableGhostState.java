package pacman;

import java.util.Random;

public class VulnerableGhostState extends GhostState {

	public GhostState move(Ghost ghost, Random random) {
		int i = 0;
		while ( i!=6000) {
		if(i%2000 == 0)
			ghost.reallyMove(random);
		i++;
	}
		return new RegularGhostState();
	}
	
	public GhostState hitBy(Ghost ghost, PacMan pacman) {
		ghost.setGhostState(new RegularGhostState());
		ghost.setSquare(ghost.getSpawn());
		return ghost.getGhostState();
	}
}
