package com.nullhawk.models;

public class Move {
    private Cell cell;
    private Player player;

    public Move(Cell cell, Player player) {
        this.cell = cell;
        this.player = player;
    }

    // Getters: 
    public Cell getCell() {
        return this.cell;
    }
    
    public Player getPlayer() {
        return this.player;
    }

    // Setters:

    public void setCell(Cell cell) {
        this.cell = cell;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

}
