package com.nullhawk.models;

import java.util.List;

import com.nullhawk.enums.CellState;

import java.util.ArrayList;

public class Board {
    private int size;
    List<List<Cell>> board;
    
    public Board(int size) {
        this.size = size;
        
        //generates empty board
        this.board = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            List<Cell> row = new ArrayList<>();
            for (int j = 0; j < size; j++) {
                row.add(new Cell(i, j));
            }
            this.board.add(row);
        }
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public List<List<Cell>> getBoard() {
        return board;
    }

    public void setBoard(List<List<Cell>> board) {
        this.board = board;
    }

    // TODO: Make compatible witjh both GUI and CLI
    public void printBoard(){
        // TODO: prints the board
        for(List<Cell> row : board){
            for(Cell cell : row){
                if(cell.getState().equals(CellState.EMPTY)){
                    System.out.print("| - |");
                }else{
                    System.out.print("| " + cell.getPlayer().getSymbol().getSymbol() + " |");
                }
            }
            System.out.println();
        }
    }

    public Cell getCell(int row, int col) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getCell'");
    }
}
