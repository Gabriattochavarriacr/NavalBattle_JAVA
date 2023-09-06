# NavalBattle_JAVA
I have created this game in Java as a university project of the Fundamentals of Programming course, at CENFOTEC University, called: "Battleship" or Naval Battle, simplified. This game consists of the user being able to play against the computer and whoever manages to shoot down all the ships of the opposing team or whoever has the best score wins.
To implement the game, both the user and the computer have a list of integers, with 20 positions each, called PlayerBoats and ComputerBoats, which will contain the information of the boats. Each ship is symbolized with a number from 1 to 5, so these lists in each of their positions contain the following information: 0 if there is no ship, or a number between 1 and 5 to indicate that one of the ships is in that position. five
boats.
How to place boats on the lists?
The player's ships are placed manually, the user indicates in which positions he wants to place his 5 ships
in the corresponding list. The computer places its 5 ships randomly (for this the routine
random standard) inside the corresponding list.
How to shoot down the opponent's ships?
Once the ships are placed, the game starts with 10 chances for both the player and the computer.
to shoot down your opponent's ships or accumulate points. In each attempt the player starts first, which indicates in
which position it thinks there is a ship, the program should indicate if it shot down a ship or if it was a failed attempt. then it will be
the turn of the computer that randomly (for this the standard random routine is used) indicates in which
position believes there is a ship, the program should indicate if it shot down a ship or if it was an unsuccessful attempt.
How do you win the game?
If, before the 10 chances, the player or the computer shoot down all 5 of their opponent's ships, then they win.
If no one does, then whoever found or shot down the most ships wins. But if they have the same amount of
ships shot down, the winner is whoever has the greatest sum of the numbers of ships shot down. If the sum is
the same then a draw is declared.
I hope you like my game.
