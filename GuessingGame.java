import java.util.*;

public class GuessingGame
{
   public static Scanner sc = new Scanner(System.in);
   public static int counter, random, guess;
   public static String name, yes;
   public static boolean isRunning;
   
   public static void main(String[] args)
   {
      startGame(counter, random, name, guess);
   }
   public static void startGame(int counter, int random, String name, int guess)
   {
      counter = 1;   
      
      System.out.printf("\n========================================");
      System.out.printf("\n     WELCOME TO THE GUESSING GAME!      ");
      System.out.printf("\n========================================");
      System.out.printf("\nEnter your name: ");
      name = sc.nextLine();

      
      do
      {
                  
         displayWelcome(name);
         random = generateSecretnumber();
         guess = getUserGuess(counter, random, name);
         sc.nextLine();
         System.out.printf("\n========================================\n");
         System.out.printf("\nWould you like to play again, %s? (Y/N): ", name);
         yes = sc.nextLine().toUpperCase();
         if(yes.equals("Y"))
            isRunning = true;
      }
      while(isRunning);
      System.out.printf("\n\n========================================");
      System.out.printf("\nThanks for playing, %s!", name);
      System.out.printf("\nSee you next time!");
      System.out.printf("\n========================================\n");
   }
   public static void displayWelcome(String name)
   {
      System.out.printf("\n========================================");
      System.out.printf("\n     WELCOME TO THE GUESSING GAME!      ");
      System.out.printf("\n========================================");
      System.out.printf("\nHello, %s!", name);
      System.out.printf("\nI'm thinking of a number between 1 and 100.\nYou have 10 attempts to guess it.\nI'll give you a hint after each guess.\n\n");
      System.out.printf("Let's begin!");
      System.out.printf("\n========================================");
   }
   public static int generateSecretnumber()
   {
      Random rd = new Random();
      int random;
      
      random = rd.nextInt(1, 100);
      return random;
   }
   public static int getUserGuess(int counter, int random, String name)
   {
      int guess, i;
      boolean isValid;
      
      isValid = false;
      guess = 0;
   
      System.out.printf("\n\n--- Attempt %d ---", counter);
      
      
      while (!isValid)
      {
         System.out.printf("\nEnter your guess (1-100): ");
         guess = sc.nextInt();
         if(guess >= 1 && guess <= 100)
            isValid = true;
         else
            System.out.printf("Invalid! Please enter a number between 1 and 100.");
      }
      if(guess != random)
         giveHint(guess, random, counter);
      if(guess == random || counter > 10)
         playGame(counter, random, name, guess);
      counter++;
      if(counter <= 11 && guess != random)
         getUserGuess(counter, random, name);
      return guess;
   }
   public static void giveHint(int guess, int random, int counter)
   {
      if(guess > random)
         System.out.printf("\nToo high! Try a lower number.");
      else if(guess < random)
         if(counter < 11)
            System.out.printf("\nToo low! Try a higher number.");
      return;
   }
   public static void playGame(int counter, int random, String name, int guess)
   {
      if(guess == random)
      {
         System.out.printf("\nCongratulations %s!", name);
         System.out.printf("\nYou guessed the number %d in %d attempts!", random, counter);
      }
      else if(counter >= 11)
      {
         System.out.printf("\nGAME OVER!");
         System.out.printf("\nYou've used all 10 attempts.");
         System.out.printf("\nThe secret number was %d.", random);
         System.out.printf("\nBetter luck next time, %s!", name);
      }
      displayStats(counter, random, name, guess);
   }
   public static void displayStats(int counter, int random, String name, int guess)
   {
      String rating;
   
      System.out.printf("\n\n========================================");
      System.out.printf("\n           GAME STATISTICS              ");  
      System.out.printf("\n========================================");
      System.out.printf("\nPlayer: %s", name);
      System.out.printf("\nSecret Number: %d", random);
      System.out.printf("\nAttempts Used: %d", counter);
      
      if(counter == 1)
         rating = "Perfect";
      else if(counter <= 3)
         rating = "Excellent";
      else if(counter <= 6)
         rating = "Good Job";
      else if(counter <= 10)
         rating = "Nice Try!";
      else
         rating = "Better luck next time!";
      
      System.out.printf("\nRating: %s", rating);
   }  
}