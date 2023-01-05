/**
*  Name: Andy Lee
*  Date: September, 30, 2021
*  Program: StudentTest
*  Description: This program is a test for the Student class
*/

// StudentTest Class
public class StudentTest {
   
   // Student Main
   public static void main (String[] args) {
   
      // Method input test
      Student student1 = new Student();
      
      // Initial summary
      student1.summary();
      
      // Change everything
      student1.emailChange();
      student1.sexChange();
      student1.nameChange();
      student1.schoolNameChange();
      student1.guardianChange();
      student1.ageChange();
      student1.phoneNumberChange();
      
      // Each grade / course
      for (int i = 0; i < student1.numCourses(); i++) {
      
         student1.courseChange(i);
         student1.gradeChange(i);
      
      } // End for
      
      // Post change summary
      student1.summary();
      
      // Accessors test
      System.out.println("\n" + student1.name());
      System.out.println(student1.schoolName());
      System.out.println(student1.email());
      System.out.println(student1.guardian());
      System.out.println(student1.sex());
      System.out.println(student1.healthCardNumber());
      System.out.println(student1.studentNumber());
      System.out.println(student1.age());
      System.out.println(student1.phoneNumber());
      
      // Each grade / course
      for (int i = 0; i < student1.numCourses(); i++) {
      
         System.out.printf("%s: %.2f%%%n", student1.courses(i), student1.grades(i));
      
      } // End for
   
   } // End Main
   
} // End Class