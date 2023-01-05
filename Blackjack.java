/*
Blackjack.java

Programmer: Andy Lee
Date:       Jan. 7, 2020
Course:     ICS3U1

This program will simulate a game of blackjack
*/

// Import
import java.util.*;

// Class
public class Blackjack {

   // Global Declaration
   static ArrayList<String> deck = new ArrayList<String> ();
   static ArrayList<String> playerHand = new ArrayList<String> ();
   static ArrayList<String> houseHand = new ArrayList<String> ();
   
   // Main
   public static void main(String[] args) {
   
      // Declaration
      Scanner in = new Scanner(System.in); // Scanner
      
      // Used in Intro
      String exit = "y";            // Used to check if the player wants to play again
      String dummy = "";            // Used in various in.nextLine();'s in order to allow the player to press enter before the program continues
      
      // Used in Game
      final int BLACKJACK = 21;     // The threshold for a blackjack
      final int HOUSE_STAND = 17;   // The threshold for the house to stand
      String activeCard;            // Keeps track of the last drawn card
      String hitStand;              // Used for the player to indicate if they want to hit or stand
      int total = 0;                // Used to keep track of the player's total value
      int houseTotal = 0;           // Used to keep track of the house's total value
      int activeValue;              // Used to keep track of the value of the last drawn card
      boolean win = false;          // Used to store whether or not the player has won at any point in the program, particularly used in the instant victory conditions
      boolean quickEnd = false;     // Used to store whether or not the game should end instantly
      
      // Cross game information
      int wins = 0;                 // Total wins
      int losses = 0;               // Total losses
      
      // Intro      
      System.out.println("----------------------------------------");
      System.out.println("Welcome to Blackjack!\n");
      System.out.println("Press enter to play");
      System.out.println("----------------------------------------");
      dummy = in.nextLine();
      
      // Game
      while (exit.equals("y")) {
         // Refills deck and emptys hands
         reset ();
         
         // Various other reset variables
         win = false;
         quickEnd = false;
         total = 0;
         houseTotal = 0;
         
         hitStand = "";
         // Draw Phase
         while (!hitStand.equals("stand")) {
            // Selects a random card from the deck and adds it to the player's hand
            activeCard = draw (true);
         
            System.out.println("----------------------------------------");
            // Prints existing cards in hand
            for (String card : playerHand) {
               System.out.print(card + " ");
            }
            
            // Shows this turn's draw
            activeValue = translate (activeCard, true, 0);
            total += activeValue;
            System.out.println("\nTotal value: " + total);
            
            // Check if instant victory or loss
            if (total < BLACKJACK) {
               System.out.println("\nWould you like to 'hit' or 'stand'");
            } else if (total == BLACKJACK) {
               // (These variables are used for the instant victory of either going over or getting a blackjack)
               win = true;
               quickEnd = true;
            } else {
               win = false;
               quickEnd = true;
            }
            System.out.println("----------------------------------------");
            
            // Instant victory break after the border is drawn
            // This is done seperately because the prompt of "\nWould you like to 'hit' or 'stand'" should not be printed if the player reaches an instant victory or loss
            if (total >= 21) {
               break;
            }
            
            // Hit / Stand prompt
            hitStand = "";
            hitStand = in.nextLine();
            // Continually gets input until a valid input is recieved
            while (!(hitStand.equals("hit") || hitStand.equals("stand"))) {
               System.out.println("Invalid input, Would you like to 'hit' or 'stand'?");
               hitStand = in.nextLine();
            }
         } // End Draw Phase
         
         // House's turn
         while (quickEnd == false) {
            // Selects a random card from the deck and adds it to the house's hand
            activeCard = draw (false);
         
            System.out.println("----------------------------------------");
            
            // Prints existing cards in your hand
            System.out.println("You:");
            for (String card : playerHand) {
               System.out.print(card + " ");
            }
            
            // Prints existing cards in house's hand
            System.out.println("\n\nHouse:");
            for (String card : houseHand) {
               System.out.print(card + " ");
            }
            
            // Shows this turn's draw
            activeValue = translate (activeCard, false, houseTotal);
            houseTotal += activeValue;
            System.out.println("\nYour total value: " + total);
            System.out.println("House's total value: " + houseTotal);
            System.out.println("----------------------------------------");
            
            // Stand conditions
            if (houseTotal >= HOUSE_STAND) {
               if (houseTotal > BLACKJACK) win = true; quickEnd = true;
               break;
            }
            
            System.out.println("Confirm next draw:");
            dummy = in.nextLine ();

         } // End House Draw Phase
         
         // Win / loss calculation
         if (!quickEnd) {
            if (houseTotal >= total) {
               win = false;
            }
         }
         
         System.out.println("----------------------------------------");
         // Win / loss messages
         if (win) {
            System.out.println("Congratulations you win!");
            wins += 1;
         } else {
            System.out.println("You have lost to the house");
            losses += 1;
         }
         
         // Repeat prompt
         System.out.println("Wins: " + wins + ", Losses: " + losses);
         System.out.println("\nWould you like to play again? ('y'): ");
         System.out.println("----------------------------------------");
            
         exit = in.nextLine ();
         
      } // End Game
      
      System.out.println("----------------------------------------");
      System.out.println("Thank you for playing!\n");
      System.out.println("----------------------------------------");
                        
   } // Main end
   
