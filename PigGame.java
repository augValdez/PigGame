//Augustine Valdez
import java.util.Scanner;

public class PigGame{
  public static final int GOAL = 100;
  static boolean verbose = false;
  PigPlayer player1, player2;
  
  public PigGame(){
    player1 = new UserPigPlayer("Player 1");
    player2 = new UserPigPlayer("Player 2");
  }
  
  public PigGame(String nameOne, String nameTwo){
    player1 = new UserPigPlayer(nameOne);
    player2 = new UserPigPlayer(nameTwo);
  }
  
  public PigGame(PigPlayer player1, PigPlayer player2){
    this.player1 = player1;
    this.player2 = player2;
  }
  
  public void reset(){
    player1.reset();
    player2.reset();
  }
  
  public boolean verbose(boolean change){
    verbose = change;
    
    return verbose;
  }
  
  
  
  
  //turn
  public static int playTurn(PigPlayer player, PigPlayer opponent){
    int turnTotal = 0;
    while (player.isRolling(turnTotal, opponent.getScore())){
      int roll = Die.roll();
      if (verbose){
        System.out.println(player.getName() + "'s Score: " 
                             + player.getScore());
        System.out.println(opponent.getName() + "'s Score: " 
                             + opponent.getScore());
      }                   
      if(roll == 1){
        turnTotal = 0;
        return turnTotal;
      } else {
        turnTotal = turnTotal + roll;
        if (verbose){
          System.out.println("Turn Total: " + turnTotal);        
        }
      }
    }
    return turnTotal;
  }
  
  //play game
  public void playGame(){
    reset();
    while(player1.getScore() < GOAL && player2.getScore() < GOAL){
       if (verbose){
      System.out.println(player1.getName() + " is rolling");
       }
      player1.addPoints(playTurn(player1,player2));
      if(player1.won() == true){
        if (verbose){
          System.out.println("Winner: " + player1.getName());
        }
        break;
      }
       if (verbose){
      System.out.println(player2.getName() + " is rolling");
       }
      player2.addPoints(playTurn(player2,player1));
      if(player2.won() == true){
        if (verbose){
          System.out.println("Winner: " + player2.getName());
        }
        break;
      }
    }  
  }
  //user vs user
  public static void userVsUser(){
    
    Scanner scanner = new Scanner(System.in);
    
    System.out.println("Ready to play Pig?");
    System.out.println("how it works:");
    System.out.println("2 players will race to reach 100 points.");
    System.out.println("For each turn, a player will roll a dice repeatedly adding up points until: \n" +
                       "- a 1 is rolled, in which you earn 0 points for that round \n" + 
                       "- the players turn total adds up the the goal of 100 points \n \n");
    System.out.println("while it is your turn you have 2 choices: \n" + 
                       "- you can roll by hitting the enter key \n" +
                       "- you can hold {you keep whatever points you have earned and end your turn} by hitting any other key + enter");
    System.out.println("READY?");
    System.out.println("First Player: what is your name?");
    String pOne = scanner.nextLine();
    System.out.println("Second Player: what is your name?");
    String pTwo = scanner.nextLine();
    
    double ran = Math.random();
    PigGame game;
    PigPlayer player1 = new UserPigPlayer(pOne);
    PigPlayer player2 = new UserPigPlayer(pTwo);
    if(ran < 0.5){     
      if (verbose){
        System.out.println("who starts? \n" + player1.getName() + "!");
      }
      game = new PigGame(player1,player2);
    } else {
      if (verbose){
        System.out.println("who starts? \n" + player1.getName() + "!");
      }
      game = new PigGame(player2,player1);
    }
    game.playGame();
  }
  
  //you vs computer
  public static void userVsComputer(){
    
    Scanner scanner = new Scanner(System.in);
    
    System.out.println("Ready to play Pig with the computer?");
    System.out.println("how it works:");
    System.out.println("You will race the computer tp reach 100 points.");
    System.out.println("For each turn, you and the computer will roll a dice repeatedly adding up points until: \n" +
                       "- a 1 is rolled, in which you earn 0 points for that round \n" + 
                       "- the players turn total adds up the the goal of 100 points ");
    System.out.println("while it is your turn you have 2 choices: \n" + 
                       "- you can roll by hitting the enter key \n" +
                       "- you can hold {you keep whatever points you have earned and end your turn} by hitting any other key + enter");
    System.out.println("READY?");
    System.out.println("Player: what is your name?");
    String player = scanner.nextLine();
    System.out.println("vs Computer");
    String computer = "computer";
    
    double ran = Math.random();
    PigGame game;
    PigPlayer player1 = new UserPigPlayer(player);
    PigPlayer player2 = new SimpleHoldPlayer(computer);
    if(ran < 0.5){
      if (verbose){
        System.out.println("who starts? \n" + player1.getName() + "!");
      }
      game = new PigGame(player1,player2);
      game.playGame();
    } else {
      if (verbose){
        System.out.println("who starts? \n" + player1.getName() + "!");
      }
      game = new PigGame(player2,player1);
    }
    game.playGame();
  }
  
  //computer vs computer
  public static void computerVsComputer(){
    
    Scanner scanner = new Scanner(System.in);
    
    System.out.println("Computer vs Computer");
    System.out.println("how it works:");
    System.out.println("they'll race to reach 100 points.");
    System.out.println("For each turn, the computers will roll a dice repeatedly adding up points until: \n" +
                       "- a 1 is rolled, in which you earn 0 points for that round \n" + 
                       "- the players turn total adds up the the goal of 100 points ");
    System.out.println("while it is your turn you have 2 choices: \n" + 
                       "- you can roll by hitting the enter key \n" +
                       "- you can hold {you keep whatever points you have earned and end your turn} by hitting any other key + enter");
    System.out.println("READY?");
    System.out.println("first computer: Ada ");
    String compOne = "Ada";
    System.out.println("second computer: Charles");
    String compTwo = "Charles";
    
    double ran = Math.random();
    PigGame game;
    
    PigPlayer player1 = new SimpleHoldPlayer(compOne);
    PigPlayer player2 = new SimpleHoldPlayer(compTwo);
    if(ran < 0.5){
      if (verbose){
        System.out.println("who starts? \n" + player1.getName() + "! \n");
      }
      game = new PigGame(player1,player2);
    } else {
      if (verbose){
        System.out.println("who starts? \n" + player1.getName() + "! \n");
      }
      game = new PigGame(player2,player1);
    }
    game.playGame();
  }
  
  //main 
  public static void main(String[] args){
    userVsComputer();
    
  }
  
  
}


