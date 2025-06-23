package Models;

import lombok.Data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Data
public class Board {
    private List<Integer> board;
    Map<Integer,Integer> enemies;

    public Board() {
        board = new ArrayList<>();

        int cnt = 1;
        for (int i = 0; i < 100; i++) {
            board.add(cnt++);
        }
        enemies = new HashMap<>();
    }
}
