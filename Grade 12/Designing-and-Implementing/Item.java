/**
 * Name: Andy, Christine, Lisa 
 * Date: November 23, 2021 
 * Filename: Item.java
 * Description: This is the Item class.
 */

public class Item {

  //attributes
  private String name;
  private int rarity;

  //default contructor
  public Item() {

    this.name = "None";
    this.rarity = 0;

  }

  // accessor methods
  public int getRarity() {

    return this.rarity;

  }
  public String getName() {

    return this.name;

  }

  // mutator methods
  public void changeRarity(int newRarity) {

    this.rarity = newRarity;

  }
  public void changeName(String newName) {

    this.name = newName;

  }

  //methods
   /**
   * Method: bePicked
   * @params N/A
   * @return N/A
   * Description: outputs messae when item is picked up, for future sprints where items appear outside of chests regularly
   */
  public void bePicked () {

    System.out.println ("you picked up a " + this.name);

  }
  
  /*
   * Method: Default toString
   * @return ret This Item's attributes
   */
  public String toString () {

    String ret = "\nName: " + this.getName() + "\nrarity: " + this.getRarity();

    return ret;

  }
  
}