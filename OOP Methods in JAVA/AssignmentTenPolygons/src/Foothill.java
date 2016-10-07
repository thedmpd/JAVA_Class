/* Source Program for Assignment #9 for CS 1A
 * Written by Diogo Delgado 7/13/2015
 */

import java.util.Arrays;
import java.lang.Math;
import java.lang.reflect.Array;

public class Foothill {
   //main
   public static void main(String[] args) throws Exception{
      Polygon diogo;
      diogo = new Polygon(4, [3 42 5 53], [1 1 1 1 1]);
   }
}
//point class
class Point{
   //private members
   private double xCoordinate;
   private double yCoordinate;
   private static double MIN_VAL = -10.00;
   private static double MAX_VAL = 10.00;
   //public 
   public static final double DEFAULT_POINT = ((MIN_VAL + MAX_VAL)/ 2);
   //constructors
   Point(){
      xCoordinate = DEFAULT_POINT;
      yCoordinate = DEFAULT_POINT;
   }
   Point(double x, double y){
      if (validCoordinate(x) && validCoordinate(y)){
         xCoordinate = x;
         yCoordinate = y;
      }
      else{
         xCoordinate = DEFAULT_POINT;
         yCoordinate = DEFAULT_POINT;
      }
   }
   //private helper to check value is correct
   private boolean validCoordinate(double coordinate){
      if (coordinate >= MIN_VAL && coordinate <= MAX_VAL)
         return true;
      else
         return false;
   }
   //mutator methods
   public boolean setCoordinates(double x, double y){
      if (validCoordinate(x) && validCoordinate(y)){
         xCoordinate = x;
         yCoordinate = y;
         return true;
      }
      else
         return false;
   }
   public static boolean setRange(double newMinVal, double newMaxVal){
      if (newMinVal < newMaxVal){
         MIN_VAL = newMinVal;
         MAX_VAL = newMaxVal;
         return true;
      }
      else
         return false;
   }
   //accessor methods
   public double getX(){
      return xCoordinate;
   }
   public double getY(){
      return yCoordinate;
   }
   public void displayPoint(){
      System.out.println("(" + xCoordinate + "," + yCoordinate +
            ")");
   }
}
//polygon class
class Polygon{
   //private members
   private int numPoints;
   private double[] points;
   //public 
   public static final int MAX_POINTS = 20;
   public static final int DEFAULT_NUM_POINTS = 0;
   //constructors
   Polygon(){
      numPoints = DEFAULT_NUM_POINTS;
      points = new double[MAX_POINTS];
   }
   Polygon(int numPoints, double xArray[], double yArray[]){
      double arrayX[] = xArray[];
      if (validNumPoints(numPoints) && 
            validArrays(numPoints, xArray[], yArray[])){
         
      }
   }
   //private helpers
   private boolean validNumPoints(int numPoints){
      if (numPoints > 0 && numPoints <= MAX_POINTS){
         this.numPoints = numPoints;
         return true;
      }
      else
         return false;
   }
   private boolean validArrays(int numPoints, double xValues[],
         double yValues[]){
      if (xValues.length >= numPoints && yValues.length >= numPoints)
         return true;
      else
         return false;
   }
   //mutator methods
   public boolean setPoints(int numPoints, double xValues[],
         double yValues[]){
      if (validNumPoints(numPoints) && 
            validArrays(numPoints, yValues, yValues)){
         this.points = new double[numPoints];
         for (int k = 0; k < numPoints; k++){
            this.points[k] = xValues[k] + yValues[k];
            System.out.println(this.points[k]);
         }
         return true;
      }
      else
         return false;
   }
}