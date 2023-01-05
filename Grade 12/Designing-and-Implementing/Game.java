/**
 * Name: Andy, Christine, Lisa Date: November, 23, 2021 Class: Main Description:
 * This is the main upon which the game system is built, also where central game
 * logic is done
 */

// Imported Classes
import java.util.*;

public class Game {

  // Attributes
  
  private ArrayList<Player> players = new ArrayList<Player>();// ArrayList to accomodate multiple players, currently multiplayer not implemented
  private ArrayList<Location> locations = new ArrayList<Location>();
  private Inventory inventory = new Inventory(); // Although inventories are planned to be attached to players, inventory was made in the game class for the first sprint to centralize the systems

  /**
   * Method: Game
   * @params N/A
   * @return N/A
   * Description: Default Constructor
   */
   public Game () {
   
      
      
   } // End Game

  // Mutators ------------------------------
  /**
    * Method: Adds a player
    * @params Player player
    * @return void
    */
    public void addPlayer (Player player) {

      this.players.add(player);

    }

    /**
    * Method: Removes a player
    * @params int index
    * @return void
    */
    public void removePlayer (int index) {

      this.players.remove(index);

    }

    /**
    * Method: Adds a Location
    * @params Location location
    * @return void
    */
    public void addLocation (Location location) {

      this.locations.add(location);

    }

    /**
    * Method: Removes a Location
    * @params int index
    * @return void
    */
    public void removeLocation (int index) {

      this.locations.remove(index);

    }

    
  // Accessors ------------------------------
    
    /**
    * Method: Gets the player list
    * @params N/A
    * @return ArrayList<Player>
    */
    public ArrayList<Player> getPlayerList () {

      return this.players;

    }

    /**
    * Method: Gets a player
    * @params int index
    * @return Player
    */
    public Player getPlayer (int index) {

      return this.players.get(index);

    }

    /**
    * Method: Gets the inventory
    * @params N/A
    * @return Inventory
    */
    public Inventory getInventory () {

      return this.inventory;

    }

    /**
    * Method: Gets an item
    * @params int index
    * @return Item
    */
    public Item getItem (int index) {

      return this.inventory.getItem(index);

    }

  // Misc ------------------------------
  /**
    * Method: Starts the game
    * @params N/A
    * @return void
    */
    public void startGame () {
      
      // Until the next "-" barrier, this will all be preset objects that will be used for this version of the game ----------------------------------------
      // Imports all heroes. Selection of heroes not implemented in first sprint
      // Imports all base heroes
      Hero diluc = new Hero();
      diluc.retrieveBaseHero("Diluc");
      Hero kaeya = new Hero();
      kaeya.retrieveBaseHero("Kaeya");
      Hero zhongli = new Hero();
      zhongli.retrieveBaseHero("Zhongli");
      Hero kokomi = new Hero();
      kokomi.retrieveBaseHero("Kokomi");

      // Adds first player. Multiplayer not implemented in first sprint
      this.addPlayer(new Player());
      this.getPlayer(0).changeActiveHero(0, diluc);
      this.getPlayer(0).changeActiveHero(1, kaeya);
      this.getPlayer(0).changeActiveHero(2, zhongli);
      this.getPlayer(0).changeActiveHero(3, kokomi);

      // Adds three base artifacts to player 1's first hero
      Artifact gladiator = new Artifact();
      gladiator.retreiveArtifactInfo("GladiatorIntoxication");
      Artifact lavawalker = new Artifact();
      lavawalker.retreiveArtifactInfo("LavawalkerResolution");
      Artifact royal = new Artifact();
      royal.retreiveArtifactInfo("RoyalPlume");

      diluc.changeArtifact(0, gladiator);
      diluc.changeArtifact(1, lavawalker);
      diluc.changeArtifact(2, royal);

      // Basic locations, more would be added for a full game
      Location home = new Location();
      Location arena = new Domain();

      this.addLocation(home);
      this.addLocation(arena);

      arena.changeName("Arena");
      home.retrieveBaseLocation("Home", locations);
      arena.retrieveBaseLocation("Arena", locations);
      arena.addChest(new Chest());

      // ----------------------------------------

      // Begins the running of the game fromt he starting location
      tick (home);

    }

