// Katherine Tran
//
// This program creates ASCII art using text characters. The image is built by utilizing several static methods, each of
// which is responsible for generating a specific part of the image. The size of the image is determined by a constant
// value called SIZE, which is used in the for loops to control the number of iterations required to construct the image.
public class Firecracker {
   public static final int SIZE = 5;
   
   public static void main(String[] args) {
      point();
      plus();
      box();
      middle();
      box();
      plus();
      point();
   }

   /**
    * This method generates the top and bottom border of the ASCII art image. It prints a plus sign (+) followed by a
    * number of tildes (~), equal to the SIZE constant, on each side of the plus sign.
    */
   public static void plus() {
      System.out.print("+");
      for (int line = 1; line <= SIZE; line++) {
         System.out.print("~~");
      }
      System.out.println("+");
   
      // Prints the top and bottom border of the ASCII art image
      for (int line = 1; line <= SIZE-1; line++) {
         for (int space = 1; space<= SIZE-line; space++) {
            System.out.print(" ");
         }
         System.out.print("//");
         for (int exclaim = 1; exclaim < line; exclaim++) {
            System.out.print("!!");
         }
         System.out.println("\\\\");     
      }
   }
   
   /**
    * Prints a box made of square brackets with a decorative pattern of dashes and slashes inside. The size of the box
    * is determined by the constant SIZE.
    */
   public static void box() {
      for (int line = 0; line <= SIZE-1; line++) {
         System.out.print("[");
         for (int dash = 0; dash < line; dash++) {
            System.out.print("-");
         }
         for (int arrow = 1; arrow <= SIZE-line; arrow++) {
            System.out.print("\\/");
         }
         for (int dash = 0; dash < line; dash++) {
            System.out.print("-");
         } 
         System.out.println("]");
      }
   }

   /**
    * Generates the middle section of the ASCII art image.
    * The number of slashes, dashes, and backslashes in each row increases in a specific pattern based on the constant SIZE.
    */
   public static void middle() {
      for (int line = 1; line <= SIZE-2; line++) {
         System.out.print("[");
         for (int slash = 1; slash <= SIZE-1-line; slash++) {
            System.out.print("/");
         }
         for (int dash = 1; dash <= line+1; dash++) {
            System.out.print("--");
         }
         for (int slash = 1; slash <= SIZE-1-line; slash++) {
            System.out.print("\\");
         }   
         System.out.println("]");
      }
   }
     
      
}

/*
 
  ----jGRASP exec: java Firecracker
     //\\
    //!!\\
   //!!!!\\
  //!!!!!!\\
 +~~~~~~~~~~+
 [\/\/\/\/\/]
 [-\/\/\/\/-]
 [--\/\/\/--]
 [---\/\/---]
 [----\/----]
 [///----\\\]
 [//------\\]
 [/--------\]
 [\/\/\/\/\/]
 [-\/\/\/\/-]
 [--\/\/\/--]
 [---\/\/---]
 [----\/----]
 +~~~~~~~~~~+
     //\\
    //!!\\
   //!!!!\\
  //!!!!!!\\
 
  ----jGRASP: operation complete.
 
*/
