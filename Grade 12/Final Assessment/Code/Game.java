/**
*  Name: Andy Lee
*  Date: January, 3, 2022
*  Program: Game
*  Description: This program holds the core of Operation Umbra, handling controls and interactions between other classes
*/

// Imported Libraries
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;
import javax.imageio.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
import java.awt.image.*;

public class Game extends JLayeredPane implements MouseListener {

  // Attributes
  // Default Constants;
  static final int SCREEN_WIDTH = 1280;
  static final int SCREEN_HEIGHT = 896;
  static final int BG_INTENSITY = 50;
  static final Color BG = new Color (BG_INTENSITY, BG_INTENSITY, BG_INTENSITY);
  static final int FG_INTENSITY = 200;
  static final Color FG = new Color (FG_INTENSITY, FG_INTENSITY, FG_INTENSITY);
  static final Font TITLE = new Font("Cambria", 1, 50);
  static final Font DEFAULT = new Font("Cambria", 1, 15);
  static final double FACTOR = 1.5;
  static final int BUTTON_DISTANCE = 300;
  static final int BUTTON_HEIGHT = 600;
  static final int XGRID = 10;
  static final int YGRID = 7;
  static final int TICK_SPEED = 20;

  // Gameplay variables
  private ArrayList<Entity> entities = new ArrayList<Entity> ();
  private HashMap<String, JLabel> labels = new HashMap<String, JLabel> ();
  private JLabel[][] gridLabels = new JLabel[XGRID][YGRID];
  private String state;
  private Level level;
  private int levelNum;
  private int wave;
  private ArrayList<Enemy> enemies = new ArrayList<Enemy>();
  Time timer;
  private boolean tileUpdate;
  private String back = "";
  private int hp;
  private int money;

  // Saved assets
  Image gear;
  Image home;
  Image enemy;
  Image directorBody;
  Image directorFootU;
  Image directorFootR;
  Image directorFootD;
  Image directorFootL;
  Image directorHeadU;
  Image directorHeadR;
  Image directorHeadD;
  Image directorHeadL;
  Image empty;
  Image towerBase;
  Image basicTower;
  Image basicProjectile;
  Image den;
  Image tempImg;
  Image heart;
  Image dollar;
  Image skull;
  Image trophy;

