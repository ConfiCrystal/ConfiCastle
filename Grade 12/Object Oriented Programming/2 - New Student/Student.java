/**
*  Name: Andy Lee
*  Date: September, 30, 2021
*  Program: Student
*  Description: This program is a class for the Student object
*/

// Imported libraries
import java.util.*;

// Student Class
public class Student {
   
   // Initialization
   // Self explanatory Strings representing parameters
   private String name, schoolName, email, guardian, sex;
   
   // Array for courses
   private int numCourses = 9;
   private String[] courses = new String[numCourses];
   
   // Array for grades
   private double[] grades = new double[numCourses];
   
   // Self explanatory integers representing parameters
   private int healthCardNumber, studentNumber, age, phoneNumber;
   
   // Student Main
   public static void main (String[] args) {
   
      // Nothing
   
   } // End Main

   /**
   * Method: Student
   * Inputs: N/A
   * Outputs: N/A
   * Description: Constructor Method
   */
   public Student () {
   
      this.name = "None";
      this.schoolName = "None";
      this.email = "None";
      this.guardian = "None";
      this.sex = "None";
      this.healthCardNumber = -1;
      this.studentNumber = -1;
      this.age = -1;
      this.phoneNumber = -1;
      
      // Empty marks
      for (int i = 0; i < courses.length; i++) {
      
         courses[i] = "None";
         grades[i] = -1;
      
      } // End for
      
      // Output
      System.out.println("\nThe Student, " + this.name + ", has been created");
      
   } // End Student
   
   /**
   * Method: Student
   * Inputs: N/A
   * Outputs: N/A
   * Description: General Constructor Method
   */
   public Student (String name, String schoolName, String email, String guardian, String sex, int healthCardNumber, int studentNumber, int age, int phoneNumber) {
   
      this.name = name;
      this.schoolName = schoolName;
      this.email = email;
      this.guardian = guardian;
      this.sex = sex;
      this.healthCardNumber = healthCardNumber;
      this.studentNumber = studentNumber;
      this.age = age;
      this.phoneNumber = phoneNumber;
      
      // Empty marks
      for (int i = 0; i < courses.length; i++) {
      
         courses[i] = "None";
         grades[i] = 0;
      
      } // End for
      
      // Output
      System.out.println("\nThe Student, " + this.name + ", has been created");
      
   } // End Student   
   
   // ------------------------------------------------ Mutators ------------------------------------------------
   
   /**
   * Method: emailChange
   * Inputs: None
   * Outputs: void
   * Description: Replaces a student's email
   */
   public void emailChange () {
      
      // Initialization
      Scanner in = new Scanner (System.in);
      String email;
      
      // Input
      System.out.print("\nPlease enter a new email for " + this.name + ": ");
      email = in.nextLine();
      
      // Output
      this.email = email;
      System.out.println(this.name + "'s email is now: " + email);
   
   } // End emailChange
   
   /**
   * Method: sexChange
   * Inputs: None
   * Outputs: void
   * Description: Replaces a student's sex
   */
   public void sexChange () {
      
      // Initialization
      Scanner in = new Scanner (System.in);
      String sex;
      
      // Input
      System.out.print("\nPlease enter a new sex for " + this.name + ": ");
      sex = in.nextLine();
      
      // Output
      this.sex = sex;
      System.out.println(this.name + "'s sex is now: " + sex);
   
   } // End sexChange
   
   /**
   * Method: nameChange
   * Inputs: None
   * Outputs: void
   * Description: Replaces a student's name
   */
   public void nameChange () {
      
      // Initialization
      Scanner in = new Scanner (System.in);
      String name;
      
      // Input
      System.out.print("\nPlease enter a new name for " + this.name + ": ");
      name = in.nextLine();
      
      // Output
      this.name = name;
      System.out.println(this.name + "'s name is now: " + name);
   
   } // End nameChange
   
   /**
   * Method: schoolNameChange
   * Inputs: None
   * Outputs: void
   * Description: Replaces a student's school's name
   */
   public void schoolNameChange () {
      
      // Initialization
      Scanner in = new Scanner (System.in);
      String schoolName;
      
      // Input
      System.out.print("\nPlease enter a new school name for " + this.name + ": ");
      schoolName = in.nextLine();
      
      // Output
      this.schoolName = schoolName;
      System.out.println(this.name + "'s school name is now: " + schoolName);
   
   } // End schoolNameChange
   
