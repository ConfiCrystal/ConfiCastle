/**
 * Name: Andy, Christine, Lisa
 * Date: November 23, 2021
 * Filename: Entity.java
 * Description: This class handles universal attributes and methods between entities
*/

import java.util.Scanner;

// Class
public class Entity {

  // Attributes --------------------
  private String name; // Stores the name of the entity
  private String skill; // Stores the skill of the entity
  private String burst; // Stores the burst of the entity
  private String element; // Stores the elemental attribute of this entity
  private String elementalAffliction; // Stores an element applied to this entity
  private int elementalInfusion; // Stores the state of whether or not the entity is infused with their element
  private Weapon weapon; // Stores the current weapon being used by the entity
  private int hp; // Stores the current health of the entity
  private int hpMax; // Stores the maximum health of the entity
  private int baseDamage; // Stores the unmodified damage of the entity
  private boolean defended; // Stores the state of whether or not the entity is defended;

  /**
   * Method: Entity
   * @params N/A
   * @return N/A
   * Description: Deafult Constructor
   */
   public Entity () {
   
      this.name = "";
      this.element = "";
      this.elementalInfusion = 0;
      this.elementalAffliction = "";
      this.weapon = new Weapon();
      this.hp = 0;
      this.hpMax = 0;
      this.baseDamage = 0;
      this.skill = "";
      this.burst = "";
      this.defended = false;
      
   } // End Entity

    // Mutators ------------------------------------------------------------
    /**
    * Method: Changes the name
    * @params String newName
    * @return void
    */
    public void changeName (String newName) {

      this.name = newName;

    }

    /**
    * Method: Changes the element
    * @params String newElement
    * @return void
    */
    public void changeElement (String newElement) {

      this.element = newElement;

    }

    /**
    * Method: Changes the elementalInfusion
    * @params int newElementalInfusion
    * @return void
    */
    public void changeElementalInfusion (int newElementalInfusion) {

      this.elementalInfusion = newElementalInfusion;

    }

    /**
    * Method: equips the weapon
    * @params Weapon newWeapon
    * @return void
    */
    public void changeWeapon (Weapon newWeapon) {

      this.changeBaseDamage(this.getBaseDamage() - this.getWeapon().getBaseAttack());
      this.changeBaseDamage(this.getBaseDamage() + newWeapon.getBaseAttack());
      
      this.weapon = newWeapon;

    }

    /**
    * Method: Changes the hp
    * @params int newHp
    * @return void
    */
    public void changeHp (int newHp) {

      this.hp = newHp;

    }

    /**
    * Method: Changes the hpMax
    * @params int newHpMax
    * @return void
    */
    public void changeHpMax (int newHpMax) {

      this.hpMax = newHpMax;

    }

    /**
    * Method: Changes the baseDamage
    * @params int newBaseDamage
    * @return void
    */
    public void changeBaseDamage (int newBaseDamage) {

      this.baseDamage = newBaseDamage;

    }

    /**
    * Method: Changes the defended state
    * @params boolean newDefended
    * @return void
    */
    public void changeDefended (boolean newDefended) {

      this.defended = newDefended;

    }

    /**
    * Method: Changes the skill
    * @params String newSkill
    * @return void
    */
    public void changeSkill (String newSkill) {

      this.skill = newSkill;

    }

    /**
    * Method: Changes the burst
    * @params String newBurst
    * @return void
    */
    public void changeBurst (String newBurst) {

      this.burst = newBurst;

    }

    /**
    * Method: Changes the elemental affliction
    * @params String newElementalAffliction
    * @return void
    */
    public void changeElementalAffliction (String newElementalAffliction) {

      this.elementalAffliction = newElementalAffliction;

    }

    // Accessors ------------------------------------------------------------
    /**
    * Method: Gets the name
    * @params N/A
    * @return String
    */
    public String getName () {

      return this.name;

    }

    /**
    * Method: Gets the element
    * @params N/A
    * @return String
    */
    public String getElement () {

      return this.element;

    }

