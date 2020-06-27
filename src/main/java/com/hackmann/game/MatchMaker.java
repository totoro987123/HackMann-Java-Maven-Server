package com.hackmann.game;

import com.hackmann.player.*;
import com.hackmann.packets.client.*;
import com.hackmann.packets.Event;
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
        System.out.println("\t"+player.getUsername() + " has joined the queue for the game.");
        System.out.println("\tThere are " + playerStack.size() + " players in the queue.");

        Event event = new ConfirmQueueJoin();
        player.getConnection().send(event);
    }
    
    public void stop(){
        this.running = false;
    }
    
    public void removePlayer(Player player) {
        this.playerStack.remove(player);
    }
    
}