   /**
   * Method: guardianChange
   * Inputs: None
   * Outputs: void
   * Description: Replaces a student's guardian's name
   */
   public void guardianChange () {
      
      // Initialization
      Scanner in = new Scanner (System.in);
      String guardian;
      
      // Input
      System.out.print("\nPlease enter a guardian for " + this.name + ": ");
      guardian = in.nextLine();
      
      // Output
      this.guardian = guardian;
      System.out.println(this.name + "'s guardian is now: " + guardian);
   
   } // End guardianChange
   
   /**
   * Method: ageChange
   * Inputs: None
   * Outputs: void
   * Description: Replaces a student's age
   */
   public void ageChange () {
      
      // Initialization
      int age;
      
      // Input
      age = inputInt("\nPlease enter a new age for " + this.name + ": ");
      
      // Output
      this.age = age;
      System.out.println(this.name + "'s age is now: " + age);
   
   } // End ageChange
   
   /**
   * Method: phoneNumberChange
   * Inputs: None
   * Outputs: void
   * Description: Replaces a student's phoneNumber
   */
   public void phoneNumberChange () {
      
      // Initialization
      int phoneNumber;
      
      // Input
      phoneNumber = inputInt("\nPlease enter a new phone number for " + this.name + ": ");
      
      // Output
      this.phoneNumber = phoneNumber;
      System.out.println(this.name + "'s phone number is now: " + phoneNumber);
   
   } // End phoneNumberChange
   
   /**
   * Method: courseChange
   * Inputs: int courseNum
   * Outputs: void
   * Description: Replaces a student's course
   */
   public void courseChange (int courseNum) {
      
      // Initialization
      Scanner in = new Scanner (System.in);
      String input;
      
      // Input
      System.out.print("\nPlease enter a new course for " + this.name + "'s #" + (courseNum + 1) + " course: ");
      input = in.nextLine();
      
      // Output
      this.courses[courseNum] = input;
      System.out.printf("%s's #%d course is now: %s", this.name, courseNum + 1, input);
   
   } // End courseChange
   
   /**
   * Method: gradeChange
   * Inputs: int courseNum
   * Outputs: void
   * Description: Replaces a student's grade
   */
   public void gradeChange (int courseNum) {
      
      // Initialization
      double input;
      
      // Input
      input = inputDouble("\nPlease enter a grade for " + this.name + "'s #" + (courseNum + 1) + " course: ");
      
      // Output
      this.grades[courseNum] = input;
      System.out.printf("%s's #%d course grade is now: %.2f%n", this.name, courseNum + 1, input);
   
   } // End gradeChange
   
   // ------------------------------------------------ Accessors ------------------------------------------------
   
   /**
   * Method: summary
   * Inputs: None
   * Outputs: void
   * Description: Summarises a student's attributes
   */
   public void summary () {
      
      // Output
      System.out.println("\nThis student has the following attributes:");
      System.out.println("Name: " + this.name);
      System.out.println("School Name: " + this.schoolName);
      System.out.println("Email: " + this.email);
      System.out.println("Guardian: " + this.guardian);
      System.out.println("Sex: " + this.sex);
      System.out.println("Health Card Number: " + this.healthCardNumber);
      System.out.println("Student Number: " + this.studentNumber);
      System.out.println("Age: " + this.age);
      System.out.println("Phone Number: " + this.phoneNumber);
      
      // Courses and grades
      for (int i = 0; i < courses.length; i++) {
      
         System.out.printf("%s: %.2f%%%n", courses[i], grades[i]);
      
      } // End for
   
   } // End summary
   
   /**
   * Method: email
   * Inputs: None
   * Outputs: String
   * Description: Returns a student's email
   */
   public String email () {
      
      // Output
      return this.email;
         
   } // End email
   
   /**
   * Method: name
   * Inputs: None
   * Outputs: String
   * Description: Returns a student's name
   */
   public String name () {
      
      // Output
      return this.name;
         
   } // End name
   
