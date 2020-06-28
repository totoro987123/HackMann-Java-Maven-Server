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
    public ArrayList<Player> getPlayers () {
        return this.players;
    }
    public void start() {
        for (Player player : this.players) {
            player.setMatch(this);
            player.setGameEnd(false);
            player.changeScore(-player.score());
            player.setState(PlayerState.In_Game);
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
        System.out.println("Match started");

        this.running = true;

        while (this.running){
            /*for (Player player : this.players) {
                UpdateMatch event = new UpdateMatch();
                event.yourScore = player.score();
                event.otherPlayerScore = player.getOtherPlayer(this.players).score();
                System.out.println(""+event.yourScore+" "+event.otherPlayerScore);
                player.getConnection().send(event);
                System.out.println("updated match");
            }*/
            boolean endGame = true;
            for (Player player : this.players) {
                System.out.println(player.getUsername()+" "+Boolean.toString(player.getGameEnd()));
                if (!player.getGameEnd()) {
                    endGame = false;
                    break;
                }
            }

            if (endGame) {
                Player winner = null;
                for (Player player : this.players){
                    if (winner == null || player.score() > winner.score()){
                        winner = player;
                    }
                }
                this.endGame(winner);
            }
        }

        this.stop();
    }

    public void endGame(Player winner){
        System.out.println("end game");
        for (Player player : this.players) {
            System.out.println("end game for "+player.toString());
            EndMatch event = new EndMatch();
            event.winnerName = winner.getUsername();
            player.setState(PlayerState.Lobby);
            player.getConnection().send(event);
        }


        this.stop();
    }

	public void stop() {
        this.running = false;
	}
}
