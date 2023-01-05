/**
*  Name: Andy, Christine, Lisa
*  Date: November, 23, 2021
*  Class: Hero
*  Description: This class allows for the creation and usage of heroes
*/

// Imported Classes
import java.io.*;
import java.util.ArrayList;

public class Hero extends Entity {

  // Attributes --------------------
  // Constant Stats ----------
  private int energyMax; // Stores the amount of energy needed to charge this hero's burst
  private int rarity; // Stores the rarity of the hero in stars
  private String basicAttack; // Stores the form of basic attack used by this hero

  // Progressive Stats ----------
  private boolean owned;
  private int level;
  private int ascensionLevel;

  private int basicAttackLevel; // Stores the level of the basic attack used by this hero
  private int skillLevel; // Stores the level of the elemental skill used by this hero
  private int burstLevel; // Stores the level of the elemental burst used by this hero
  
  // Volatile Stats----------
  private int energy;
  private ArrayList<Artifact> artifacts = new ArrayList<Artifact>();

  /**
   * Method: Hero
   * @params N/A
   * @return N/A
   * Description: Default Constructor
   */
   public Hero () {
   
      super();
      this.energyMax = 0;
      this.rarity = 0;
      this.basicAttack = "";
      this.owned = false;
      this.level = 0;
      this.ascensionLevel = 0;
      this.basicAttackLevel = 0;
      this.skillLevel = 0;
      this.burstLevel = 0;
      this.energy = 0;
      for (int i = 0; i < 5; i++) {
        this.artifacts.add(new Artifact());
      }
      
   } // End Hero

