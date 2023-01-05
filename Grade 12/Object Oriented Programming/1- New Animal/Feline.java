/**
*  Name: Andy Lee & Shreya
*  Date: September, 29, 2021
*  Program: Feline
*  Description: This program is a class for the feline object
*/

// imported libraries
import java.util.*;

// Feline Class
public class Feline {
   
   // Initialization
   // furColour, eyeColour, and name are self explanatory strings attached to the object
   private String furColour, eyeColour, name;
   
   // killCount is a counter for how many things the object has killed
   private int killCount;
   
   // speed is in meters per second, weight is in kilograms, x, y, and z are coordinates on a 3-D plane in the unit of meters
   private double speed, weight, x, y, z;
   
   // A purely conceptual boolean representing whether or not the Feline is trying to conceal itself. While true, speed will be
   // half as effective
   private boolean stealthed;
   
   // Feline Main
   public static void main (String[] args) {
   
      // Nothing
   
   } // End Main

   /**
   * Method: Feline
   * @params N/A
   * @return N/A
   * Description: Constructor Method
   */
   public Feline () {
   
      this.name = "Feline";
      this.furColour = "None";
      this.eyeColour = "None";
      this.killCount = 0;
      this.x = 0.0;
      this.y = 0.0;
      this.z = 0.0;
      this.speed = 1.0;
      this.weight = 1.0;
      this.stealthed = false;
      
      // Output
      System.out.println("\nThe Feline, " + this.name + ", has been created");
      
   } // End Feline
   
   /**
   * Method: Feline
   * @params N/A
   * @return N/A
   * Description: General Constructor Method
   */
   public Feline (String name, String furColour, String eyeColour, int killCount, double x, double y, double z, double speed, double weight, boolean stealthed) {
  
      this.name = name;
      this.furColour = furColour;
      this.eyeColour = eyeColour;
      this.killCount = killCount;
      this.x = x;
      this.y = y;
      this.z = z;
      this.speed = speed;
      this.weight = weight;
      this.stealthed = stealthed;
      
      // Output
      System.out.println("\nThe Feline, " + this.name + ", has been created");
      
   } // End Feline
   
   // ------------------------------------------------ Mutators ------------------------------------------------
   /**
   * Method: kill
   * @params None
   * @return void
   * Description: Makes a feline kill a target
   */
   public void kill () {
      
      // Initialization
      Scanner in = new Scanner(System.in);
      String target;
      
      // Input
      System.out.print("\nWhat is " + this.name + "'s target: ");
      target = in.nextLine();
       
      // Output
      System.out.println(this.name + " killed " + target);
      this.killCount++;
      System.out.println(this.name + " now has " + this.killCount + " kills");
   
   } // End kill
   
   /**
   * Method: roar
   * @params double decibles
   * @return void
   * Description: Makes a feline roar at a specified decible level
   */
   public void roar () {
      
      // Initialization
      double decibles;
      
      // Input
      decibles = inputDouble("\nHow many decibles does this feline roar at: ");
      
      // Output
      System.out.println(this.name + " roared at " + decibles + " decibles");
   
   } // End roar
   
   /**
   * Method: prance
   * @params None
   * @return void
   * Description: Makes a feline prance (move) along the x and y coordinate plane based on a degree and distance measurement
   */
   public void prance () {
      
      // Initialization
      double degrees, distance;
      
      // Input
      degrees = inputDouble("\nAt what angle on the horizontal plane would you like this feline to prance: ");
      distance = inputDouble("How far would you like this feline to prance: ");
      
      // Processing
      double dx = Math.cos(Math.toRadians(degrees)) * distance;
      double dy = Math.sin(Math.toRadians(degrees)) * distance;
      
      this.x += dx;
      this.y += dy;
      
      // Modifies speed based on stealthed
      double time = 0;
      switch (String.valueOf(this.stealthed)) {
         
         // If stealthed, half speed
         case "true":
            time = distance / (speed / 2);
            break;
         
         // If not stealthed, full speed
         case "false":
            time = distance / speed;
            break;
      
      } // End switch
      
      // Output
      System.out.printf("%s pranced %.2f meters east, and %.2f meters north over %.2f seconds%n", this.name, dx, dy, time);
      System.out.printf("%s is now at the position (%.2f meters, %.2f meters)%n", this.name, this.x, this.y);
   
   } // End prance
   
