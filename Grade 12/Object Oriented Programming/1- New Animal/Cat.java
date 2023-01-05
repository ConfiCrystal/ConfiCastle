/**
*  Name: Andy Lee
*  Date: September, 28, 2021
*  Program: Cat
*  Description: This program is a class for the cat object
*/

// Imported libraries
import java.util.*;

// Cat Class
public class Cat {
   
   // Initialization
   String name, food, size, colour, breed;
   int age;
   char sex;
   double weight;
   boolean sleeping;
   
   // Cat Main
   public static void main (String[] args) {
   
      // Nothing
   
   } // End Main

   /**
   * Method: Cat
   * @params N/A
   * @return N/A
   * Description: Constructor Method
   */
   public Cat () {
   
      this.name = "Cat";
      this.food = "None";
      this.size = "None";
      this.colour = "None";
      this.breed = "None";
      this.age = 0;
      this.sex = 'N';
      this.weight = 0.0;
      this.sleeping = false;
      
   } // End Cat
   
   /**
   * Method: Cat
   * @params N/A
   * @return N/A
   * Description: General Constructor Method
   */
   public Cat (String name, String food, String size, String colour, String breed, int age, char sex, double weight, boolean sleeping) {
  
      this.name = name;
      this.food = food;
      this.size = size;
      this.colour = colour;
      this.breed = breed;
      this.age = age;
      this.sex = sex;
      this.weight = weight;
      this.sleeping = sleeping;
      
   } // End Cat
   
   // ------------------------------------------------ Mutators ------------------------------------------------
   
   /**
   * Method: sleep
   * @params N/A
   * @return void
   * Description: Makes a cat sleep
   */
   public void sleep () {
      
      System.out.println(this.name + " is now sleeping");
      this.sleeping = true;
   
   } // End sleep
   
   /**
   * Method: eat
   * @params int grams
   * @return void
   * Description: Makes a cat eat
   */
   public void eat (int grams) {
   
      System.out.println(this.name + " ate " + grams + " grams of food");
      this.weight += grams;
   
   } // End eat
   
   /**
   * Method: eat
   * @params Meat meat
   * @return void
   * Description: Makes a cat eat a meat
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
   * Description: Makes a cat eat a specific amount of meat 
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
   * Description: Makes a cat eat a vegetable
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
   * Description: Makes a cat eat a specific amount of vegetable 
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
   
   /**
   * Method: poop
   * @params int grams
   * @return void
   * Description: Makes a cat poop
   */
   public void poop (int grams) {
   
      System.out.println(this.name + " pooped " + grams + " grams of poop");
      this.weight -= grams;
   
   } // End poop
   
   // ------------------------------------------------ Accessors ------------------------------------------------
   
   /**
   * Method: summary
   * @params None
   * @return void
   * Description: Summarises a cat's attributes
   */
   public void summary () {
      
      // Output
      System.out.println("\nThis Cat has the following attributes:");
      System.out.println("Name: " + this.name);
      System.out.println("Food: " + this.food);
      System.out.println("Size: " + this.size);
      System.out.println("Colour: " + this.colour);
      System.out.println("Breed: " + this.breed);
      System.out.println("Age: " + this.age);
      System.out.println("Sex: " + this.sex);
      System.out.printf("Weight: %.2f kilograms%n", this.weight);
      System.out.println("Sleeping: " + this.sleeping);
         
   } // End summary
   
   /**
   * Method: name
   * @params None
   * @return String
   * Description: Gets a cat's name
   */
   public String name () {
      
      // Output
      return this.name;
         
   } // End name
   
   /**
   * Method: food
   * @params None
   * @return String
   * Description: Gets a cat's favourite food
   */
   public String food () {
      
      // Output
      return this.food;
         
   } // End food
   
   /**
   * Method: size
   * @params None
   * @return String
   * Description: Gets a cat's size
   */
   public String size () {
      
      // Output
      return this.size;
         
   } // End size
   
   /**
   * Method: colour
   * @params None
   * @return String
   * Description: Gets a cat's colour
   */
   public String colour () {
      
      // Output
      return this.colour;
         
   } // End colour
   
   /**
   * Method: breed
   * @params None
   * @return String
   * Description: Gets a cat's breed
   */
   public String breed () {
      
      // Output
      return this.breed;
         
   } // End breed
   
   /**
   * Method: age
   * @params None
   * @return int
   * Description: Gets a cat's age
   */
   public int age () {
      
      // Output
      return this.age;
         
   } // End age
   
   /**
   * Method: sex
   * @params None
   * @return char
   * Description: Gets a cat's sex
   */
   public char sex () {
      
      // Output
      return this.sex;
         
   } // End sex
   
   /**
   * Method: weight
   * @params None
   * @return double
   * Description: Gets a cat's weight
   */
   public double weight () {
      
      // Output
      return this.weight;
         
   } // End weight
   
   /**
   * Method: sleeping
   * @params None
   * @return boolean
   * Description: Gets a cat's sleeping
   */
   public boolean sleeping () {
      
      // Output
      return this.sleeping;
         
   } // End sleeping
   
} // End Class