   /**
   * Method: retrieveBaseHero
   * @params String name, The name of the hero being retrieved
   * @return void
   * Description: Retrieves a base level hero from a properly formatted textfile
   */
   public void retrieveBaseHero (String name) {
     
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
      this.changeEnergyMax(Integer.parseInt(reader.readLine()));
      this.changeRarity(Integer.parseInt(reader.readLine()));
      this.changeBasicAttack(reader.readLine());
      this.changeSkill(reader.readLine());
      this.changeBurst(reader.readLine());
      this.changeOwned(Boolean.valueOf(reader.readLine()));
      this.changeLevel(Integer.parseInt(reader.readLine()));
      this.changeAscensionLevel(Integer.parseInt(reader.readLine()));
      this.changeBasicAttackLevel(Integer.parseInt(reader.readLine()));
      this.changeSkillLevel(Integer.parseInt(reader.readLine()));
      this.changeBurstLevel(Integer.parseInt(reader.readLine()));
      this.changeEnergy(Integer.parseInt(reader.readLine()));

      for (int i = 0; i < 5; i++) {

        this.changeArtifact(i, new Artifact());

      }

      // Closes the reader
      reader.close();

     } catch (IOException e) {

       

     }

   } // retrieveBaseHero

    // Mutators ------------------------------------------------------------
    /**
    * Method: Changes the energyMax
    * @params int newEnergyMax
    * @return void
    */
    public void changeEnergyMax (int newEnergyMax) {

      this.energyMax = newEnergyMax;

    }

    /**
    * Method: Changes the rarity
    * @params int newRarity
    * @return void
    */
    public void changeRarity (int newRarity) {

      this.rarity = newRarity;

    }

    /**
    * Method: Changes the basicAttack
    * @params String newBasicAttack
    * @return void
    */
    public void changeBasicAttack (String newBasicAttack) {

      this.basicAttack = newBasicAttack;

    }

    /**
    * Method: Changes the owned
    * @params boolean newOwned
    * @return void
    */
    public void changeOwned (boolean newOwned) {

      this.owned = newOwned;

    }

    /**
    * Method: Changes the level
    * @params int newLevel
    * @return void
    */
    public void changeLevel (int newLevel) {

      this.level = newLevel;

    }

    /**
    * Method: Changes the ascensionLevel
    * @params int newAscensionLevel
    * @return void
    */
    public void changeAscensionLevel (int newAscensionLevel) {

      this.ascensionLevel = newAscensionLevel;

    }

    /**
    * Method: Changes the basicAttackLevel
    * @params int newBasicAttackLevel
    * @return void
    */
    public void changeBasicAttackLevel (int newBasicAttackLevel) {

      this.basicAttackLevel = newBasicAttackLevel;

    }

    /**
    * Method: Changes the skillLevel
    * @params int newSkillLevel
    * @return void
    */
    public void changeSkillLevel (int newSkillLevel) {

      this.skillLevel = newSkillLevel;

    }

    /**
    * Method: Changes the burstLevel
    * @params int newBurstLevel
    * @return void
    */
    public void changeBurstLevel (int newBurstLevel) {

      this.burstLevel = newBurstLevel;

    }

    /**
    * Method: Changes the energy
    * @params int newEnergy
    * @return void
    */
    public void changeEnergy (int newEnergy) {

      this.energy = newEnergy;

    }

    /**
    * Method: Changes an artifact
    * @params int index, Artifact artifact
    * @return void
    */
    public void changeArtifact (int index, Artifact artifact) {
      
      // Removal of artifact stats
      int sum = this.artifacts.get(index).getMainStatValue();
      for (int i = 0; i < 4; i++) {
        sum += this.artifacts.get(index).getSubStatValues()[i];
      }
      this.changeBaseDamage(this.getBaseDamage() - sum);

      // Equipping of artifact
      sum = artifact.getMainStatValue();
      for (int i = 0; i < 4; i++) {
        sum += artifact.getSubStatValues()[i];
      }
      this.changeBaseDamage(this.getBaseDamage() + sum);

      this.artifacts.set(index, artifact);

    }

    // Accessors ------------------------------------------------------------
    /**
    * Method: Gets the energyMax
    * @params N/A
    * @return int
    */
    public int getEnergyMax () {

      return this.energyMax;

    }

    /**
    * Method: Gets the rarity
    * @params N/A
    * @return int
    */
    public int getRarity () {

      return this.rarity;

    }

    /**
    * Method: Gets the basicAttack
    * @params N/A
    * @return String
    */
    public String getBasicAttack () {

      return this.basicAttack;

    }

    /**
    * Method: Gets the owned
    * @params N/A
    * @return boolean
    */
    public boolean getOwned () {

      return this.owned;

    }

    /**
    * Method: Gets the level
    * @params N/A
    * @return int
    */
    public int getLevel () {

      return this.level;

    }

    /**
    * Method: Gets the ascensionLevel
    * @params N/A
    * @return int
    */
    public int getAscensionLevel () {

      return this.ascensionLevel;

    }

    /**
    * Method: Gets the basicAttackLevel
    * @params N/A
    * @return int
    */
    public int getBasicAttackLevel () {

      return this.basicAttackLevel;

    }

    /**
    * Method: Gets the skillLevel
    * @params N/A
    * @return int
    */
    public int getSkillLevel () {

      return this.skillLevel;

    }

    /**
    * Method: Gets the burstLevel
    * @params N/A
    * @return int
    */
    public int getBurstLevel () {

      return this.burstLevel;

    }

    /**
    * Method: Gets the energy
    * @params N/A
    * @return int
    */
    public int getEnergy () {

      return this.energy;

    }

    /**
    * Method: Gets the artifacts
    * @params N/A
    * @return ArrayList<Artifact>
    */
    public ArrayList<Artifact> getArtifacts () {

      return this.artifacts;

    }

   /**
    * Method: Gets an artifact
    * @params int index
    * @return Artifact
    */
    public Artifact getArtifact (int index) {

      return this.artifacts.get(index);

    }

    /**
    * Method: Gets a string of all attributes
    * @params N/A
    * @return String
    */
    public String toString () {
      
      // Initialization of output String
      String output = "";

      // Gathers all attributes inside this string
      output += "\n";
      output += "Name: " + this.getName() + "\n";
      output += "\n";
      output += "Element: " + this.getElement() + "\n";
      output += "Element Infused: " + this.getElementalInfusion() + "\n";
      output += "\n";
      output += "Basic Attack: " + this.getBasicAttack() + "\n";
      output += "Basic Attack Level: " + this.getBasicAttackLevel() + "\n";
      output += "\n";
      output += "Skill: " + this.getSkill() + "\n";
      output += "Skill Level: " + this.getSkillLevel() + "\n";
      output += "\n";
      output += "Burst: " + this.getBurst() + "\n";
      output += "Burst Level: " + this.getBurstLevel() + "\n";
      output += "\n";
      output += "Health: " + this.getHp() + "\n";
      output += "Max Health: " + this.getHpMax() + "\n";
      output += "Energy: " + this.getEnergy() + "\n";
      output += "Max Energy: " + this.getEnergyMax() + "\n";
      output += "Base Damage: " + this.getBaseDamage() + "\n";
      output += "\n";
      output += "Weapon: " + this.getWeapon() + "\n";
      output += "\n";
      
      for (int i = 0; i < 5; i++) {
        
        output += "Artifact #" + (i + 1) + ": " + this.getArtifact(i) + "\n";
        output += "\n";
      
      }

      output += "\n";
      output += "Rarity: " + this.getRarity() + " Stars\n";
      output += "Owned: " + this.getOwned() + "\n";
      output += "Level: " + this.getLevel() + "\n";
      output += "Ascension Level: " + this.getAscensionLevel() + "\n";

      return output;
      
    }

} // Class End