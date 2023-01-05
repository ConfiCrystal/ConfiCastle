/**
*  Name: Andy Lee
*  Date: January, 3, 2022
*  Program: Main
*  Description: This program is a main for Operation Umbra
*/

// Imported Libraries
import javax.swing.JFrame;

public class Main extends JFrame {

  public static void main(String[] args) {

    // Begins the game
    new Main();

  } // End main

  /**
   * Method: Main
   * Description: Constructor Method, begins the game
   */
  public Main() {

    // Sets a number of parameters to the following defaults and creates the game
    this.add(new Game());
    this.setTitle("Operation Umbra");
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setResizable(false);
    this.pack();
    this.setVisible(true);
    this.setLocationRelativeTo(null);

  } // End Main

}