    /**
    * Method: Runs the player interaction with the game
    * @params Location location
    * @return void
    */
    public void tick (Location location) {

      System.out.println("");
      System.out.println("");
      System.out.println(location.getDescription());

      actionMenu(location);

    }

    /**
    * Method: Recursively handles general input and actions taken in locations
    * @params Location location
    * @return void
    */
    public void actionMenu (Location location) {

      // Initialization
      Scanner in = new Scanner(System.in);
      String input;
      ArrayList<String> keys = new ArrayList<String>();
      ArrayList<String> names = new ArrayList<String>();
      int count = 0;

      // Prompt
      System.out.println("------------------------------");
      System.out.println("Choose an action:");
      System.out.println("Travel - t     Inspect - i");
      System.out.println("Inventory - i1 Level Up - l");
      System.out.println("Talent - t1");
      if (location.getFountain()) System.out.println("Fountain - f");
      if (location instanceof Domain) System.out.println("Fight - f1");
      System.out.println("------------------------------");

      input = in.nextLine();

      // If the player wishes to travel to another location
      // TRAVEL ----------------------------------------------------------------------------------------------
      if (input.equalsIgnoreCase("t")) {
        
        // Ensures a valid input is typed
        while (true) {
          // Reset temporary values
          names.clear();
          keys.clear();
          count = 0;

          System.out.println("------------------------------");
          System.out.println("Choose a location:");
          
          names.add("Back");

          // Creates location keys
          for (Location destination: location.getAdjacency()) {
            
            // Adds location name to names arraylist
            names.add(destination.getName());

          }

          keys = createKeys(names);

          // Outputs all keys
          for (String name: names) {
            
            // Outputs names and attached keys
            System.out.println(name + " - " + keys.get(count));
            count++;

          }

          System.out.println("------------------------------");

          // Collect input
          input = in.nextLine();

          // Menu exit condition
          if (input.equalsIgnoreCase("b")) break;

          // Travel condition
          for (int i = 0; i < keys.size(); i++) {
            
            if (input.equalsIgnoreCase(keys.get(i))) {
              
              Location destination = location.getAdjacencyValue(i-1);
              // If the location being travelled to is a domain, fill it with monsters randomly
              if (destination instanceof Domain) {

                ((Domain)destination).fill();

              }

              // Travels to new location
              tick(destination);
              return;
              
            }

          }
          
        }

      // If the player wishes to inspect the location or other information
      // INSPECTION ----------------------------------------------------------------------------------------------
      } else if (input.equalsIgnoreCase("i")) {

        // Ensures a valid input is typed
        inspect:
        while (true) {
          // Reset temporary values
          names.clear();
          keys.clear();
          count = 0;

          // Prompt
          System.out.println("------------------------------");
          System.out.println("Choose an inspection action:");
          System.out.println("Back - b       Equip - e");
          System.out.println("Heroes - h");
          System.out.println("------------------------------");

          // Collect input
          input = in.nextLine();

          // Menu exit condition
          if (input.equalsIgnoreCase("b")) break;

          // Equip condition
          // EQUIP ----------------------------------------------------------------------------------------------
          if (input.equalsIgnoreCase("e")) {

            // Ensures a valid input is typed
            while (true) {
              // Reset temporary values
              names.clear();
              keys.clear();
              count = 0;

              // Prompt
              System.out.println("------------------------------");
              System.out.println("Choose a hero to equip onto:");

              names.add("Back");
              
              // Adding names to arraylist
              for (Player player: players) {
                
                for (int i = 0; i < 4; i++) {
                  
                  names.add(player.getActiveHero(i).getName());

                }

              }

              // Creates based on arrayList
              keys = createKeys(names);

              for (String name: names) {

                System.out.println(name + " - " + keys.get(count));
                count++;

              }

              System.out.println("------------------------------");

              // Collect input
              input = in.nextLine();

              // Menu exit condition
              if (input.equalsIgnoreCase("b")) continue inspect;

              // Hero selection
              // int i = 1 to avoid exit condition
              for (int i = 1; i < names.size(); i++) {
                
                // Once a hero is selected, choose what is being equipped
                if (input.equalsIgnoreCase(keys.get(i))) {
                  Hero hero = players.get((i - 1)/4).getActiveHero((i - 1)%4);

                  // Ensures a valid input is typed
                  while (true) {
                    // Reset temporary values
                    names.clear();
                    keys.clear();
                    count = 0;

                    // Prompt
                    System.out.println("------------------------------");
                    System.out.println("Would you like to equip an artifact or a weapon?:");

                    names.add("Back");
                    
                    names.add("Artifact");
                    names.add("Weapon");

                    // Creates based on arrayList
                    keys = createKeys(names);

                    for (String name: names) {

                      System.out.println(name + " - " + keys.get(count));
                      count++;

                    }

                    System.out.println("------------------------------");

                    // Collect input
                    input = in.nextLine();

                    // Menu exit condition
                    if (input.equalsIgnoreCase("b")) continue inspect;

                    // Weapon
                    // EQUIP WEAPON ----------------------------------------------------------------------------------------------
                    if (input.equalsIgnoreCase("w")) {

                      // Ensures a valid input is typed
                      while (true) {
                        // Reset temporary values
                        names.clear();
                        keys.clear();
                        count = 0;

                        // Initialization
                        ArrayList<Weapon> weapons = new ArrayList<Weapon>();

                        System.out.println("------------------------------");
                        System.out.println("Choose a weapon:");
                        
                        names.add("Back");

                        // Creates weapon keys
                        for (int l = 0; l < this.getInventory().getItems().size(); l++) {
                          
                          // Adds weapon name to names arraylist
                          Item item = this.getInventory().getItem(l);
                          if (item instanceof Weapon) {

                            names.add(item.getName());
                            weapons.add((Weapon)item);

                          }

                        }

                        keys = createKeys(names);

                        // Outputs all keys
                        for (String name: names) {
                          
                          // Outputs names and attached keys
                          System.out.println(name + " - " + keys.get(count));
                          count++;

                        }

                        System.out.println("------------------------------");

                        // Collect input
                        input = in.nextLine();

                        // Menu exit condition
                        if (input.equalsIgnoreCase("b")) continue inspect;

                        // Equip condition
                        for (int k = 0; k < keys.size(); k++) {
                          
                          if (input.equalsIgnoreCase(keys.get(k))) {
                            
                            // equips new weapon and replaces old weapon in inventory
                            this.getInventory().addItem(hero.getWeapon());

                            // Removes equipped weapon from inventory
                            count = -1;
                            for (int l = 0; l < this.getInventory().getSize(); l++) {

                              if (this.getInventory().getItem(l) instanceof Weapon) count++;

                              if (count == (k-1)) {
                                
                                this.getInventory().removeItem(l);
                                break;

                              }

                            }

                            hero.changeWeapon(weapons.get(k - 1));
                            
                            actionMenu(location);
                            return;
                            
                          }

                        }
                        
                      }

                    }

                    // Artifact
                    // EQUIP ARTIFACT ----------------------------------------------------------------------------------------------
                    if (input.equalsIgnoreCase("a")) {

                      // Ensures a valid input is typed
                      while (true) {
                        // Reset temporary values
                        names.clear();
                        keys.clear();
                        count = 0;

                        // Initialization
                        ArrayList<Artifact> artifacts = new ArrayList<Artifact>();

                        System.out.println("------------------------------");
                        System.out.println("Choose an artifact:");
                        
                        names.add("Back");

                        // Creates artifact keys
                        for (int l = 0; l < this.getInventory().getItems().size(); l++) {
                          
                          // Adds artifact name to names arraylist
                          Item item = this.getInventory().getItem(l);
                          if (item instanceof Artifact) {

                            names.add(item.getName());
                            artifacts.add((Artifact)item);

                          }

                        }

                        keys = createKeys(names);

                        // Outputs all keys
                        for (String name: names) {
                          
                          // Outputs names and attached keys
                          System.out.println(name + " - " + keys.get(count));
                          count++;

                        }

                        System.out.println("------------------------------");

                        // Collect input
                        input = in.nextLine();

                        // Menu exit condition
                        if (input.equalsIgnoreCase("b")) continue inspect;

                        // Equip condition
                        // EQUIP ARTIFACT SLOT ----------------------------------------------------------------------------------------------
                        for (int k = 0; k < keys.size(); k++) {
                          
                          if (input.equalsIgnoreCase(keys.get(k))) {
                            
                            // Ensures a valid input is typed
                            while (true) {
                              // Reset temporary values
                              names.clear();
                              keys.clear();
                              count = 0;

                              System.out.println("------------------------------");
                              System.out.println("Choose an artifact slot:");
                              
                              names.add("Back");

                              // Creates location keys
                              names.add("One");
                              names.add("Two");
                              names.add("Three");
                              names.add("Four");
                              names.add("Five");

                              keys = createKeys(names);

                              // Outputs all keys
                              for (String name: names) {
                                
                                // Outputs names and attached keys
                                System.out.println(name + " - " + keys.get(count));
                                count++;

                              }

                              System.out.println("------------------------------");

                              // Collect input
                              input = in.nextLine();

                              // Menu exit condition
                              if (input.equalsIgnoreCase("b")) continue inspect;
                              
                              int index = 0;

                              // Equip condition
                              for (int l = 0; l < keys.size(); l++) {
                                
                                if (input.equalsIgnoreCase(keys.get(l))) {
                                  
                                  if (input.equalsIgnoreCase("o")) index = 0;
                                  if (input.equalsIgnoreCase("t")) index = 1;
                                  if (input.equalsIgnoreCase("t1")) index = 2;
                                  if (input.equalsIgnoreCase("f")) index = 3;
                                  if (input.equalsIgnoreCase("f1")) index = 4;

                                  // equips new artifact, replaces old one in inventory
                                  this.getInventory().addItem(hero.getArtifact(index));

                                  // Removes equipped artifact from inventory
                                  count = -1;
                                  for (int m = 0; m < this.getInventory().getSize(); m++) {

                                    if (this.getInventory().getItem(m) instanceof Artifact) count++;

                                    if (count == (k-1)) {

                                      this.getInventory().removeItem(m);
                                      break;

                                    }

                                  }

                                  hero.changeArtifact(index, artifacts.get(k - 1));

                                  actionMenu(location);
                                  return;
                                  
                                }

                              }

                            }
                            
                          }

                        }

                      }
                      
                    }

                  }
                  
                }

              }
              
            }

          // Hero inspection condition  
          // INSPECTION OF HERO ----------------------------------------------------------------------------------------------
          } else if (input.equalsIgnoreCase("h")) {

            // Ensures a valid input is typed
            while (true) {
              // Reset temporary values
              names.clear();
              keys.clear();
              count = 0;

              // Prompt
              System.out.println("------------------------------");
              System.out.println("Choose a hero to inspect:");

              names.add("Back");
              
              // Adding names to arraylist
              for (Player player: players) {
                
                for (int i = 0; i < 4; i++) {
                  
                  names.add(player.getActiveHero(i).getName());

                }

              }

              // Creates based on arrayList
              keys = createKeys(names);

              for (String name: names) {

                System.out.println(name + " - " + keys.get(count));
                count++;

              }

              System.out.println("------------------------------");

              // Collect input
              input = in.nextLine();

              // Menu exit condition
              if (input.equalsIgnoreCase("b")) break inspect;

              // Hero inspect conditions
              // int i = 1 to avoid exit condition
              for (int i = 1; i < names.size(); i++) {

                if (input.equalsIgnoreCase(keys.get(i))) {
                  System.out.println(players.get((i - 1)/4).getActiveHero((i - 1)%4).toString());
                  continue inspect;
                }

              }
              
            }

          }
    
        }

      // FOUNTAIN -----------------------------------------------------------
      } else if (input.equalsIgnoreCase("f")&&location.getFountain()) {
        
        // Heals all heroes
        for (Player player: this.getPlayerList()) {
          
          for (int i = 0; i < 4; i++) {
            
            Hero hero = player.getActiveHero(i);
            if (hero.getHp() < hero.getHpMax()) hero.changeHp(hero.getHpMax());

          }

        } 

        System.out.println("Your heroes were healed to full!");
        System.out.println("");
        System.out.print("Confirm: ");
        in.nextLine();

      // Fight -------------------------------------------------------------
      } else if (input.equalsIgnoreCase("f1")&&location instanceof Domain) {
        
          this.beginCombat((Domain)location);
          
      // Inventory -------------------------------------------------------------
      } else if (input.equalsIgnoreCase("i1")) {  

        // Initialization
        count = 1;
        
        // Outputs every item
        for (Item item : this.getInventory().getItems()) {

          System.out.println("Item #" + count + ":");
          System.out.println(item.toString());
          System.out.println("");
          count++;

        }

      // To level up an item, hero, or skill
      // Level -------------------------------------------------------------
      } else if (input.equalsIgnoreCase("l")) {  

        // Ensures a valid input is typed, checks which hero to operate on
        while (true) {
          // Reset temporary values
          names.clear();
          keys.clear();
          count = 0;

          // Prompt
          System.out.println("------------------------------");
          System.out.println("Choose a hero to level:");

          names.add("Back");
          
          // Adding names to arraylist
          for (Player player: players) {
            
            for (int i = 0; i < 4; i++) {
              
              names.add(player.getActiveHero(i).getName());

            }

          }

          // Creates based on arrayList
          keys = createKeys(names);

          for (String name: names) {

            System.out.println(name + " - " + keys.get(count));
            count++;

          }

          System.out.println("------------------------------");

          // Collect input
          input = in.nextLine();

          // Menu exit condition
          if (input.equalsIgnoreCase("b")) break;

          // Hero inspect conditions
          // int i = 1 to avoid exit condition
          for (int i = 1; i < names.size(); i++) {

            if (input.equalsIgnoreCase(keys.get(i))) {
              
              // Initialization
              Hero hero = players.get((i - 1)/4).getActiveHero((i - 1)%4);

              // Checks if ascension is required
              if (hero.getLevel()>=hero.getAscensionLevel()*20) {

                // Finds an ascension item
                for (int j = 0; j < this.getInventory().getSize();j++) {
                  
                  // Success
                  if (this.getItem(j) instanceof Ascension) {

                    hero.changeAscensionLevel(hero.getAscensionLevel() + 1);
                    hero.changeHpMax(hero.getHpMax() + 5);
                    hero.changeHp(hero.getHp() + 5);
                    hero.changeBaseDamage(hero.getBaseDamage() + 2);
                    this.getInventory().removeItem(j);

                    System.out.println(hero.getName() + " ascended!");
                    actionMenu(location);
                    return;

                  }

                }

                // Fail
                System.out.println("Ascension material required to ascend!");
                actionMenu(location);
                return;

              // If not, level up
              } else {

                // Finds an exp material item
                for (int j = 0; j < this.getInventory().getSize();j++) {
                  
                  // Success
                  if (this.getItem(j) instanceof ExpMaterial) {

                    hero.changeLevel(hero.getLevel() + 1);
                    hero.changeHpMax(hero.getHpMax() + 10);
                    hero.changeHp(hero.getHp() + 10);
                    hero.changeBaseDamage(hero.getBaseDamage() + 4);
                    this.getInventory().removeItem(j);

                    System.out.println(hero.getName() + " levelled up!");
                    actionMenu(location);
                    return;

                  }

                }

                // Fail
                System.out.println("Exp Material required to level up!");
                actionMenu(location);
                return;

              }

            }

          }

        }

      // Talent Level ------------------------------------------
      } else if (input.equalsIgnoreCase("t1")) {
        
        // Ensures a valid input is typed, checks which hero to operate on
        while (true) {
          // Reset temporary values
          names.clear();
          keys.clear();
          count = 0;

          // Prompt
          System.out.println("------------------------------");
          System.out.println("Choose a hero to level their talent:");

          names.add("Back");
          
          // Adding names to arraylist
          for (Player player: players) {
            
            for (int i = 0; i < 4; i++) {
              
              names.add(player.getActiveHero(i).getName());

            }

          }

          // Creates based on arrayList
          keys = createKeys(names);

          for (String name: names) {

            System.out.println(name + " - " + keys.get(count));
            count++;

          }

          System.out.println("------------------------------");

          // Collect input
          input = in.nextLine();

          // Menu exit condition
          if (input.equalsIgnoreCase("b")) break;

          // Hero inspect conditions
          // int i = 1 to avoid exit condition
          for (int i = 1; i < names.size(); i++) {

            if (input.equalsIgnoreCase(keys.get(i))) {
              
              // Initialization
              Hero hero = players.get((i - 1)/4).getActiveHero((i - 1)%4);

              // Ensures a valid input is typed, checks which talent to level
              while (true) {
                // Reset temporary values
                names.clear();
                keys.clear();
                count = 0;

                // Prompt
                System.out.println("------------------------------");
                System.out.println("Choose a talent to level:");

                names.add("Back");
                
                names.add("Basic");
                names.add("Skill");
                names.add("Burst");

                // Creates based on arrayList
                keys = createKeys(names);

                for (String name: names) {

                  System.out.println(name + " - " + keys.get(count));
                  count++;

                }

                System.out.println("------------------------------");

                // Collect input
                input = in.nextLine();

                // Menu exit condition
                if (input.equalsIgnoreCase("b")) break;

                // Detects talent to level
                // Basic attack
                if (input.equalsIgnoreCase("b1")) {

                  // Finds a talent item and levels up a specific talent
                  for (int j = 0; j < this.getInventory().getSize();j++) {
                    
                    // Success
                    if (this.getItem(j) instanceof Talent) {

                      hero.changeBasicAttackLevel(hero.getBasicAttackLevel() + 1);
                      this.getInventory().removeItem(j);

                      System.out.println(hero.getName() + "'s basic attack levelled up!");
                      tick(location);
                      return;

                    }

                  }

                  // Fail
                  System.out.println("Talent Material required to level up!");
                  tick(location);
                  return;

                // Skill
                } else if (input.equalsIgnoreCase("s")) {

                  // Finds a talent item and levels up a specific talent
                  for (int j = 0; j < this.getInventory().getSize();j++) {
                    
                    // Success
                    if (this.getItem(j) instanceof Talent) {

                      hero.changeSkillLevel(hero.getSkillLevel() + 1);
                      this.getInventory().removeItem(j);

                      System.out.println(hero.getName() + "'s elemental skill levelled up!");
                      tick(location);
                      return;

                    }

                  }

                  // Fail
                  System.out.println("Talent Material required to level up!");
                  tick(location);
                  return;

                // Burst
                } else if (input.equalsIgnoreCase("b2")) {

                  // Finds a talent item and levels up a specific talent
                  for (int j = 0; j < this.getInventory().getSize();j++) {
                    
                    // Success
                    if (this.getItem(j) instanceof Talent) {

                      hero.changeBurstLevel(hero.getBurstLevel() + 1);
                      this.getInventory().removeItem(j);

                      System.out.println(hero.getName() + "'s burst levelled up!");
                      tick(location);
                      return;

                    }

                  }

                  // Fail
                  System.out.println("Talent Material required to level up!");
                  tick(location);
                  return;

                }

              } // End selecting target talent

            }

          }

        }

      } else {

        // If nothing is chosen
        tick(location);

      }

      tick(location);

    }

