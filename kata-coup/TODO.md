Refactor, ideas I had during the creation of this kata:

* if we remove the "targetforstealing" and "target for assasination" fields we may refactor the tests to a simpler classes since the tests will become homogeneous.
or even having a common class for some and then some for te specifics.


* if we do have specific Exceptions, or we do the checknig of the exception text we can be more accurate in the assertThrow calls, this gives us certainty


* Adding the game board class, may provide order and simplify the code and tests



This kata is targeting, the user to learn:
------------------------------------------

* The kata must provide a jar that let you play, we can use NC -l and NC to talk between the players computers, so the jar will deal the random cards via network to the users (consider ascii art)
The jar opens the port and everyone connects to it. And prompts for the plays, and keeps describing each players moves and handles the games (spiting texts)
* Nc is great because can ask all players...: Any one blocks? any one challenges? and all players can act, the first doing it is the one doing the action


One player runs the jar, then the game accepts users,
How they connect?
Is the ascii art included? or simple braked tags [TheDuke] [Unknown]?




------ 

The kata objective is to learn a list of clear and specific topics.
The kata has to be very enjoyable, we play the real game, then we play the .jar game in our computers.
The kata, besides the main targets to learn, brings refactors opportunities, challenges.
The kata successful result is a playable extended game.






## Remaining

To test the implementations of the people, we need an acceptance test.
Is a way of play against their library, all the known possible plays and expected results.
So as they progress we can keep running this test constantly and asses if they are done or not, and what is missing

* A simulation of just a hand with:
  * random number of users
  * random users will randomly block and call the bluff
  * Actions will be triggered random as well for the playing user
  * This test will run million times and the results will be asserted against a file
  * the file well contain all the action -> results possible combinations pre-calculated
 

