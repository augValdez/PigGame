public class SimpleHoldPlayer extends PigPlayer{
  //Instance Variables
  private int hold;
  private String playName;
  
  public SimpleHoldPlayer(){
    super("");
    hold = 15;
  }
  
  public SimpleHoldPlayer(String name){
    super(name);
    hold = 15;
  }
  
  public SimpleHoldPlayer(String name, int value){
    super(name);
    playName = name;
    hold = value;
  }
  
  
  public boolean isRolling(int turnTotal, int opponentScore){
    boolean rolling = false;
    if (turnTotal < hold){
      rolling = true;
    }
    return rolling;
  }
}
     
