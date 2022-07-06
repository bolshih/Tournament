package ru.netology.tournament;

import java.util.ArrayList;

public class Game {
    private ArrayList<String> regPlayers = new ArrayList<>();
    private Player[] players = new Player[0];

    public void register(Player player) {
        Player[] tmp = new Player[players.length + 1];
        for (int i = 0; i < players.length; i++) {
            tmp[i] = players[i];
        }
        tmp[tmp.length - 1] = player;
        players = tmp;
        regPlayers.add(player.getName());
    }


    public int round(String playerName1, String playerName2) {
        if (regPlayers.contains(playerName1)) {
            if (regPlayers.contains(playerName2)) {
                if (findPlayerStrength(playerName1) - findPlayerStrength(playerName2) > 0) {
                    return 1;
                } else {
                    if (findPlayerStrength(playerName1) - findPlayerStrength(playerName2) < 0) {
                        return 2;
                    } else {
                        return 0;
                    }
                }
            } else throw new NotRegisteredException("Игрок " + playerName2 + " не зарегистрирован");
        } else throw new NotRegisteredException("Игрок " + playerName1 + " не зарегистрирован");
    }

    public Player[] getPlayers() {
        return players;
    }

    public ArrayList<String> getRegPlayers() {
        return regPlayers;
    }

    public void setRegPlayers(ArrayList<String> regPlayers) {
        this.regPlayers = regPlayers;
    }

    public int findPlayerStrength(String name) {
        for (Player player : getPlayers()) {
            if (player.getName() == name) {
                return player.getStrength();
            }
        }
        return 0;
    }
}
