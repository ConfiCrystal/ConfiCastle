/**
*  Name: Andy Lee
*  Date: September, 28, 2021
*  Program: CatTest
*  Description: This program is a test for the cat class
*/

// CatTest Class
public class CatTest {
   
   // Cat Test Main
   public static void main (String[] args) {
   
      // Initialization
      Cat owo = new Cat();
      owo.name = "AAAAAA";
      owo.food = "Styrofoam";
      owo.size = "Unimaginably large";
      owo.colour = "All of them";
      owo.breed = "Eldritch monstrosity";
      owo.age = 2000000000;
      owo.sex = 'E';
      owo.weight = 20000002;
      
      Cat uwu = new Cat();
      uwu.name = "BCDEFGHIJKLMNOPQRSTUVWXYZ";
      uwu.food = "Not styrofoam";
      uwu.size = "Microscopic";
      uwu.colour = "Vanta black";
      uwu.breed = "Rat";
      uwu.age = -74;
      uwu.sex = 'G';
      uwu.weight = 1.1111111;
      
      // Processing
      owo.sleep();
      owo.eat(15);
      uwu.poop(15);
      System.out.println("");
      
      // Output
      System.out.println("Name: " + owo.name);
      System.out.println("Favourite Food: " + owo.food);
      System.out.println("Size: " + owo.size);
      System.out.println("Colour: " + owo.colour);
      System.out.println("Breed: " + owo.breed);
      System.out.println("Age: " + owo.age);
      System.out.println("Sex: " + owo.sex);
      System.out.println("Weight: " + owo.weight);
      
      System.out.println("");
      System.out.println("Name: " + uwu.name);
      System.out.println("Favourite Food: " + uwu.food);
      System.out.println("Size: " + uwu.size);
      System.out.println("Colour: " + uwu.colour);
      System.out.println("Breed: " + uwu.breed);
      System.out.println("Age: " + uwu.age);
      System.out.println("Sex: " + uwu.sex);
      System.out.println("Weight: " + uwu.weight);
      
      System.out.println("");
      // Outputs if owo is sleeping
      switch (String.valueOf(owo.sleeping)) {
         case "true":
            System.out.println(owo.name + " is sleeping");
            break;
         case "false":
            System.out.println(owo.name + " is awake");
            break;
      }
      
      // Outputs if uwu is sleeping
      switch (String.valueOf(uwu.sleeping)) {
         case "true":
            System.out.println(uwu.name + " is sleeping");
            break;
         case "false":
            System.out.println(uwu.name + " is awake");
            break;
      }
   
      // Low input test
      Cat abc = new Cat();
      System.out.println("\n" + abc.name);
      
      // Fill test
      Cat fear = new Cat("No", "No", "No", "No", "No", 0, 'N', 0.0, false);
      System.out.println("\n" + fear.name);
      
      // Eat test
      Cat test = new Cat();
      Meat meat1 = new Meat("Beef", "Yum", 5.0, 2.0, false);
      test.eat(meat1, 6.0);
      meat1.summary();
      test.summary();
      
      Vegetable vegetable1 = new Vegetable("Orange", "Crunchy", "Carrot", 5.0);
      test.eat(vegetable1, 6);
      vegetable1.summary();
      test.summary();
      
   } // End Main
   
} // End Class