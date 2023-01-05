/**
*  Name: Andy Lee
*  Date: January, 17, 2022
*  Program: Time
*  Description: This class runs the timer for the game
*/

// Imported Libararies
import java.util.Timer;
import java.util.TimerTask;

public class Time {

  // Attributes
  Timer timer;

  /**
   * Method: Time
   * @param game
   * Description: Constructor Method
   */
  public Time (Game game) {

    // Begins the game using a method that is repeated through a timer
    this.timer = new Timer();

    this.timer.scheduleAtFixedRate(new TimerTask() {

      @Override
      public void run() {

        game.tick();
        
      }

    }, 0, (int)(1000 / Game.TICK_SPEED));

  } // End Time

  /**
   * Method: end
   * @return void
   * Description: Ends the timer
   */
  public void end() {

    this.timer.cancel();

  } // End end
  
}