package com.hackmann.game;

import java.util.ArrayList;
import com.hackmann.player.*;
import com.hackmann.music.*;
import com.hackmann.packets.client.*;

public class Match implements Runnable {

    private ArrayList<Player> players;
    private Song song;

    private int pointsPerNote = 100;
    private boolean running = false;

    public Match(ArrayList<Player> players){
        this.players = players;
        this.song = SongHandler.pickRandomSong();
    }

    public void start() {
        for (Player player : this.players) {
            JoinMatch event = new JoinMatch();
            event.otherPlayerName = player.getOtherPlayer(this.players).getUsername();
            event.songName = this.song.getName();
            event.maxPoints = this.song.getScorablePoints() * this.pointsPerNote;
            player.getConnection().send(event);
        }

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

		new Thread(this).start();
	}


	@Override
	public void run() {
        for (Player player : this.players) {
            player.getConnection().send(new StartMatch());
        }

        this.running = true;

        while (this.running){
            for (Player player : this.players) {
                UpdateMatch event = new UpdateMatch();
                event.yourScore = player.score();
                event.otherPlayerScore = player.getOtherPlayer(this.players).score();
                player.getConnection().send(event);
            }

            for (Player player : this.players) {
                if (!player.getGameEnd()){
                    continue;
                }
            }
            this.endGame();
        }		
        
        this.stop();
    }
    
    public void endGame(){
        Player winner = null;
        for (Player player : this.players){
            if (winner == null || player.score() > winner.score()){
                winner = player;
            }
        }

        for (Player player : this.players){
            EndMatch event = new EndMatch();
            event.winnerName = winner.getUsername();
            player.getConnection().send(event);
        }

        this.stop();
    }

	public void stop() {
        this.running = false;	
	}
}
