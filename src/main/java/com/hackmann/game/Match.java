import java.util.ArrayList;

public class Match extends Runnable {
    private ArrayList<Player> players = new ArrayList<Player>(); //1st element = 1st player,
    //2nd element = 2nd player
    private Player winningPlayer = null;
    private int gameDuration = 0; //duration of the game
    private int timeElapsed = 0;  ///
    private boolean gameFinished = false;
    private Player player1 = null;
    private Player player2 = null;
    private int player1Score = 0;
    private int player2Score = 0;
    
    //we need to send the other players score to the other player

    public Match(ArrayList<Player> players) { //pass in the two players for the match
        this.players = players;
        player1 = players.get(0);
        player2 = players.get(1);
    }

    @Override
    public run() {
        if (timeElapsed >= gameDuration) { //if the game is over, we can change the condition later
            gameFinished = true;
        }
 
        if (gameFinished) { //if the game is finished
            if (player1Score > player2Score) { //if the first Player wins
                winningPlayer = player1;
            }
            else if (player2Score) > player1Score) {
                winningPlayer = player2;
            }
            else {
                winningPlayer = null;
            }
        }

        //how to send the score to the players
        //since we have variables for player1 and player2,
        //we can send player1Score to player2, and player2Score to player1 using the send method
        //in Connection
    }
}
