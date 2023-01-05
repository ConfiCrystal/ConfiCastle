/**
 * Name: Andy, Christine, Lisa
 * Date: November 23, 2021
 * Filename: Monster.java
 * Description: This is the Monster class which is a subclass of Entity.
*/

public class Monster extends Entity {

    // Attributes
    private String type;

    /**
   * Method: Entity
   * @params N/A
   * @return N/A
   * Description: Deafult Constructor
   */
    public Monster() {

      super();
      this.type = "";

    }

    // Mutators ------------------------------------------------------------
    /**
    * Method: Changes the type
    * @params String newType
    * @return void
    */
    public void changeType (String newType) {

      this.type = newType;

    }

    // Accessors ------------------------------------------------------------
    /**
    * Method: Gets the type
    * @params N/A
    * @return String
    */
    public String getType () {

      return this.type;

    }

    public String toString () {

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
      output += "Type: " + this.getType();

      return output;
      
    }
    
}