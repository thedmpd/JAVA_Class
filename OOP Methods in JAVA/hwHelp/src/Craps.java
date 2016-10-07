import java.util.Random;
import java.util.*;


public class Craps
{
     // create random number generator for use in method rollDice
     private static final Random randomNumbers = new Random();
     // enumeration with constants that represent the game status
     private enum Status { CONTINUE, WON, LOST };
    
     // constants that represent common rolls of the dice
     private static final int SNAKE_EYES = 2;
     private static final int TREY = 3;
     private static final int SEVEN = 7;
     private static final int YO_LEVEN = 11;
     private static final int BOX_CARS = 12;
    
     private static int winCount = 0;    //counter for number of games won
     private static int loseCount = 0;  // counter for number of games lost
     private static int length = 0; //how long it takes to win a game
     // plays one game of craps
     public static void main( String[] args )
     {
         int lengthCount[] = new int[20]; // list for count of the number of rolls each game took
         int i = 0;
         int b = 0;
         b = b + '0';
         
         System.out.println(b);
         System.out.println("answer above");
         
         
          do{
             length = runGame();
             lengthCount[i]= length + 1;
             i++;
         }while ( i < 10); // end do while
         
         for (int y:lengthCount)
             System.out.println(y);
         System.out.println(winCount);
         System.out.println(loseCount);
         } // end main
         
         public static int runGame(){
         int myPoint = 0; // point if no win or loss on first roll
         Status gameStatus; // can contain CONTINUE, WON or LOST
         int sumOfDice = rollDice(); // first roll of the dice
        
        // determine game status and point based on first roll
        switch ( sumOfDice )
        {
        case SEVEN: // win with 7 on first roll
        case YO_LEVEN: // win with 11 on first roll
            gameStatus = Status.WON;
            length += 1;
            break;
        case SNAKE_EYES: // lose with 2 on first roll
        case TREY: // lose with 3 on first roll
        case BOX_CARS: // lose with 12 on first roll
             gameStatus = Status.LOST;
             length += 1;
        break;
        default: // did not win or lose, so remember point
             gameStatus = Status.CONTINUE; // game is not over
             myPoint = sumOfDice; // remember the point
             length += 1;
             break; // optional at end of switch
         } // end switch
         // while game is not complete
         while ( gameStatus == Status.CONTINUE ) // not WON or LOST
         {
             sumOfDice = rollDice(); // roll dice again
         // determine game status
         if ( sumOfDice == myPoint ) // win by making point
             gameStatus = Status.WON;
         else
             if ( sumOfDice == SEVEN ) // lose by rolling 7 before point
                 gameStatus = Status.LOST;
         } // end while
         
         // display won or lost message
         if ( gameStatus == Status.WON )
             winCount += 1;
         else
             loseCount += 1;
        
         return length;
         } // end runGame method
    
         public static int rollDice()
         {
             // pick random die values
             int die1 = 1 + randomNumbers.nextInt( 6 ); // first die roll
            int die2 = 1 + randomNumbers.nextInt( 6 ); // second die roll
             int sum = die1 + die2; // sum of die values
             // display results of this roll
             return sum; // return sum of dice
         } // end method rollDice
        } // end class Craps