  /**
   * Method: Game
   * Description: Constructor Method
   */
  public Game() {
    
    // Sets a number of parameters to the following defaults
    this.setPreferredSize (new Dimension(SCREEN_WIDTH, SCREEN_HEIGHT));
    this.setBackground (new Color(0, 0, 0));
    this.setFocusable (true);
    addMouseListener(this);
    this.setLayout(null);
    level = new Level();
    levelNum = 1;
    tileUpdate = false;
    wave = 0;
    this.setOpaque(true);

    try {

      // Asset Initialization
      this.gear = ImageIO.read(new File("Gear.png"));
      this.home = ImageIO.read(new File("Home.png"));
      this.home = home.getScaledInstance(SCREEN_WIDTH/Game.XGRID, SCREEN_HEIGHT/Game.YGRID, java.awt.Image.SCALE_SMOOTH);
      this.enemy = ImageIO.read(new File("Enemy.png")); 
      this.enemy = enemy.getScaledInstance(32, 32, java.awt.Image.SCALE_SMOOTH);
      this.directorBody = ImageIO.read(new File("Director_Body.png"));
      this.directorBody = directorBody.getScaledInstance(SCREEN_WIDTH/Game.XGRID, SCREEN_HEIGHT/Game.YGRID, java.awt.Image.SCALE_SMOOTH);

      this.directorFootU = ImageIO.read(new File("Director_Foot U.png"));
      this.directorFootU = directorFootU.getScaledInstance(SCREEN_WIDTH/Game.XGRID, SCREEN_HEIGHT/Game.YGRID, java.awt.Image.SCALE_SMOOTH);
      this.directorFootR = ImageIO.read(new File("Director_Foot R.png"));
      this.directorFootR = directorFootR.getScaledInstance(SCREEN_WIDTH/Game.XGRID, SCREEN_HEIGHT/Game.YGRID, java.awt.Image.SCALE_SMOOTH);
      this.directorFootD = ImageIO.read(new File("Director_Foot D.png"));
      this.directorFootD = directorFootD.getScaledInstance(SCREEN_WIDTH/Game.XGRID, SCREEN_HEIGHT/Game.YGRID, java.awt.Image.SCALE_SMOOTH);
      this.directorFootL = ImageIO.read(new File("Director_Foot L.png"));
      this.directorFootL = directorFootL.getScaledInstance(SCREEN_WIDTH/Game.XGRID, SCREEN_HEIGHT/Game.YGRID, java.awt.Image.SCALE_SMOOTH);

      this.directorHeadU = ImageIO.read(new File("Director_Head U.png"));
      this.directorHeadU = directorHeadU.getScaledInstance(SCREEN_WIDTH/Game.XGRID, SCREEN_HEIGHT/Game.YGRID, java.awt.Image.SCALE_SMOOTH);
      this.directorHeadR = ImageIO.read(new File("Director_Head R.png"));
      this.directorHeadR = directorHeadR.getScaledInstance(SCREEN_WIDTH/Game.XGRID, SCREEN_HEIGHT/Game.YGRID, java.awt.Image.SCALE_SMOOTH);
      this.directorHeadD = ImageIO.read(new File("Director_Head D.png"));
      this.directorHeadD = directorHeadD.getScaledInstance(SCREEN_WIDTH/Game.XGRID, SCREEN_HEIGHT/Game.YGRID, java.awt.Image.SCALE_SMOOTH);
      this.directorHeadL = ImageIO.read(new File("Director_Head L.png"));
      this.directorHeadL = directorHeadL.getScaledInstance(SCREEN_WIDTH/Game.XGRID, SCREEN_HEIGHT/Game.YGRID, java.awt.Image.SCALE_SMOOTH);

      this.empty = ImageIO.read(new File("Empty.png"));
      this.empty = empty.getScaledInstance(SCREEN_WIDTH/Game.XGRID, SCREEN_HEIGHT/Game.YGRID, java.awt.Image.SCALE_SMOOTH);
      this.towerBase = ImageIO.read(new File("Tower Base.png"));
      this.towerBase = towerBase.getScaledInstance(SCREEN_WIDTH/Game.XGRID, SCREEN_HEIGHT/Game.YGRID, java.awt.Image.SCALE_SMOOTH);
      this.basicTower = ImageIO.read(new File("Basic Tower.png"));
      this.basicTower = basicTower.getScaledInstance(SCREEN_WIDTH/Game.XGRID, SCREEN_HEIGHT/Game.YGRID, java.awt.Image.SCALE_SMOOTH);
      this.basicProjectile = ImageIO.read(new File("Basic Projectile.png"));
      this.basicProjectile = basicProjectile.getScaledInstance(32, 32, java.awt.Image.SCALE_SMOOTH);
      this.den = ImageIO.read(new File("Den.png"));
      this.den = den.getScaledInstance(SCREEN_WIDTH/Game.XGRID, SCREEN_HEIGHT/Game.YGRID, java.awt.Image.SCALE_SMOOTH);

      this.heart = ImageIO.read(new File("Heart.png"));
      this.heart = heart.getScaledInstance(32, 32, java.awt.Image.SCALE_SMOOTH);
      this.dollar = ImageIO.read(new File("Dollar.png"));
      this.dollar = dollar.getScaledInstance(32, 32, java.awt.Image.SCALE_SMOOTH);
      this.skull = ImageIO.read(new File("Skull.png"));
      this.skull = skull.getScaledInstance(32, 32, java.awt.Image.SCALE_SMOOTH);
      this.trophy = ImageIO.read(new File("Trophy.png"));
      this.trophy = trophy.getScaledInstance(32, 32, java.awt.Image.SCALE_SMOOTH);
    
    } catch (IOException e) {

    } // End try

    // Begin!
    state = "Menu";
    menu();

  } // End game

