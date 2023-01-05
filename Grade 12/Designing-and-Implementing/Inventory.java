/**
 * Name: Andy, Christine, Lisa
 * Date: November 23, 2021
 * Filename: Inventory.java
 * Description: This is the Inventory class.
*/

import java.util.*;

public class Inventory {

   //attributes
   // currency interaction not implemented
   private int mora;
   private int primogems;
   private int genesisCrystals;
   private int starglitter;
   private int stardust;
   private ArrayList <Item> items = new ArrayList<Item>();
   
   //default constructor
   public Inventory(){

      this.mora = 0;
      this.primogems = 0;
      this.genesisCrystals = 0;
      this.starglitter = 0;
      this.stardust = 0;

   }
   
   //accessor methods
   public int getMora(){

      return this.mora;

   }

   public int getPrimogems(){

      return this.primogems;

   }

   public int getGenesisCrystals(){

      return this.genesisCrystals;

   }

   public int getStarglitter(){

      return this.starglitter;

   }

   public int getStardust(){

      return this.stardust;

   }

   public ArrayList<Item> getItems(){

      return this.items;

   }
   
   public Item getItem(int index){

      return this.items.get(index);

   }

   public int getSize(){

      return this.items.size();

   }

   public void removeItem(int index){

      this.items.remove(index);

   }
   
   //mutator methods
   public void changeMora(int newMora){

      this.mora = newMora;

   }

   public void changePrimogems(int newPrimogems){

      this.primogems = newPrimogems;

   }

   public void changeGenesisCrystals(int newGenesisCrystals){

      this.genesisCrystals = newGenesisCrystals;

   }

   public void changeStarglitter(int newStarglitter){

      this.starglitter = newStarglitter;

   }

   public void changeStardust(int newStardust){

      this.stardust = newStardust;

   }
   
   public void addItem(Item newItem){

      this.items.add(newItem);

   }
   
   //methods
   /**
   * Method: drop
   * @params int index
   * @return N/A
   * Description: outputs message when item is dropped
   */
   public void drop(int index){

     System.out.println(items.get(index).getName() + " was dropped");

   }
   
   /*
    * Method: Default toString
    * @return ret This inventory's attributes
    */
   public String toString(){

      String ret = "Mora: " + this.getMora() + "\nprimogems: " + this.getPrimogems() + "\ngenesis crystals: " + this.getGenesisCrystals() + "\nstarglitter: " + this.getStarglitter() + "\nstardust: " + this.getStardust() + "\nitems: " + this.getItems();
      
      return ret;

   }

}