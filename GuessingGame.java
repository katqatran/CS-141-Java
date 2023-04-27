// Katherine Tran
//
// This program involves a random number generator and requires the user to make guesses in an attempt to correctly
// guess the number. The program provides cues to the user based on the number they input. Users can play the game
// multiple times, and at the end, the program evaluates and displays statistics about the games.

import java.util.Scanner;

public class GuessingGame {
   
   public static final int MAX = 50;

   public static void main(String[] args) {
      Scanner console = new Scanner(System.in);
      introduction();
      
      int correct = (int)(Math.random() * MAX) + 1;
      int games = 1;
      int guesses = game(console, correct, MAX);
      int fewest = guesses;
      int gameGuesses = 0;
      
      System.out.print("Do you want to play again? ");
      String answer = console.next();
      
      while (answer.toLowerCase().charAt(0) == 'y'){
         correct = (int)(Math.random() * MAX) + 1;

         gameGuesses = game(console, correct, MAX);
         guesses += gameGuesses;
         if (gameGuesses < fewest){
            fewest = gameGuesses;
         }
         games++;
         System.out.print("Do you want to play again? ");
         answer = console.next();
      }
      statistics(games, guesses, fewest);
   }

   /**
    * The function provides an introduction to the guessing game.
    * It explains that the game involves guessing a number between 1 and MAX.
    * It also states that the user can make multiple guesses until they correctly guess the number.
    * For each guess, the program will indicate whether the guess is too high or too low.
    * This method is intended to provide the user with an understanding of the game rules and objectives.
    */
   public static void introduction() {
      System.out.println("This program allows you to play a guessing game.");
      System.out.println("It will think of a number between 1 and " + MAX); 
      System.out.println("and will allow you to guess until you get the number.");
      System.out.println("For each guess, it will tell you whether you have");
      System.out.println("guessed too high or too low.");
   }

   /**
    * The function allows the user to play a guessing game by inputting their guess using the console.
    * It takes a Scanner object 'console', the actual number to be guessed 'actual', and the maximum possible number 'MAX'.
    * The method prompts the user for their guess, provides feedback if the guess is too high or too low, and allows the
    * user to continue guessing until they correctly guess the actual number.
    * It returns the number of guesses it took the user to correctly guess the actual number.
    * @param console a Scanner object for reading user input
    * @param actual the actual number to be guessed
    * @param MAX the maximum possible number
    * @return the number of guesses it took the user to correctly guess the actual number
    */
   public static int game(Scanner console, int actual, int MAX){
      System.out.println("I'm thinking of a number between 1 and " + MAX + "...");
      System.out.print("Your guess? ");
      int guess = console.nextInt();
      int count = 1;
      
      while (guess != actual) {
         if (guess < actual) {
            System.out.println("Too low!");
         } else {
            System.out.println("Too high!");
         }  
         System.out.print("Your guess? ");
         count++;
         guess = console.nextInt();
      }
      
      System.out.println();
      if (guess == 1) {
         System.out.println("You got it right on the first guess!!");
      } else {
         System.out.println("You got it right in " + count + " guesses");
      }
      return count;  
   }

   /**
    * The function prints out statistics about the guessing game after all the rounds have been completed.
    * The method displays the total number of games played, the total number of guesses made across all games, and the
    * average number of guesses per game.The method also displays the fewest number of guesses it took the user to
    * correctly guess the actual number across all games played.
    * @param games the total number of games played
    * @param guesses the total number of guesses made across all games played
    * @param fewest the fewest number of guesses it took the user to correctly guess the actual number across all games played
    */
   public static void statistics(int games, int guesses, int fewest){
      System.out.println("Game statistics:");
      System.out.println("    games   = " + games);
      System.out.println("    guesses = " + guesses);
      System.out.printf("    guesses/game  = %.1f\n", ((double)guesses)/games);
      System.out.println("    fewest guesses = " + fewest);
   }
}

/*

 This program allows you to play a guessing game.
 It will think of a number between 1 and 50
 and will allow you to guess until you get the number.
 For each guess, it will tell you whether you have
 guessed too high or too low.
 I'm thinking of a number between 1 and 50...
 Your guess? 25
 Too low!
 Your guess? 40
 Too high!
 Your guess? 30
 Too low!
 Your guess? 35
 Too high!
 Your guess? 33
 
 You got it right in 5 guesses
 Do you want to play again? y
 I'm thinking of a number between 1 and 50...
 Your guess? 25
 Too low!
 Your guess? 40
 Too high!
 Your guess? 30
 Too low!
 Your guess? 35
 Too low!
 Your guess? 37
 Too low!
 Your guess? 38
 Too low!
 Your guess? 39
 
 You got it right in 7 guesses
 Do you want to play again? YES
 I'm thinking of a number between 1 and 50...
 Your guess? 25
 Too low!
 Your guess? 40
 Too low!
 Your guess? 45
 Too low!
 Your guess? 48
 Too high!
 Your guess? 47
 
 You got it right in 5 guesses
 Do you want to play again? nope
 Game statistics:
     games   = 3
     guesses = 17
     guesses/game  = 5.7
     fewest guesses = 5
  
 */
