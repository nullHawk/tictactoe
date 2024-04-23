package com.nullhawk.models;

import com.nullhawk.enums.*;
import java.util.List;

public class Game {
    Board board;
    List<Player> players;
    int nextPlayerMoveIndex;
    Player Winner;
    List<Move> moves;
    GameState gameState;
    Game(){
        
    }
}