    /**
    * Method: Gets the elementalInfusion
    * @params N/A
    * @return int
    */
    public int getElementalInfusion () {

      return this.elementalInfusion;

    }

    /**
    * Method: Gets the weapon
    * @params N/A
    * @return Weapon
    */
    public Weapon getWeapon () {

      return this.weapon;

    }

    /**
    * Method: Gets the hp
    * @params N/A
    * @return int
    */
    public int getHp () {

      return this.hp;

    }

    /**
    * Method: Gets the hpMax
    * @params N/A
    * @return int
    */
    public int getHpMax () {

      return this.hpMax;

    }

    /**
    * Method: Gets the baseDamage
    * @params N/A
    * @return int
    */
    public int getBaseDamage () {

      return this.baseDamage;

    }

    /**
    * Method: Gets the status of defence
    * @params N/A
    * @return boolean
    */
    public boolean getDefended () {

      return this.defended;

    }

    /**
    * Method: Gets the skill
    * @params N/A
    * @return String
    */
    public String getSkill () {

      return this.skill;

    }

    /**
    * Method: Gets the burst
    * @params N/A
    * @return String
    */
    public String getBurst () {

      return this.burst;

    }

    /**
    * Method: Gets the elementalAffliction
    * @params N/A
    * @return String
    */
    public String getElementalAffliction () {

      return this.elementalAffliction;

    }
    
    // Misc ------------------------------
    /**
    * Method: Gets a string of all attributes
    * @params N/A
    * @return String
    */
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