  /**
   * Method: game
   * @return void
   * Description: Runs the game
   */
  public void game () {

    // Begins a game
    this.level.readLevel("Level " + levelNum + ".txt");
    this.wave = 0;
    this.hp = 100;
    this.money = 50;
    this.timer = new Time(this);  
     
    // Reset entities
    labels.clear();
    this.removeAll();
    entities.clear();

    // Text values and buttons
    entities.add(new Button(SCREEN_WIDTH - 32, 0, 32, 32, false, false, false, TITLE, "Settings"));
    this.entities.add(new Text(35, 5, 0, 0, false, true, true, DEFAULT, String.valueOf(this.hp)));
    this.entities.add(new Text(35, 37, 0, 0, false, true, true, DEFAULT, String.valueOf(this.money)));

    tileUpdate = true;

    repaint();  

  } // End game

  /**
   * Method: menu
   * @return void
   * Description: Runs the menu
   */
  public void menu () {

    // Reset entities
    labels.clear();
    this.removeAll();
    entities.clear();
    
    // Add buttons and title
    entities.add(new Text(0, 50, 0, 0, true, true, true, TITLE, "Operation Umbra"));
    entities.get(0).changeX(SCREEN_WIDTH / 2 - entities.get(0).getDx() / 2);

    entities.add(new Button(0, BUTTON_HEIGHT, 0, 0, true, true, true, TITLE, "Start"));
    entities.get(1).changeX(SCREEN_WIDTH / 2 - entities.get(1).getDx() / 2 - BUTTON_DISTANCE / 2);

    entities.add(new Button(0, BUTTON_HEIGHT, 0, 0, true, true, true, TITLE, "Load"));
    entities.get(2).changeX(SCREEN_WIDTH / 2 - entities.get(2).getDx() / 2 + BUTTON_DISTANCE / 2);

    // Settings Gear
    entities.add(new Button(SCREEN_WIDTH - 32, 0, 32, 32, false, false, false, TITLE, "Settings"));

    labels.put("Gear", new JLabel(new ImageIcon(this.gear)));
    JLabel gearLabel = labels.get("Gear");
    Dimension size = gearLabel.getPreferredSize();

    this.add(gearLabel, JLayeredPane.DEFAULT_LAYER);
    gearLabel.setBounds(SCREEN_WIDTH - 32, 0, size.width, size.height);
    gearLabel.setVisible(true);

    repaint();

  } // End menu

  /**
   * Method: settings
   * @return void
   * Description: Runs the settings
   */
  public void settings () {

    // Reset entities
    labels.clear();
    this.removeAll();
    entities.clear();

    // Settings Gear
    entities.add(new Button(SCREEN_WIDTH - 32, 0, 32, 32, false, false, false, TITLE, "Settings"));

    labels.put("Gear", new JLabel(new ImageIcon(this.gear)));
    JLabel gearLabel = labels.get("Gear");
    Dimension size = gearLabel.getPreferredSize();

    this.add(gearLabel, JLayeredPane.DEFAULT_LAYER);
    gearLabel.setBounds(SCREEN_WIDTH - 32, 0, size.width, size.height);
    gearLabel.setVisible(true);

    repaint();

  } // End menu

  /**
   * Method: paintComponenet
   * @param Graphics g
   * @return void
   * Description: Activates upon needing to update the screen
   */
  public void paintComponent(Graphics g) {

    super.paintComponent(g);

    // Draws based on game state
    switch (this.state) {
      case "Menu":
        drawMenu(g);
        break;

      case "Game":
        drawGame(g);
        break;

      case "Settings":
        drawSettings(g);
        break;

      case "Win":
        break;

      case "Lose":
        break;

    } // End switch

  }// End paintComponent

  /**
   * Method: drawGame
   * @param Graphics g
   * @return void
   * Description: Draws the screen for in game elements
   */
  public void drawGame (Graphics g) {

    // Initialization
    int x = (int) (SCREEN_WIDTH / XGRID);
    int y = (int) (SCREEN_HEIGHT / YGRID);

    // Background grid
    g.setColor(BG);

    // Vertical lines
    for (int i = x; i <= SCREEN_WIDTH; i+= x) {

      g.drawLine(i, 0, i, SCREEN_HEIGHT);

    } // End for

    // Horizontal Lines
    for (int i = y; i <= SCREEN_HEIGHT; i+= y) {

      g.drawLine(0, i, SCREEN_WIDTH, i);

    } // End for

    // Draw layout
    if (tileUpdate) this.drawTiles();
    
    // Draw entities
    this.drawEntities(g);

  } // End drawGame

