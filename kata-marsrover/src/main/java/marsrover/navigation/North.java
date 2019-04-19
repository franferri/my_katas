package marsrover.navigation;

public class North extends Direction {

	Direction turnRight() {
		return new East();
	}

	Direction turnLeft() {
		return new West();
	}

	void forward(Location location) {
		location.forwardY();
	}

	void backwards(Location location) {
		location.backwardsY();
	}

}