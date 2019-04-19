package marsrover.navigation;

import marsrover.Mars;

public class Location {

	int x;
	int y;

	boolean obstacle = false;

	public Location(int x, int y) {
		this.x = x;
		this.y = y;
	}

	private void detectObstacle(int x, int y) {
		if (Mars.OBSTACLES != null) {
			for (int i = 0; i < Mars.OBSTACLES.length; i++) {
				if (x == Mars.OBSTACLES[i].x && y == Mars.OBSTACLES[i].y) {
					obstacle = true;
				}
			}
		}
	}

	void forwardX() {

		int nextX = x;
		if (Mars.MARS_MAX_X == nextX) {
			nextX = Mars.MARS_MAX_X * -1;
		} else {
			++nextX;
		}

		detectObstacle(nextX, y);
		if (obstacle == true) {
			return;
		}

		x = nextX;

	}

	void backwardsX() {

		int nextX = x;
		if (Mars.MARS_MAX_X * -1 == nextX) {
			nextX = Mars.MARS_MAX_X;
		} else {
			--nextX;
		}

		detectObstacle(nextX, y);
		if (obstacle == true) {
			return;
		}

		x = nextX;
	}

	void forwardY() {

		int nextY = y;
		if (Mars.MARS_MAX_Y == nextY) {
			nextY = Mars.MARS_MAX_Y * -1;
		} else {
			++nextY;
		}

		detectObstacle(x, nextY);
		if (obstacle == true) {
			return;
		}

		y = nextY;

	}

	void backwardsY() {

		int nextY = y;
		if (Mars.MARS_MAX_Y * -1 == nextY) {
			nextY = Mars.MARS_MAX_Y;
		} else {
			--nextY;
		}

		detectObstacle(x, nextY);
		if (obstacle == true) {
			return;
		}

		y = nextY;

	}

}