   // void reset
   //
   // Resets hands and the deck
   static void reset () {
      // Deck reset
      deck.clear();
      for (int count = 0; count < 4; count++) {
         deck.add("0A");
         deck.add("02");
         deck.add("03");
         deck.add("04");
         deck.add("05");
         deck.add("06");
         deck.add("07");
         deck.add("08");
         deck.add("09");
         deck.add("10");
         deck.add("0J");
         deck.add("0Q");
         deck.add("0K");
      }
      
      // Hand resets
      playerHand.clear();
      houseHand.clear();      
   } // reset end
   
   // String draw
   // Returns a random card in string form from the deck
   // player indicates whether a player or house card is being processed, true is for player cards, false is for house cards
   // 
   // Draws a random card form the deck
   static String draw (boolean player) {
      // Randomize
      int card = (int)(Math.random() * (deck.size ()));
      
      // Adds card to approrpiate hand and removes the appropriate card from the deck
      if (player) playerHand.add(deck.get(card));
      else houseHand.add(deck.get(card));
      deck.remove(card);
      
      if (player) return playerHand.get(playerHand.size() - 1);
      else return houseHand.get(houseHand.size() - 1);
   } // draw end
   
   // int translate
   // Returns the integer value of the input cards
   // input is the card being evaluated in string form
   // player indicates whether a player or house card is being processed, true is for player cards, false is for house cards
   // houseTotal is used if the card drawn is an ace for house calculations, as the house has to be able to evaluate its current number to make a decision with an ace
   //
   // Converts card names to integer values
   static int translate (String input, boolean player, int houseTotal) {
      System.out.println("");
      String translateInput = "";
      Scanner in = new Scanner(System.in);
      
      // Based on the input card in string form, this method outputs the input card in integer form
      switch (input) {
         // Unique Ace conditions
         case "0A":
            System.out.print("An ace was drawn");
            // Checks who's draw is being processed
            if (player) {
               // If it is the player's turn, prompt them with which value they would like to assign to the ace
               System.out.println(", would you like to use a value of 1 or 11: ");
               translateInput = in.nextLine();
            
               // If the input is invalid continue to collect inputs until a correcpt input is made
               while (!translateInput.equals("1") && !translateInput.equals("11")) {
                  System.out.println("Invalid Choice");
                  System.out.println("Would you like to use a value of 1 or 11: ");
                  translateInput = in.nextLine();
               }
               // Based on input, return appropriate value of the ace
               if (translateInput.equals("1")) return 1;
               else return 11;
            } else {
               // If it is the house's turn, use the house's algorithm to check what the ace's value will be
               if (houseTotal <= 10) {
                  return 11;
               } else {
               return 1;
               }
            }
         case "02":
            System.out.println("A 2 was drawn");
            return 2;
         case "03":
            System.out.println("A 3 was drawn");
            return 3;
         case "04":
            System.out.println("A 4 was drawn");
            return 4;
         case "05":
            System.out.println("A 5 was drawn");
            return 5;
         case "06":
            System.out.println("A 6 was drawn");
            return 6;
         case "07":
            System.out.println("A 7 was drawn");
            return 7;
         case "08":
            System.out.println("An 8 was drawn");
            return 8;
         case "09":
            System.out.println("A 9 was drawn");
            return 9;
         case "10":
            System.out.println("A 10 was drawn");
            return 10;
         case "0J":
            System.out.println("A Jack was drawn");
            return 10;
         case "0Q":
            System.out.println("A Queen was drawn");
            return 10;
         case "0K":
            System.out.println("A King was drawn");
            return 10;
      } // switch end
      return 0;
   } // translate end
   
} // Class end