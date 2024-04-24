package com.nullhawk;

import com.nullhawk.controlers.GameController;
import com.nullhawk.enums.GameState;
import com.nullhawk.enums.PlayerType;
import com.nullhawk.exceptions.InvalidMoveException;
import com.nullhawk.models.Bot;
import com.nullhawk.models.Game;
import com.nullhawk.models.Player;
import com.nullhawk.models.Symbol;
import java.util.Scanner;
import java.util.List;

public class Main {
    public static void main(String[] args) throws InvalidMoveException {
        Scanner sc = new Scanner(System.in);
        GameController gameController = new GameController();
        int dimmension = 3;
        List<Player> players = List.of(
            new Player("Suraynsh", new Symbol('X'), PlayerType.HUMAN),
            new Bot("nullHawk", new Symbol('0'), PlayerType.BOT, null)
        );
        Game game = gameController.startGame(3,players);
        //gameController.printBoard(game);

        while(game.getGameState().equals(GameState.IN_PROGRESS)){
            // 1.printBoard
            gameController.printBoard(game);

            //2.Player's turn
            gameController.makeMove(game);
        }

        if(!gameController.checkState(game).equals(GameState.ENDED)){
            game.setGameState(GameState.DRAW);
            System.out.println("Game DRAW");
        }else{
            System.out.println("Winner is: " + gameController.getWinner(game).getName());
        }
    }
}