   /**
   * Method: schoolName
   * Inputs: None
   * Outputs: String
   * Description: Returns a student's school name
   */
   public String schoolName () {
      
      // Output
      return this.schoolName;
         
   } // End schoolName
   
   /**
   * Method: guardian
   * Inputs: None
   * Outputs: String
   * Description: Returns a student's guardian's name
   */
   public String guardian () {
      
      // Output
      return this.guardian;
         
   } // End guardian
   
   /**
   * Method: sex
   * Inputs: None
   * Outputs: String
   * Description: Returns a student's sex
   */
   public String sex () {
      
      // Output
      return this.sex;
         
   } // End sex
   
   /**
   * Method: healthCardNumber
   * Inputs: None
   * Outputs: Integer
   * Description: Returns a student's healthCardNumber
   */
   public int healthCardNumber () {
      
      // Output
      return this.healthCardNumber;
         
   } // End healthCardNumber
   
   /**
   * Method: studentNumber
   * Inputs: None
   * Outputs: Integer
   * Description: Returns a student's studentNumber
   */
   public int studentNumber () {
      
      // Output
      return this.studentNumber;
         
   } // End studentNumber
   
   /**
   * Method: age
   * Inputs: None
   * Outputs: Integer
   * Description: Returns a student's age
   */
   public int age () {
      
      // Output
      return this.age;
         
   } // End age
   
   /**
   * Method: phoneNumber
   * Inputs: None
   * Outputs: Integer
   * Description: Returns a student's phoneNumber
   */
   public int phoneNumber () {
      
      // Output
      return this.phoneNumber;
         
   } // End phoneNumber
   
   /**
   * Method: courses
   * Inputs: int courseNum
   * Outputs: String
   * Description: Returns a student's course based on an inputted number
   */
   public String courses (int courseNum) {
      
      // Output
      return this.courses[courseNum];
         
   } // End courses
   
   /**
   * Method: grades
   * Inputs: int courseNum
   * Outputs: Double
   * Description: Returns a student's course grade based on an inputted number
   */
   public double grades (int courseNum) {
      
      // Output
      return this.grades[courseNum];
         
   } // End grades
   
   /**
   * Method: numCourses
   * Inputs: Void
   * Outputs: Integer
   * Description: Returns a student's number of courses
   */
   public double numCourses () {
      
      // Output
      return this.numCourses;
         
   } // End numCourses
   
   // ------------------------------------------------ Misc ------------------------------------------------
   
   /**
   * Method: inputInt
   * Inputs: String prompt
   * Outputs: int
   * Description: Gathers a positive integer input
   */
   private int inputInt (String prompt) {
      
      // Initialization
      Scanner in = new Scanner (System.in);
      String input;
      int inputInt;
      
      // Input
      System.out.print(prompt);
      input = in.nextLine();
      
      // Ensures a valid input is typed
      try {
         
         // Integer value of input
         inputInt = Integer.parseInt(input);
      
         // Ensures a positive input is typed
         if (inputInt < 0) {
         
            System.out.println("Invalid Input");
            return inputInt (prompt);
         
         } // End if
         
         return inputInt;
      
      } catch (NumberFormatException e) {
      
         System.out.println("Invalid Input");
         return inputInt (prompt);
      
      } // End try
   
   } // End inputInt
   
   /**
   * Method: inputDouble
   * Inputs: String prompt
   * Outputs: Double
   * Description: Gathers a positive Double input
   */
   private double inputDouble (String prompt) {
      
      // Initialization
      Scanner in = new Scanner (System.in);
      String input;
      double inputDouble;
      
      // Input
      System.out.print(prompt);
      input = in.nextLine();
      
      // Ensures a valid input is typed
      try {
         
         // Integer value of input
         inputDouble = Double.parseDouble(input);
      
         // Ensures a positive input is typed
         if (inputDouble < 0) {
         
            System.out.println("Invalid Input");
            return inputDouble (prompt);
         
         } // End if
         
         return inputDouble;
      
      } catch (NumberFormatException e) {
      
         System.out.println("Invalid Input");
         return inputDouble (prompt);
      
      } // End try
   
   } // End inputDouble
   
} // End Class