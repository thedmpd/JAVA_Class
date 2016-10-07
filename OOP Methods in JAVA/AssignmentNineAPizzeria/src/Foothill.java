/* Source Program for Assignment #9 for CS 1A
 * Written by Diogo Delgado 7/13/2015
 */

import java.util.Arrays;
import java.util.Scanner;

public class Foothill {
   //main
   public static void main(String[] args) throws Exception{
      //declare public variables
      int QuitOuterLoop = -1;
      
      String toppingChoice;
      //start request for user selection
      int userChoice = getSizeFromUser();
      //outer loop size selection
      while (userChoice != QuitOuterLoop){
         PizzaOrder firstOrder;
         firstOrder = new PizzaOrder(userChoice);
         displayPizza(firstOrder);
         displayMainMenu();
         toppingChoice = getToppingSelection(firstOrder);
         //inner loop: topping selection
         while (toppingChoice.charAt(0) != 'd'){
            displayPizza(firstOrder);
            displayMainMenu();
            toppingChoice = getToppingSelection(firstOrder);
         }
         userChoice = getSizeFromUser();
      }
   }
   //manage input from user
   @SuppressWarnings("resource")
   public static int getSizeFromUser(){
      Scanner userInput = new Scanner(System.in);
      String userChoice;
      int sizeSelection;
      //get value from user
      System.out.println("Please select the size of your pizza.");
      System.out.println("Small, Medium, Large, or Duper. Type quit to exit.");
      userChoice = userInput.nextLine();
      userChoice = userChoice.toUpperCase();
      //test for correct selection
      while ( userChoice.charAt(0) != 'S' && userChoice.charAt(0) != 'M'
            && userChoice.charAt(0) != 'L' && userChoice.charAt(0) != 'Q'
            && userChoice.charAt(0) != 'D'){
         System.out.println("Please select the size of your pizza.");
         System.out.println("Small, Medium, Large, or Duper. Type quit to exit.");
         userChoice = userInput.nextLine();
         userChoice = userChoice.toUpperCase();
      }
      //assign correct int to be passed to PizzaOrder
      if (userChoice.charAt(0) == 'S'){
            sizeSelection = 0;
         return sizeSelection;
      }
      else if (userChoice.charAt(0) == 'M'){
         sizeSelection = 1;
         return sizeSelection;
      }
      else if (userChoice.charAt(0) == 'L'){
         sizeSelection = 2;
         return sizeSelection;
      }
      else if (userChoice.charAt(0) == 'D'){
         sizeSelection = 3;
         return sizeSelection;
      }
      else{
         sizeSelection = -1;
         return sizeSelection;
      }
   }
   @SuppressWarnings("resource")
   public static String getToppingSelection(PizzaOrder order){
      Scanner userInput = new Scanner(System.in);
      String toppingSelected;
      System.out.println("Enter your topping selection");
      toppingSelected = userInput.nextLine();
      toppingSelected = toppingSelected.toLowerCase();
      if (toppingSelected.charAt(0) == 'r'){
         System.out.println("Resetting your order...");
         order.resetToppings();
      }
      else if (toppingSelected.charAt(0) == 'd'){
         System.out.println("Thank you for your order!");
      }
      else if (!(order.addTopping(toppingSelected))){
         System.out.println("That was an invalid topping.");
      }
      return toppingSelected;
   }
   @SuppressWarnings("resource")
   public static int getToppingSelectionInt(PizzaOrder order){
      Scanner userInput = new Scanner(System.in);
      int toppingSelected;
      System.out.println("Enter your topping selection");
      toppingSelected = userInput.nextInt();
      if(toppingSelected == 0){
         System.out.println("Thank you for your order!");
      }
      else if (toppingSelected == 99){
         System.out.println("Resetting your order...");
         order.resetToppings();
      }
      else if (!(order.addToppings(toppingSelected))){
         System.out.println("That was an invalid topping.");
      }
      return toppingSelected;
   }
   //manage output to user
   public static void displayPizza(PizzaOrder order){
      System.out.println("Current Pizza: " + order.stringizeSize()
            + " with " + order.getToppings() + "| Current price: "
            + order.getPrice());
      System.out.println("Reset toppings by typing: reset or "
            + "if finished: done.");
      }
   public static void displayMainMenu(){
      System.out.println("Toppings offered: ");
      for (int k = 0; k < PizzaOrder.toppingsOffered.length; k++){
         int positionCount;
         positionCount = k + 1;
         System.out.println(positionCount + ". " +
            PizzaOrder.toppingsOffered[k]);
      }
   }
   public static void resetToppings(PizzaOrder order){
      order.resetToppings();
   }
}
class PizzaOrder{
   //member data and shared constants
   public static final String[] toppingsOffered = 
      {"pepperoni", "canadian bacon", "bacon",
      "jalapenos", "spinach", "anchovies", "feta cheese",
      "sweet Bell peppers", "salami", "italian sausage",
      "pastrami", "clams", "lean beef", "smoked ham",
      "linguica", "pineapple", "fresh Mushrooms", "black olives",
      "fresh tomatoes", "sun dried tomatoes", "cilantro", 
      "pepperoncini", "chicken", "onions", "artichoke hearts",
      "pesto", "broccoli", "bbq chicken", "fresh garlic"};
   public static final double TOPPING_BASE_COST = .75;
   public static final double BASE_PRICE = 10.00;
   public static final int MAX_TOPPINGS = 20;
   public static final int DEFAULT_PIZZA_SMALLEST = 0; //0-small, 1-medium,
   // 2-large, 3 super-duper
   public static final int DEFAULT_PIZZA_LARGEST = 3;
   public static final int DEFAULT_TOPPINGS = 0;
   //private data
   private int size;
   private int numToppings;
   private String[] toppings;
   //default constructor 
   PizzaOrder(){
      size = DEFAULT_PIZZA_SMALLEST;
      numToppings = DEFAULT_TOPPINGS;
      toppings = new String[MAX_TOPPINGS];
   }
   //constructor with 1 param
   PizzaOrder(int size){
      if (validSize(size))
         this.size = size;
      else
         this.size = DEFAULT_PIZZA_SMALLEST;
      numToppings = DEFAULT_TOPPINGS;
      toppings = new String[MAX_TOPPINGS];
   }
   //private helper to check data
   private boolean validSize(int size){
      if (size >= DEFAULT_PIZZA_SMALLEST && size <= DEFAULT_PIZZA_LARGEST)
         return true;
      else
         return false;
   }
   private boolean validTopping(String str){
      if (Arrays.asList(toppingsOffered).contains(str.toLowerCase()))
         return true;
      else
         return false;
   }
   private boolean validTopping(int topping){
      if (topping >= 1 && topping <= toppingsOffered.length)
         return true;
      else
         return false;
   }
   //mutator methods
   public boolean setSize(int size){
      if (validSize(size)){
         this.size = size;
         return true;
      }
      else
         return false;
   }
   public void resetToppings(){
      numToppings = DEFAULT_TOPPINGS;
      toppings = new String[MAX_TOPPINGS];
   }
   public boolean addTopping(String topping){
      int tempNumToppings = numToppings + 1;
      topping = topping.toLowerCase();
      if (validTopping(topping)){
         for (int k = numToppings; k < tempNumToppings; k++){
            toppings[k] = topping;
            numToppings = numToppings + 1;
         }
         return true;
      }
      else{
         return false;
      }
   }
   public boolean addToppings(int topping){
      int tempNumToppings = numToppings + 1;
      if (validTopping(topping)){
         topping = topping - 1;
         for (int k = numToppings; k < tempNumToppings; k++){
            toppings[k] = toppingsOffered[topping];
            numToppings = numToppings + 1;
         }
         return true;
      }
      else{
         return false;
      }
   }
   //accessor methods
   public int getSize(){
      return size;
   }
   public double getPrice(){
      double price;
      if (size == 0){
         price = BASE_PRICE + (numToppings * TOPPING_BASE_COST);
         return price;
      }
      else if (size == 1){
         price = (BASE_PRICE + (numToppings * TOPPING_BASE_COST));
         price = price + (price * .15);
         return price;
      }
      else if (size == 2){
         price = (BASE_PRICE + (numToppings * TOPPING_BASE_COST));
         price = price + (price * .25);
         return price;
      }
      else if (size == 3){
         price = (BASE_PRICE + (numToppings * TOPPING_BASE_COST));
         price = price + (price * .35);
         return price;
      }
      else {
         price = 0;
         return price;
      }
   }
   public String stringizeSize(){
      String size;
      if (this.size == 0){
         size = "Small";
         return size;
      }
      else if (this.size == 1){
         size = "Medium";
         return size;
      }
      else if (this.size == 2){
         size = "Large";
         return size;
      }
      else if (this.size == 3){
         size = "Super-Duper";
         return size;
      }
      else {
         size = "Unknown";
         return size;
      }
   }
   public String getToppings(){
      String toppingList = " ";
      int tempToppings = numToppings -1;
      while (tempToppings < numToppings){
         for (int k = 0; k < toppings.length; k++){
            if (toppings[k] != null){
               toppingList = toppingList + toppings[k] + ", ";
            }
         }
         tempToppings = tempToppings + 1;
      }
      return toppingList;
   }
}