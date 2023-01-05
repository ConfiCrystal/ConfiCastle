/**
*  Name: Andy Lee
*  Date: October, 1, 2021
*  Program: Vegetable
*  Description: This program is a class for the vegetable object
*/

// imported libraries
import java.util.*;

// Vegetable Class
public class Vegetable {
   
   // Initialization
   // self explanatory strings
   private String colour, taste, name;
   
   // self explanatory double
   private double weight;
   
   // Vegetable Main
   public static void main (String[] args) {
   
      // Nothing
   
   } // End Main

   /**
   * Method: Vegetable
   * @params N/A
   * @return N/A
   * Description: Constructor Method
   */
   public Vegetable () {
   
      this.colour = "None";
      this.taste = "None";
      this.name = "Vegetable";
      this.weight = 0.0;
      
      // Output
      System.out.println("\nThe Vegetable, " + this.name + ", has been created");
      
   } // End Vegetable
   
   /**
   * Method: Vegetable
   * @params N/A
   * @return N/A
   * Description: General Constructor Method
   */
   public Vegetable (String colour, String taste, String name, double weight) {
  
      this.colour = colour;
      this.taste = taste;
      this.name = name;
      this.weight = weight;
      
      // Output
      System.out.println("\nThe Vegetable, " + this.name + ", has been created");
      
   } // End Feline
   
   // ------------------------------------------------ Mutators ------------------------------------------------
   
   /**
   * Method: weightChange
   * @params None
   * @return void
   * Description: Changes a vegetable's weight
   */
   public void weightChange () {
      
      // Initialization
      double weight;
      
      // Input
      weight = inputDouble("\nWhat is the " + this.name + "'s new weight in kilograms: ");
       
      // Output
      this.weight = weight;
      System.out.println("The " + this.name + "'s new weight is " + weight + " kilograms");
   
   } // End weightChange
   
   /**
   * Method: eaten
   * @params None
   * @return void
   * Description: Eats the vegetable
   */
   public void eaten () {
   
      // Output
      this.weight = 0.0;
      System.out.println("\nThe " + this.name + " is now eaten");
   
   } // End eaten
   
   /**
   * Method: eaten
   * @params double size
   * @return void
   * Description: Eats a specific amount of grams of the vegetable
   */
   public void eaten (double size) {
   
      // Output
      this.weight -= size;
      System.out.println("\n" + size + " grams of the " + this.name + " is now eaten");
   
   } // End eaten
      
   // ------------------------------------------------ Accessors ------------------------------------------------
   
   /**
   * Method: summary
   * @params None
   * @return void
   * Description: Summarises a vegetable's attributes
   */
   public void summary () {
      
      // Output
      System.out.println("\nThis Vegetable has the following attributes:");
      System.out.println("Colour: " + this.colour);
      System.out.println("Taste: " + this.taste);
      System.out.println("Name: " + this.name);
      System.out.printf("Weight: %.2f kilograms%n", this.weight);
         
   } // End summary
   
   /**
   * Method: colour
   * @params None
   * @return String
   * Description: Gets a vegetable's colour
   */
   public String colour () {
      
      // Output
      return this.colour;
         
   } // End colour
   
   /**
   * Method: taste
   * @params None
   * @return String
   * Description: Gets a vegetable's taste
   */
   public String taste () {
      
      // Output
      return this.taste;
         
   } // End taste
   
   /**
   * Method: name
   * @params None
   * @return String
   * Description: Gets a vegetable's name
   */
   public String name () {
      
      // Output
      return this.name;
         
   } // End name
   
   /**
   * Method: weight
   * @params None
   * @return Double
   * Description: Gets a vegetable's weight
   */
   public double weight () {
      
      // Output
      return this.weight;
         
   } // End weight
   
   // ------------------------------------------------ Misc ------------------------------------------------
      
   /**
   * Method: inputDouble
   * @params String prompt
   * @return Double
   * Description: Gathers a positive Double input
   */
   private double inputDouble (String prompt) {
      
      // Initialization
      Scanner in = new Scanner (System.in);
      String input;
      double inputDouble;
      
      // Input
      System.out.print(prompt);
      input = in.nextLine();
      
      // Ensures a valid input is typed
      try {
         
         // Integer value of input
         inputDouble = Double.parseDouble(input);
      
         // Ensures a positive input is typed
         if (inputDouble < 0) {
         
            System.out.println("Invalid Input");
            return inputDouble (prompt);
         
         } // End if
         
         return inputDouble;
      
      } catch (NumberFormatException e) {
      
         System.out.println("Invalid Input");
         return inputDouble (prompt);
      
      } // End try
   
   } // End inputDouble
   
} // End Class