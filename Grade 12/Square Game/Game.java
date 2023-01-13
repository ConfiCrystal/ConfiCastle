/**
*  Name: Andy Lee
*  Date: October, 14, 2021
*  Program: Game
*  Description: This program is a main for the square game
*/

// Imported Libraries
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.ArrayList;
import java.util.Random;

// Game class
public class Game extends JPanel implements ActionListener {
   
   // Constants
   static final int SCREEN_WIDTH = 500;
   static final int SCREEN_HEIGHT = 500;
   static final int PLAYER_LENGTH = 50;
   static final int TARGET_LENGTH = 20;
   static final int SUM_LENGTH = PLAYER_LENGTH + TARGET_LENGTH;
   static final int UNIT = 5;
   static final int DELAY = 30;
   
   // Keys to Press
   static final int UP_KEY = KeyEvent.VK_UP;
   static final int LEFT_KEY = KeyEvent.VK_LEFT;
   static final int RIGHT_KEY = KeyEvent.VK_RIGHT;
   static final int DOWN_KEY = KeyEvent.VK_DOWN;
   
   
   //Determining whether a key is pressed
   boolean upPressed = false;
   boolean leftPressed = false;
   boolean rightPressed = false;
   boolean downPressed = false;
   
   boolean gameOver = false;
   
   int score = 0;
   int numCoins = 4;
   int numEnemies = 2;
    
   Timer timer;
   
   //Declaring characters
   public Player p1;
   public ArrayList<Entity> entities = new ArrayList<Entity> ();
   
   /**
   * Method: Game
   * @params N/A
   * @return N/A
   * Description: Constructor Method
   */
   public Game(){
      
      this.setPreferredSize(new Dimension(SCREEN_WIDTH,SCREEN_HEIGHT));
      this.setBackground(Color.black);
      this.setFocusable(true);
      this.addKeyListener(new MyKeyAdapter());
      
      startGame();
      
   } // End game
   
   
   /***
      Initializing the values of the game
      @param: N/A
      @return: void
   **/
   public void startGame() {
   
      // Intialization
      Random random = new Random();
      p1 = new Player(0,0,PLAYER_LENGTH,PLAYER_LENGTH,Color.red);
      
      // Adds coins
      for (int i = 0; i < numCoins; i++) {
      
         entities.add(new Coin(0, 0, TARGET_LENGTH, TARGET_LENGTH, new Color(255, 255, 0, 255), false));
      
      }
      
      // Adds enemies
      for (int i = 0; i < numEnemies; i++) {
      
         entities.add(new Enemy(0, 0, TARGET_LENGTH, TARGET_LENGTH, new Color(0, 0, 255, 255)));
         
      }
      
      // Sets coin and enemy positions
      newGame();
      
      timer = new Timer(DELAY,this);
      timer.start();
      
   } // End startGame
   
  /**
   * Method: newGame
   * @params N/A
   * @return void
   * Description: Adds an enemy and coin, and randomizes positions
   */
   public void newGame() {
      
      Random random = new Random();
      
      p1.xSet(0);
      p1.ySet(0);
      
      entities.add(new Coin(0, 0, TARGET_LENGTH, TARGET_LENGTH, new Color (255,255,0,255), false));
      entities.add(new Enemy(0, 0, TARGET_LENGTH, TARGET_LENGTH, new Color (0,0,255,255)));
      
      numCoins++;
      numEnemies++;
      
      // Entity reset
      for (Entity entity : entities) {
      
         // If Coin
         if (entity instanceof Coin) {
         
            Coin coin = (Coin) entity;
            coin.claimedSet(false);
            coin.xSet(random.nextInt(SCREEN_WIDTH-SUM_LENGTH) + PLAYER_LENGTH);
            coin.ySet(random.nextInt(SCREEN_WIDTH-SUM_LENGTH) + PLAYER_LENGTH);
            
         // If Enemy
         } else {
         
            Enemy enemy = (Enemy) entity;
            enemy.xSet(random.nextInt(SCREEN_WIDTH-SUM_LENGTH) + PLAYER_LENGTH);
            enemy.ySet(random.nextInt(SCREEN_WIDTH-SUM_LENGTH) + PLAYER_LENGTH);
         
         } // End if
      
      } // End for
      
   } // End newGame
   
   /**
   * Method: paintComponenet
   * @params Graphics g
   * @return void
   * Description: paints a componenet
   */
   public void paintComponent(Graphics g) {
   
      super.paintComponent(g);
      draw(g);
      
   }// End paintComponent
   
