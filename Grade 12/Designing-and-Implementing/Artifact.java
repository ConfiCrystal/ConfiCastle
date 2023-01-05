/**
 * Name: Andy, Christine, Lisa
 * Date: November 23, 2021
 * Filename: Artifact.java
 * Description: This is the Artifact class which is a subclass of Item.
*/

// Imported classes
import java.io.*;
import java.util.ArrayList;

public class Artifact extends Item {

   /**
    * Attribtues of Artifact
    */
   private String set;
   private String piece;
   private int level;
   private String mainStat;
   private int mainStatValue;
   private String[] subStats = new String[4];
   private int[] subStatValues = new int[4];
   
   /**
    * Default Constructor for Artifact
    */
   public Artifact () {

     super();
      this.changeName("Flower");
      this.set = "";
      this.piece = "";
      this.level = 0;
      this.mainStat = "";
      this.mainStatValue = 0;

      for (int i = 0; i < 4; i++) {
        this.subStats[i] = "";
        this.subStatValues[i] = 0;
      }

   }
   
   //accessor methods
   public String getSet () {

      return this.set;

   }

   public String getPiece () {

      return this.piece;

   }

   public int getLevel () {

      return this.level;

   }

   public String getMainStat () {

      return this.mainStat;

   }

   public int getMainStatValue () {

      return this.mainStatValue;

   }

   public String[] getSubStats () {

      return this.subStats;

   }

   public int[] getSubStatValues () {

      return this.subStatValues;

   }
   
   //mutator methods
   public void changeSet (String newSet) {

      this.set = newSet;

   }

   public void changePiece (String newPiece) {

      this.piece = newPiece;

   }

   public void changeLevel (int newLevel) {

      this.level = newLevel;

   }

   public void changeMainStat (String newMainStat) {

      this.mainStat = newMainStat;

   }

   public void changeMainStatValue (int newMainStatValue) {

      this.mainStatValue = newMainStatValue;

   }

   public void changeSubStat (int index, String newSubStat) {

      this.subStats[index] = newSubStat;

   }

   public void changeSubStatValue (int index, int newSubStatValue) {

      this.subStatValues[index] = newSubStatValue;

   }
   
   //methods
   /**
   * Method: levelUp
   * @params ArrayList<ExpMaterial> expMaterials
   * @return N/A
   * Description: levels up artifact
   */
   public void levelUp (ArrayList<ExpMaterial> expMaterials) {

      System.out.println (this.getName() + " was leveled up" + expMaterials.size());

   }

    /**
   * Method: retreiveArtifactInfo
   * @params String name, The name of the artifact being retrieved
   * @return void
   * Description: Retrieves a base level artifact from a properly formatted textfile
   */
   public void retreiveArtifactInfo (String name) {

     try{

        BufferedReader reader = new BufferedReader (new FileReader((name + ".txt")));
        
        this.changeSet (reader.readLine());
        this.changePiece (reader.readLine());
        this.changeLevel (Integer.parseInt(reader.readLine()));
        this.changeMainStat (reader.readLine());
        this.changeMainStatValue (Integer.parseInt(reader.readLine()));

        for (int i = 0; i < 4; i++){
          this.changeSubStat (i, reader.readLine());
        }

        for (int i = 0; i < 4; i++) {
          this.changeSubStatValue (i, Integer.parseInt(reader.readLine()));
        }

        reader.close ();
     }
     catch (IOException e) {

     }

   }
   
   /*
    * Method: Default toString
    * @return ret This Artifact's attributes
    */
   public String toString () {
     
      String ret = "\nArtifact\nName: " + this.getName() + "\nrarity: " + this.getRarity() + "\nset: " + this.getSet() + "\npiece: " + this.getPiece() + "\nlevel: " + this.getLevel() + "\nmain stat: " + this.getMainStat() + "\nmain stat value: " + this.getMainStatValue();
      for (int i = 0; i < 4; i++) {
        ret += "\nsubstat " + (i+1) + ": " + this.getSubStats()[i] + "\nsubstat " + (i+1) + " value: " + this.getSubStatValues()[i];
      }
      return ret;
   }
   
}