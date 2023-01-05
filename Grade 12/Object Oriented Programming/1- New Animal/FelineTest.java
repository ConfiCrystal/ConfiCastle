/**
*  Name: Andy Lee & Shreya
*  Date: September, 29, 2021
*  Program: FelineTest
*  Description: This program is a test for the Feline class
*/

// Imported libraries
import java.util.*;

// FelineTest Class
public class FelineTest {
      
   // FelineTest Main
   public static void main (String[] args) {
   
      // Full input test
      Feline feline1 = new Feline("Ranboo", "Black and White", "Green and Red", 1, 0.0, 0.0, 0.0, 1.0, 5.0, false);
      
      // feline1 tests
      feline1.kill();
      feline1.roar();
      feline1.prance();
      feline1.fall();
      feline1.climb();
      feline1.stalk();
      feline1.fall();
      feline1.climb();
      feline1.summary();
      
      // Low input test
      Feline feline2 = new Feline();
      
      // feline2 tests
      feline2.kill();
      feline2.roar();
      feline2.prance();
      feline2.fall();
      feline2.climb();
      feline2.stalk();
      feline2.fall();
      feline2.climb();
      feline2.summary();
      
      System.out.println("\n" + feline2.name());
      System.out.println(feline2.furColour());
      System.out.println(feline2.eyeColour());
      System.out.println(feline2.killCount());
      System.out.println(feline2.x());
      System.out.println(feline2.y());
      System.out.println(feline2.z());
      System.out.println(feline2.speed());
      System.out.println(feline2.weight());
      System.out.println(feline2.stealthed());
      
      // feline eat test
      Scanner in = new Scanner (System.in);
      Feline feline3 = new Feline();
      Vegetable vegetable1 = new Vegetable("Orange", "Crunchy", "Carrot", 5.0);
      Meat meat1 = new Meat("Beef", "Good", 6.0, 1.0, false);
      
      System.out.print("\nHow much of the carrot will " + feline3.name() + " eat in grams? ");
      
      // Ensures a valid input is typed
      while(true) {
         
         try {
         
            feline3.eat(vegetable1, Double.parseDouble(in.nextLine()));
            break;
            
         } catch (NumberFormatException e) {
         
            System.out.print("Invalid Input ");
         
         } // End try
         
      } // End while
      
      System.out.print("\nHow much of the beef will " + feline3.name() + " eat in grams? ");
      
      // Ensures a valid input is typed
      while(true) {
         
         try {
         
            feline3.eat(meat1, Double.parseDouble(in.nextLine()));
            break;
            
         } catch (NumberFormatException e) {
         
            System.out.print("Invalid Input ");
         
         } // End try
         
      } // End while
      
      
      // feline generation test
      // Initialization
      ArrayList<Feline> felines = new ArrayList<Feline>();
      
      // while loop to make infinite
      while (true) {
      
         // New feline
         felines.add (new Feline());
         
         // Operate on each feline
         for(int i = 0; i < felines.size(); i++) {
         
            felines.get(i).prance();
            felines.get(i).summary();
         
         } // End for
      
      } // End While
   
   } // End Main
   
} // End Class