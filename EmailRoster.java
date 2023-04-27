// Katherine Tran
//
// This program reads the contents of a file containing student names and generates a list of emails for each student. 
// The list of emails is created based on the given names.
// To evaluate the functionality of this program, use the file named 'names.txt' as a test case.

import java.io.*;
import java.util.*;

public class EmailRoster {
   public static final String ext = "@go.shoreline.edu";
   
   public static void main(String[] args) throws FileNotFoundException {
      File f = new File("names.txt"); 
      Scanner input = new Scanner(f);
      
      String[] names = loadInput(input);
      Arrays.sort(names);
      studentList(names);
      String[] emails = createEmail(names);
      roster(names, emails);
      
   }

   /**
    * This method reads input from a Scanner and loads student names into an array of Strings.
    * @param input the Scanner to read input from
    * @return the array of Strings containing student names
    */
   public static String[] loadInput(Scanner input)  {
      
      int size = Integer.parseInt(input.nextLine());
      String[] names = new String[size];
      
      for (int i = 0; i <= size - 1; i++) {
         names[i] = input.nextLine();
      }
      return names;
   }

   /**
    * This method generates and prints out a list of students being processed, given an array of their names.
    * @param names an array of Strings containing the names of the students being processed
    */
   public static void studentList(String[] names) {
      System.out.println("Students being processed...");
      for (String name : names) {
         System.out.println("        " + name);
      }
      System.out.println();
   }

   /**
    * This method creates email addresses for each student based on their name and generates a unique email address by
    * appending a number to the email address if there are duplicates.
    * @param names an array of student names
    * @return an array of unique email addresses for each student
    */
   public static String[] createEmail(String[] names) {
      String[] emails = new String[names.length];
      Arrays.fill(emails, "A");

      for (int i = 0; i <= names.length - 1; i++) {
               
         String[] name = names[i].toUpperCase().split(" ", 2);
         String user = name[0].charAt(0) + name[1];
         
         emails[i] = user + contains(emails, user + ext) + ext;
      }
      return emails;
   }

   /**
    * This method returns a string representing the number of times the given key appears in the given array of email 
    * addresses. If the key appears only once, an empty string is returned. If the key appears more than once, the 
    * number of duplicates is returned as a string.
    * @param emails the array of email addresses to search
    * @param key the email address to search for
    * @return a string representing the number of duplicates of the key in the array, or an empty string if there are no duplicates
    */
   public static String contains(String[] emails, String key) {
      int amount = 1;
      for (int i = 0; i <= emails.length - 1; i++) {
         if (emails[i].equals(key)) {
            amount++;
         }
      }
      if (amount == 1) {
         return "";
      }
      return String.valueOf(amount);
   }

   /**
    * This method prints out a roster of students and their corresponding email addresses.
    * @param names an array of strings representing the names of the students
    * @param emails an array of strings representing the email addresses of the students
    */
   public static void roster(String[] names, String[] emails) {
      for (int i = 0; i <= names.length - 1; i++) {
         System.out.println(names[i]);
         System.out.println(emails[i]);
         System.out.println();
      }
   }
}

/*
  ----jGRASP exec: java EmailRoster
 Students being processed...
         Anna Martinez
         Elfrida Larrega
         Fredric Getti
         Gia Domino
         Oreta Johnson
         Orion Johnson
         Peter Chu
         Yun Nguyen
         Zerb Pinnell
         Zeta Ngdogo
 
 Anna Martinez
 AMARTINEZ@go.shoreline.edu
 
 Elfrida Larrega
 ELARREGA@go.shoreline.edu
 
 Fredric Getti
 FGETTI@go.shoreline.edu
 
 Gia Domino
 GDOMINO@go.shoreline.edu
 
 Oreta Johnson
 OJOHNSON@go.shoreline.edu
 
 Orion Johnson
 OJOHNSON2@go.shoreline.edu
 
 Peter Chu
 PCHU@go.shoreline.edu
 
 Yun Nguyen
 YNGUYEN@go.shoreline.edu
 
 Zerb Pinnell
 ZPINNELL@go.shoreline.edu
 
 Zeta Ngdogo
 ZNGDOGO@go.shoreline.edu
 
 
  ----jGRASP: operation complete.
 
 
*/
