/*
 *  Source program for Assignment #3 for CS 1A
 *  Written by Diogo Delgado 06/19/2015
 *
 */

import java.util.Scanner;

public class Foothill {
   public static void main(String[] args){
      //user provided values
      double userHeight, userWeight;
      
      //declare an object for console input
      Scanner inputStream = new Scanner(System.in);
      
      //string variable for user input
      String userHeightInput, userWeightInput;
      
      //obtain input from user
      System.out.print("What is your height in inches? "
       + "Remember 1 foot = 12 inches. ");
      userHeightInput = inputStream.nextLine();
      userHeight = Double.parseDouble(userHeightInput);
      
      System.out.print("What is your weight in pounds? ");
      userWeightInput = inputStream.nextLine();
      userWeight = Double.parseDouble(userWeightInput);
      
      //check for errors and if found pinpoint the error. 
      //else start BMI calculations.
      if ((userHeight <= 0) || (userHeight > 107) 
       || (userWeight <= 0) || (userWeight > 1400)){
         System.out.println("Error detected.");
         if ((userHeight <=0) || (userWeight <=0))
            System.out.println("Input is less than zero. ");
         else if (userHeight > 107)
            System.out.println("You're taller than Robert Wadlow?!?");
         else if (userWeight > 1400)
            System.out.println("You're heavier than Jon Brower Minnoch?!?");
         else 
            System.out.println("Unknown error.");
      }
      else {
         double calculateBMI;
         calculateBMI = ((userWeight * 703.0) / ((userHeight) * (userHeight)));
         //check to see where the user's BMI falls in the scale
         if (calculateBMI < 18.5)
            System.out.print("Your BMI is " + calculateBMI 
             + " and it indicates you are underweight.");
         else if (calculateBMI > 25)
            System.out.print("Your BMI is " + calculateBMI 
             + " and it indicates you are overweight.");
         else
            System.out.print("Your BMI is " + calculateBMI
             + " and it indicates you're at an optimal weight.");
      }
      inputStream.close();
   }
}
