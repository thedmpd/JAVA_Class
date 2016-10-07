/*
 *  Source program for Assignment #2 for CS 1A
 *  Written by Diogo Delgado 06/11/2015
 *
 */
public class Foothill {
   public static void main(String[] args){
      //initiate the output sample.
      String outputFormulaOne;
      String outputFormulaTwo;
      String outputFormulaThree;
      String outputFormulaFour;
      String outputNisThree;
      String outputNisSix;
      String outputNisEleven;
      
      outputFormulaOne = "2+3+...+(n+1) equals     ";
      outputFormulaTwo = "((n+1)*(n+2)/2)-7 equals ";
      outputFormulaThree = "3+5+...+(2n-1) equals    ";
      outputFormulaFour = "n^3 equals to            ";
      outputNisThree = " when n is 3.";
      outputNisSix = " when n is 6.";
      outputNisEleven = " when n is 11.";
      
      int n = 3;//initiate the first number in the set [3,6,11]
      
      int calculationOne;//2+3+...+(n+1)
      calculationOne = 2 + 3 + (n+1);
      System.out.println(outputFormulaOne
       + calculationOne + outputNisThree);
      
      int calculationTwo;//((n+1)*(n+2)/2)-7
      calculationTwo = ((n + 1)*(n + 2) / 2) - 7;
      System.out.println(outputFormulaTwo
       + calculationTwo + outputNisThree);
      
      int calculationThree;//3+5+...+(2n-1)
      calculationThree = 3+5;
      System.out.println(outputFormulaThree
       + calculationThree + outputNisThree);
      
      int calculationFour;//n^3
      calculationFour = n * n * n;
      System.out.println(outputFormulaFour + calculationFour 
       + outputNisThree + "\n");
      
      n = 6;//replace the first number in the set with the second.
      
      calculationOne = 2 + 3 + 4 + 5 + 6 + (n + 1);
      System.out.println(outputFormulaOne
       + calculationOne + outputNisSix);
      
      calculationTwo = ((n + 1)*(n + 2) / 2) - 7;
      System.out.println(outputFormulaTwo
       + calculationTwo + outputNisSix);
      
      calculationThree = 3 + 5 + 7 + 9 + 11;
      System.out.println(outputFormulaThree
       + calculationThree + outputNisSix);
      
      calculationFour = n * n * n;
      System.out.println(outputFormulaFour + calculationFour 
       + outputNisSix + "\n");
      
      n = 11; //replace the 2nd number in the set with the third.
      
      calculationOne = 2 + 3 + 4 + 5 + 6 + 7 + 8 + 9 + 10 + 11 + (n+1);
      System.out.println(outputFormulaOne +
       + calculationOne + outputNisEleven);
      
      calculationTwo = ((n + 1)*(n + 2) / 2) - 7;
      System.out.println(outputFormulaTwo
       + calculationTwo + outputNisEleven);
      
      calculationThree = 3 + 5 + 7 + 9 + 11 + 13 + 15 + 17 + 19 + 21;
      System.out.println(outputFormulaThree
       + calculationThree + outputNisEleven);
      
      calculationFour = n * n * n;
      System.out.println(outputFormulaFour + calculationFour 
       + outputNisEleven + "\n");
   }
}