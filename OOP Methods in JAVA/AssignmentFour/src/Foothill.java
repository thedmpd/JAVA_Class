/*
import java.util.Scanner;
  
public class Foothill
{
   public static void main (String[] args)
   {
      Scanner input = new Scanner(System.in);
      String password;
      boolean validated;
      char letter;
      int length;

      // Get password candidate from console, until it passes our tests
      validated = false;
      while (!validated)
      {
         // get the password candidate from user
         System.out.print("Enter a password, please ('q' to quit): ");
         password = input.nextLine();
         
         length = password.length();

         // test for quit first
         if ( length == 1 
            && ( password.charAt(0) == 'q'  || password.charAt(0) == 'Q') )
         {
            System.out.println("No password defined.");
            break;  // from loop
         }
         
         // test for reasonable length
         if (length < 6 || length > 15)
         {
            System.out.println(
                  "Password must be between 6 and 15 characters.");
            continue;
         }
         
         validated = true;   // assume innocent entering loop
         // allow only letters and numbers
         for (int k = 0; k < length; k++)
         {
            letter = password.charAt(k);   // store in letter for reuse
            if (letter >= 'a' && letter <= 'z')
               continue; //  we have a good lower case letter
            else if (letter >= 'A' && letter <= 'Z')
               continue; //  we have a good upper case letter
            else if (letter >= '0' && letter <= '9')
               continue; //  we have a good numeral
            else
            {
               // this letter is not one of the three legal types
               System.out.println("Use only A-Z, a-z or 0-9, please.");
               validated = false;
               break;   // from the for loop leaving validated as false
            }
         }
         
         // if the above loop yielded an error, we try again
         if (!validated)
            continue;
         
         // if here, it is the proper length and contains legal chars
         // but is the first character a letter?
         letter = password.charAt(0);
         if (letter >= '0' && letter <= '9')
         {
            System.out.println(
                  "First character must be a letter (non-numeric).");
            validated = false;
            continue;
         }
         else
         {
            // they passed the final test
            System.out.println(
                  "Your password " + password + " has been accepted.");
            break;   // this is not really needed but is safe
         }
      }
      
      System.out.println("\nGood bye.\n");
      input.close();
   }
}
*/
/* ----------- Output ----------------

Enter a password, please ('q' to quit): hi mom
Use only A-Z, a-z or 0-9, please.
Enter a password, please ('q' to quit): sdfkj(*&
Use only A-Z, a-z or 0-9, please.
Enter a password, please ('q' to quit): 8thhing
First character must be a letter (non-numeric).
Enter a password, please ('q' to quit): sdf
Password must be between 6 and 15 characters.
Enter a password, please ('q' to quit): adfa sdfjasdlfkjasdlfkjasdf
Password must be between 6 and 15 characters.
Enter a password, please ('q' to quit): sdf sdf
Use only A-Z, a-z or 0-9, please.
Enter a password, please ('q' to quit): asdfASDF
Your password asdfASDF has been accepted.

Good bye.

------------------------------------- */
/*
import java.util.Scanner;

public class Foothill
{
   // main method
   public static void main (String[] args)
   {
      stateInstructions();
      getInputAndComputeMonthlyPayment();    
      sayGoodbye();
   }

   // gives an overview to user
   public static void stateInstructions()
   {
      String instructions;
      instructions = 
         "The following program will calculate the \n"
         + "monthly payment  required for a loan of D dollars \n"
         + "over a period of Y years at an annual \n"
         + "interest rate of R%.";
      System.out.println(instructions);
      System.out.println("---------------\n");
   }
   
   // does all the work - gets input, computes and reports answer
   public static void getInputAndComputeMonthlyPayment()
   {
      Scanner input = new Scanner(System.in);
      
      String prompt, strUserResponse;
      double dblPrincipal, dblRate, dblYears, dblMoRt, dblMonths;
      double dblTemp, dblPmt;
   
      // get principal
      prompt = "\nEnter amount of the loan. (only use numbers, \n"
         + "please, no commas or characters like '$')\n"
         + "Your loan amount: ";
      System.out.print(prompt);
      strUserResponse = input.nextLine();
      dblPrincipal = Double.parseDouble(strUserResponse);
      
      // get interest
      prompt = "\nNow enter the interest rate (If the quoted rate is "
         + " 6.5%, \nfor example, enter 6.5 without the %.)\n"
         + "Your annual interest rate: ";
      System.out.print(prompt);
      strUserResponse = input.nextLine();
      dblRate = Double.parseDouble(strUserResponse);

      // get length of loan
      prompt = "\nEnter term of the loan in years: ";
      System.out.print(prompt);
      strUserResponse = input.nextLine();
      dblYears = Double.parseDouble(strUserResponse);
      
      // convert years to months
      dblMonths = dblYears * 12;
      
      // convert rate to decimal and months
      dblMoRt = dblRate / (100 * 12);
      
      // use formula to get result
      dblTemp = Math.pow(1 + dblMoRt, dblMonths);
      dblPmt = dblPrincipal * dblMoRt * dblTemp 
         / ( dblTemp - 1 );
      
      System.out.println("Monthly Payment: " + dblPmt);
  }
   
   // sign off
   public static void sayGoodbye()
   {
      String signoff;
      signoff = 
         "\nThanks for using the Foothill Mortgage Calculator. \n"
         + "We hope you'll come back and see us again, soon.";
      System.out.println(signoff);
   }
}
*/
/*
import java.text.*;
import java.util.*;

public class Foothill
{
   
   // class variables shared by more than one method
   static double dblPrincipal, dblRate, dblYears;
   
   // main method
   public static void main (String[] args)
   {
      double answer;
      int seconds;
      int milliseconds;
      milliseconds = 19999;
      seconds = milliseconds/1000;
      System.out.println( seconds + "seconds");
      stateInstructions();
      getInput();
      answer = computeMonthlyPayment();    
      reportResults(answer);
   }

   // gives an overview to user
   public static void stateInstructions()
   {
      String instructions;
      
      instructions = 
         "The following program will calculate the \n"
         + "monthly payment  required for a loan of D dollars \n"
         + "over a period of Y years at an annual \n"
         + "interest rate of R%.";
      System.out.println(instructions);
      System.out.println("---------------\n");
   }
   
   // gets input, stores in static class variables
   public static void getInput()
   {
      Scanner input = new Scanner(System.in);
      String prompt, strUserResponse;
   
      // get principal
      prompt = "\nEnter amount of the loan. (only use numbers, \n"
         + "please, no commas or characters like '$')\n"
         + "Your loan amount: ";
      System.out.print(prompt);
      strUserResponse = input.nextLine();
      dblPrincipal = Double.parseDouble(strUserResponse);
      
      // get interest
      prompt = "\nNow enter the interest rate (If the quoted rate is "
         + " 6.5%, \nfor example, enter 6.5 without the %.)\n"
         + "Your annual interest rate: ";
      System.out.print(prompt);
      strUserResponse = input.nextLine();
      dblRate = Double.parseDouble(strUserResponse);

      // get length of loan
      prompt = "\nEnter term of the loan in years: ";
      System.out.print(prompt);
      strUserResponse = input.nextLine();
      dblYears = Double.parseDouble(strUserResponse);
      
      input.close();
  }
   
   
   // computes and returns answer
   public static double computeMonthlyPayment()
   {
      // local variables needed only in this method
      double dblTemp, dblPmt, dblMonths, dblMoRt;
           
      // convert years to months
      dblMonths = dblYears * 12;
      
      // convert rate to decimal and months
      dblMoRt = dblRate / (100 * 12);
      
      // use formula to get result
      dblTemp = Math.pow(1 + dblMoRt, dblMonths);
      dblPmt = dblPrincipal * dblMoRt * dblTemp 
         / ( dblTemp - 1 );
      
      // now that we have computed the payment, return it
      return dblPmt;
  }
   
   // sign off
   public static void reportResults(double result)
   {
      String signoff;
      NumberFormat bucks = 
         NumberFormat.getCurrencyInstance(Locale.US);
      
      signoff = 
         "\nThanks for using the Foothill Mortgage Calculator. \n"
         + "We hope you'll come back and see us again, soon.";
      
      System.out.println("Monthly Payment: " 
            + bucks.format(result));
      System.out.println(signoff);
   }
}

/*
public class Foothill
{
   public static void main(String[] args) throws Exception
   {
      // declare the references
      Galaxy gal1, gal2;
      
      // instantiate the objects
      gal1 = new Galaxy();
      gal2 = new Galaxy();
      
      // try to set the data
      gal1.setName("X");
      gal1.setMagnitude(100);
      gal2.setName("Stephan's Third");
      gal2.setMagnitude(13.2);
      
      // let's see what happened
      System.out.println("Gal #1 name: " +  gal1.getName() );
      System.out.println("Gal #1 mag: " +  gal1.getMagnitude() );
      System.out.println("Gal #2 name: " +  gal2.getName() );
      System.out.println("Gal #2 mag: " +  gal2.getMagnitude() );
   }
}
class Galaxy
{
   // member data
   private String name;
   private double magnitude;
      
   // default constructor
   Galaxy()
   {
      name = "undefined";
      magnitude = 0.0;   
   }
      
   // accessor "set" method -------------------------------
   public boolean setMagnitude(double mag)
   {
      if (mag < -3 || mag > 30)
         return false;
      // else
      magnitude = mag;
      return true; 
   }

   public boolean setName(String theName)
   {
      if (theName == null || theName.length() < 2)
         return false;
      // else we fall through
      name = theName;
      return true;
   }

   // accessor "get" methods --------------------------------
   public String getName()
   {
     return name;
   }
   public double getMagnitude()
   {
      return magnitude;
   }
}
*/
/*
public class Foothill
{
   public static void main(String[] args) throws Exception
   {
      // declare the references
      Galaxy gal1, gal2;
      
      // instantiate the objects
      gal1 = new Galaxy();
      gal2 = new Galaxy();
      
      // try to set the data
      gal1.setName("X");
      gal1.setMagnitude(100);
      gal2.setName("Stephan's Third");
      gal2.setMagnitude(13.2);
      
      // let's see what happened
      System.out.println("Gal #1 name: " +  gal1.getName() );
      System.out.println("Gal #1 mag: " +  gal1.getMagnitude() );
      System.out.println("Gal #2 name: " +  gal2.getName() );
      System.out.println("Gal #2 mag: " +  gal2.getMagnitude() );
   }
}

class Galaxy
{
   // member data
   private String name;
   private double magnitude;
      
   // default constructor
   Galaxy()
   {
      name = "undefined";
      magnitude = 0.0;   
   }
  
   // 2-parameter constructor (to be discussed)
   Galaxy(String myName, double myMag)
   {
      if (myName.length() > 2)
         name = myName;
      else
         name = "undefined";
      if (myMag >= -3 && myMag <= 30)
         magnitude = myMag;
      else
         magnitude = 0.0;   
   }
   
   // accessor "set" method -------------------------------
   public boolean setMagnitude(double mag)
   {
      if (mag < -3 || mag > 30)
         return false;
      // else
      magnitude = mag;
      return true; 
   }

   public boolean setName(String theName)
   {
      if (theName == null || theName.length() < 2)
         return false;
      // else we fall through
      name = theName;
      return true;
   }

   // accessor "get" methods --------------------------------
   public String getName()
   {
     return name;
   }
   public double getMagnitude()
   {
      return magnitude;
   }
}

 ------------------ Paste of Run from Above Program ----------

Gal #1 name: undefined
Gal #1 mag: 0.0
Gal #2 name: Stephan's Third
Gal #2 mag: 13.2

---------------------------------------------------------------- */
//class Employee --------------------
/*
class Employee 
{
// member data for the class -- no keyword
// static in front, so these are called 
// "instance members"
     
private int socSec;
private int age;

// -------  clearSocSec Definition --------------
private void clearSocSec()
{
    socSec = 000000000;    
}
     
// -------  setAge Definition --------------
public boolean setAge(int a)
{
   if (a < 0 )
      // don't allow negative age
      return false;
   else
   {
      age = a;
      return true;
   }
}

// -------  setSS Definition --------------
public boolean setSS(int ss)
{
   if (ss < 0 )
      // don't allow negative ss
      return false;
   else
   {
      socSec = ss;
      return true;
   }
}
   
// ------- Employee::getOlder ------- 
public boolean getOlder()
{
   if (age++ > 147 )
   {
      clearSocSec();
      return false;
   } 
   else
      return true;
}
          
} // ----------------------- end Employee 

//main class Company --------------------
public class Foothill 
{
public static void main (String[] args)
{
   Employee walter;
   int k;
   
   walter = new Employee();
    
   walter.setSS(123456789);
   walter.setAge(140);

   for (k = 0; k < 14; k++)
      if ( walter.getOlder() )
         System.out.println( "Happy Birthday!" );
      else
         System.out.println( "You must be dead.  I have given"
            + " your social security number"
            + " to someone else.");           
}   
} 
*//*
public class Foothill
{
   public static void main(String[] args) throws Exception
   {
      // declare the references
      Galaxy gal1, gal2;
      
      // instantiate the objects
      gal1 = new Galaxy();
      gal2 = new Galaxy();
      
      // try to set the data
      gal1.setName("X");
      gal1.setMagnitude(100);
      gal2.setName("Stephan's Third");
      gal2.setMagnitude(13.2);
      
      // let's see what happened
      System.out.println("Gal #1 name: " +  gal1.getName() );
      System.out.println("Gal #1 mag: " +  gal1.getMagnitude() );
      System.out.println("Gal #2 name: " +  gal2.getName() );
      System.out.println("Gal #2 mag: " +  gal2.getMagnitude() );
   }
}

class Galaxy
{
   // member data
   private String name;
   private double magnitude;
   
   // static constants
   public static final double DEFAULT_MAG = 0.0;
   public static final String DEFAULT_NAME = "undefined";
   public static final double MIN_MAG = -3.;
   public static final double MAX_MAG = 30.;
   public static final int MIN_STR_LEN = 2;
      
   // default constructor
   Galaxy()
   {
      name = DEFAULT_NAME;
      magnitude = DEFAULT_MAG;   
   }
  
   // 2-parameter constructor
   Galaxy(String myName, double myMag)
   {
      if ( !setName(myName) )
         name = DEFAULT_NAME;
      if ( !setMagnitude(myMag) )
         magnitude = DEFAULT_MAG; 
   }
   
   // accessor "set" method -------------------------------
   public boolean setMagnitude(double mag)
   {
      if (mag < MIN_MAG || mag > MAX_MAG)
         return false;
      // else
      magnitude = mag;
      return true; 
   }

   public boolean setName(String theName)
   {
      if (theName == null || theName.length() < MIN_STR_LEN)
         return false;
      // else we fall through
      name = theName;
      return true;
   }

   // accessor "get" methods --------------------------------
   public String getName()
   {
     return name;
   }
   public double getMagnitude()
   {
      return magnitude;
   }
}

 ------------------ Paste of Run from Above Program ----------

Gal #1 name: undefined
Gal #1 mag: 0.0
Gal #2 name: Stephan's Third
Gal #2 mag: 13.2

---------------------------------------------------------------- */

