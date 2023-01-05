/**
*  Name: Andy Lee
*  Date: January, 4, 2022
*  Program: Text
*  Description: This Class, subclass of Entity, represents text boxes
*/

import java.awt.*;
import java.awt.font.*;
import java.awt.geom.*;

public class Text extends Entity {

  // Attributes
  private boolean background;
  private boolean visible;
  private String name;
  private Font font;
  private boolean autoSize;
  static FontRenderContext frc = new FontRenderContext(new AffineTransform(), true, true);
  
  /**
   * Method: Text
   * Description: Constructor Method
   */
   public Text () {

     super();
     this.background = false;
     this.visible = false;
     this.font = new Font("Arial", 1, 1);
     this.autoSize = true;
     this.name = "";

   } // End Text

   /**
   * Method: Text
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
   public Text (int x, int y, int dx, int dy, boolean background, boolean visible, boolean autoSize, Font font, String name) {

    super(x, y, dx, dy);
    this.background = background;
    this.visible = visible;
    this.font = font;
    this.autoSize = autoSize;
    this.name = name;

    if (this.autoSize) {
    
      this.changeDx((int)(font.getStringBounds(name, frc).getWidth()));
      this.changeDy((int)(font.getStringBounds(name, frc).getHeight()));

    } // End if

  } // End Text

  // Mutators ----------------------------------------------------------------------------
  /**
   * Method: changeBackground
   * @param newBackground
   * @return void
   * Description: changes the background state of a text
   */
   public void changeBackground (boolean newBackground) {

     this.background = newBackground;

   } // End changeBackground

   /**
   * Method: changeVisible
   * @param newVisible
   * @return void
   * Description: changes the visibility state of a text
   */
   public void changeVisibile (boolean newVisible) {

     this.visible = newVisible;

   } // End changeVisible

   /**
   * Method: changeAutoSize
   * @param newAutoSize
   * @return void
   * Description: changes the auto size state of a text
   */
   public void changeAutoSize (boolean newAutoSize) {

     this.autoSize = newAutoSize;

   } // End changeAutoSize

  /**
   * Method: changeName
   * @param newName
   * @return void
   * Description: changes the name of a text
   */
   public void changeName (String newName) {

    this.name = newName;

    if (this.autoSize) {
    
      this.changeDx((int)(font.getStringBounds(name, frc).getWidth()));
      this.changeDy((int)(font.getStringBounds(name, frc).getHeight()));

    } // End if

   } // End changeName

   /**
   * Method: changeFont
   * @param newFont
   * @return void
   * Description: changes the font of a text
   */
   public void changeFont (Font newFont) {

    this.font = newFont;

    if (this.autoSize) {
    
      this.changeDx((int)(font.getStringBounds(name, frc).getWidth()));
      this.changeDy((int)(font.getStringBounds(name, frc).getHeight()));

    } // End if

   } // End changeFont
  
  // Accessors ----------------------------------------------------------------------------
  /**
   * Method: getBackground
   * @return boolean
   * Description: gets the background state of a text
   */
   public boolean getBackground () {

     return this.background;

   } // End getBackground

   /**
   * Method: getVisible
   * @return boolean
   * Description: gets the visibility state of a text
   */
   public boolean getVisible () {

     return this.visible;

   } // End getVisible

   /**
   * Method: getAutoSize
   * @return boolean
   * Description: gets the auto size state of a text
   */
   public boolean getAutoSize () {

     return this.autoSize;

   } // End getAutoSize

  /**
   * Method: getName
   * @return String
   * Description: gets the name of a text
   */
   public String getName () {

     return this.name;

   } // End getName

   /**
   * Method: getFont
   * @return Font
   * Description: gets the font of a text
   */
   public Font getFont () {

     return this.font;

   } // End getFont

}