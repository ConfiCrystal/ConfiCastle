/**
 * Name: Andy, Christine, Lisa
 * Date: November 23, 2021
 * Filename: Chest.java
 * Description: This is the Chest class.
*/

// Imported Class
import java.util.*; 

public class Chest {

    /**
     * Attribute of the Chest class
     */
    private ArrayList <Item> items = new ArrayList <Item> ();
    
    /**
     * General Constructor of Chest
     * @param items This is an Arraylist of the items in this Chest
     */
    public Chest (ArrayList <Item> items) {

        this.items = items;

    }

    /**
     * Default Constructor of Chest
     */
    public Chest () {

        

    }


    /**
    * Mutator Method: Adds an item to the Chest class
    * @param item This is the item to be added to the cest
    * @return void
    */
    public void addItem (Item item) {

      this.items.add (item);

    }

    /**
     * Accessor Method: Gets the items of the Chest class
     * @return the Chest's items
     */
    public ArrayList <Item> getItems () {

        return this.items;

    }

    /**
     * Accessor Method: Gets a specific item of the Chest class
     * @return one of a Chest's items
     * @param index This is the ArrayList index of the item to be retrieved
     */
    public Item getItem (int index) {

        return this.items.get (index);

    }

    /**
     * Accessor Method: Gets the size of a chest
     * @return int of size
     */
    public int getSize () {

        return this.items.size ();

    }

    /**
     * Method: default toString
     * @returns ret This Chest's attributes
     */
    public String toString () {

        String ret = "Items: " + items;
        return ret;

    }

    /**
     * Method: Empties the chest
     */
    public void empty () {

        items.clear ();
        System.out.println ("The chest has been emptied.");

    }

    /**
     * Method: Adds items to the chest
     */
    public void refill () {

        Random r = new Random ();
        
        for (int i = 0; i < (r.nextInt (1) + 1) * 5; i++) {
          
            int type = r.nextInt(6);
            
            // Selects type of item added to the chest
            switch (type) {

                // Weapon
                case 0:
                    // Creating randomized weapon
                    Weapon weapon = new Weapon ();
                    weapon.changeName ("Slasher");
                    weapon.changeBaseAttack (r.nextInt (10) + 1);
                    weapon.changeRarity (4 + r.nextInt (2));
                    weapon.changeSecondaryTrait ("Attack");
                    weapon.changeSecondaryTraitValue (r.nextInt (5) + 1);

                    this.addItem (weapon);
                    break;

                // Artifact
                case 1:
                    // Creating randomized artifact
                    Artifact artifact = new Artifact ();
                    artifact.changeName ("Finale");
                    artifact.changeSet ("Gladiator");
                    artifact.changeMainStat ("Attack");
                    artifact.changeMainStatValue (r.nextInt (10) + 1);

                    for (int j = 0; j < 4; j++) {
                        artifact.changeSubStat (j, "Attack");
                    }

                    for (int j = 0; j < 4; j++) {
                        artifact.changeSubStatValue (j, r.nextInt (8) + 1);
                    }

                    this.addItem (artifact);
                    break;

                // Food
                case 2:
                    // Creating randomized food
                    Food food = new Food ();
                    food.changeName ("Sweet Madame");

                    this.addItem (food);
                    break;
                
                // Exp
                case 3:
                    // Creating randomized exp material
                    ExpMaterial expMaterial = new ExpMaterial ();
                    expMaterial.changeName ("Hero's wit");

                    this.addItem (expMaterial);
                    break;

                // Ascension
                case 4:
                    // Creating randomized ascension material
                    Ascension ascension = new Ascension ();
                    ascension.changeName ("Dandelion Seed");

                    this.addItem (ascension);
                    break;
                
                // Talent
                case 5:
                    // Creating randomized talent material
                    Talent talent = new Talent ();                    talent.changeName ("Guide to Propsperity");

                    this.addItem (talent);
                    break;

            }

        }
        
    }
    
}