  /**
    * Method: Creates simple keys based on an input array
    * @params Hero hero
    * @return boolean
    */
    public boolean eatFood (Hero hero) {

      // Initialization
      ArrayList<String> names = new ArrayList<String>();
      int count = 0;
      String input;
      ArrayList<String> keys = new ArrayList<String>();
      Scanner in = new Scanner(System.in);
      
      // Ensures a valid input is typed, targets a specific food to eat
      while (true) {
        // Reset temporary values
        names.clear();
        keys.clear();
        count = 0;

        // Initialization
        ArrayList<Food> foods = new ArrayList<Food>();
        ArrayList<Integer> indicies = new ArrayList<Integer>();

        System.out.println("------------------------------");
        System.out.println("Choose a Food to eat:");

        names.add("Back");

        // Creates food keys
        for (int l = 0; l < getInventory().getSize(); l++) {
          
          // Adds food name to names arraylist
          Item item = getInventory().getItem(l);
          if (item instanceof Food) {

            names.add(item.getName());
            foods.add((Food)item);
            indicies.add(l);

          }

        }

        keys = createKeys(names);

        // Outputs all keys
        for (String name: names) {
          
          // Outputs names and attached keys
          System.out.println(name + " - " + keys.get(count));
          count++;

        }

        System.out.println("------------------------------");

        // Collect input
        input = in.nextLine();

        // Exit
        if (input.equalsIgnoreCase("b")) return false;

        // Consume condition
        for (int k = 0; k < keys.size(); k++) {
          
          if (input.equalsIgnoreCase(keys.get(k))) {
            
            // heals using a food
            System.out.println(hero.getName() + " ate " + foods.get(k-1).getName() + ", restoring half their health!");
            hero.changeHp(hero.getHp() + (int)(hero.getHpMax() * 0.5));
            if (hero.getHp() > hero.getHpMax()) hero.changeHp(hero.getHpMax());

            // removes the food
            inventory.removeItem(indicies.get(k-1));

            return true;
            
          }

        }
        
      }
    
    }
    /**
    * Method: Creates simple keys based on an input array
    * @params ArrayList<String> input
    * @return ArrayList<String>
    */
    public static ArrayList<String> createKeys (ArrayList<String> input) {
      
      // Initialization of output
      ArrayList<String> keys = new ArrayList<String>();

      // runs through each input
      for (int i = 0; i < input.size(); i++) {

        // handles keys
        String operator = input.get(i).substring(0,1).toLowerCase();

        // prevents duplicate keys
        while (true) {

          for (int j = 0; j < keys.size(); j++) {

            try {

              // If duplicate key, add extra key text to remove duplicity
              if (keys.get(j).equals(operator)) {
                
                // Checks for existing extra character
                try {

                  operator = operator.substring(0,1) + (Integer.parseInt(keys.get(j).substring(1)) + 1);

                // If no existing character
                } catch (NumberFormatException e) {

                  operator = operator.substring(0,1) + "1";

                }

              }

            // If key comparison index empty, move on
            } catch (NullPointerException e) {

              break;

            }

          }

          // If all is well, go to the next key
          keys.add(operator);
          break;

        } // End while of preventing duplicates

      } // End for of all keys

      // Reutrns finished keys
      return(keys);

    }


    /**
     * Method: Begins combat
     * @params location, the location the combat is happening in
     */
    public void beginCombat (Domain location) {

        System.out.println ("Beginning Combat...");
        Combat combat = new Combat(location);
        
        // Add heroes
        for (Player player : players) {

          combat.addPlayer(player);

        }

        // Add monsters
        location.fill();
        combat.addMonsters(location.getMonsters());
        combat.beginCombat(this);

    }

} // Class End