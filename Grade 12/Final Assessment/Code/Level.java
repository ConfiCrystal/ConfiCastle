/**
*  Name: Andy Lee
*  Date: January, 4, 2022
*  Program: Level
*  Description: This Class represents a particular level in the game
*/

// Imported libraries
import java.io.*;
import java.util.ArrayList;

public class Level {

  // Attributes
  private Tile[][] layout = new Tile[Game.XGRID][Game.YGRID];
  private ArrayList<ArrayList<Enemy>> waves = new ArrayList<ArrayList<Enemy>>();
  private int denX;
  private int denY;
  private int homeX;
  private int homeY;

  /**
   * Method: Level
   * Description: Constructor Method
   */
   public Level () {

    // Fills layout with basic tiles
    for (int i = 0; i < Game.XGRID; i++) {

      for (int j = 0; j < Game.YGRID; j++) {

      layout[i][j] = new Tile();

      }

    }

   } // End Level

   /**
   * Method: Level
   * @param file
   * Description: Constructor Method
   */
   public Level (String file) {

    this.readLevel(file);

   } // End Level

   /**
   * Method: readLevel
   * @param file
   * @return void
   * Description: reads in a level based on a file
   */
   public void readLevel (String file) {

    // Fills layout with file information
    try {

      BufferedReader reader = new BufferedReader(new FileReader(file));

      // Collects every tile
      for (int i = 0; i < Game.YGRID; i++) {

        String[] input = reader.readLine().split(" ");

        for (int j = 0; j < Game.XGRID; j++) {
          
          // Assigns tiles based on level data
          if (input[j].equals("T")) {

            layout[j][i] = new Tile();

          } else if (input[j].equals("H")) {
            
            // Home tiles require special saved coordinates
            layout[j][i] = new Home();
            this.homeX = (int)(j * Game.SCREEN_WIDTH / Game.XGRID);
            this.homeY = (int)(i * Game.SCREEN_HEIGHT / Game.YGRID);

          } else if (input[j].substring(0,1).equals("D")) {

            // Director tiles
            int intake = Integer.parseInt(input[j].substring(1,2));

            // Specialized system used to read incoming director tiles
            layout[j][i] = new Director(input[j].substring(2, 2 + intake), input[j].substring(2 + intake));
          
          } else if (input[j].equals("B")) {

            // The basic tower            
            layout[j][i] = new Tower();

          } else if (input[j].substring(0,1).equals("E")) {
            
            // Den tiles (from which enemies spawn) require special saved coordinates
            layout[j][i] = new Den(input[j].substring(1,2));
            this.denX = (int)(j * Game.SCREEN_WIDTH / Game.XGRID);
            this.denY = (int)(i * Game.SCREEN_HEIGHT / Game.YGRID);

          } else {
            
            layout[j][i] = new Tile();

          } // End if

        } // End for

      } // End for

      // Collects enemies in waves
      // Waves
      int wavesNum = Integer.parseInt(reader.readLine());
      for (int i = 0; i < wavesNum; i++) {

        String[] input = reader.readLine().split(" ");
        this.waves.add(new ArrayList<Enemy>());
        
        for (int j = 0; j < input.length; j++) {

          switch (input[j]) {
            // Basic form of enemy, add in future sprints
            case "S":
              this.waves.get(i).add(new SqrEnemy(-32, -32, 32, 32, 1, 5, 5, String.valueOf(j)));
              break;

          } // End switch

        } // End for

      } // End for

      reader.close();

     } catch (IOException e) {

     } // End try

   } // End readLevel

  // Mutators ------------------------------------------------------------------------

  /**
   * Method: changeTower
   * @param x
   * @param y
   * @param tower
   * @return void
   * Description: changes the tower of a level
   */
  public void changeTower (int x, int y, String tower) {

    switch (tower) {
      case "Basic":
        this.layout[x][y] = new Basic();
        break;
    
    } // End switch

  } // End changeTower

  // Accessors ------------------------------------------------------------------------
  /**
   * Method: getWaves
   * @return ArrayList<ArrayList<Enemy>>
   * Description: gets the waves of a level
   */
   public ArrayList<ArrayList<Enemy>> getWaves () {

     return this.waves;

   } // End getWaves

   /**
   * Method: getLayout
   * @return Tile[][]
   * Description: gets the layout of a level
   */
   public Tile[][] getLayout () {

     return this.layout;

   } // End getLayout
   
   /**
   * Method: getDenX
   * @return int
   * Description: gets the base x coordinate of the den
   */
   public int getDenX () {

     return this.denX;

   } // End getDenX

   /**
   * Method: getDenY
   * @return int
   * Description: gets the base y coordinate of the den
   */
   public int getDenY () {

     return this.denY;

   } // End getDenY

   /**
   * Method: getHomeX
   * @return int
   * Description: gets the base x coordinate of the home
   */
   public int getHomeX () {

     return this.homeX;

   } // End getHomeX

   /**
   * Method: getHomeY
   * @return int
   * Description: gets the base y coordinate of the home
   */
   public int getHomeY () {

     return this.homeY;

   } // End getHomeY

}