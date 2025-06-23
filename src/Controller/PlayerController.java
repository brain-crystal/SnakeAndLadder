package Controller;

import Models.Player;

import java.util.ArrayList;
import java.util.List;

public class PlayerController {
    List<Player> players;
    public PlayerController() {
        players = new ArrayList<>();
    }

    public void addPlayer(Player player) {
        if (!players.contains(player)) {
            players.add(player);
        }
    }
    public Player getPlayer(String name) {
        for (Player player : players) {
            if (player.getName().equals(name)) {
                return player;
            }
        }
        System.out.println("Player not found");
        return null;
    }
}
