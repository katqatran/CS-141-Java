// Katherine Tran
//
// This program is designed to analyze the content of emails and determine whether they are spam.
// It utilizes a line-based approach to isolate individual emails from the input file, and then employs token-based
// processing on each line to identify potential spam words.
// The program can effectively evaluate the contents of each email and make an informed determination on its spam status.
// To evaluate the functionality of this program, use the file named 'emails.txt' as a test case.

import java.io.*;
import java.util.*;

public class SpamFilter {

   public static void main(String[] args) throws FileNotFoundException {
      File f = new File("emails.txt"); 
      Scanner input = new Scanner(f);
      File g = new File("summary.txt"); 
      PrintStream output = new PrintStream(g); 
      output.println("Ignore the robots reading your emails...");
      output.println();
      int threshold = 2;
      int emails = readFile(input, threshold, output);
      output.println();
      output.println(emails + " emails processed.");
   }

   /**
    * The function reads through an input Scanner object line by line and identifies emails that contain a "Subject:" line.
    * For each identified email, the function calls the find() function to analyze the contents and identify potential spam words.
    * If the number of identified spam words exceeds the given threshold, the function outputs the email to the given PrintStream object.
    * @param input the input Scanner object to read from
    * @param threshold the minimum number of spam words
    * @param output the output PrintStream object to write spam emails to
    * @return the number of emails identified in the input file
    * @throws FileNotFoundException  if the input file cannot be found or accessed
    */
   public static int readFile(Scanner input, int threshold, PrintStream output) throws FileNotFoundException{
      int count = 0;
      while(input.hasNextLine()) {
         String line = input.nextLine();
         if(line.contains("Subject: ")){
            count++;
            find(input, line.substring(9), threshold, output);
         }
      }
      return count;
   }

   /**
    * The function scans through an input Scanner object to identify potential spam words, and calculates the number of
    * identified spam words. If the number of identified spam words exceeds the given threshold, the function calls the
    * summary() function to write a summary of the spam email to the given PrintStream object.
    * @param input the input Scanner object to read from
    * @param subject the subject line of the email being analyzed
    * @param threshold the minimum number of spam words required for an email to be considered spam
    * @param output the output PrintStream object to write spam summaries to
    * @throws FileNotFoundException if the input file cannot be found or accessed
    */
   public static void find(Scanner input, String subject, int threshold, PrintStream output) throws FileNotFoundException{
      int spam = 0;
      while(input.hasNext()) {
         String word = input.next();
         if(word.toLowerCase().contains("offer")) { 
            spam++;
         }
         else if(word.toLowerCase().contains("wire")) { 
            spam++;
         }
         else if(word.toLowerCase().contains("bank")) { 
            spam++;
         }
         else if(word.toLowerCase().contains("fund")) { 
            spam++;
         }
         else if(word.toLowerCase().contains("transfer")) { 
            spam++;
         }
         else if(word.toLowerCase().contains("lottery")) { 
            spam++;
         }
         if(word.equals("---eom---")) {
            break;
         }
      }
      summary(subject, threshold, spam, output);
   }

   /**
    * The function prints a summary of a subject to the given output stream, indicating if the subject is considered spam.
    * @param subject the subject to summarize
    * @param threshold the spam threshold; if the number of spam emails received for a given sender is at least this
    * number, the email is considered spam
    * @param spam the number of spam emails received from the sender of the current email
    * @param output the output stream to print the summary to
    * @throws FileNotFoundException if the output file cannot be found or opened
    */
   public static void summary(String subject, int threshold, int spam, PrintStream output) throws FileNotFoundException{
      if(spam >= threshold) {
         output.print("**SPAM** ");
      }
      else {
         output.print("         ");
      }
      output.print(subject + "\n");
   }
}