import javax.swing.*;

public class Foothill
{
   public static void main (String[] args)
   {
      String[] student = new String[20];
      int value = 0;
      String strValue;
      String newName;

      // initialize the array
      for (int k = 0; k < student.length; k++)
         student[k] = "undefined";
      
      // infinite loop until user enters q or cancels
      while (true)
      {
         // input filter loop to get a valid array index from user
         while (true)
         {
            strValue = JOptionPane.showInputDialog(
                  "Choose a student to edit\n"
                  + "from 0 to " + (student.length - 1) + "\n"
                  + " ('q' to end program):");
            // did they click cancel or close box?
            if (strValue == null)
               return; // if so, end program
            
            // did they type a string that was not 1 or 2 digits?
            if (strValue.length() < 1 || strValue.length() > 2)
               continue; // if so, prompt again
            
            // did they type 'q'?
            if (strValue.length() == 1 && strValue.charAt(0) == 'q')
               return;  // if so, exit program
            
            // finally, convert to int.  Is it a valid int?
            try
            {
               value = Integer.parseInt(strValue);              
            }
            catch (NumberFormatException e)
            {
               // typed illegal int ("34.5" or "sdf" or "*2", etc.)
               continue;
            }
            
            // is the int within our expected range?
            if (value >= 0 &&  value < student.length)
               break;  // good value, escape from this loop
               
            // typed a valid int but was it in range?
            // could test inside loop or in while statement
         } 
         
         // infinite loop for name input
         while (true)
         {
            newName = JOptionPane.showInputDialog(null, 
               "Enter New Name:", 
               "Editing student " + value + ": '" 
                     + student[value] + "'", 
               JOptionPane.QUESTION_MESSAGE );
            
            // they hit cancel or close box
            if (newName == null)
               break;
            else if (newName.length() >=2 && newName.length() <= 40)
            {
               student[value] = newName;
               break; // from input loop
            }
            else
               JOptionPane.showMessageDialog(null, 
                  "Invalid Name, try again.");
         }
      }
   }
}
