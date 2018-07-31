
public class StrategicPlayer extends PigPlayer{
  
  int closeValue;
  int reasonableValue;
  
  public StrategicPlayer(String player, int valueClose, int valueReasonable){
    
    super(player);
    this.closeValue = valueClose;
    this.reasonableValue = valueReasonable;
  }
  
  public boolean isRolling(int turnTotal, int opponentScore) 
  { 
    int hold = reasonableValue;
    if(getScore() >= closeValue || opponentScore >= closeValue){
      hold = PigGame.GOAL - getScore();
    }else{
      hold = reasonableValue + (opponentScore - getScore()) / 25;
    }
     if (PigGame.verbose){
      System.out.println("Hold Score: " + hold);
      System.out.println("Turn Total: " + turnTotal);
     }
    if(hold > turnTotal){
      return true;
    }else{
      return false; 
    }
  }
  
}