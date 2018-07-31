import java.util.Scanner;

public class UserPigPlayer extends PigPlayer{
  
  Scanner scanner = new Scanner(System.in);
  
  public UserPigPlayer(String name){
    super(name);
  }

          
  
  
  
  public boolean isRolling(int turnTotal, int opponentScore){
   String input = scanner.nextLine();
    
    if (input.length() == 0) {
      return true;
    }
    else {
      return false;
    }
  }
  
  
  
  
  
  
}