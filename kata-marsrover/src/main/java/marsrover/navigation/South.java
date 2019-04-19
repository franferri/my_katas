package marsrover.navigation;

public class South extends Direction {

	Direction turnRight() {
		return new West();
	}

	Direction turnLeft() {
		return new East();
	}

	void forward(Location location) {
		location.backwardsY();
	}

	void backwards(Location location) {
		location.forwardY();
	}

}
