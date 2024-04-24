package com.nullhawk.models;

import com.nullhawk.enums.*;

public class Cell {
    private int row;
    private int column;
    private Player player;
    private CellState state;

    public Cell(int row, int column) {
        this.row = row;
        this.column = column;
        this.state = CellState.EMPTY;
    }
    
    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getColumn() {
        return column;
    }

    public void setColumn(int column) {
        this.column = column;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public CellState getState() {
        return state;
    }

    public void setState(CellState state) {
        this.state = state;
    }
}
