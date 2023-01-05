/*
ConncetFour.java

Programmer: Andy Lee
Date:       Jan. 22, 2021
Course:     ICS3U1

This program will simulate the game Connect Four

ChangeLog:

January 22nd
   - Started program
   - Created File I/O system
   - Created Startup prompts

January 25th
   - Finished and polished general structure of program except for the acutal game
   
Jaunary 26th
   - Fixed some issues regarding scanner inputs
   - Sorted methods by section to organize better
   - Started game relevant methods
   
January 27th
   - Started player input and game display
   
January 28th
   - Finished player interactions
   - Started computer turn
   
January 29th
   - Focused on computer turn AI
   
February 1st
   - Finsihed computer turn AI
*/

// Import
import java.io.*;
import java.util.*;

// Class
public class ConnectFour {

   // Main
   public static void main(String[] args) {
      
      // Declaration (continued below)
      Scanner sc = new Scanner (System.in);
      
      // User input
      String input, name;
      
      // Stored information
      int[] wins = {0};
      int[] losses = {0};
      int[] ties ={0};
      
      // Game
      final int ROWS = 6;
      final int COLUMNS = 7;
      final int VICTORY_CONDITION = 4;
      int victory;
      String[][] board = new String[ROWS][COLUMNS];
      
      // Check if player is a returning player or not
      System.out.println("----------------------------------------");
      System.out.println("Are you are returning player? ('y'/'n')");
      System.out.println("----------------------------------------");
      input = sc.nextLine();
      // Continues to check until a valid input is entered
      while (input.compareToIgnoreCase("y") != 0 && input.compareToIgnoreCase("n") != 0) {
         System.out.println("\n----------------------------------------");
         System.out.println("Invalid Input, are you a returning player? ('y'/'n')");
         System.out.println("----------------------------------------");
         input = sc.nextLine();
      }
      
      // File I/O based on input above
      // Returning player
      if (input.compareToIgnoreCase("y") == 0) {
         name = nameCheck(wins, losses, ties);
      // New player
      } else {
         name = newPlayer(wins, losses, ties);
      }
      
      // Current Stats
      displayStats (wins, losses, ties);
      
      System.out.println("\n----------------------------------------");
      System.out.println("Press enter to start the game");
      System.out.println("----------------------------------------");
      input = sc.nextLine();
      
      // Game loop
      input = "y";
      while (input.equals("y")) {
         // Reset game board
         reset (board);
         
         victory = 0;
         // Loops until the player or computer is victorious
         while (victory == 0) {
         
            // Shows game board
            displayBoard(board);
         
            // Player's turn
            playerTurn (board);
            
            victory = checkWin(board, VICTORY_CONDITION);
            
            // breaks if player wins before the computer's turn
            if (victory != 0) {
               break;
            }
            
            // Computer's turn
            computerTurn(board);
            
            victory = checkWin(board, VICTORY_CONDITION);
            
            // breaks if computer wins before doing confirmation
            if (victory != 0) {
               break;
            }
      
            // Displays board before confirmation
            displayBoard (board);
      
            // Asks for confirmation to continue
            System.out.println("Press enter to continue");
            sc.nextLine();
         }
         
         displayBoard(board);
         
         System.out.println("----------------------------------------");
         
         // Update stats and display appropriate message
         if (victory == 1) {
            wins[0] += 1;
            System.out.println("Congratulations, you won!");
         }
         if (victory == 2) {
            losses[0] += 1;
            System.out.println("You have lost the game");
         }
         if (victory == 3) {
            ties[0] += 1;
            System.out.println("The game has ended in a tie!");
         }
         
         System.out.println("----------------------------------------");
         
         // record and display stats
         record (wins, losses, ties, name);
         displayStats(wins, losses, ties);
         
         // Prompt to repeat game
         input = "";
         while (!input.equals("y") && !input.equals("n")) {
            System.out.println("----------------------------------------");
            System.out.println("Would you like to play again? ('y'/'n')");
            System.out.println("----------------------------------------");
            input = sc.nextLine();
         }
      }
      
      // End message
      System.out.println("----------------------------------------");
      System.out.println("Thank you for playing!\n");
      System.out.println("----------------------------------------");
      
   } // Main end
   
