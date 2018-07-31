public class FourTurnsPlayer extends PigPlayer {
  
  public FourTurnsPlayer(String player){
    super(player);
  }
  
  public boolean isRolling(int turnTotal, int opponentScore){
    int hold = PigGame.GOAL / 4;
    if(getScore() >= hold){
      hold = (PigGame.GOAL - getScore()) / 3;
      
      if (getScore()>= hold + PigGame.GOAL / 4){
        hold = (PigGame.GOAL - getScore()) / 2;
        
        if(PigGame.GOAL / 4 >= PigGame.GOAL - getScore()){
          hold = PigGame.GOAL - getScore();
        }
      }
    }
    if(hold > turnTotal){
      return true;
    }else{
      return false; 
    }
  }
  
  
}