  /**
   * Method: drawMenu
   * @param Graphics g
   * @return void
   * Description: Draws the screen for menu elements
   */
  public void drawMenu (Graphics g) {    

    // Background Effect
    g.setColor(BG);

    for (int i = 2; i <= SCREEN_WIDTH / 2; i = (int)(i * FACTOR)) {

      g.drawRect(SCREEN_WIDTH / 2 - i, SCREEN_HEIGHT / 2 - i, 2 * i, 2 * i);

    } // End for

    // Draw entities
    this.drawEntities(g);

  } // End drawMenu

  /**
   * Method: drawSettings
   * @param Graphics g
   * @return void
   * Description: Draws the screen for settings elements
   */
  public void drawSettings (Graphics g) {    

    // Background Effect
    g.setColor(BG);

    for (int i = 2; i <= SCREEN_WIDTH / 2; i = (int)(i * FACTOR)) {

      g.drawRect(SCREEN_WIDTH / 2 - i, SCREEN_HEIGHT / 2 - i, 2 * i, 2 * i);

    } // End for

    // Draw entities
    this.drawEntities(g);

  } // End drawSettings

  /**
   * Method: drawWin
   * @param Graphics g
   * @return void
   * Description: Draws the win overlay
   */
  public void drawWin (Graphics g) {    

    // Overlay

  } // End drawWin

  /**
   * Method: drawEntities
   * @param Graphics g
   * @return void
   * Description: Draws all existing entities
   */
  public void drawEntities (Graphics g) {

    for (Entity entity: entities) {

      // If the entity is text, print it
      if (entity instanceof Text) {

        Text text = (Text)entity;
        
        // If the text is invisible, skip in
        if (text.getVisible() == false) continue;

        // If the text has a background, draw it first
        if (text.getBackground() != false) {

          final int BUFFER = 10;
          g.setColor(BG);
          g.fillRect(text.getX() - BUFFER, text.getY() + BUFFER, text.getDx() + 2 * BUFFER, text.getDy());

        } // End if

        // Print the actual text
        g.setColor(FG);
        g.setFont(text.getFont());
        g.drawString(text.getName(), text.getX(), text.getY() + text.getDy());
        
      } // Drawing enemies
      // Incomplete as of this sprint 
      /*else if (entity instanceof Enemy) {
        
        Enemy enemy = (Enemy)entity;
        String designation = enemy.getDesignation();

        if (!labels.containsKey(designation)) {

          labels.put(designation, new JLabel(new ImageIcon(this.enemy)));
          JLabel enemyLabel = labels.get(designation);

          this.add(enemyLabel, JLayeredPane.PALETTE_LAYER);
          enemyLabel.setVisible(true);

        } // End if

        JLabel enemyLabel = labels.get(designation);
        enemyLabel.setBounds(enemy.getX(), enemy.getY(), enemy.getDx(), enemy.getDy());
        
      } // End if*/

    } // End for

  } // End drawEntities

