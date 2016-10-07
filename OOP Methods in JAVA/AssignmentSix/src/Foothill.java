/*
 * Source program for Assignment #6 for CS 1A
 * Written by Diogo Delgado 7/9/2015
 */

import java.util.*;
import java.lang.Math;

public class Foothill {
   //member data for the winning probabilities
   public static final String fiftyProbability = "BAR";
   public static final String twentyFiveProbability = "cherries";
   public static final String twelveProbability = "space";
   public static final String twelveWinProbability = "7";
   //main function
   public static void main(String[] args) throws Exception{
      //declare variables to be used in main
      int moneyBet;
      int moneyWon;
      TripleString pullString;
      //run getBet() and obtain the return value prior to starting the loop
      moneyBet = getBet();
      while (moneyBet != 0){
         pullString = pull();
         moneyWon = getPayMultiplier(pullString) * moneyBet;
         display(pullString, moneyWon);
         moneyBet = getBet();
      }
      System.out.println("Thank you for playing.");
   }
   //gets input from player and checks for correct values
   public static int getBet(){
      Scanner userInput = new Scanner(System.in);
      int userBet;
      //get value from user
      System.out.println("Please place your bet up to 100. "
            + "Whole dollars only." + " Place a bet of 0 to quit.");
      userBet = userInput.nextInt();
      //validate bet
      while (userBet < 0 || userBet > 100){
         System.out.println("That was an invalid bet. Please" +
            " enter a bet up to 100. Place a bet of 0 to quit.");
         userBet = userInput.nextInt();
      }
      return userBet;
   }
   //sets up an object and sets the data by using the private helper
   public static TripleString pull(){
      TripleString pullOne;
      pullOne = new TripleString();
      pullOne.setStringOne(randString());
      pullOne.setStringTwo(randString());
      pullOne.setStringThree(randString());
      return pullOne;
   }
   //gets a random number to generate odds of words
   //BAR 50%, cherries 25%, space 12.5%, '7' 12.5%
   private static String randString(){
      //get a random number for the probabilities
      double randNumber = Math.random();
      randNumber = randNumber * 100 + 1;
      //initiate a string for the return value
      String randomRoll;
      randomRoll = "";
      if (randNumber > 50){
         randomRoll = fiftyProbability;
      }
      else if (randNumber > 25 && randNumber <= 50){
         randomRoll = twentyFiveProbability;
      }
      else if (randNumber > 12.5 && randNumber <= 25){
         randomRoll = twelveProbability;
      }
      else{
         randomRoll = twelveWinProbability;
      }
      return randomRoll;
   }
   //get the amount the bet is multiplied in a win or loss
   public static int getPayMultiplier(TripleString thePull){
      int winnings;
      
      if (thePull.getStringOne() == twentyFiveProbability){
         if (thePull.getStringTwo() == twentyFiveProbability 
               && thePull.getStringThree() == twentyFiveProbability){
            winnings = 30;
         }
         else if (thePull.getStringTwo() == twentyFiveProbability){
            winnings = 15;
         }
         else
            winnings = 5;
      }
      else if (thePull.getStringOne() == fiftyProbability && 
            thePull.getStringTwo() == fiftyProbability &&
            thePull.getStringThree() == fiftyProbability){
         winnings = 50;
      }
      else if (thePull.getStringOne() == twelveWinProbability && 
            thePull.getStringTwo() == twelveWinProbability &&
            thePull.getStringThree() == twelveWinProbability){
         winnings = 100;
      }
      else
         winnings = 0;
      return winnings;
   }
   //displays the results of the roll and the amount won
   public static void display(TripleString thePull, int winnings){
      String winStatement, lossStatement, theSuspense;
      
      theSuspense = "Drum Roll Please..... " + thePull.getStringOne()
            + " " + thePull.getStringTwo() + " " + thePull.getStringThree();
      lossStatement = "Sorry bud. Don't worry, "
            + "this time is different. I feel it.";
      winStatement = "Well done Champ! May the odds be ever in your favor."
            + "You're on a roll! You won $";
      
      System.out.println(theSuspense);
      if (winnings > 0){
         System.out.println(winStatement + winnings + "!");
      }
      else
         System.out.println(lossStatement);
   }
}

class TripleString{
   //member data
   private String stringOne, stringTwo, stringThree;
   public static final double MAX_LEN = 20;
   public static final String DEFAULT_STRING = "";
   
   //default constructor
   TripleString(){
      stringOne = DEFAULT_STRING;
      stringTwo = DEFAULT_STRING;
      stringThree = DEFAULT_STRING;
   }
   //private helper to check if strings are valid
   private boolean validString(String str){
      if (str == null || str.length() > MAX_LEN)
         return false;
      else
         return true;
   }
   //set mutators for strings 1-3
   public boolean setStringOne(String str){
      if (validString(str)){
         stringOne = str;
         return true;
      }
      else
         return false;
   }
   public boolean setStringTwo(String str){
      if (validString(str)){
         stringTwo = str;
         return true;
      }
      else
         return false;
   }
   public boolean setStringThree(String str){
      if (validString(str)){
         stringThree = str;
         return true;
      }
      else
         return false;
   }
   // accessor methods
   public String getStringOne(){
      return stringOne;
   }
   public String getStringTwo(){
      return stringTwo;
   }
   public String getStringThree(){
      return stringThree;
   }
}


