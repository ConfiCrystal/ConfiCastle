/**
*  (THIS IS A CLASS TEST I MADE FOR CHERRY'S CLASS)
*  Name: Andy Lee
*  Date: October, 12, 2021
*  Program: FurryMammalTest
*  Description: This program is a test for the Furry Mammal Class
*/

// Furry Mammal Class
public class FurryMammalTest {

   // Furry Mammal Main
   public static void main (String [] args)
   {
      
      // Basic Test
      FurryMammal furryMammal1 = new FurryMammal("a", "b", "c", "d", 12, 50);         
       
      System.out.println(furryMammal1);
      furryMammal1.play(2);
      furryMammal1.setFavActivity ("war");
      System.out.println(furryMammal1.getFavActivity());
      
      // Eat test
      Meat meat1 = new Meat("beef", "uwu" , 7, 5, true);
      Vegetable vegetable1 = new Vegetable("ha", "fear", "me", 4);

      furryMammal1.eat(vegetable1);
      System.out.println("The weight of the vegetable " + vegetable1.name() + " is " + vegetable1.weight());
      
      furryMammal1.eat(meat1);
      System.out.println("The weight of the meat " + meat1.type() + " is " + meat1.weight());
      
      System.out.println("\nThe weight of the animal is now " + furryMammal1.getWeight());       
   
   }
   
}