   // ----------------------------------------------------------------------------------------------------------------------------------------------------------------
   // METHODS
   // ----------------------------------------------------------------------------------------------------------------------------------------------------------------
   // Game relevent methods
   
   // int checkWin
   // returns number corresponding to who won if anyone has won, or if it is a tie
   // String[][] board, used to calculate who won
   // int condition, used to change the minimum amount of pieces in a row, used basically only for the computer ai
   //
   // Processes any victories
   static int checkWin (String[][] board, int condition) {
      // Used reset count every row
      int multi = 1;
      
      // Horizontal connect four checks
      for (int row = 0; row < board.length; row++) {
         // reset count each row
         multi = 1;
      
         for (int column = 1; column < board[0].length; column++) {
            
            // If there is a piece in a row, keep track of it
            if (board[row][column].equals(board[row][column - 1]) && !board[row][column].equals(" ")) {
               multi += 1;
               
               // Victory condition
               if (multi >= condition) {
                  // 1 = player victory, 2 = computer vitory
                  if (board[row][column].equals("*")) return 1;
                  else return 2;
               }
            } else {
               // reset count if something breaks the chain
               multi = 1;
            }
         }
      }
      
      multi = 1;
      
      // Vertical connect four checks
      for (int column = 0; column < board[0].length; column++) {
         // Used to reset the count every column
         multi = 1;
         for (int row = 1; row < board.length; row++) {
            
            // If there is a piece in a row, keep track of it
            if (board[row][column].equals(board[row - 1][column]) && !board[row][column].equals(" ")) {
               multi += 1;
               
               // Victory condition
               if (multi >= condition) {
                  // 1 = player victory, 2 = computer vitory
                  if (board[row][column].equals("*")) return 1;
                  else return 2;
               }
            } else {
               // reset count if something breaks the chain
               multi = 1;
            }
         }
      }
      
      // Diagonal connect four checks (bottom left to top right)
      for (int row = 0; row < board.length - (condition - 1); row++) {
         for (int column = 0; column < board[0].length - (condition - 1); column++) {
         
            // Instead of checking entire columns or rows, this check will check each possible address for a diagonal connect four
            if (board[row][column].equals(" ")) continue;
            
            for (int difference = 1; difference < condition; difference++) {
               if(!board[row + difference][column + difference].equals(board[row + difference - 1][column + difference - 1])) {
                  // reset if something breaks the chain
                  break;
               } else {
                  // 1 = player victory, 2 = computer victory
                  if (difference >= (condition - 1)) {
                     if (board[row + difference][column + difference].equals("*")) return 1;
                     else return 2;
                  }
                  
               }
            }
         }
      }
      
      // Diagonal connect four checks (top left to bottom right)
      for (int row = board.length - 1; row >= (condition - 1); row--) {
         for (int column = 0; column < board[0].length - (condition - 1); column++) {
         
            // Instead of checking entire columns or rows, this check will check each possible address for a diagonal connect four
            if (board[row][column].equals(" ")) continue;
            
            for (int difference = 1; difference < condition; difference++) {
               if(!board[row - difference][column + difference].equals(board[row - difference + 1][column + difference - 1])) {
                  // reset if something breaks the chain
                  break;
               } else {
                  // 1 = player victory, 2 = computer victory
                  if (difference >= (condition - 1)) {
                     if (board[row - difference][column + difference].equals("*")) return 1;
                     else return 2;
                  }
                  
               }
            }
         }
      }
      
      // Check for tie
      multi = board.length;
      for (int column = 0; column < board[0].length; column++) {
         if (board[board.length - 1][column] != " ") {
            multi -= 1;
         }
      }
      if (multi == 0) return 3;
      
      return 0;
   }
   
