package com.nullhawk.models;

import com.nullhawk.enums.BotDifficultyLevel;
import com.nullhawk.enums.CellState;
import com.nullhawk.enums.PlayerType;
import java.util.List;

public class Bot extends Player{
    private BotDifficultyLevel difficultyLevel;

    public Bot(String name, Symbol symbol, PlayerType playerType, BotDifficultyLevel difficultyLevel) {
        super(name, symbol, playerType);
        this.difficultyLevel = difficultyLevel;
    }
    
    public BotDifficultyLevel getDifficultyLevel() {
        return this.difficultyLevel;
    }

    @Override
    public Move makeMove(Board board){
        // TODO: Find the first empty cell and make the move there.
        for(List<Cell> row: board.getBoard()){
            for(Cell cell : row){
                if(cell.getState().equals(CellState.EMPTY)){
                    return new Move(cell, this);
                }
            }
        }
        return super.makeMove(board);
    }
}
