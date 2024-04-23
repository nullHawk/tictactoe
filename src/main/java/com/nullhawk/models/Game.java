package com.nullhawk.models;

import com.nullhawk.enums.*;
import java.util.List;
import java.util.ArrayList;

public class Game {
    Board board;
    List<Player> players;
    int nextPlayerMoveIndex;
    Player Winner;
    List<Move> moves;
    GameState gameState;

    public Game(Board board, List<Player> players) {
        this.board = board;
        this.players = players;
        this.nextPlayerMoveIndex = 0;
        this.Winner = null;
        this.moves = new ArrayList<>();
        this.gameState = GameState.IN_PROGRESS;
    }
}