   /**
   * Method: fall
   * @params None
   * @return void
   * Description: Makes a feline fall (move) along the z axis based on a distance measurement
   */
   public void fall () {
      
      // Initialization
      double distance;
      
      // Input
      distance = inputDouble("\nHow far would you like this feline to fall: ");
      
      // Processing
      this.z -= distance;
      
      // Modifies speed based on stealthed
      double time = 0;
      switch (String.valueOf(this.stealthed)) {
         
         // If stealthed, half speed
         case "true":
            time = distance / (speed / 2);
            break;
         
         // If not stealthed, full speed
         case "false":
            time = distance / speed;
            break;
      
      } // End switch

      // Output
      System.out.printf("%s fell %.2f meters over %.2f seconds%n", this.name, distance, time);
      System.out.printf("%s is now at the z position %.2f meters%n", this.name, this.z);
   
   } // End fall
   
   /**
   * Method: climb
   * @params None
   * @return void
   * Description: Makes a feline climb (move) along the z axis based on a distance measurement
   */
   public void climb () {
      
      // Initialization
      double distance;
      
      // Input
      distance = inputDouble("\nHow far would you like this feline to climb: ");
      
      // Processing
      this.z += distance;
      
      // Modifies speed based on stealthed
      double time = 0;
      switch (String.valueOf(this.stealthed)) {
         
         // If stealthed, half speed
         case "true":
            time = distance / (speed / 2);
            break;
         
         // If not stealthed, full speed
         case "false":
            time = distance / speed;
            break;
      
      } // End switch

      // Output
      System.out.printf("%s climbed %.2f meters over %.2f seconds%n", this.name, distance, time);
      System.out.printf("%s is now at the z position %.2f meters%n", this.name, this.z);
   
   } // End climb
   
   /**
   * Method: stalk
   * @params None
   * @return void
   * Description: Makes a feline enter or exit stealth mode
   */
   public void stalk () {
      
      // Checks if feline is already stealthed
      switch (String.valueOf(this.stealthed)) {
      
         case "true":
            // If the feline is already stealthed, it becomes not stealthed
            this.stealthed = false;
            System.out.println("\n" + this.name + " is no longer stealthed");
            break;
         
         case "false":
            // If the feline is not stealthed, it becomes stealthed
            this.stealthed = true;
            System.out.println("\n" + this.name + " is now stealthed");
            break;
      
      } // End switch
   
   } // End stalk
   
   /**
   * Method: eat
   * @params Meat meat
   * @return void
   * Description: Makes a feline eat a meat
   */
   public void eat (Meat meat) {
   
      System.out.println("\n" + this.name + " ate the " + meat.type());
      this.weight += meat.weight() - meat.boneWeight();
      meat.eaten();
   
   } // End eat
   
   /**
   * Method: eat
   * @params Meat meat, double size
   * @return void
   * Description: Makes a feline eat a specific amount of meat 
   */
   public void eat (Meat meat, double size) {
   
      // Ensures an impossible input is not possible
      if (size > meat.weight()) {
         this.eat(meat);
         return;
      } // End if
      
      if (size > meat.boneWeight()) size = meat.weight() - meat.boneWeight();
      
      System.out.println("\n" + this.name + " ate " + size + " grams of the " + meat.type());
      this.weight += size;
      meat.eaten(size);
   
   } // End eat
   
   /**
   * Method: eat
   * @params Vegetable vegetable
   * @return void
   * Description: Makes a feline eat a vegetable
   */
   public void eat (Vegetable vegetable) {
   
      System.out.println("\n" + this.name + " ate the " + vegetable.name());
      this.weight += vegetable.weight();
      vegetable.eaten();
   
   } // End eat
   
   /**
   * Method: eat
   * @params Vegetable vegetable, double size
   * @return void
   * Description: Makes a feline eat a specific amount of vegetable 
   */
   public void eat (Vegetable vegetable, double size) {
   
      // Ensures an impossible input is not possible
      if (size > vegetable.weight()) {
         this.eat(vegetable);
         return;
      } // End if
      
      System.out.println("\n" + this.name + " ate " + size + " grams of the " + vegetable.name());
      this.weight += size;
      vegetable.eaten(size);
   
   } // End eat

   
   // ------------------------------------------------ Accessors ------------------------------------------------
   
