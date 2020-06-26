import java.io.*;
import java.util.*;
import java.util.Scanner;
import java.util.Stack;
import java.util.List;

public class MatchMaker { //handles the matchmaking of the players

    private Stack<Player> stack = new Stack<Player>(); //makes a new empty stack of players
    private boolean running = false;
    List<List<Player>> gameList = new ArrayList<List<Player>>(); //this is experimental, will probably delete
    private int gameNum = 0; //current room number

    public MatchMaker() {
        running = true;
    }

    public void start() {
        if (stack.size() >= 2) { //if there are at least two players
            stack.pop(); //pop the first player
            stack.pop(); //pop the second player

            //put the two players in a seperate game or room
            //i'm not sure how we're doing this, for now I just made table
            //each index represents a seperate game id, with two players in it
            ArrayList<Player> players = new ArrayList<Player>();
            players.add(stack.pop());
            players.add(stack.pop());
            listOfLists.get(gameNum).add(players);
            gameNum++;
        }
    }

    public void addPlayer(Player player) { //add a player to the stack
        stack.push(player);
    }
    
    /** 
    public void removePlayer(Player player) {
        int index = stack.search(player.getUsername()); //search for the lement
        if (stack.search(player.id) != -1) { //if the player's name exists
            stack.remove(index);
        }
    }
    */
    
    //push, pop (EmptyStackException)
    //stack.push(num); //adds an element
    //System.out.println(stack);
    }
}
