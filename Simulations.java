public class Simulations{
  
  public static PigPlayer player1, player2;
  
  public static void firstAdvantage(long simulations){
    
    SimpleHoldPlayer player1 = new SimpleHoldPlayer("Ada");
    SimpleHoldPlayer player2 = new SimpleHoldPlayer("Charles");
    player1.resetWinRecord();
    player2.resetWinRecord();
    int gamesWon = 0;
    for(int i = 0; i < simulations; i++){
      PigGame game = new PigGame(player1,player2);
      game.playGame();
    }
    
    //System.out.println("Games won: " + player1.getWinRecord());
    double winP = (((double)player1.getWinRecord())/ simulations) * 100;
    System.out.println("first player to go has an advantage of " + winP);
  }
  
  
 public static void findBestValue(long simulations){
   for(int k = 1; k <= 3; k++){
      SimpleHoldPlayer firstPlayer = new SimpleHoldPlayer("player1", k);      
      SimpleHoldPlayer secondPlayer = new SimpleHoldPlayer("player2");      
      PigGame game = new PigGame(player1, player2);
      
      int gamesWon = 0;
      for(int i = 1; i <= simulations; i++){
        game.playGame();
        if(firstPlayer.won()){
          gamesWon++;
        }
      }
      double winP = (((double)player1.getWinRecord())/ simulations) * 100;
      System.out.println("Player who goes first has an advantage of " + winP + " holding at " + k);
      System.out.println("Games won " + gamesWon);
      System.out.println(simulations);
    }
  }
 
  public static double comparePlayers(long simulations, PigPlayer first, PigPlayer second) {
    long half = simulations/2;
    
    for (long i = 0; i < half; i++) {
      PigGame pig = new PigGame(first, second);
      pig.playGame();
    }
    
    for (long i = half; i < simulations; i++) {
      PigGame pig = new PigGame(second, first);
      pig.playGame();
    }
    
    return (double)first.getWinRecord()/simulations;
  }
  
  public static void main(String[] args){ 

    PigPlayer hold = new SimpleHoldPlayer("Ada", 10);
    for(int closeValue = 50; closeValue < 100; closeValue++){
      for(int reasonableValue = 5; reasonableValue < 50; reasonableValue++){
        PigPlayer turns = new StrategicPlayer("Charles", closeValue, reasonableValue);
        
        double player1Won =  comparePlayers(100, turns, hold) * 100.0;
        
        if(player1Won > 1.0){
          System.out.println("Player who goes first has an advantage of " + player1Won + " holding at " + reasonableValue);
         // System.out.println("close value: " + closeValue + "\n hold value: " + reasonableValue + " " + player1Won); 
        }
      }
    }
  }
}
