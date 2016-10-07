/*Source Program for Assignment #4 for CS 1A
 * Written by Diogo Delgado 10/24/2015
 */
import java.util.Scanner;

public class Foothill {
   //member data for starting balances
   public static final int balanceDollars = 15;
   public static final int balanceBars = 15;
   //main function
   public static void main(String[] args) throws Exception {
      //declare variables to be used in main and get first choice
      int userBalanceDollars = balanceDollars;
      int userBalanceBars = balanceBars;
      char userChoice = getChoice(userBalanceBars, userBalanceDollars);
      //start the loop of choices
      while (userChoice != 'q'){
         //choice b shows the current months bill and resets the bill and count
         if (userChoice == 'b'){
            System.out.println(userBill(userBalanceBars, userBalanceDollars));
            userBalanceDollars = balanceDollars;
            userBalanceBars = balanceBars;
         }
         //choice c consumes the bars asked by the user
         else if(userChoice == 'c'){
            System.out.println(consumptionRules());
            int consumption = userConsumption(getUserNumber());
            userBalanceBars = userBalanceBars - consumption;
            if (userBalanceBars <= 0){
               userBalanceDollars = userAutoPurchaseBill(userBalanceDollars);
               userBalanceBars = userPurchaseBars(userBalanceBars);
            }
         }
         //choice p allows the purchase of up to 30 bars at once for $11/10
         else if(userChoice == 'p'){
            System.out.println(purchaseChoices());
            int userPurchase = userPurchase(getUserNumber());
            for(int k = userPurchase; k > 0; k--){
               userBalanceBars = userPurchaseBars(userBalanceBars);
               userBalanceDollars = userPlannedPurchase(userBalanceDollars);
            }
         }
         userChoice = getChoice(userBalanceBars, userBalanceDollars);
      }
      
   }
   //gets input from player and checks for correct choice
   public static char getChoice(int bars, int dollars){
      @SuppressWarnings("resource")
      Scanner userInput = new Scanner(System.in);
      String userChoice;
      char userComparison;
      //display the users bars and balance so far
      System.out.println("Account Balances" +
            System.getProperty("line.separator") +
            "Available Bars: " + bars +
            System.getProperty("line.separator") +
            "Monthly Bill (so far): " + dollars +
            System.getProperty("line.separator"));
      //displays options to be selected
      System.out.println("Please choose an option from below:");
      System.out.println("B (show Bill and start new month)" + 
         System.getProperty("line.separator") +
         "A (show Available capacity for the current month)" +
         System.getProperty("line.separator") +
         "C (Consume bars now)" +
         System.getProperty("line.separator") +
         "P (Purchase additional bars for current month)" +
         System.getProperty("line.separator") +
         "Q (show final bill and Quit)" +
         System.getProperty("line.separator"));
      //get user input and transform it to a char
      userChoice = userInput.nextLine();
      userComparison = userChoice.toLowerCase().charAt(0);
      //compare to see if proper selection was made else return an error
      if (userComparison == 'a' ||
            userComparison == 'c' ||
            userComparison == 'p' ||
            userComparison == 'q' ||
            userComparison == 'b'){
         return userComparison;
      }
      else {
         System.out.println("That is an incorrect choice. Please "
               + "enter another choice.");
         return userComparison;
      }
   }
   //gets input from player for integers
   public static int getUserNumber(){
      @SuppressWarnings("resource")
      Scanner userInput = new Scanner(System.in);
      int userConsumption = userInput.nextInt();
      return userConsumption;
   }
   //prints out the rules for consumption
   public static String consumptionRules(){
      String rules = "You may consume 1 to 10 bars at a time. "
            + System.getProperty("line.separator") 
            + "How many would you like to eat right now?";
      return rules;
   }
   //gets passed the userConsumptionNumber and checks to see if valid
   public static int userConsumption(int userNumConp){
      if (userNumConp > 0 && userNumConp <= 10){
         return userNumConp;
      }
      else {
         System.out.println("Please input a number between 1 and 10.");
         userNumConp = 0;
         return userNumConp;
      }
   }
   //gets passed the monthly bill and prints it
   public static String userBill(int bars, int dollars){
      String bill;
      bill ="Your monthly bill is: " + 
               dollars +
               System.getProperty("line.separator") +
               "Your unused bars for the month (lost forever): " +
               bars;
      return bill;
   }
   //autoPurchaseBill adds the 15 dollars to the user account
   public static int userAutoPurchaseBill(int dollars){
      dollars = dollars + 15;
      return dollars;
   }
   //userPurchaseBars adds 10 bars to user account
   public static int userPurchaseBars(int bars){
      bars = bars + 10;
      return bars;
   }
   //gets passed the purchase number to see if valid
   public static int userPurchase(int purchase){
      if(purchase > 0 && purchase <= 3){
         return purchase;
      }
      else {
         System.out.println("Please input a number between 1 and 3.");
         purchase = 0;
         return purchase;
      }
   }
   //print out userPurchase choices
   public static String purchaseChoices(){
      String purchaseRules = "How many sets of 10 would you like to "
         + "purchase: " + System.getProperty("line.separator") +
         "1 for 10 bars." + System.getProperty("line.separator") +
         "2 for 20 bars." + System.getProperty("line.separator") +
         "3 for 30 bars." + System.getProperty("line.separator");
      return purchaseRules;
   }
   //gets passed the userdollarbalance and adds 11 for planned purchases
   public static int userPlannedPurchase(int dollars){
      dollars = dollars + 11;
      return dollars;
   }
}
/*-----------------------------------OUTPUT----------------------------------
Account Balances
Available Bars: 15
Monthly Bill (so far): 15

Please choose an option from below:
B (show Bill and start new month)
A (show Available capacity for the current month)
C (Consume bars now)
P (Purchase additional bars for current month)
Q (show final bill and Quit)

WHO
That is an incorrect choice. Please enter another choice.
Account Balances
Available Bars: 15
Monthly Bill (so far): 15

Please choose an option from below:
B (show Bill and start new month)
A (show Available capacity for the current month)
C (Consume bars now)
P (Purchase additional bars for current month)
Q (show final bill and Quit)

Bill
Your monthly bill is: 15
Your unused bars for the month (lost forever): 15
Account Balances
Available Bars: 15
Monthly Bill (so far): 15

Please choose an option from below:
B (show Bill and start new month)
A (show Available capacity for the current month)
C (Consume bars now)
P (Purchase additional bars for current month)
Q (show final bill and Quit)

a
Account Balances
Available Bars: 15
Monthly Bill (so far): 15

Please choose an option from below:
B (show Bill and start new month)
A (show Available capacity for the current month)
C (Consume bars now)
P (Purchase additional bars for current month)
Q (show final bill and Quit)

consumption
You may consume 1 to 10 bars at a time. 
How many would you like to eat right now?
10
Account Balances
Available Bars: 5
Monthly Bill (so far): 15

Please choose an option from below:
B (show Bill and start new month)
A (show Available capacity for the current month)
C (Consume bars now)
P (Purchase additional bars for current month)
Q (show final bill and Quit)

c
You may consume 1 to 10 bars at a time. 
How many would you like to eat right now?
10
Account Balances
Available Bars: 5
Monthly Bill (so far): 30

Please choose an option from below:
B (show Bill and start new month)
A (show Available capacity for the current month)
C (Consume bars now)
P (Purchase additional bars for current month)
Q (show final bill and Quit)

purch
How many sets of 10 would you like to purchase: 
1 for 10 bars.
2 for 20 bars.
3 for 30 bars.

2
Account Balances
Available Bars: 25
Monthly Bill (so far): 52

Please choose an option from below:
B (show Bill and start new month)
A (show Available capacity for the current month)
C (Consume bars now)
P (Purchase additional bars for current month)
Q (show final bill and Quit)

aval
Account Balances
Available Bars: 25
Monthly Bill (so far): 52

Please choose an option from below:
B (show Bill and start new month)
A (show Available capacity for the current month)
C (Consume bars now)
P (Purchase additional bars for current month)
Q (show final bill and Quit)

con
You may consume 1 to 10 bars at a time. 
How many would you like to eat right now?
10
Account Balances
Available Bars: 15
Monthly Bill (so far): 52

Please choose an option from below:
B (show Bill and start new month)
A (show Available capacity for the current month)
C (Consume bars now)
P (Purchase additional bars for current month)
Q (show final bill and Quit)

pur
How many sets of 10 would you like to purchase: 
1 for 10 bars.
2 for 20 bars.
3 for 30 bars.

3
Account Balances
Available Bars: 45
Monthly Bill (so far): 85

Please choose an option from below:
B (show Bill and start new month)
A (show Available capacity for the current month)
C (Consume bars now)
P (Purchase additional bars for current month)
Q (show final bill and Quit)

bill me
Your monthly bill is: 85
Your unused bars for the month (lost forever): 45
Account Balances
Available Bars: 15
Monthly Bill (so far): 15

Please choose an option from below:
B (show Bill and start new month)
A (show Available capacity for the current month)
C (Consume bars now)
P (Purchase additional bars for current month)
Q (show final bill and Quit)

computer
You may consume 1 to 10 bars at a time. 
How many would you like to eat right now?
45
Please input a number between 1 and 10.
Account Balances
Available Bars: 15
Monthly Bill (so far): 15

Please choose an option from below:
B (show Bill and start new month)
A (show Available capacity for the current month)
C (Consume bars now)
P (Purchase additional bars for current month)
Q (show final bill and Quit)

purch
How many sets of 10 would you like to purchase: 
1 for 10 bars.
2 for 20 bars.
3 for 30 bars.

40
Please input a number between 1 and 3.
Account Balances
Available Bars: 15
Monthly Bill (so far): 15

Please choose an option from below:
B (show Bill and start new month)
A (show Available capacity for the current month)
C (Consume bars now)
P (Purchase additional bars for current month)
Q (show final bill and Quit)

bill
Your monthly bill is: 15
Your unused bars for the month (lost forever): 15
Account Balances
Available Bars: 15
Monthly Bill (so far): 15

Please choose an option from below:
B (show Bill and start new month)
A (show Available capacity for the current month)
C (Consume bars now)
P (Purchase additional bars for current month)
Q (show final bill and Quit)

a
Account Balances
Available Bars: 15
Monthly Bill (so far): 15

Please choose an option from below:
B (show Bill and start new month)
A (show Available capacity for the current month)
C (Consume bars now)
P (Purchase additional bars for current month)
Q (show final bill and Quit)

quit

------------------------------------------END OUTPUT---------------------------
*/