   /**
   * Method: summary
   * @params None
   * @return void
   * Description: Summarises a feline's attributes
   */
   public void summary () {
      
      // Output
      System.out.println("\nThis feline has the following attributes:");
      System.out.println("Name: " + this.name);
      System.out.println("Fur Colour: " + this.furColour);
      System.out.println("Eye Colour: " + this.eyeColour);
      System.out.println("Kill Count: " + this.killCount);
      System.out.printf("X Position: %.2f meters%n", this.x);
      System.out.printf("Y Position: %.2f meters%n", this.y);
      System.out.printf("Z Position: %.2f meters%n", this.z);
      System.out.printf("Speed: %.2f meters per second%n", this.speed);
      System.out.printf("Weight: %.2f kilograms%n", this.weight);
      
      // Output for stealthed
      switch (String.valueOf(this.stealthed)) {
      
         // If stealthed
         case "true":
            System.out.println("This feline is currently stealthed");
            break;
         
         // If not stealthed
         case "false":
            System.out.println("This feline is currently not stealthed");
            break;
      
      } // End switch
   
   } // End summary
   
   /**
   * Method: name
   * @params None
   * @return String
   * Description: Gets a feline's name
   */
   public String name () {
      
      // Output
      return this.name;
         
   } // End name
   
   /**
   * Method: furColour
   * @params None
   * @return String
   * Description: Gets a feline's furColour
   */
   public String furColour () {
      
      // Output
      return this.furColour;
         
   } // End furColour
   
   /**
   * Method: eyeColour
   * @params None
   * @return String
   * Description: Gets a feline's eyeColour
   */
   public String eyeColour () {
      
      // Output
      return this.eyeColour;
         
   } // End eyeColour
   
   /**
   * Method: killCount
   * @params None
   * @return int
   * Description: Gets a feline's killCount
   */
   public int killCount () {
      
      // Output
      return this.killCount;
         
   } // End killCount

   /**
   * Method: x
   * @params None
   * @return double
   * Description: Gets a feline's x position
   */
   public double x () {
      
      // Output
      return this.x;
         
   } // End x
   
   /**
   * Method: y
   * @params None
   * @return double
   * Description: Gets a feline's y position
   */
   public double y () {
      
      // Output
      return this.y;
         
   } // End y
   
   /**
   * Method: z
   * @params None
   * @return double
   * Description: Gets a feline's z position
   */
   public double z () {
      
      // Output
      return this.z;
         
   } // End z
   
   /**
   * Method: speed
   * @params None
   * @return double
   * Description: Gets a feline's speed
   */
   public double speed () {
      
      // Output
      return this.speed;
         
   } // End speed
   
   /**
   * Method: weight
   * @params None
   * @return double
   * Description: Gets a feline's weight
   */
   public double weight () {
      
      // Output
      return this.weight;
         
   } // End weight
   
   /**
   * Method: stealthed
   * @params None
   * @return boolean
   * Description: Finds if feline is stealthed or not
   */
   public boolean stealthed () {
      
      // Output
      return this.stealthed;
         
   } // End stealthed
   
   // ------------------------------------------------ Misc ------------------------------------------------
   
   /**
   * Method: inputInt
   * @params String prompt
   * @return int
   * Description: Gathers a positive integer input
   */
   private int inputInt (String prompt) {
      
      // Initialization
      Scanner in = new Scanner (System.in);
      String input;
      int inputInt;
      
      // Input
      System.out.print(prompt);
      input = in.nextLine();
      
      // Ensures a valid input is typed
      try {
         
         // Integer value of input
         inputInt = Integer.parseInt(input);
      
         // Ensures a positive input is typed
         if (inputInt < 0) {
         
            System.out.println("Invalid Input");
            return inputInt (prompt);
         
         } // End if
         
         return inputInt;
      
      } catch (NumberFormatException e) {
      
         System.out.println("Invalid Input");
         return inputInt (prompt);
      
      } // End try
   
   } // End inputInt
   
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