
### Remaining

* A simulation of just a hand with:
  * random number of users
  * random users will randomly block and call the bluff
  * Actions will be triggered random as well for the playing user
  * This test will run million times and the results will be asserted against a file
  * the file well contain all the action -> results possible combinations pre-calculated
 

## Coup

This is just a funny exercise of having a library able to play the game following all the rules and testing all possible combinations.

[Oficial web page](http://www.indieboardsandcards.com/index.php/games/coup/#1480828355170-55d598da-e40d00e9-c875)

[The game description](https://boardgamegeek.com/boardgame/131357/coup)

[Review](https://boardgamegeek.com/video/46733/coup/board-game-brawl-reviews-coup)

![The game assets](https://github.com/franferri/my-codingdojos-katas/blob/master/kata-coup/img/coup_the_game.jpg)

You are head of a family in an Italian city-state, a city run by a weak and corrupt court. You need to manipulate, bluff and bribe your way to power. Your object is to destroy the influence of all the other families, forcing them into exile. Only one family will survive...

### Iteration 1

In Coup, you want to be the last player with influence in the game, with influence being represented by face-down character cards in your playing area.

Each player starts the game with two coins and two influence – i.e., two face-down character cards; the fifteen card deck consists of three copies of five different characters, each with a unique set of powers:

Duke: Take three coins from the treasury. Block someone from taking foreign aid.
Assassin: Pay three coins and try to assassinate another player's character.
Contessa: Block an assassination attempt against yourself.
Captain: Take two coins from another player, or block someone from stealing coins from you.
Ambassador: Draw two character cards from the Court (the deck), choose which (if any) to exchange with your face-down characters, then return two. Block someone from stealing coins from you.
On your turn, you can take any of the actions listed above, regardless of which characters you actually have in front of you, or you can take one of three other actions:

Income: Take one coin from the treasury.
Foreign aid: Take two coins from the treasury.
Coup: Pay seven coins and launch a coup against an opponent, forcing that player to lose an influence. (If you have ten coins or more, you must take this action.)
When you take one of the character actions – whether actively on your turn, or defensively in response to someone else's action – that character's action automatically succeeds unless an opponent challenges you. In this case, if you can't (or don't) reveal the appropriate character, you lose an influence, turning one of your characters face-up. Face-up characters cannot be used, and if both of your characters are face-up, you're out of the game.

If you do have the character in question and choose to reveal it, the opponent loses an influence, then you shuffle that character into the deck and draw a new one, perhaps getting the same character again and perhaps not.

The last player to still have influence – that is, a face-down character – wins the game!

### Iteration 2

Now we have more than 2 players, 3 and 4. Does your testing resist?

### Iteration 3

Mind that player 3 can call the bluff when player 1 attacks player 2.

### Iteration 4

A new & optional character called the Inquisitor has been added (currently, the only English edition with the Inquisitor included is the Kickstarter Version from Indie Boards & Cards. Copies in stores may not be the Kickstarter versions and may only be the base game). The Inquisitor character cards may be used to replace the Ambassador cards.

Inquisitor: Draw one character card from the Court deck and choose whether or not to exchange it with one of your face-down characters. OR Force an opponent to show you one of their character cards (their choice which). If you wish it, you may then force them to draw a new card from the Court deck. They then shuffle the old card into the Court deck. Block someone from stealing coins from you.

