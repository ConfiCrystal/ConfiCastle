/**
*  Name: Andy Lee
*  Date: October, 1, 2021
*  Program: Meat
*  Description: This program is a class for the meat object
*/

// imported libraries
import java.util.*;

// Meat Class
public class Meat {
   
   // Initialization
   // self explanatory strings
   private String type, taste, name;
   
   // self explanatory doubles
   private double weight, boneWeight;
   
   // self explanatory booleans
   private boolean hasBone, isPrepared;
   
   // Meat Main
   public static void main (String[] args) {
   
      // Nothing
   
   } // End Main

   /**
   * Method: Meat
   * @params N/A
   * @return N/A
   * Description: Constructor Method
   */
   public Meat () {
   
      this.type = "Meat";
      this.taste = "None";
      this.weight = 0.0;
      this.boneWeight = 0.0;
      this.hasBone = false;
      this.isPrepared = false;
      
      // Output
      System.out.println("\nThe Meat, " + this.type + ", has been created");
      
   } // End Meat
   
   /**
   * Method: Meat
   * @params N/A
   * @return N/A
   * Description: General Constructor Method
   */
   public Meat (String type, String taste, double weight, double boneWeight, boolean isPrepared) {
  
      this.type = type;
      this.taste = taste;
      this.weight = weight;
      this.boneWeight = boneWeight;
      this.isPrepared = isPrepared;
      
      // hasBone conditional
      if (boneWeight > 0) {
      
         hasBone = true;
      
      } // End if
      
      // Output
      System.out.println("\nThe Meat, " + this.type + ", has been created");
      
   } // End Feline
   
   // ------------------------------------------------ Mutators ------------------------------------------------
   
   /**
   * Method: weightChange
   * @params None
   * @return void
   * Description: Changes a meat's weight
   */
   public void weightChange () {
      
      // Initialization
      double weight;
      
      // Input
      weight = inputDouble("\nWhat is the " + this.type + "'s new weight in grams: ");
       
      // Output
      this.weight = weight;
      System.out.println("The " + this.type + "'s new weight is " + weight + " grams");
   
   } // End weightChange
   
   /**
   * Method: boneWeightChange
   * @params None
   * @return void
   * Description: Changes a meat's bone weight
   */
   public void boneWeightChange () {
      
      // Initialization
      double boneWeight;
      
      // Input
      boneWeight = inputDouble("\nWhat is the " + this.type + "'s new bone weight in grams: ");
       
      // Output
      this.boneWeight = boneWeight;
      System.out.println("The " + this.type + "'s new bone weight is " + weight + " grams");
      
      // hasBone conditional
      if (boneWeight <= 0) {
      
         hasBone = false;
         
      } // End if
   
   } // End boneWeightChange
   
   /**
   * Method: prepare
   * @params None
   * @return void
   * Description: Prepares a meat
   */
   public void prepare () {
   
      // Output
      this.isPrepared = true;
      System.out.println("\nThe " + this.type + " is now prepared");
   
   } // End prepare
   
   /**
   * Method: eaten
   * @params None
   * @return void
   * Description: Eats the meat
   */
   public void eaten () {
   
      // Output
      this.weight = this.boneWeight();
      System.out.println("\nThe " + this.type + " is now eaten");
   
   } // End eaten
   
   /**
   * Method: eaten
   * @params double size
   * @return void
   * Description: Eats a specific amount of grams of the meat
   */
   public void eaten (double size) {
   
      // Output
      this.weight -= size;
      System.out.println("\n" + size + " grams of the " + this.type + " is now eaten");
   
   } // End eaten
      
   // ------------------------------------------------ Accessors ------------------------------------------------
   
   /**
   * Method: summary
   * @params None
   * @return void
   * Description: Summarises a meat's attributes
   */
   public void summary () {
      
      // Output
      System.out.println("\nThis Meat has the following attributes:");
      System.out.println("Name: " + this.type);
      System.out.println("Taste: " + this.taste);
      System.out.println("Prepared: " + this.isPrepared);
      System.out.println("Has Bone: " + this.hasBone);
      System.out.printf("Bone Weight: %.2f grams%n", this.boneWeight);
      System.out.printf("Weight: %.2f grams%n", this.weight);
         
   } // End summary
   
   /**
   * Method: taste
   * @params None
   * @return String
   * Description: Gets a meat's taste
   */
   public String taste () {
      
      // Output
      return this.taste;
         
   } // End taste
   
   /**
   * Method: type
   * @params None
   * @return String
   * Description: Gets a meat's type
   */
   public String type () {
      
      // Output
      return this.type;
         
   } // End type
   
   /**
   * Method: weight
   * @params None
   * @return Double
   * Description: Gets a meat's weight
   */
   public double weight () {
      
      // Output
      return this.weight;
         
   } // End weight
   
   /**
   * Method: boneWeight
   * @params None
   * @return Double
   * Description: Gets a meat's bone weight
   */
   public double boneWeight () {
      
      // Output
      return this.boneWeight;
         
   } // End boneWeight
   
   /**
   * Method: isPrepared
   * @params None
   * @return boolean
   * Description: Finds if a meat is prepared or not
   */
   public boolean isPrepared () {
      
      // Output
      return this.isPrepared;
         
   } // End isPrepared
   
   /**
   * Method: hasBone
   * @params None
   * @return boolean
   * Description: Finds if a meat has bone or not
   */
   public boolean hasBone () {
      
      // Output
      return this.hasBone;
         
   } // End hasBone
   
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