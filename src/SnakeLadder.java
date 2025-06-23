import Controller.GameController;
import Controller.PlayerController;
import Models.Board;
import Models.Game;
import Models.Player;

import java.util.*;

public class SnakeLadder {
    private PlayerController playerController;
    private GameController gameController;

    public SnakeLadder() {
        playerController = new PlayerController();
        gameController = new GameController();
    }
    void runDemo(){
        Board board = new Board();

        setupBoard(board);

        Game game = setupGame(board);

        playGame(game);
    }

    void playGame(Game game) {
        List<Player> players = game.getPlayers();
        Board board = game.getBoard();
        Map<Integer, Integer> enemies = board.getEnemies();
        boolean gameOver = false;
        int p1 = 0,p2 = 0,p3 = 0;
        while(!gameOver){
            for(Player player : players){
                int moves = nextMove();
                int curPosOfPlayer = player.getCurrentPosition();

                int nextPosOfPlayer = curPosOfPlayer + moves;

                if(nextPosOfPlayer > 100) {
                    continue;
                }
                if(enemies.containsKey(nextPosOfPlayer)){
                    nextPosOfPlayer = enemies.get(nextPosOfPlayer);

                }
                player.setCurrentPosition(nextPosOfPlayer);
                if (player.getName().equals("Ayushi")) {
                    p1 = player.getCurrentPosition();
                } else if (player.getName().equals("Mudit")) {
                    p2 = player.getCurrentPosition();

                } else if (player.getName().equals("Niharika")) {
                    p3 = player.getCurrentPosition();
                }
                if (nextPosOfPlayer == 100) {
                    System.out.println("Player " + player.getName() + " won!");
                    player.setCurrentPosition(nextPosOfPlayer);
                    gameOver = true;
                    break;
                }
            }

            System.out.println("Ayushi - " + p1 + " Mudit - " + p2 + " Niharika - " + p3);
            for(int i = 1; i <= 100; i++){
                if(i == p1) {
                    System.out.print("A ");
                } else if (i == p2) {
                    System.out.print("M ");
                } else if (i == p3) {
                    System.out.print("N ");
                } else {
                    System.out.print(i + " ");
                }
            }
            System.out.println();
        }

    }
    int nextMove() {
        int moves = rollADice();
        if(moves == 6) {
            moves += rollADice();
            if(moves == 12) {
                moves += rollADice();
                if(moves == 18) {
                    return 0;
                }
            }
            moves += rollADice();

        }
        return moves;
    }
    int rollADice(){
        Random rand = new Random();
        return rand.nextInt(6) + 1;
    }
     Game setupGame(Board board){
        List<Player> players = new ArrayList<>();
        Player player1 = new Player("Ayushi",0);
        Player player2 = new Player("Mudit",0);
        Player player3 = new Player("Niharika",0);
        players.add(player1);
        players.add(player2);
        players.add(player3);

         return new Game("1",players, board, null);


    }

    void setupBoard(Board board) {
        addEnemeis(board);



    }
    void addEnemeis(Board board) {

        // add 5 snakes

        Map<Integer,Integer> enemies = new HashMap<>();

        enemies.put(67,23);
        enemies.put(25,7);
        enemies.put(89,45);
        enemies.put(99,5);
        enemies.put(43,11);

        // add 8 ladders
        enemies.put(33,78);
        enemies.put(17,89);
        enemies.put(9,44);
        enemies.put(58,69);
        enemies.put(85,97);

        board.setEnemies(enemies);

    }

}
