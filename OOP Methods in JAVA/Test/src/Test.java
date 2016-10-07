import java.awt.Component;
import java.awt.Graphics;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;


public class Test{
   
   public static void main(String[] args) throws Exception{
      
      PaintComponent drawing = new PaintComponent();
      int n = drawing.numberLines(userInput());
      while (n == 0){
         n = drawing.numberLines(userInput());
      }
      drawPanel(drawing);
   }
   public static void drawPanel(Component panel){
      JFrame app = new JFrame();
      app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      app.add(panel);
      app.setSize(500, 500);
      app.setVisible(true);
   }
   public static int userInput(){
      int number;
      String userInput = JOptionPane.showInputDialog("Please Enter A Number "
            + "Between 2 and 50!");
      number = Integer.parseInt(userInput);
      return number;
   }
}
class PaintComponent extends JPanel{
   //member data
   private int numSteps;
   
   public void paintComponent(Graphics g){
      super.paintComponent(g);
      int width = 50;
      int height = 50;
      
      g.drawLine(10, 10, width, height);
      g.drawLine(30, height, width, 40);
   }
   //mutator
   public int numberLines(int number){
      if (validNumber(number)){
         numSteps = number;
         return number;
      }
      else {
         return 0;
      }
   }
   //method helper to check proper data
   private boolean validNumber(int number){
      if(number >= 2 && number <= 50){
         return true;
      }
      else {
         return false;
      }
   }
   //accessor method
   public int getUserNumber(){
      return numSteps;
   }
}