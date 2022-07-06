package ru.netology.tournament;

import java.util.ArrayList;
import java.util.HashMap;

public class Game {
    private HashMap<String, Integer> regPlayers = new HashMap();
    private Player[] players = new Player[0];

    public void register(Player player) {
        Player[] tmp = new Player[players.length + 1];
        for (int i = 0; i < players.length; i++) {
            tmp[i] = players[i];
        }
        tmp[tmp.length - 1] = player;
        players = tmp;
        regPlayers.put(player.getName(), player.getStrength());
    }


    public int round(String playerName1, String playerName2) {
        if (regPlayers.containsKey(playerName1)) {
            if (regPlayers.containsKey(playerName2)) {
                if (regPlayers.get(playerName1) - regPlayers.get(playerName2) > 0) {
                    return 1;
                } else {
                    if (regPlayers.get(playerName1) - regPlayers.get(playerName2) < 0) {
                        return 2;
                    } else {
                        return 0;
                    }
                }
            } else {
                throw new NotRegisteredException("Игрок " + playerName2 + " не зарегистрирован");
            }
        } else {
            throw new NotRegisteredException("Игрок " + playerName1 + " не зарегистрирован");
        }
    }

    public Player[] getPlayers() {
        return players;
    }

    public HashMap getRegPlayers() {
        return regPlayers;
    }
}
