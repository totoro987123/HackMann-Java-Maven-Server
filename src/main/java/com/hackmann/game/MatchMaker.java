package com.hackmann.game;

import com.hackmann.player.*;

import java.util.*;


public class MatchMaker implements Runnable{ //handles the matchmaking of the players

    static public MatchMaker matchMaker = new MatchMaker();

    private Stack<Player> playerStack = new Stack<Player>(); //makes a new empty stack of players

    private boolean running = false;

    public MatchMaker() {}

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

    public void addPlayerToQueue(Player player){
        playerStack.push(player);
    }
    
    public void stop(){
        this.running = false;
    }
    
    public void removePlayer(Player player) {
        this.playerStack.remove(player);
    }
    
}
