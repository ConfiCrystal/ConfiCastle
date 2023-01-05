/**
 * Name: Andy, Christine, Lisa
 * Date: November 23, 2021
 * Filename: Combat.java
 * Description: This Class represents the system that managaes and creates combates
*/

// Imported Classes
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Combat {
    
  // Attributes --------------------
  private ArrayList<Hero> heroes = new ArrayList<Hero>();
  private ArrayList<Monster> monsters = new ArrayList<Monster>();
  private ArrayList<Entity> turnOrder = new ArrayList<Entity>();
  private Location location = new Location();
  int turnPointer;

  /**
   * Method: Combat
   * @params N/A
   * @return N/A
   * Description: Default Constructor
   */
   public Combat () {

     turnPointer = 0;
      
   } // Combat

   /**
   * Method: Combat
   * @params N/A
   * @return N/A
   * Description: General Constructor
   */
   public Combat (Location location) {
     
     turnPointer = 0;
     this.changeLocation(location);

    // Adds rewards
     ((Domain)location).getChest(0).refill();

     // Adds monsters and players
     this.addMonsters(location.getMonsters());

     for (Player player : this.location.getPlayers()) {

       this.addPlayer(player);

     }
     
   } // Combat

    // Mutators ------------------------------
    /**
    * Method: Adds a player's heroes
    * @params Player player
    * @return void
    */
    public void addPlayer (Player player) {

      for (int i = 0; i < 4; i++) {        
      
      this.heroes.add(player.getActiveHero(i));

      }

    }

    /**
    * Method: Adds a location's monsters
    * @params ArrayList<Monster> monsters
    * @return void
    */
    public void addMonsters (ArrayList<Monster> monsters) {

      this.monsters = monsters;

    }

    /**
    * Method: Removes a player
    * @params int index
    * @return void
    */
    public void removeHero (int index) {

      this.heroes.remove(index);

    }

    /**
    * Method: Adds a monster
    * @params Monster monster
    * @return void
    */
    public void addMonster (Monster monster) {

      this.monsters.add(monster);

    }

    /**
    * Method: Removes a monster
    * @params int index
    * @return void
    */
    public void removeMonster (int index) {

      this.monsters.remove(index);

    }

    /**
    * Method: Adds an entity in turn order
    * @params Entity entity
    * @return void
    */
    public void addEntity (Entity entity) {

      this.turnOrder.add(entity);

    }

    /**
    * Method: Removes an entity in turn order
    * @params int index
    * @return void
    */
    public void removeEntity (int index) {

      this.turnOrder.remove(index);

    }

    /**
    * Method: Changes the location
    * @params Location location
    * @return void
    */
    public void changeLocation (Location location) {

      this.location = location;

    }

    // Accessors ------------------------------
   /**
    * Method: Gets a hero
    * @params int index
    * @return Hero
    */
    public Hero getHero (int index) {

      return this.heroes.get(index);

    }

    /**
    * Method: Gets a monster
    * @params int index
    * @return Monster
    */
    public Monster getMonster (int index) {

      return this.monsters.get(index);

    }

    /**
    * Method: Gets an entity in turn order
    * @params int index
    * @return Entiy
    */
    public Entity getEntity (int index) {

      return this.turnOrder.get(index);

    }

    /**
    * Method: Gets the location
    * @params N/A
    * @return Location
    */
    public Location getLocation () {

      return this.location;

    }

    /**
    * Method: Gets the turn order
    * @params N/A
    * @return Locaiton
    */
    public ArrayList<Entity> getTurnOrder () {

      return this.turnOrder;

    }

    // Misc ------------------------------

  /**
    * Method: Begins a combat
    * @params Game game
    * @return void
    */
    public void beginCombat (Game game) {

      // Initialization
      Scanner in = new Scanner (System.in);
      
      // Prevents invalid heroes
      ArrayList<Integer> marks = new ArrayList<Integer>();
      for (int i = 0; i < heroes.size(); i++) {

        if (this.getHero(i).getName().equals("")||this.getHero(i).getHp()<=0) marks.add(i);

      }

      for (int i = 0; i < marks.size(); i++) {

        this.removeHero(marks.get(i) - i);

      }
      
      this.setOrder();

      // Combat prompt
      System.out.println("You have entered combat!");
      System.out.println("The entities in combat in turn order are as follows:");
      System.out.println(this.toString());
      System.out.print("Confirm");
      in.nextLine();
      System.out.println("");

      // Sets the turn to the first in line
      turnPointer = 0;

      // Runs the turns of the combat
      turn(game);

    }

    /**
    * Method: Sets the order of a combat
    * @params N/A
    * @return void
    */
    public void setOrder () {
      
      // Initialization
      this.turnOrder.clear();
      int count = heroes.size() + monsters.size();
      Random r = new Random();

      // Loops through each entity in the combat object and randomly chooses one at a time for turn order
      ArrayList<Integer> visited = new ArrayList<Integer>();
      for (int i = count; i > 0; i--) {

        int operator = r.nextInt(i);

        // Checks for already selected entities
        outer:
        while (true) {

          for (int j = 0; j < visited.size(); j++) {

            if (operator == visited.get(j)) {

              operator--;

              if (operator < 0) {

                operator = visited.size();

              }
                
              continue outer;

            }

          }

          break;

        }

        // Distinguishes between hero and monster
        if (operator >= heroes.size()) {

          visited.add(operator);
          operator = operator - heroes.size();
          this.addEntity(this.getMonster(operator));

        } else {

          this.addEntity(this.getHero(operator));
          visited.add(operator);

        }

      }

    }

    /**
    * Method: Runs a turns in combat recursively
    * @params Game game
    * @return void
    */
    public void turn (Game game) {
      
      // Ends the combat if one side has completely left combat
      int heroes = 0;
      int monsters = 0;

      for (int i = 0; i < turnOrder.size(); i++) {

        if (this.getEntity(i) instanceof Hero) heroes++;
        else monsters++;
      
      }

      if (heroes == 0) {

        this.complete(false, game); 
        return;

      }

      if (monsters == 0) {
        
        this.complete(true, game); 
        return;

      }

      // Storage of reference
      Entity entity = this.getEntity(turnPointer);

      // Resets one turn effects at the start of turn
      // Resets defence
      if (entity.getDefended() == true) {

        System.out.println(entity.getName() + " is no longer defending!");
        entity.changeDefended(false);

      }
      // Resets infusion
      if (entity.getElementalInfusion() > 0) {
        
        entity.changeElementalInfusion(entity.getElementalInfusion() - 1);

        if (entity.getElementalInfusion() == 0) {

          System.out.println(entity.getName() + "'s weapon is no longer infused!");

        } else {

          System.out.println(entity.getName() + "'s weapon has lost a turn of infusion!");
          
        }

      }

      // Action menu if the current turn is held by a hero
      if (entity instanceof Hero) {
        
        // Initialization and Storage of reference
        Hero hero = (Hero)entity;
        
        // Ensures a valid input is typed
        outer:
        while (true) {

          // Collects action
          String action = this.actionMenu((Hero)entity);

          // Chooses action based on user input
          int index;
          switch (action.toUpperCase()) {

            // Attack
            case "A":
              
              index = selectTarget();

              hero.attack(this.getEntity(index), this, index, 0);
              
              // Bonus energy from base attack
              hero.changeEnergy(hero.getEnergy() + 40);
              break outer;
            
            // Defend
            case "D":
              hero.defend();
              break outer;
            
            // Skill
            case "S":

              index = selectTarget();

              hero.skill(this.getEntity(index), this, index);
              break outer;

            // Burst
            case "B":
              index = selectTarget();

              hero.burst(this.getEntity(index), this, index);
              break outer;
            
            // Eat Food
            case "F":
              if (!(game.eatFood(hero))) continue outer;
              break outer;

          }
        }

      // Monster action
      } else {

        // Initialization and Storage of reference
        Monster monster = (Monster)entity;
        Random r = new Random();

        // Boss monsters have a slightly altered system
        if (monster instanceof Boss) {

          // Randomly chooses between attacking and defending as actions for a boss
          int choice = r.nextInt(4);
          // Randomly selects a target
          int target = r.nextInt(heroes);

          // Chooses
          switch (choice) {
            // Attack
            case 0:

              monster.attack(this.getHero(target), this, this.getTurnOrder().indexOf(this.getHero(target)), 0);
              break;
            
            // Defend
            case 1:
              monster.defend();
              break;
            
            // Skill
            case 2:

              monster.skill(this.getHero(target), this, this.getTurnOrder().indexOf(this.getHero(target)));
              break;

            // Burst
            case 3:

              monster.burst(this.getHero(target), this, this.getTurnOrder().indexOf(this.getHero(target)));
              break;
          }

        } else {
          
          // Randomly chooses between attacking and defending as actions for a monster
          int choice = r.nextInt(2);
          switch (choice) {

            // Attack
            case 0:
              // Randomly selects a target
              int target = r.nextInt(heroes);

              monster.attack(this.getHero(target), this, target, 0);

              break;

            // Defend
            case 1:
            monster.defend();
              break;

          }

        }

      }

      // Starts the next turn
      turnPointer++;
      if (turnPointer >= turnOrder.size()) turnPointer = 0;
      turn(game);

    }

    /**
    * Method: Selects a target for a hero to attack
    * @params N/A
    * @return String
    */
    public int selectTarget() {

      // Collects a target, ensures a valid target is typed
      int index;
      outer:
      while (true) {

        // Initialization
        Scanner in = new Scanner (System.in);
        String input;

        // Prompt
        System.out.println("Select a target monster by name");
        System.out.println(this.monsterList());
        input = in.nextLine();

        // Ensures a valid monster is typed
        for (int i = 0; i < turnOrder.size(); i++) {

          if (input.equalsIgnoreCase(this.getEntity(i).getName())) {
            
            index = i;
            break outer;

          }

        }

        System.out.println("Invalid Input");
      
      }

      return index;

    }

    /**
    * Method: Opens a menu of actions to be selected by the user
    * @params N/A
    * @return String
    */
    public String actionMenu (Hero hero) {
      
      // Initialization
      Scanner in = new Scanner (System.in);
      String input;

      // Displays an Ascii based menu and uses a switch case to select certain actions
      System.out.println("It is " + hero.getName() + "'s turn! " + hero.getHp() + " / " + hero.getHpMax());
      System.out.println("------------------------------");
      System.out.println("Please select an action:");
      System.out.println("Attack - a     Defend - d     ");

      // Condition for burst energy
      if (hero.getEnergy() < hero.getEnergyMax()) {

        System.out.println("Skill - s      Burst - " + hero.getEnergy() + " / " + hero.getEnergyMax());

      } else {

        System.out.println("Skill - s      Burst - b      ");

      }
      System.out.println("Food - f");

      System.out.println("------------------------------");
      System.out.println("");

      // Gets input
      input = in.nextLine();

      // Checks if input is valid
      if (input.equalsIgnoreCase("a") || input.equalsIgnoreCase("d") ||input.equalsIgnoreCase("s") || input.equalsIgnoreCase("b") && hero.getEnergy() >= hero.getEnergyMax() || input.equalsIgnoreCase("f")) return input;

      // Reprompts if input is invalid
      System.out.println("Invalid input");
      return actionMenu(hero);

    }

    /**
    * Method: Finishes a combat
    * @params boolean victory, Game game
    * @return void
    */
    public void complete (boolean victory, Game game) {

      // Resets elemental afflictions
      for (Hero hero: heroes) {
        
        hero.changeElementalAffliction("");

      }

      for (Monster monster: monsters) {
        
        monster.changeElementalAffliction("");

      }

      // Messages and rewards based on result of battle
      if (victory) {

        System.out.println("Congratulations, you won!");
        System.out.println("");
        
        if (location instanceof Domain) {
          // Initialization
          Chest chest = ((Domain)location).getChest(0); // Assume only 1 chest until later sprints

          // Collect rewards
          for (int i = 0; i < chest.getSize(); i++) {
            
            Item item = chest.getItem(i);
            game.getInventory().addItem(item);

          }

          ((Domain)location).getChest(0).empty();
          ((Domain)location).getChest(0).refill();
          
          System.out.println("Rewards were collected!");
          System.out.println("");
        }

      } else {

        System.out.println("Your team was knocked out!");
        System.out.println("");

      }

      location.endCombat(this);
      return;

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
      for (int i = 0; i < turnOrder.size(); i++) {
        
        if (this.getEntity(i) instanceof Hero) {
          
          output += "Hero, Entity #" + (i + 1) + ": " + this.getEntity(i).getName() + "\n";

        } else {

          output += "Monster, Entity #" + (i + 1) + ": " + this.getEntity(i).getName() + "\n";

        }
      
      }

      return output;
      
    }

    /**
    * Method: Gets a string of all heroes during combat
    * @params N/A
    * @return String
    */
    public String heroList () {
      
      // Initialization of output String
      String output = "";

      // Holds the hero number
      int count = 1;

      // Gathers all attributes inside this string      
      for (int i = 0; i < turnOrder.size(); i++) {
          
        if (this.getEntity(i) instanceof Hero) {

          output += "Hero, Entity #" + (count) + ": " + this.getEntity(i).getName() + ", Health: " + this.getEntity(i).getHp() + " / " + this.getEntity(i).getHpMax() +"\n";

          count++;

        }
      
      }

      return output;
      
    }

    /**
    * Method: Gets a string of all monsters during combat
    * @params N/A
    * @return String
    */
    public String monsterList () {
      
      // Initialization of output String
      String output = "";

      // Holds the monster number
      int count = 1;

      // Gathers all attributes inside this string      
      for (int i = 0; i < turnOrder.size(); i++) {
          
        if (this.getEntity(i) instanceof Monster) {

          output += "Monster, Entity #" + (count) + ": " + this.getEntity(i).getName() + ", Health: " + this.getEntity(i).getHp() + " / " + this.getEntity(i).getHpMax() +"\n";

          count++;

        }
      
      }

      return output;
      
    }
    
}