  /**
   * Method: drawTiles
   * @return void
   * Description: Draws tiles in game
   */
  public void drawTiles () {

    // Reset
    this.tileUpdate = false;
    labels.clear();
    this.removeAll();

    // Settings gear
    labels.put("Gear", new JLabel(new ImageIcon(this.gear)));
    JLabel gearLabel = labels.get("Gear");
    Dimension size = gearLabel.getPreferredSize();

    this.add(gearLabel, JLayeredPane.DEFAULT_LAYER);
    gearLabel.setBounds(SCREEN_WIDTH - 32, 0, size.width, size.height);
    gearLabel.setVisible(true);

    // Health Indicator
    labels.put("Heart", new JLabel(new ImageIcon(this.heart)));
    JLabel heartLabel = labels.get("Heart");
    size = heartLabel.getPreferredSize();

    this.add(heartLabel, JLayeredPane.DEFAULT_LAYER);
    heartLabel.setBounds(0, 0, size.width, size.height);  
    heartLabel.setVisible(true);

    // Money Indicator
    labels.put("Dollar", new JLabel(new ImageIcon(this.dollar)));
    JLabel dollarLabel = labels.get("Dollar");
    size = dollarLabel.getPreferredSize();

    this.add(dollarLabel, JLayeredPane.DEFAULT_LAYER);
    dollarLabel.setBounds(0, 32, size.width, size.height);
    dollarLabel.setVisible(true);

    // Initialization
    Tile[][] layout = this.level.getLayout();

    // Draws each tile
    for (int i = 0; i < Game.YGRID; i++) {

      for (int j = 0; j < Game.XGRID; j++) {

        Tile tile = layout[j][i];

        if (tile instanceof Home) {

          gridLabels[j][i] = new JLabel(new ImageIcon(this.home));

        // Direction image synthesis more complicated
        // Made up of input pathways, a center, and output paths
        // Layer such components based on intake and output symbols
        } else if (tile instanceof Director) {
          
          // Initiliazation
          Director director = (Director) tile;
          String intake = director.getIntake();
          String output = director.getOutput();

          // Image initializaiton
          this.tempImg = new BufferedImage(SCREEN_WIDTH / XGRID, SCREEN_HEIGHT / YGRID, BufferedImage.TYPE_INT_ARGB);
          Graphics temp = this.tempImg.getGraphics();

          // Intake direction synthesis
          for (int k = 0; k < intake.length(); k++) {

            String chr = intake.substring(k, k + 1);

            switch (chr) {

              case "U":
                temp.drawImage(directorFootU, 0, 0, null);
                break;
              
              case "R":
                temp.drawImage(directorFootR, 0, 0, null);
                break;

              case "D":
                temp.drawImage(directorFootD, 0, 0, null);
                break;

              case "L":
                temp.drawImage(directorFootL, 0, 0, null);
                break;

            } // End switch

          } // End for

          // Output direction synthesis
          for (int k = 0; k < output.length(); k++) {

            String chr = output.substring(k, k + 1);

            switch (chr) {

              case "U":
                temp.drawImage(directorHeadU, 0, 0, null);
                break;
              
              case "R":
                temp.drawImage(directorHeadR, 0, 0, null);
                break;

              case "D":
                temp.drawImage(directorHeadD, 0, 0, null);
                break;

              case "L":
                temp.drawImage(directorHeadL, 0, 0, null);
                break;

            } // End switch

          } // End for

          // Body Synthesis
          temp.drawImage(directorBody, 0, 0, null);
          temp.dispose();

          gridLabels[j][i] = new JLabel (new ImageIcon(this.tempImg));
          
        } else if (tile instanceof Den) {
          
          gridLabels[j][i] = new JLabel (new ImageIcon(this.den));
          
        } else if (tile instanceof Basic) {
          
          gridLabels[j][i] = new JLabel (new ImageIcon(this.basicTower));
          
        } else if (tile instanceof Tower) {
          
          gridLabels[j][i] = new JLabel (new ImageIcon(this.towerBase));
          
        } else {

          gridLabels[j][i] = new JLabel (new ImageIcon(this.empty));

        }
        
        JLabel label = gridLabels[j][i];
        size = label.getPreferredSize();
        label.setBounds(j * SCREEN_WIDTH/Game.XGRID, i * SCREEN_HEIGHT/Game.YGRID, size.width, size.height);
        this.add(label, JLayeredPane.DEFAULT_LAYER);
        label.setVisible(true);

      } // End for

    } // End for

  } // End drawTiles

