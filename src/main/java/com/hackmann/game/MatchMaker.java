package com.hackmann.game;

import com.hackmann.player.*;
import com.hackmann.server.*;

import java.util.*;


public class MatchMaker implements Runnable{ //handles the matchmaking of the players

    private Stack<Player> playerStack = new Stack<Player>(); //makes a new empty stack of players

    private boolean running = false;

    public MatchMaker() {}

    public void addPlayerToQueue(Player player){
        playerStack.push(player);
    }

	@Override
	public void run() {
        while (this.running) {
            if (playerStack.size() >= 2) {
                ArrayList<Player> players = new ArrayList<Player>();
                players.add(playerStack.pop());
                players.add(playerStack.pop());
            }
        }
    }
    
    public void stop(){
        this.running = false;
    }
    

    //Remove player from stack if they disconect
    //End the loop if the server ends the
    
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
