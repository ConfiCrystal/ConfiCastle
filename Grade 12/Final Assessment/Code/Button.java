/**
*  Name: Andy Lee
*  Date: January, 4, 2022
*  Program: Button
*  Description: This Class, subclass of Text, buttons that when clicked interact with the game
*/

import java.awt.*;

public class Button extends Text {

  /**
   * Method: Button
   * Description: Constructor Method
   */
   public Button () {

     super();

   } // End Button

   /**
   * Method: Button
   * @param x
   * @param y
   * @param dx
   * @param dy
   * @param background
   * @param visisble
   * @param autoSize
   * @param font
   * @param name
   * Description: Constructor Method
   */
   public Button (int x, int y, int dx, int dy, boolean background, boolean visible, boolean autoSize, Font font, String name) {

     super(x, y, dx, dy, background, visible, autoSize, font, name);

   } // End Button

}