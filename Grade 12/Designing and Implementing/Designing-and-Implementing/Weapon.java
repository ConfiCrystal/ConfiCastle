/**
 * Name: Andy, Christine, Lisa
 * Date: November 23, 2021
 * Filename: Weapon.java
 * Description: This class handles the storage and applications of weapons
*/

import java.util.ArrayList;

public class Weapon extends Item{

  //attributes
   private String type;
   private int refinement; // Future sprint property
   private int level; // Future sprint property
   private int baseAttack;
   private String secondaryTrait; // Future sprint property
   private int secondaryTraitValue; // Future sprint property

  //default constructor
   public Weapon () {

      this.changeName("Dull blade");
      this.type = "";
      this.refinement = 0;
      this.level = 1;
      this.baseAttack = 0;
      this.secondaryTrait = "";
      this.secondaryTraitValue = 0;

   }

   //accessor methods
   public String getType(){

      return this.type;

   }

   public int getRefinement(){

      return this.refinement;

   }

   public int getLevel(){

      return this.level;

   }

   public int getBaseAttack(){

      return this.baseAttack;

   }

   public String getSecondaryTrait(){

      return this.secondaryTrait;

   }
   public int getSecondaryTraitValue(){

      return this.secondaryTraitValue;

   }
   
   //mutator methods
   public void changeRefinement(){

      this.refinement += 1;

   }

   public void changeLevel(int newLevel){

      this.level = newLevel;

   }

   public void changeBaseAttack(int newBaseAttack){

      this.baseAttack = newBaseAttack;

   }

   public void changeSecondaryTrait(String newSecondaryTrait){

      this.secondaryTrait = newSecondaryTrait;

   }

   public void changeSecondaryTraitValue(int newSecondaryTraitValue){

      this.secondaryTraitValue = newSecondaryTraitValue;

   }
   
   //methods
   /**
   * Method: levelUp
   * @params ArrayList<ExpMaterial> expMaterials
   * @return N/A
   * Description: this method levels up a weapon and outputs an appropriate response
   */
   public void levelUp (ArrayList<ExpMaterial> expMaterials) {

      System.out.println (this.getName() + " was leveled up");

   }

   /**
   * Method: ascend
   * @params ArrayList<Ascension> ascension
   * @return N/A
   * Description: this method ascends a weapon and outputs an appropriate response
   */
   public void ascend (ArrayList<Ascension> ascension) {

      System.out.println (this.getName() + " was ascended");

   }
   
   /**
   * Method: refine
   * @params Weapon weapon
   * @return N/A
   * Description: this method refines a weapon and outputs an appropriate response
   */
   public void refine (Weapon weapon) {

      System.out.println (this.getName() + " was refined");
      this.refinement += 1;

   }
   
   /*
    * Method: Default toString
    * @return ret This Weapono's attributes
    */
   public String toString(){

      String ret = "\nWeapon\nName: " + this.getName() + "\ntype: " + this.getType() + "\nrefinement: " + this.getRefinement() + "\nlevel: " + this.getLevel() + "\nbase attack: " + this.getBaseAttack() + "\nsecondary trait: " + this.getSecondaryTrait() + "\nrarity: " + this.getRarity() + "\nsecondary trait value: " + this.getSecondaryTraitValue();
      
      return ret;

   }
   
}