package com.nullhawk.controlers;

import com.nullhawk.enums.GameState;
import com.nullhawk.exceptions.InvalidMoveException;
import com.nullhawk.models.Game;
import com.nullhawk.models.Player;
import java.util.List;

public class GameController {
    public Game startGame(int dimention, List<Player> players){
        // TODO
        // validate if 2 players have the same symbol or not?
        // If 2 players have the same symbol, throw an exception (Create custom Exception SameSymbolException)
        return new Game(dimention, players);
    }

    public void makeMove(Game game) throws InvalidMoveException{
        game.makeMove(game);
    }

    public GameState checkState(Game game){
        return game.getGameState();
    }

    public  Player getWinner(Game game){
        return game.getWinner();
    }

    // public int getNextPlayerMoveIndex(){
    //     return nextPlayerMoveIndex;
    // }

    // public void setNextPlayerMoveIndex(int nextPlayerMoveIndex){
    //     this.nextPlayerMoveIndex = nextPlayerMoveIndex;
    // }

    public void printBoard(Game game){
        // TODO
        // print the board
        game.printBoard();
    }
}
