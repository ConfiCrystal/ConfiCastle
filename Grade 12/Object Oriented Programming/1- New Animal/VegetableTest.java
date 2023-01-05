/**
*  Name: Andy Lee 
*  Date: October, 1, 2021
*  Program: VegetableTest
*  Description: This program is a test for the Vegetable class
*/

// Imported libraries
import java.util.*;

// VegetableTest Class
public class VegetableTest {
      
   // VegetableTest Main
   public static void main (String[] args) {
   
      // Mutator test
      Vegetable vegetable1 = new Vegetable("Orange", "Crunchy", "Carrot", 5.0);
      vegetable1.summary();
      vegetable1.weightChange();
      vegetable1.summary();
         
   } // End Main
   
} // End Class