      return output;
      
    }

    /**
    * Method: An entity attacks, dealing damage based on base damage and bonus stats
    * @params Entity target, Combat combat, int index
    * @return void
    */
    public void attack (Entity target, Combat combat, int index, int times) {
      
      // Initialization
      Scanner in = new Scanner(System.in);
      boolean dead = false;

      // Calculates damage
      int damage = this.getBaseDamage();
      damage += this.getWeapon().getBaseAttack();

      // Accounts for skill levels of heroes
      if (this instanceof Hero) {

        Hero hero = (Hero)this;
        // +30% for each burst level above one
        if (times == 2) damage = damage + (int)(damage * 0.3 * (hero.getBurstLevel() - 1));
        // +20% for each skill level above one
        if (times == 1) damage = damage + (int)(damage * 0.2 * (hero.getSkillLevel() - 1));
        // +10% for each basic attack level above one
        if (times == 0) damage = damage + (int)(damage * 0.1 * (hero.getBasicAttackLevel() - 1));

      }

      // Accounts for defended
      if (target.getDefended() == true) damage = (int)(damage / 2);

      // Deals damage and prompts based on if the damage is lethal
      if (target.takeDamage(damage)) {
        
        System.out.println(this.getName() + " attacked " + target.getName()+ " for " + damage + " damage, killing them!");

        // Appropriately manages subject type
        if (index <= combat.turnPointer) combat.turnPointer--;
        combat.removeEntity(index);

        dead = true;

      } else {

        System.out.println(this.getName() + " attacked " + target.getName()+ " for " + damage + " damage! " + target.getName() + " now has " + target.getHp() + " health remaining!");

        // Deals with elemental infusions and reactions
        if (this.getElementalInfusion() != 0) {
          
          // If the target has no element, simply apply an element
          if (target.getElementalAffliction().equals("")) {

            target.changeElementalAffliction(this.getElement());

          // If the target has an element, trigger a reaction
          } else {

            // Crystalizes, healing the subject for 25% hp and giving them a shield from any excess
            if (reaction(this.getElement(), target.getElementalAffliction()).equals("crystalize")) {
              
              this.changeHp(this.getHp() + (int)(this.getHp() * 0.25));

              if (this.getHp() > this.getHpMax()) {

                System.out.println("The elements crystalize, healing " + this.getName() + " for 25% of their health and forming a shield from the excess!");

              } else {
                
                System.out.println("The elements crystalize, healing " + this.getName() + " for 25% of their health!");
              
              }

              target.changeElementalAffliction("");

              // Adds energy if the reaction triggerer is a hero
              if (this instanceof Hero) ((Hero)this).changeEnergy(((Hero)this).getEnergy() + 20);

            // Explodes, dealing damage to the target equal to 25% of their maxHp
            } else if (reaction(this.getElement(), target.getElementalAffliction()).equals("explosion")) {

              if (target.takeDamage((int)(target.getHpMax() * 0.25))) {
        
                System.out.println("The elements explode, damaging " + target.getName()+ " for " + damage + " damage, killing them!");

                // Appropriately manages subject type
                if (index <= combat.turnPointer) combat.turnPointer--;
                combat.removeEntity(index);

                dead = true;

              } else {

                System.out.println("The elements explode, damaging " + target.getName()+ " for " + damage + " damage! " + target.getName() + " now has " + target.getHp() + " health remaining!");
              }

              target.changeElementalAffliction("");

              // Adds energy if the reaction triggerer is a hero
              if (this instanceof Hero) ((Hero)this).changeEnergy(((Hero)this).getEnergy() + 20);

            }

          }

        } // End reactions

      }

      // Grants energy if the entity is a hero
      if (this instanceof Hero) {

        ((Hero)this).changeEnergy(((Hero)this).getEnergy() + 10);

      } 

      // Prompt
      System.out.print("Confirm: ");
      in.nextLine();
      System.out.println("");

      // For repetative attacks
      if (times > 0 && dead == false) {

        times--;
        attack(target, combat, index, times);

      }

    }

    /**
    * Method: Checks for a reaction
    * @params Entity target, Combat combat, int index
    * @return String
    */
    public String reaction (String element1, String element2) {
      
      // Crystalize, heals 25% hp, allows for overhealing
      if (element1.equalsIgnoreCase("geo") || element2.equalsIgnoreCase("geo")) {
        
        return "crystalize";

      // All other reactions trigger an explosion
      } else if (!element1.equalsIgnoreCase(element2)) {

        return "explosion";

      }

      return "";

    }

    /**
    * Method: An entity uses its elemental skill, infusing its weapon for this round and making two attack against a target
    * @params Entity target, Combat combat, int index
    * @return void
    */
    public void skill (Entity target, Combat combat, int index) {
      
      System.out.println(this.getName() + " uses their elemental skill, " + this.getSkill() + ", infusing their weapon with " + this.getElement() + " and attacking " + target.getName() + " twice!");

      this.changeElementalInfusion(this.getElementalInfusion() + 1);

      attack(target, combat, index, 1);

    }

    /**
    * Method: An entity uses its elemental burst, infusing its weapon for this round and making three attack against a target
    * @params Entity target, Combat combat, int index
    * @return void
    */
    public void burst (Entity target, Combat combat, int index) {
      
      System.out.println(this.getName() + " uses their elemental burst, " + this.getBurst() + ", infusing their weapon with " + this.getElement() + " and attacking " + target.getName() + " thrice!");

      this.changeElementalInfusion(this.getElementalInfusion() + 2);
      
      attack(target, combat, index, 2);

    }

    /**
    * Method: An entity defends, healing for a quarter of health and reducing incoming damage
    * @params N/A
    * @return void
    */
    public void defend () {
      
      // Initialization
      Scanner in = new Scanner(System.in);

      // Heals
      if (hp + (int)(hpMax*0.25) > hpMax) hp = hpMax;
      else hp += (int)(hpMax*0.25);

      // Prompts
      System.out.println(this.getName() + " is now defending!");

      // Defends
      this.changeDefended(true);

      // Prompt
      System.out.print("Confirm: ");
      in.nextLine();
      System.out.println("");

    }

    /**
    * Method: Causes an entity to take damage
    * @params int damage
    * @return boolean if the entity dies
    */
    public boolean takeDamage (int damage) {
      
      hp -= damage;

      if (hp <= 0) return true;
      return false;

    }

}