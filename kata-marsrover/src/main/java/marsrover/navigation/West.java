package marsrover.navigation;

public class West extends Direction {

	Direction turnRight() {
		return new North();
	}

	Direction turnLeft() {
		return new South();
	}

	void forward(Location location) {
		location.backwardsX();
	}

	void backwards(Location location) {
		location.forwardX();
	}

}
