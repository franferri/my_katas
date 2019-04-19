package marsrover.navigation;

public class East extends Direction {

	Direction turnRight() {
		return new South();
	}

	Direction turnLeft() {
		return new North();
	}

	void forward(Location location) {
		location.forwardX();
	}

	void backwards(Location location) {
		location.backwardsX();
	}

}
