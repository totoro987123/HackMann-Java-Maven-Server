package com.hackmann.game;

import java.util.ArrayList;
import com.hackmann.player.*;
import com.hackmann.music.*;

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
            
        }


		new Thread(this).start();
	}


	@Override
	public void run() {
        this.running = true;

        while (this.running){

        }		
        
        this.stop();
    }
    
	public void stop() {
        this.running = false;	
	}
}
