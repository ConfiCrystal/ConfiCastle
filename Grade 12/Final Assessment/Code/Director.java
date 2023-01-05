/**
*  Name: Andy Lee
*  Date: January, 4, 2022
*  Program: Director
*  Description: This Class represents a specific tile that indicates the direction of enemy movement
*/

public class Director extends Tile {

  // Attributes
  private String intake;
  private String output;
  
  /**
   * Method: Director
   * Description: Constructor Method
   */
  public Director () {

    super();
    this.intake = "";
    this.output = "";

  } // End Director
  
  /**
   * Method: Director
   * @param intake
   * @param output
   * Description: Constructor Method
   */
  public Director (String intake, String output) {
    
    this.intake = intake;
    this.output = output;

  } // End Tile

  // Mutators ------------------------------------------------------------------------
  /**
   * Method: changeIntake
   * @param newIntake
   * @return void
   * Description: changes the intake String of a director
   */
   public void changeIntake (String newIntake) {

     this.intake = newIntake;

   } // End changeIntake

   /**
   * Method: changeOutput
   * @param newOutput
   * @return void
   * Description: changes the output String of a director
   */
   public void changeOutput (String newOutput) {

     this.output = newOutput;

   } // End changeIntake

  // Accessors ------------------------------------------------------------------------
  /**
   * Method: getIntake
   * @return String
   * Description: gets the intake String of a director
   */
   public String getIntake () {

     return this.intake;

   } // End getIntake

   /**
   * Method: getOutput
   * @return String
   * Description: gets the output String of a director
   */
   public String getOutput () {

     return this.output;

   } // End getOutput

}