package com.hackmann.player;

import com.hackmann.server.*;
import java.util.*;

public class PlayerHandler {

    public static HashMap<Connection,Player> players = new HashMap<Connection,Player>();

    public static Player registerPlayer(Connection connection){
        Player player = new Player(connection);
        players.put(connection, player);
        return player;
    }

    public static Player getPlayer(Connection connection) {
        Player player = players.get(connection);
        if (player != null){
            return player;
        }
        return registerPlayer(connection);
    }

}