   // void computerTurn
   // Executes computer's turn, and asks for confirmation to continue the game
   // String[][] board, used to calculate the computer's turn
   //
   // Processes the computer's turn
   static void computerTurn (String[][] board) {
      Scanner in = new Scanner (System.in);
      
      String[][] arr = board;
      
      // Repeats the processes within for chains of 3 and 2 pieces as well, so that if the computer cannot win it will try to get closer to winning or prevent the player from winning
      // Only looks up to one turn in the future to avoid making an impossible to beat AI
      for (int condition = 4; condition > 1; condition--) {
         for (int column = 0; column < board[0].length; column++) {
            for (int row = 0; row < board.length; row++) {
               if (arr[row][column].equals(" ")) {
               
                  // If any move wins the game, play that move
                  arr[row][column] = "^";
                  if (checkWin(arr, condition) == 2) {
                     board [row][column] = "^";               
                     return;
                  } else {
                     arr[row][column] = " ";
                  }
                  
                  break;
               }
            }
         }
         
         for (int column = 0; column < board[0].length; column++) {
            for (int row = 0; row < board.length; row++) {
               if (arr[row][column].equals(" ")) {
                   // If any move can win for the player if they play it on the next turn, play that move
                  arr[row][column] = "*";
                  if (checkWin(arr, condition) == 1) {
                     board [row][column] = "^";               
                     return;
                  } else {
                     arr[row][column] = " ";
                  }
                  
                  break;
               }
            }
         }
      }
      
      // If there are no smart moves, use a random move (Will almost never happen, but just in case so that the program does not stop) 
      
      // Used to check if the piece value is valid
      boolean valid = false;
      
      while (valid == false) {
         // AI calculation of where to insert piece
         int piece = (int)(Math.random() * 7);
         
         if (!board[board.length - 1][piece].equals(" ")) {
            continue;
         } else {
            valid = true;
         }
         
         // Adds piece to board
         for (int y = 0; y < board.length; y++) {
            if (board[y][piece] == " ") {
               board[y][piece] = "^";
               break;
            }
         }
      }
   }
   
   // void playerTurn
   // Prompts the player for their turn input and execute it
   // String[][] board, used to execute the player's turn
   //
   // Processes the player's turn
   static void playerTurn (String[][] board) {
      Scanner in = new Scanner (System.in);
      int input = 0;
      
      // Input gather
      System.out.println("----------------------------------------");
      System.out.println("Which column would you like to enter a piece into?");
      System.out.println("----------------------------------------");
      
      // Initial prompt
      try {
         input = Integer.parseInt(in.nextLine());
      } catch (NumberFormatException e) {
         System.out.println("Invalid Input");
      }
      
      // Prompts until a valid input is entered
      while (!(input >= 1) || !(input <= 7) || !board[board.length - 1][input - 1].equals(" ")) {
         System.out.println("----------------------------------------");
         System.out.println("Invalid input, which column would you like to enter a piece into?");
         System.out.println("----------------------------------------");
      
         try {
            input = Integer.parseInt(in.nextLine());
         } catch (NumberFormatException e) {
            System.out.println("Invalid Input");
         }
      }
      
      // Puts piece into board
      for (int y = 0; y < board.length; y++) {
         if (board[y][input - 1] == " ") {
            board[y][input - 1] = "*";
            break;
         }
      }
   }
   
   // void reset
   // String[][] board, passed by reference to reset the board
   // resets the board
   //
   // resets the game
   static void reset (String[][] board) {
      for (int y = 0; y < board.length; y++) {
         for (int x = 0; x < board[0].length; x++) {
            board[y][x] = " ";
         }
      }
   }
   
   // void displayBoard
   // Outputs the current board state
   // String[][] board, used to indicate the board state
   //
   // Outputs board state
   static void displayBoard (String[][] board) {
      // Legend
      System.out.println("\n----------------------------------------");
      System.out.println("' ' = empty, '*' = your piece, '^' = computer piece");
      System.out.println("----------------------------------------");
      
      // headers
      System.out.print (" ");
      for (int column = 1; column <= board[0].length; column++) {
         System.out.print(column + " ");
      }
      System.out.println("");
      
      // for loop to go through each slot
      for (int row = board.length - 1; row >= 0; row--) {
         System.out.print("|");
         for (String piece : board[row]) {
            System.out.print(piece + "|");
         }
         // Space between rows
         System.out.println("");
      }
      System.out.println("----------------------------------------");
   }
   
   // ----------------------------------------------------------------------------------------------------------------------------------------------------------------
   // Basic output & structural methods
   
