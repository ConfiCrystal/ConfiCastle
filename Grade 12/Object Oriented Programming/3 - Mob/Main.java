/**
*  Name: Andy Lee
*  Date: October, 13, 2021
*  Program: Main
*  Description: This program is a main for the mob class and its subclasses
*/

// Main class
public class Main {
   
   // Main main
   public static void main(String[] args) {
      
      // Mob Test
      Mob mob1 = new Mob(0,0,0,20);
      
      System.out.println("This mob's x position is: " + mob1.getX());
      System.out.println("This mob's y position is: " + mob1.getY());
      System.out.println("This mob's z position is: " + mob1.getZ());
      System.out.println("This mob's hp is: " + mob1.getHP());
      mob1.sound();
      mob1.move(1,1,1);
      System.out.println("This mob's x position is: " + mob1.getX());
      System.out.println("This mob's y position is: " + mob1.getY());
      System.out.println("This mob's z position is: " + mob1.getZ());
      
      // Creeper Test
      Creeper creeper1 = new Creeper(0,0,0,20);
      
      System.out.println("This creeper's x position is: " + creeper1.getX());
      System.out.println("This creeper's y position is: " + creeper1.getY());
      System.out.println("This creeper's z position is: " + creeper1.getZ());
      System.out.println("This creeper's hp is: " + creeper1.getHP());
      creeper1.sound();
      creeper1.explode();
      creeper1.move(1,1,1);
      System.out.println("This creeper's x position is: " + creeper1.getX());
      System.out.println("This creeper's y position is: " + creeper1.getY());
      System.out.println("This creeper's z position is: " + creeper1.getZ());
      
      // Skeleton Test
      Skeleton skeleton1 = new Skeleton (0,0,0,20,20);
      
      System.out.println("This skeleton's x position is: " + skeleton1.getX());
      System.out.println("This skeleton's y position is: " + skeleton1.getX());
      System.out.println("This skeleton's z position is: " + skeleton1.getX());
      System.out.println("This skeleton's hp is: " + skeleton1.getHP());
      skeleton1.attack(30);
      skeleton1.attack(20);
      skeleton1.move(1,1,1);
      System.out.println("This skeleton's x position is: " + skeleton1.getX());
      System.out.println("This skeleton's y position is: " + skeleton1.getX());
      System.out.println("This skeleton's z position is: " + skeleton1.getX());
      
   } // End main

} // End Main