   /***
   Drawing the Game
   ***/
   public void draw(Graphics g) {
      g.setColor(Color.red);
      g.fillRect(p1.x(), p1.y(), p1.length(), p1.width());
      
      // Draws entities
      for (Entity entity : entities) {
        
        // If Coin
         if (entity instanceof Coin) {
         
            Coin coin = (Coin) entity;
            
            if (coin.claimed() == false) {
            
               g.setColor(coin.color());
               g.fillOval(coin.x(), coin.y(), coin.width(), coin.length());
               
            } // End if
            
         // If Enemy
         } else {
         
            Enemy enemy = (Enemy) entity;
            g.setColor(enemy.color());
            g.fillOval(enemy.x(), enemy.y(), enemy.width(), enemy.length());
         
         } // End if
         
      } // End for
      
      // Game end condition
      if (gameOver == true) {
      
         g.setColor (new Color(255,255,255,255));
         g.drawString("GAME OVER", SCREEN_WIDTH/2-40, SCREEN_HEIGHT/2);
         timer.stop();
         
      } // End if


      // Draw Score
      g.setColor(Color.white);
      g.drawString("Score: " + score, 0, SCREEN_HEIGHT);    
   }
   
   /**
   * Method: actionPerformed
   * @params ActionEvent e
   * @return void
   * Description: Does an action
   */
   @Override
    public void actionPerformed(ActionEvent e) {
      move();
      checkCollision();
      repaint();
      
      int count = 0;
            
      // New coins condition
      for (Entity entity : entities) {
            
         if (entity instanceof Coin) {
         
            if (((Coin) entity).claimed() == false) break;
               
            count++;
            
         } // End if
         
      } // End for
      
      
      if (count == numCoins) newGame();
      
   } // End actionPerformed
   
   /**
      Movement Code
   */
   public void move(){
      if (upPressed) {
         p1.ySet(p1.y() - UNIT);
      }
      if (leftPressed) {
         p1.xSet(p1.x() - UNIT);
      }
      if (rightPressed) {
         p1.xSet(p1.x() + UNIT);
      }
      if (downPressed) {
         p1.ySet(p1.y() + UNIT);
      }
   }
   
   
   /***
   Collision Code
   */
   public void checkCollision() {
      // Horizontal check
      if (p1.x()<0) p1.xSet(0);
      else if (p1.x()>SCREEN_WIDTH-PLAYER_LENGTH) p1.xSet(SCREEN_WIDTH-PLAYER_LENGTH);
      
      // Vertical check
      if (p1.y()<0) p1.ySet(0);
      else if (p1.y()>SCREEN_HEIGHT-PLAYER_LENGTH) p1.ySet(SCREEN_HEIGHT-PLAYER_LENGTH);
      
      // Entity collision
      for (Entity entity : entities) {
      
         if (p1.x() >= entity.x() - PLAYER_LENGTH && p1.x() <= entity.x() + TARGET_LENGTH && p1.y() >= entity.y() - PLAYER_LENGTH && p1.y() <= entity.y() + TARGET_LENGTH) {
            
            // Coin
            if (entity instanceof Coin) {
            
               Coin coin = (Coin) entity;
               
               if (coin.claimed() == false) {
               
                  score ++;
                  
               } // End if
               
               coin.claimedSet(true); 
            
            // Enemy
            } else {
            
               gameOver = true;
            
            } // End if
         
         } // End if
      
      } // End for
      
   } // End checkCollision
   
   /**
   * Class: myKeyAdapter
   * Description: Checks for keys being pressed
   */
   public class MyKeyAdapter extends KeyAdapter{
      @Override
        public void keyPressed(KeyEvent e) {
         if (e.getKeyCode() == UP_KEY) {
            upPressed = true;
         }
         if (e.getKeyCode() == LEFT_KEY) {
            leftPressed = true;
         } 
         if (e.getKeyCode() == RIGHT_KEY) {
            rightPressed = true;
         }
         if (e.getKeyCode() == DOWN_KEY) {
            downPressed = true;
         }
      }
      public void keyReleased(KeyEvent e) {
         if (e.getKeyCode() == UP_KEY) {
            upPressed = false;
         }
         if (e.getKeyCode() == LEFT_KEY) {
            leftPressed = false;
         }
         if (e.getKeyCode() == RIGHT_KEY) {
            rightPressed = false;
         }
         if (e.getKeyCode() == DOWN_KEY) {
            downPressed = false;
         }
      }
   }
   
} // End class