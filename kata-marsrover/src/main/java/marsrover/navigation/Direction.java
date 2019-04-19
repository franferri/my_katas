package marsrover.navigation;

public abstract class Direction {

	abstract Direction turnRight();

	abstract Direction turnLeft();

	abstract void forward(Location location);

	abstract void backwards(Location location);

}
