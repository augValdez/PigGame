//Augustine Valdez
import java.util.Scanner;

public class Die{

  protected static int rollNumber;
  protected static int totalPoints;
  protected static int random;
  protected static int win = 100;
  protected static int winner;
  protected static int number;
  protected static int numberOfSides;
  protected static int rollNum;
  protected static int sides = 6;
  protected static int customSide; // the users input side number
 
  public Die(){
  }
  
   public Die(int newSides){
    //user input
    sides = newSides;
  }
  
  public static int roll(){
     int random = (int)(Math.random()* 6 +1);
    //6 sides

    return random;
  }
  
  public int rollDie(){
    //as many sides as you want(positive)
 
    rollNum = (int)(Math.random()* sides) + 1;
   
    return rollNum;
  }
  
   public void setSides(int numberOfSides){
    //user input
    sides = numberOfSides;
  }
   
    public int getSides(){
    
    return sides;
  }
  
}





