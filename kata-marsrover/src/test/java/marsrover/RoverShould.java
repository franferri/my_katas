package marsrover;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import marsrover.navigation.East;
import marsrover.navigation.Location;
import marsrover.navigation.North;
import marsrover.navigation.South;
import marsrover.navigation.West;

public class RoverShould {

	@Test
	public void moveForwardEast() {

		Rover rover = new Rover(0, 0, new East());

		rover.move(new String[] { "Forward" });

		assertEquals("1,0,East", rover.position.toString());

	}

	@Test
	public void moveForwardWest() {

		Rover rover = new Rover(0, 0, new West());

		rover.move(new String[] { "Forward" });

		assertEquals("-1,0,West", rover.position.toString());

	}

	@Test
	public void moveForwardNorth() {

		Rover rover = new Rover(0, 0, new North());

		rover.move(new String[] { "Forward" });

		assertEquals("0,1,North", rover.position.toString());

	}

	@Test
	public void moveForwardSouth() {

		Rover rover = new Rover(0, 0, new South());

		rover.move(new String[] { "Forward" });

		assertEquals("0,-1,South", rover.position.toString());

	}

	@Test
	public void moveBackwardsEast() {

		Rover rover = new Rover(0, 0, new East());

		rover.move(new String[] { "Backwards" });

		assertEquals("-1,0,East", rover.position.toString());

	}

	@Test
	public void moveBackwardsdWest() {

		Rover rover = new Rover(0, 0, new West());

		rover.move(new String[] { "Backwards" });

		assertEquals("1,0,West", rover.position.toString());

	}

	@Test
	public void moveBackwardsNorth() {

		Rover rover = new Rover(0, 0, new North());

		rover.move(new String[] { "Backwards" });

		assertEquals("0,-1,North", rover.position.toString());

	}

	@Test
	public void moveBackwardsSouth() {

		Rover rover = new Rover(0, 0, new South());

		rover.move(new String[] { "Backwards" });

		assertEquals("0,1,South", rover.position.toString());

	}

	@Test
	public void moveTurnRightFromNorth() {

		Rover rover = new Rover(0, 0, new North());

		rover.move(new String[] { "Right" });

		assertEquals("0,0,East", rover.position.toString());

	}

	@Test
	public void moveTurnRightFromEast() {

		Rover rover = new Rover(0, 0, new East());

		rover.move(new String[] { "Right" });

		assertEquals("0,0,South", rover.position.toString());

	}

	@Test
	public void moveTurnRightFromWest() {

		Rover rover = new Rover(0, 0, new West());

		rover.move(new String[] { "Right" });

		assertEquals("0,0,North", rover.position.toString());

	}

	@Test
	public void moveTurnRightFromSouth() {

		Rover rover = new Rover(0, 0, new South());

		rover.move(new String[] { "Right" });

		assertEquals("0,0,West", rover.position.toString());

	}

	@Test
	public void moveTurnLeftFromNorth() {

		Rover rover = new Rover(0, 0, new North());

		rover.move(new String[] { "Left" });

		assertEquals("0,0,West", rover.position.toString());

	}

	@Test
	public void moveTurnLeftFromEast() {

		Rover rover = new Rover(0, 0, new East());

		rover.move(new String[] { "Left" });

		assertEquals("0,0,North", rover.position.toString());

	}

	@Test
	public void moveTurnLeftFromWest() {

		Rover rover = new Rover(0, 0, new West());

		rover.move(new String[] { "Left" });

		assertEquals("0,0,South", rover.position.toString());

	}

	@Test
	public void moveTurnLeftFromSouth() {

		Rover rover = new Rover(0, 0, new South());

		rover.move(new String[] { "Left" });

		assertEquals("0,0,East", rover.position.toString());

	}

	@Test
	public void routeCommands() {

		Rover rover = new Rover(2, 2, new North());

		String[] commands = new String[10];
		commands[0] = "Forward";
		commands[1] = "Left";
		commands[2] = "Forward";
		commands[3] = "Forward";
		commands[4] = "Left";
		commands[5] = "Forward";
		commands[6] = "Forward";
		commands[7] = "Right";
		commands[8] = "Backwards";
		commands[9] = "Backwards";

		rover.move(commands);

		assertEquals("2,1,West", rover.position.toString());

	}

