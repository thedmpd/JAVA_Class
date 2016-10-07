/*
 * Source program for Assignment #5 for CS 1A
 * Written by Diogo Delgado 11/3/2015
 */
import java.util.Scanner;

public class Foothill {
   public static void main(String[] args) throws Exception{
      String choices;
      choices = getString();
      System.out.println("Your word as pigLatin:");
      System.out.println(pigLatin(choices));
      System.out.println("Your word as Turkey Irish:");
      System.out.println(turkeyIrish(choices));
      System.out.println("The amount of vowels in your word:");
      System.out.println(vowelCounter(choices));
   }
   //gets input from user
   public static String getString(){
      @SuppressWarnings("resource")
      Scanner userInput = new Scanner(System.in);
      String userString;
      //Present the rules
      System.out.println("Please enter a 4 letter word.");
      userString = userInput.nextLine();
      userString = userString.trim();
      while (userString.length() < 4 || userString.length() > 4
            || userString.contains(" ")){
         System.out.println("That input is invalid." + 
            "Please enter a 4 letter word.");
         userString = userInput.nextLine();
         userString =userString.trim();
      }
      return userString;
   }
   //transforms the passed string into pig Latin
   public static String pigLatin(String theString){
      String pigLatin = "";
      for (int i = 1; i < theString.length(); i++){
         if (i > (theString.length() - 2)){
            pigLatin = pigLatin + theString.charAt(i) 
                  + theString.charAt(0) + "ay";
         }
         else {
         pigLatin = pigLatin + theString.charAt(i);
         }
      }
      return pigLatin;
   }
   //transforms the passed string into TurkeyIrish
   public static String turkeyIrish(String theString){
      String turkIri = "";
      for (int i = 0; i < theString.length(); i++){
         if (theString.toLowerCase().charAt(i) == 'a' 
               || theString.toLowerCase().charAt(i) == 'e' 
               || theString.toLowerCase().charAt(i) == 'i'
               || theString.toLowerCase().charAt(i) == 'o'
               || theString.toLowerCase().charAt(i) == 'u'){
            turkIri = turkIri + "ab" + theString.charAt(i);
         }
         else {
            turkIri = turkIri + theString.charAt(i);
         }
      }
      return turkIri;
   }
   //counts the amount of vowels in a passed string
   public static int vowelCounter(String theString){
      int counter = 0;
      for (int i = 0; i < theString.length(); i++){
         if (theString.toLowerCase().charAt(i) == 'a' 
               || theString.toLowerCase().charAt(i) == 'e' 
               || theString.toLowerCase().charAt(i) == 'i'
               || theString.toLowerCase().charAt(i) == 'o'
               || theString.toLowerCase().charAt(i) == 'u'){
            counter ++;
         }
      }
      return counter;
   }
}