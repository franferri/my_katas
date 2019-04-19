package marsrover.navigation;

public class Position {

	private Location location;
	private Direction direction;

	public Position(Location location, Direction direction) {
		this.location = location;
		this.direction = direction;
	}

	public boolean isObstacle() {
		return location.obstacle;
	}
	
	public void forward() {
		direction.forward(location);
	}

	public void backwards() {
		direction.backwards(location);
	}

	public void turnRight() {
		direction = direction.turnRight();
	}

	public void turnLeft() {
		direction = direction.turnLeft();
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(location.x);
		sb.append(",");
		sb.append(location.y);
		sb.append(",");
		sb.append(direction.getClass().getSimpleName());
		return sb.toString();
	}

}
