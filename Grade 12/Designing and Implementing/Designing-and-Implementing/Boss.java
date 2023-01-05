/**
 * Name: Andy, Christine, Lisa 
 * Date: November 23, 2021 
 * Filename: Boss.java
 * Description: This is the Boss class which is a subclass of Monster.
 */

import java.io.*;

public class Boss extends Monster {
  
  // Attributes
  private int energyMax;
  private int energy;

  /**
   * Method: Boss
   * @params N/A
   * @return N/A
   * Description: Deafult Constructor
   */
  public Boss() {

    super();

  }

  /**
   * Method: retrieveBaseBoss
   * @params String name, The name of the boss being retrieved
   * @return void
   * Description: Retrieves a base level boss from a properly formatted textfile
   */
   public void retrieveBaseBoss (String name) {
     
     try {

     // To read from the file
      BufferedReader reader = new BufferedReader(new FileReader((name + ".txt")));
      
      // Fills in stored hero info from base file
      this.changeName(reader.readLine());
      this.changeElement(reader.readLine());
      this.changeElementalInfusion(Integer.parseInt(reader.readLine()));
      this.changeWeapon(new Weapon());
      this.changeHp(Integer.parseInt(reader.readLine()));
      this.changeHpMax(Integer.parseInt(reader.readLine()));
      this.changeBaseDamage(Integer.parseInt(reader.readLine()));
      this.changeSkill(reader.readLine());
      this.changeBurst(reader.readLine());

      // Closes the reader
      reader.close();

     } catch (IOException e) {

     }

   } // retrieveBaseHero

  public String toString() {

      // Initialization of output String
      String output = "";

      // Gathers all attributes inside this string
      output += "Name: " + this.getName() + "\n";
      output += "\n";
      output += "Element: " + this.getElement() + "\n";
      output += "Element Infused: " + this.getElementalInfusion() + "\n";
      output += "Health: " + this.getHp() + "\n";
      output += "Max Health: " + this.getHpMax() + "\n";
      output += "Base Damage: " + this.getBaseDamage() + "\n";
      output += "Weapon: " + this.getWeapon() + "\n";
      output += "Type: " + this.getType() + "\n";
      output += "Skill: " + this.getSkill() + "\n";
      output += "Burst: " + this.getBurst();

      return output;

  }
  
}