public abstract class PigPlayer{
  
  protected String playerName;
  protected int currentScore;
  protected int gamesWon;
  
  /**
 * Returns a boolean value indicating if the player wants to roll the Die again.
 * 
 * Returns true to roll again, false to not roll again.
 */ 
public abstract boolean isRolling(int turnTotal, int opponentScore);

public void resetWinRecord(){
  gamesWon = 0;  
}

  public PigPlayer(String name){
    playerName = name;
  }
  
  public void setName(String name){
    playerName = name;
  }
  
  public String getName(){
    
    return playerName;
  }
  
  public void reset(){
    
    currentScore = 0;
  }
  
  public int getScore(){
    return currentScore;
  }
  
  public void addPoints(int turnTotal){
    currentScore = currentScore + turnTotal;
    if (currentScore >= PigGame.GOAL){
      gamesWon++;
    }
  }
  
  public boolean won(){
    boolean won;
    if(currentScore >= PigGame.GOAL){
      won = true;
    } else {
      won = false;
    }
    return won;
  }
  
  public int getWinRecord(){
    
    return gamesWon;
  }
  
  
  public String toString(){
    
    return (("Name: " + playerName) + " " + "Games Won: " + gamesWon);
  }
}




