## What is COUP?

**(Work in progress)**

Coup is a card game that was created originaly by Rikki Tahta.

* Where all started: http://lamamegames.com
* Official website http://www.indieboardsandcards.com/index.php/games/coup/

![The game assets](https://github.com/franferri/my-codingdojos-katas/blob/master/kata-coup/img/coup_the_game.jpg)

This kata is a recreation of the phisical game made by Indie Boards and Cards, unlike the original game where the theme is arround being a head of a family in an Italian city-state, where you fight for influence, the Indie Boards and Cards version is based in a not too distant future where the government is run for profit by a new “royal class” of multi-national CEOs.

More information about the game: https://boardgamegeek.com/boardgame/131357/coup
Review (video): https://boardgamegeek.com/video/46733/coup/board-game-brawl-reviews-coup

The original game allows till 10 players and additional roles, but the Indie Boards and Cards version splitted the game (and doubled the profits ;);) ) in the base game and a handful expansion.

The original game can be played between 2 players till 6.
When only 2 players play, you can play normal or use a clever "variation" mode to simplify the game.

The expanson from Indie Boards and Cards adds 1 more role and introduces factions, provides also more cards, allowing til 10 players. Basically the expansion gives you more variants to play, for example the new role replaces one existent in the base game and changes the dynamics, so never gets old.

* Official website for the expansion http://www.indieboardsandcards.com/index.php/games/coup-reformation/

**Tip**: If you decide to buy the game, also buy these: https://www.amazon.co.uk/gp/product/B004VEO8P4/ref=ppx_yo_dt_b_asin_title_o01_s00?ie=UTF8&psc=1

If you fall in love with the game here you have bit more to feed yourself with: https://www.kickstarter.com/projects/2012515236/coup-bluff-and-deception-in-the-world-of-the-resis

## Game rules in a nutshell (Skip this if you are already familiar with the game)

In Coup, you want to be the last player with influence in the game, with influence being represented by face-down character cards in your playing area.

Each player starts the game with two coins and two influence – i.e., two face-down character cards; the fifteen card deck consists of three copies of five different characters, each with a unique set of powers:

**Duke**: Take three coins from the treasury. Block someone from taking foreign aid.
**Assassin**: Pay three coins and try to assassinate another player's character.
**Contessa**: Block an assassination attempt against yourself.
**Captain**: Take two coins from another player, or block someone from stealing coins from you.
**Ambassador**: Draw two character cards from the Court (the deck), choose which (if any) to exchange with your face-down characters, then return two. Block someone from stealing coins from you.

On your turn, you can take any of the actions listed above, regardless of which characters you actually have in front of you, or you can take one of three other actions:

**Income**: Take one coin from the treasury.
**Foreign aid**: Take two coins from the treasury.
**Coup**: Pay seven coins and launch a coup against an opponent, forcing that player to lose an influence. (If you have ten coins or more, you must take this action.)

When you take one of the character actions – whether actively on your turn, or defensively in response to someone else's action – that character's action automatically succeeds unless an opponent challenges you. In this case, if you can't (or don't) reveal the appropriate character, you lose an influence, turning one of your characters face-up.

Face-up characters cannot be used, and if both of your characters are face-up, you're out of the game.

Any player can block or challenge any other player action, or blocking action, regardless the order they game is being played.

If you do have the character in question and choose to reveal it, the opponent loses an influence, then you shuffle that character into the deck and draw a new one, perhaps getting the same character again and perhaps not.

The last player to still have influence – that is, a face-down character – wins the game!

# The Kata

This kata aims to make you:
* Play and Learn the game
* Expand the game

I've create for this kata a library that lets you play the base game.
* Is a simple self contained maven project
* Tests and the game library are provided in Java 8, JUnit 5 and Mockito 2
* The project is Kotlin 1.3 ready and the Kotlin testing framework is also included Mockk 1.9

The base game library works, compiles and tests out of the box.
You only need to have Java 8 or newer in your machine and internet connection.
Recommended a proper IDE like IntelliJ or Eclipse, but Maven is build in in the project, so you can use any text editor too.

## What are we going to do in this Kata?

First hour (becoming familiar with the base game)
* Read instructions from the box of the base game
* Play once
* Read instructions again
* Play 4 more times

# Challenges

## Iteration 1 - Building the JAR (environment awareness)

* Open maven configuration file, explain the dependencies section and the uber jar configuration.
* Each person builds the library
* Play using the library
* Let's start the challenges

* Open it in your IDE
* Build it

## Iteration 2 - Upgrade some tests using Mockito (Preparation for fast testing)

[TODO]

Many people knows how to Mock, or maybe not even than.
* Look for a simple test were we can use a Mock
* Look for a simple test were we can use spy()

The challenge is to update this tests to use the mock and spy() instead of normal classes.
This drives to update the library to have to expose less internal methods because the testing.

## Iteration 3 - To add the 2 players variant

You must update the base library:
* It must ask you if you want to play with the normal game rules or the variant game when the game is created only with 2 players
* It must be hable to play with the 2 players variant
* The 2 players variant test must cover all the new rules

At the end of this iteration you must be able to play with other player using the normal game rules and the variant game rules

## Iteration 4 - To add The Inquisitor card

You must update the base library:
* Given any number of players, there must be an option to play The Inquisitor variant of the game
* All tests suite must be updated acordingly

Inquisitor: Draw one character card from the Court deck and choose whether or not to exchange it with one of your face-down characters, or force an opponent to show you one of their character cards (their choice which). If you wish it, you may then force them to draw a new card from the Court deck. They then shuffle the old card into the Court deck.
The Inquisitor block someone from stealing coins from you.

At the end of this iteration you must be able to play with others players using the normal game rules or using the inquisitor card




