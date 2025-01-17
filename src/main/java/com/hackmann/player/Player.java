package com.hackmann.player;

import com.hackmann.server.*;

import java.util.ArrayList;

import com.hackmann.game.*;
import com.hackmann.packets.client.*;
import com.hackmann.packets.Event;

public class Player {

    private PlayerState state = PlayerState.Lobby;
    private String username = "";
    private Connection connection = null; //server id and socket
    private Match match;
    private int score = 0;
    private boolean  gameOver = false;

    public Player(Connection connection) { //when a new player enters
        this.connection = connection;
        this.username = "Player "+connection.id;
    }

    public void changeScore(int amount) {
        if (amount==0) {
            return;
        }
        this.score += amount;
        if (this.score < 0){
            this.score = 0;
        }
        System.out.println("\tChanged the players score by " + Integer.toString(amount) + " to get a total of " + this.score + ".");
    }
    public Match getMatch() {
        return this.match;
    }
    public void setMatch(Match match) {
        this.match = match;
    }
    public int score() {
        return this.score;
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String name){
        System.out.println("\t" + this.username + " has changed their username to " + name + ".");
        this.username = name;

        Event event = new ConfirmUsernameChange();
        this.connection.send(event);
    }

    public void setGameEnd(boolean bool){
        this.gameOver = bool;
    }

    public boolean getGameEnd(){
        return this.gameOver;
    }

    public Connection getConnection(){
        return this.connection;
    }

    public Player getOtherPlayer(ArrayList<Player> players){
        for (Player player : players){
            if (player != this){
                return player;
            }
        }
        return null;
    }

    public void setState(PlayerState state){
        this.state = state;
        System.out.println("\t" + this.username + " has changed their state to "+ state + ".");
    }

    public void joinGame(){
        if (this.state == PlayerState.Lobby){
            MatchMaker.matchMaker.addPlayerToQueue(this);
            this.setState(PlayerState.Queue);
        }
    }

    public void disconnect() {
        this.connection.close();
        if (this.state == PlayerState.Queue) {
            MatchMaker.matchMaker.removePlayer(this);
        }
        if (this.match != null ) {
            this.match.endGame(this.getOtherPlayer(this.match.getPlayers()));
        }
        System.out.println("\n"+this.username + " has disconnected from the server.\n");
    }
}
