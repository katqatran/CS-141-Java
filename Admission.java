// Katherine Tran
//
// This program allows the user to input information about two applicants, including their SAT or ACT scores and
// weighted GPA. It then evaluates the applicants using conditional statements to determine which one appears to be the
// stronger candidate.
import java.util.Scanner;

public class Admission {
   
   public static void main(String[] args) {
       Scanner console = new Scanner(System.in);
       System.out.println("Information for applicant #1:");
       double first = mainHelper(console);
       System.out.println("Information for applicant #2:");
       double second = mainHelper(console);
       System.out.printf("First applicant overall score  = " , first);
       System.out.printf("Second applicant overall score = " , second);
       better(first, second);
   }

    /**
     * The function prompts the user with questions to input their exam scores and GPA, and returns the overall score of
     * the applicant.
     * @param console the Scanner object used for user input
     * @return the overall score of the applicant
     */
   public static double mainHelper(Scanner console){
       System.out.print("do you have 1) SAT scores or 2) ACT scores?");
       int option = console.nextInt();
       double score = 0.0;
       
       if (option == 1) {
         score = SAT(console);
       }
       else if (option == 2) {
         score = ACT(console);
       }
       
       System.out.println("exam score = " + score);
       double GPA = GPA(console);
       System.out.println("GPA score = " + GPA);
       return overallScore(score, GPA);
   }

    /**
     * This method calculates and returns the ACT score of an applicant based on their ACT scores in English, Math,
     * Reading, and Science.
     * @param console A Scanner object for taking user input
     * @return The calculated ACT score
     */
    public static double ACT(Scanner console){
      System.out.print("ACT English?");
      double english = console.nextDouble();
      System.out.print("ACT math?");
      double math = console.nextDouble();
      System.out.print("ACT reading?");
      double reading = console.nextDouble();
      System.out.print("ACT science?");
      double science = console.nextDouble();
      double score = (english + 2 * math + reading + science) / 1.8;
      return score;
   }

    /**
     * This method calculates the SAT score for an applicant based on their math, critical reading, and writing scores.
     * @param console the Scanner object to read user input
     * @return the calculated SAT score for the applicant
     */
   public static double SAT(Scanner console){
      System.out.print("SAT math?");
      double math = console.nextDouble();
      System.out.print("SAT critical reading?");
      double reading = console.nextDouble();
      System.out.print("SAT writing?");
      double writing = console.nextDouble();

      double score = (2 * math + reading + writing) / 32;
      return score;
   }

    /**
     * This method calculates the GPA score of an applicant based on user input for actual GPA, max GPA, and Transcript
     * Multiplier.
     * @param console Scanner object used for user input
     * @return GPA score of the applicant
     */
   public static double GPA(Scanner console){
      System.out.print("overall GPA?");
      double actual = console.nextDouble();
      System.out.print("max GPA?");
      double max = console.nextDouble();
      System.out.print("Transcript Multiplier?");
      double transcript = console.nextDouble();
      double GPA = (actual / max) * 100 * transcript;
      return GPA;
   }

    /**
     * This method calculates and returns the overall score of an applicant based on their exam score and GPA.
     * @param score the exam score of the applicant.
     * @param GPA the GPA score of the applicant.
     * @return  the overall score of the applicant.
     */
   public static double overallScore(double score, double GPA){
      return score + GPA;
   }

    /**
     * This method compares the scores of two applicants and prints out which applicant seems to be better.
     * @param one the score of the first applicant
     * @param two the score of the second applicant
     */
   public static void better(double one, double two){
      if (one > two) {
         System.out.println("The first applicant seems to be better");
      } 
      else if (two > one){
         System.out.println("The second applicant seems to be better");
      }
      else {
         System.out.println("The two applicants seem to be equal");
      }
   }
}
   