  /**
   * Method: tick
   * @return void
   * Description: Runs the game
   */
  public void tick () {

    // If lives are below 1, lose the game
    if (this.hp < 1) {

      this.timer.end();
      this.state = "Lose";
      repaint();
      return;

    } // End if

    // If the wave is complete, start the next wave
    if (enemies.size() == 0) {

      // If the wave is final, end this level
      if (this.wave > this.level.getWaves().size()) {

        this.timer.end();
        this.state = "Win";
        repaint();
        return;

      } else {

        enemies = this.level.getWaves().get(this.wave);

        for (Entity entity : enemies) {

          entities.add(entity);

        }

        this.wave++;
        repaint();
        return;

      }

    } // End if

    // Manages enemy movement
    // Incomplete as of this sprint
    /*
    outer:
    for (Enemy enemy: enemies) {

      // If the first movement, move the enemy to the den
      if (enemy.getX() < 0 || enemy.getY() < 0) {

        enemy.changeX(this.level.getDenX());
        enemy.changeY(this.level.getDenY());

      } else {
        
        // Based on tile upon which the enemy is on, take movement actions
        int xTile = (int)(enemy.getX() * XGRID / SCREEN_WIDTH); 
        int yTile = (int)(enemy.getY() * YGRID / SCREEN_HEIGHT); 

        Tile tile = this.level.getLayout()[xTile][yTile];

        // If in a den, move towards the den's direction
        if (tile instanceof Den) {

          Den den = (Den)tile;
          switch (den.getDirection()) {
            case "D":
              enemy.changeY(enemy.getY() + enemy.getSpeed());
              break;

            case "R":
              enemy.changeX(enemy.getX() + enemy.getSpeed());
              break;
              
            case "L":
              enemy.changeX(enemy.getX() - enemy.getSpeed());
              break;
              
            case "U":
              enemy.changeY(enemy.getY() - enemy.getSpeed());
              break;
              
          } // End switch

          break outer;

        // If in a directore, move with the director's output directions (choose one)
        } else if (tile instanceof Director) {

          Director director = (Director) tile;

          if (this.reachTar(enemy) || enemy.getTarX() < -100) {

            Random r = new Random();
            int directionNum = r.nextInt(director.getOutput().length());
            String direction = director.getOutput().substring(directionNum, directionNum + 1);

            switch (direction) {
              case "D":
                enemy.changeTar(enemy.getX(), enemy.getY() + (int)(SCREEN_HEIGHT / YGRID));
                break;

              case "R":
                enemy.changeTar(enemy.getX() + (int)(SCREEN_WIDTH / XGRID), enemy.getY());
                break;

              case "U":
                enemy.changeTar(enemy.getX(), enemy.getY() - (int)(SCREEN_HEIGHT / YGRID));
                break;

              case "L":
                enemy.changeTar(enemy.getX() - (int)(SCREEN_WIDTH / XGRID), enemy.getY());
                break;

            } // End switch

            continue;

          } // End if

          enemy.changeX(enemy.getX() + enemy.getIncX());
          enemy.changeY(enemy.getY() + enemy.getIncY());

        } else if (tile instanceof Home) {

          hp -= enemy.getWeight();
          enemies.remove(enemy);
            
        } // End if

      } // End if

    } // End for
    */

    repaint();

  } // End tick

  /**
   * Method: reachTar
   * @param moving
   * @return boolean
   * Description: checks if a moving entity reaches a target destination
   */
  public boolean reachTar (Moving moving) {

    if (moving.getIncX() >= 0) {

      if (moving.getX() >= moving.getTarX()) {

        if (moving.getIncY() >= 0) {

          if (moving.getY() >= moving.getTarY()) {

            return true;

          } // End if

        } else {
          
          if (moving.getY() <= moving.getTarY()) {

            return true;

          } // End if

        } // End if

      } // End if

    } else {

      if (moving.getX() <= moving.getTarX()) {

        if (moving.getIncY() >= 0) {

          if (moving.getY() >= moving.getTarY()) {

            return true;

          } // End if

        } else {
          
          if (moving.getY() <= moving.getTarY()) {

            return true;

          } // End if

        } // End if

      } // End if

    } // End if

    return false;

  } // End reachTar

  // MouseListener ---------------------------------------------------

