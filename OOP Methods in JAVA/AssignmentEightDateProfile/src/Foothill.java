/* Source Program for Assignment #8 for CS 1A
 * Written by Diogo Delgado 7/12/2015
 */

import java.lang.Math;

public class Foothill {
   
   //main
   public static void main(String[] args) throws Exception{
      //First male, default values
      DateProfile jeff = new DateProfile("hello", 'f', 'm', 10, 8);
      //jeff = new DateProfile();
      //female looking for male 
      DateProfile joana;
      joana = new DateProfile("Joana M", 'F', 'M', 8, 10);
      //female looking for female
      DateProfile jennifer;
      jennifer = new DateProfile("Jennifer S", 'f', 'f', 10, 6);
      //male looking for female heavy romance, low finance
      DateProfile purple;
      purple = new DateProfile("Senor Purple", 'M', 'f', 10, 1);
      //display the FitValues
      display(jeff, joana, jennifer, purple);
      display(joana, jennifer, purple, jeff);
      display(jennifer, purple, jeff, joana);
      display(purple, jeff, joana, jennifer);
   }
   //display the partners and the self score.
   public static void display(DateProfile self, DateProfile partner1, 
         DateProfile partner2, DateProfile partner3){
      System.out.println(self.getName());
      System.out.println("   " + partner1.getName() + 
            " fit: " + self.fitValue(partner1));
      System.out.println("   " + partner2.getName() + 
            " fit: " + self.fitValue(partner2));
      System.out.println("   " + partner3.getName() + 
            " fit: " + self.fitValue(partner3));
      System.out.println("   " + self.getName() + 
            " fit: " + self.fitValue(self));
   }
}
class DateProfile{
   //member data and shared constants
   private String name;
   private char gender;
   private char searchGender;
   private int romance;
   private int finance;
   public static final char DEFAULT_GENDER = 'M';
   public static final char DEFAULT_PARTNER_SEARCH = 'F';
   public static final int DEFAULT_ROMANCE = 5;
   public static final int DEFAULT_FINANCE = 5;
   public static final String DEFAULT_NAME = "J. Doe";
   public static final int MIN_STR_LENGTH = 1;
   public static final int MAX_STR_LENGTH = 40;
   public static final int MIN_SCORE = 1;
   public static final int MAX_SCORE = 10;
   //default constructor
   DateProfile(){
      name = DEFAULT_NAME;
      gender = DEFAULT_GENDER;
      searchGender = DEFAULT_PARTNER_SEARCH;
      romance = DEFAULT_ROMANCE;
      finance = DEFAULT_FINANCE;
   }
   //constructor with 5 params
   DateProfile(String name, char gender, 
         char searchGender, int romance, int finance){
      if (validName(name))
         this.name = name;
      else
         this.name = DEFAULT_NAME;
      if (validGender(gender))
         this.gender = gender;
      else
         this.gender = DEFAULT_GENDER;
      if (validGender(searchGender))
         this.searchGender = searchGender;
      else
         this.searchGender = DEFAULT_PARTNER_SEARCH;
      if (validScore(romance))
         this.romance = romance;
      else
         this.romance = DEFAULT_ROMANCE;
      if (validScore(finance))
         this.finance = finance;
      else
         this.finance = DEFAULT_FINANCE;
   }
   //private helpers to validate data entered
   private boolean validName(String str){
      if (str == null || str.length() < MIN_STR_LENGTH ||
            str.length() > MAX_STR_LENGTH)
         return false;
      else
         return true;
   }
   private boolean validScore(int score){
      if (score >= MIN_SCORE && score <= MAX_SCORE)
         return true;
      else
         return false;
   }
   private boolean validGender(char gender){
      char compare = Character.toUpperCase(gender);
      if (compare == 'M' || compare == 'F')
         return true;
      else
         return false;
   }
   //mutator methods for the 5 data sets
   public boolean setName(String name){
      if (validName(name)){
         this.name = name;
         return true;
      }
      else
         return false;
   }
   public boolean setGender(char gender){
      if (validGender(gender)){
         this.gender = gender;
         return true;
      }
      else
         
         return false;
   }
   public boolean setSearchGender(char searchGender){
      if (validGender(searchGender)){
         this.searchGender = searchGender;
         return true;
      }
      else
         return false;
   }
   public boolean setRomance(int romance){
      if (validScore(romance)){
         this.romance = romance;
         return true;
      }
      else
         return false;
   }
   public boolean setFinance(int finance){
      if (validScore(finance)){
         this.finance = finance;
         return true;
      }
      else
         return false;
   }
   //accessor methods for the 5 data sets
   public String getName(){
      return name;
   }
   public char getGender(){
      return gender;
   }
   public char getSearchGender(){
      return searchGender;
   }
   public int getRomance(){
      return romance;
   }
   public int getFinance(){
      return finance;
   }
   //private helpers to make the love algorithm
   private double determineGenderFit(DateProfile partner){
      double compare;
      if (Character.toUpperCase(searchGender) == Character.toUpperCase(
            partner.getGender()) &&
            Character.toUpperCase(gender) == Character.toUpperCase(
            partner.getSearchGender())){
         compare = 1;
         return compare;
      }
      else{
         compare = 0;
         return compare;
      }
   }
   private double determineRomanceFit(DateProfile partner){
      double compare;
      double difference;
      if (romance == partner.getRomance()){
         compare = 1;
         return compare;
      }
      else{
         difference = romance - partner.getRomance();
         difference = Math.abs(difference);
         compare = 1.0 - (.1 * difference);
         return compare;
      }
   }
   private double determineFinanceFit(DateProfile partner){
      double compare;
      double difference;
      if (finance == partner.getFinance()){
         compare = 1;
         return compare;
      }
      else{
         difference = finance - partner.getFinance();
         difference = Math.abs(difference);
         compare = 1.0 - (.1 * difference);
         return compare;
      }
   }
   //public instance method of the love algorithm
   public double fitValue(DateProfile partner){
      double fitValue;
      fitValue = (determineGenderFit(partner) * determineRomanceFit(partner)
            * determineFinanceFit(partner));
      return fitValue;
      
   }
}