	@Test
	public void planetHorizonFordwardEast() {

		Rover rover = new Rover(Mars.MARS_MAX_X, 0, new East());

		rover.move(new String[] { "Forward" });

		assertEquals("-" + Mars.MARS_MAX_X + ",0,East", rover.position.toString());

	}

	@Test
	public void planetHorizonBackwardsEast() {

		Rover rover = new Rover(Mars.MARS_MAX_X * -1, 0, new East());

		rover.move(new String[] { "Backwards" });

		assertEquals(Mars.MARS_MAX_X + ",0,East", rover.position.toString());

	}

	@Test
	public void planetHorizonFordwardWest() {

		Rover rover = new Rover(Mars.MARS_MAX_X * -1, 0, new West());

		rover.move(new String[] { "Forward" });

		assertEquals(Mars.MARS_MAX_X + ",0,West", rover.position.toString());

	}

	@Test
	public void planetHorizonBackwardsWest() {

		Rover rover = new Rover(Mars.MARS_MAX_X, 0, new West());

		rover.move(new String[] { "Backwards" });

		assertEquals("-" + Mars.MARS_MAX_X + ",0,West", rover.position.toString());

	}

	@Test
	public void planetHorizonFordwardNorth() {

		Rover rover = new Rover(0, Mars.MARS_MAX_Y, new North());

		rover.move(new String[] { "Forward" });

		assertEquals("0,-" + Mars.MARS_MAX_Y + ",North", rover.position.toString());

	}

	@Test
	public void planetHorizonBackwardsNorth() {

		Rover rover = new Rover(0, Mars.MARS_MAX_Y * -1, new North());

		rover.move(new String[] { "Backwards" });

		assertEquals("0," + Mars.MARS_MAX_Y + ",North", rover.position.toString());

	}

	@Test
	public void planetHorizonFordwardSouth() {

		Rover rover = new Rover(0, Mars.MARS_MAX_Y * -1, new South());

		rover.move(new String[] { "Forward" });

		assertEquals("0," + Mars.MARS_MAX_Y + ",South", rover.position.toString());

	}

	@Test
	public void planetHorizonBackwardsSouth() {

		Rover rover = new Rover(0, Mars.MARS_MAX_Y, new South());

		rover.move(new String[] { "Backwards" });

		assertEquals("0,-" + Mars.MARS_MAX_Y + ",South", rover.position.toString());

	}

	@Test
	public void travelXEquator() {

		Rover rover = new Rover(0, 0, new East());

		int fullSpinToThePlanet = Mars.MARS_MAX_X * 2 + 1;

		String[] commands = new String[fullSpinToThePlanet];

		for (int i = 0; i < fullSpinToThePlanet; i++) {
			commands[i] = "Forward";

		}

		rover.move(commands);

		assertEquals("0,0,East", rover.position.toString());

	}

	@Test
	public void travelYEquator() {

		Rover rover = new Rover(0, 0, new North());

		int fullSpinToThePlanet = Mars.MARS_MAX_Y * 2 + 1;

		String[] commands = new String[fullSpinToThePlanet];

		for (int i = 0; i < fullSpinToThePlanet; i++) {
			commands[i] = "Forward";

		}

		rover.move(commands);

		assertEquals("0,0,North", rover.position.toString());

	}

	@Test
	public void abortRouteOnObstaclesBeforeHitThemAndReportThem() {

		Rover rover = new Rover(4, 3, new East());

		Mars.OBSTACLES = new Location[1];
		Mars.OBSTACLES[0] = new Location(5, 4);
		
		String[] commands = new String[4];
		commands[0] = "Forward";
		commands[1] = "Left";
		commands[2] = "Forward";
		commands[3] = "Forward";

		rover.move(commands);
		
		Mars.OBSTACLES = null; // Clean the obstacles to let other tests work

		assertEquals("5,3,North", rover.position.toString());

	}

}
