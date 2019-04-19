package marsrover;

import java.util.HashMap;

import marsrover.navigation.Direction;
import marsrover.navigation.Location;
import marsrover.navigation.Position;

public class Rover {

	Position position;

	private HashMap<String, Runnable> functionsMapper = new HashMap<>();

	public Rover(int x, int y, Direction direction) {

		this.position = new Position(new Location(x, y), direction);

		functionsMapper.put("Forward", () -> position.forward());
		functionsMapper.put("Left", () -> position.turnLeft());
		functionsMapper.put("Right", () -> position.turnRight());
		functionsMapper.put("Backwards", () -> position.backwards());

	}

	public void move(String[] commands) {

		for (String command : commands) {
			if (position.isObstacle()) {
				System.out.println("Obstacle in the next movement, aborting before hit it, current location: " + position.toString());
				break;
			}
			functionsMapper.get(command).run();
		}

	}

}