  /**
   * Method: mouseClicked
   * @param MouseEvent e
   * @return void
   * Description: Activates upon click
   */
  public void mouseClicked(MouseEvent e) {  

    // Checks if any buttons were pressed
    for (Entity entity: entities) {

      // If the entity is a button:
      if (entity instanceof Button) {

        Button button = (Button)entity;

        // If the mouse was on the button, activate it
        if (e.getX() >= button.getX() && e.getX() <= button.getX() + button.getDx() && e.getY() >= button.getY() && e.getY() <= button.getY() + button.getDy()) {
          
          switch (button.getName()) {

            case "Start":
              state = "Game";
              game();
              return;

            case "Load":
              return;

            case "Settings":
              
              // Return to previous screen if settings is the current screen
              if (state.equals("Settings")) {

                state = back;

                switch (state) {

                  case "Game":
                    this.game();
                    break;
                  
                  case "Menu":
                    this.menu();
                    break;

                } // End switch

              } else {

                if (state.equals("Game")) this.timer.end();
              
                back = state;
                state = "Settings";
                settings();
              
              } // End if

              return;

          } // End switch

        } // End if

      } // End if

    } // End for

    // Handles in game clicks
    if (state.equals("Game")) {    

      // Handles tower purchasing
      // Find the mouse's tile coordinates
      int xCoord = (int)(e.getX() / (SCREEN_WIDTH / Game.XGRID));
      int yCoord = (int)(e.getY() / (SCREEN_HEIGHT / Game.YGRID));

      // Purchase a tower if funds are available
      if (this.level.getLayout()[xCoord][yCoord] instanceof Tower) {

        if (money >= 50) {

          this.changeMoney(-50);
          this.level.changeTower(xCoord, yCoord, "Basic");
          tileUpdate = true;
          repaint();   

        } // End if

      } // End if

    } // End if

  } // End mouseClicked

  /**
   * Method: mouseEntered
   * @param MouseEvent e
   * @return void
   * Description: Activates upon mouse entrance
   */
  public void mouseEntered(MouseEvent e) {  

  } // End mouseEntered

  /**
   * Method: mouseExited
   * @param MouseEvent e
   * @return void
   * Description: Activates upon mouse exit
   */
  public void mouseExited(MouseEvent e) {  

  } // End mouseExited

  /**
   * Method: mousePressed
   * @param MouseEvent e
   * @return void
   * Description: Activates upon press
   */
  public void mousePressed(MouseEvent e) {  

  } // End mousePressed

  /**
   * Method: mouseReleased
   * @param MouseEvent e
   * @return void
   * Description: Activates upon release
   */
  public void mouseReleased(MouseEvent e) {  

  } // End mouseReleased

  // Mutators ---------------------------------------------------
  /**
   * Method: changeState
   * @param newState
   * @return void
   * Description: Changes the current state of the game
   */
   public void changeState (String newState) {

     this.state = newState;

   } // End changeState

   /**
   * Method: changeLevel
   * @param newLevel
   * @return void
   * Description: Changes the current level of the game
   */
   public void changeLevel (Level newLevel) {

     this.level = newLevel;

   } // End changeLevel

   /**
   * Method: changeLevelNum
   * @param newLevelNum
   * @return void
   * Description: Changes the current level number of the game
   */
   public void changeLevelNum (int newLevelNum) {

     this.levelNum = newLevelNum;

   } // End changeLevelNum

   /**
   * Method: changeMoney
   * @param newMoney
   * @return void
   * Description: Changes the current money of the game
   */
   public void changeMoney (int diffMoney) {

    this.money = this.money + diffMoney;
    ((Text)this.entities.get(2)).changeName(String.valueOf(this.money));

   } // End changeMoney

  // Accessors ---------------------------------------------------
  /**
   * Method: getState
   * @return String
   * Description: Gets the current state of the game
   */
   public String getState () {

     return this.state;

   } // End changeState

   /**
   * Method: getLevel
   * @return Level
   * Description: Gets the current level of the game
   */
   public Level getLevel () {

     return this.level;

   } // End changeLevel

   /**
   * Method: getLevelNum
   * @return int
   * Description: Gets the current level number of the game
   */
   public int getLevelNum () {

     return this.levelNum;

   } // End changeLevelNum

}