/**
*  Name: Andy Lee
*  Date: October, 14, 2021
*  Program: SquareGame
*  Description: This program is a main for the square game
*/

// Imported Libraries
import javax.swing.JFrame;

// SquareGame Class
public class SquareGame extends JFrame{
   
   // SquareGame main
   public static void main(String[] args) {
        
      new SquareGame();
         
   } // End main
   
   /**
   * Method: SquareGame
   * @params N/A
   * @return N/A
   * Description: Constructor Method
   */
   public SquareGame(){
          
      // When run, sets up the defaults for the game using the other classes in this project  
      this.add(new Game());
      this.setTitle("Move");
      this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      this.setResizable(false);
      this.pack();
      this.setVisible(true);
      this.setLocationRelativeTo(null);
        
   }
} // End class