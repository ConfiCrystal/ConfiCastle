/**
*  Name: Andy Lee 
*  Date: October, 1, 2021
*  Program: MeatTest
*  Description: This program is a test for the Meat class
*/

// Imported libraries
import java.util.*;

// MeatTest Class
public class MeatTest {
      
   // MeatTest Main
   public static void main (String[] args) {
   
      // Mutator test
      Meat meat1 = new Meat("Beef", "Tender", 5.0, 2.0, false);
      meat1.summary();
      meat1.weightChange();
      meat1.boneWeightChange();
      meat1.prepare();
      meat1.summary();
         
   } // End Main
   
} // End Class