   // void displayStats
   // Outputs the current stats
   // int[] wins, passed by reference in order to output it
   // int[] losses, passed by reference in order to output it
   // int[] ties, passed by reference in order to output it
   // 
   // Outputs player's stats
   static void displayStats (int[] wins, int[] losses, int[] ties) {
      // Declaration
      double percentageWin = 0;
      
      // percentage win calculation
      if (wins[0] != 0 || losses[0] != 0 || ties[0] != 0) percentageWin = (wins[0] / ((double)wins[0] + losses[0] + ties[0])) * 100; 
      else percentageWin = 0;
      
      System.out.println("\n----------------------------------------");
      System.out.println("Current stats:");
      System.out.println("Wins: " + wins[0]);
      System.out.println("Losses: " + losses[0]);
      System.out.println("Ties: " + ties[0]);
      System.out.printf("%nPercentage of wins: %.2f%s%n", percentageWin, "%");
      System.out.println("----------------------------------------");
   }
   
   // ----------------------------------------------------------------------------------------------------------------------------------------------------------------
   // I/O methods
   
   // String newPlayer
   // Returns the String that represents the name of the user if they are a new player, works in conjunction with nameCheck, below
   // int[] wins, used to return to nameCheck
   // int[] losses, used to return to nameCheck
   // int[] ties, used to return to nameCheck
   //
   // Finds the name of the user
   static String newPlayer (int[] wins, int[] losses, int[] ties) {
      // Initializaiton
      Scanner sc = new Scanner(System.in);
      boolean confirm = false;
      String name = "", input;
      
      // Prompts for name until confirmed
      System.out.println("\n----------------------------------------");
      System.out.println("Please enter your name, enter '-1' if you are a returning player: ");
      System.out.println("----------------------------------------");
      name = sc.nextLine();
        
      if (name.equals("-1")) {
         return nameCheck(wins, losses, ties);
      }
      
      while (confirm == false) {
         System.out.println("----------------------------------------");
         System.out.println("Are you sure your name is " + name + "? ('y'/'n')");
         System.out.println("----------------------------------------");
         input = sc.nextLine();
         
         // Confirmation
         if (input.compareToIgnoreCase("y") == 0) confirm = true;
         if (input.compareToIgnoreCase("n") == 0) {
            name = newPlayer(wins, losses, ties);
            break;
         }
      }
      return name;
   }
   
   // String nameCheck
   // Returns the String that represents the name of the user, works in conjunction with newPlayer, above
   // int[] wins, passed by reference in order to obtain this information from the method
   // int[] losses, passed by reference in order to obtain this information from the method
   // int[] ties, passed by reference in order to obtain this information from the method
   // 
   // Finds the name of the user
   static String nameCheck (int[] wins, int[] losses, int[] ties) {
      // Declaration
      Scanner sc = new Scanner (System.in);
      String name;
   
      // Prompts for name
      System.out.println("\n----------------------------------------");
      System.out.println("Please enter your name, enter '-1' if you are a new player: ");
      System.out.println("----------------------------------------");
      name = sc.nextLine();
         
      if (name.equals("-1")) {
         return newPlayer(wins, losses, ties);
      }
         
      //Read
      try {
         // Succesful read of data
         BufferedReader in = new BufferedReader(new FileReader(name + ".txt"));
         wins[0] = Integer.parseInt(in.readLine());
         losses[0] = Integer.parseInt(in.readLine());
         ties[0] = Integer.parseInt(in.readLine());
         in.close ();
         return name;
      } catch (IOException e) {
         // If the name doesn't exist, prompt again
         System.out.println("Non-existant player file");
         return nameCheck(wins, losses, ties);
      } catch (NumberFormatException e) {
         // If the data is not stored properly, prompt again
         System.out.println("Input formatted incorrectly, choose a different player file");
         return nameCheck(wins, losses, ties);
      }
   }
   
   // void record
   // Records the stats of the player
   // int[] wins, used to output the number of wins
   // int[] losses, used to output the number of losses
   // int[] ties, used to to output the number of ties
   // String name, used to save this information to the appropriate file
   //
   // Saves player stats
   static void record (int[] wins, int[] losses, int[] ties, String name) {
      try {
         // Writes stats to a file
         BufferedWriter out = new BufferedWriter(new FileWriter(name + ".txt", false));
         out.write(String.valueOf(wins[0]));
         out.newLine();
         out.write(String.valueOf(losses[0]));
         out.newLine();
         out.write(String.valueOf(ties[0]));
         out.close();
      } catch (IOException e) {
         System.out.println("Unable to save stats");
      }
   }
   
} // Class end