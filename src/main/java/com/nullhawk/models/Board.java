package com.nullhawk.models;

import java.util.List;

public class Board {
    int size;
    List<List<Cell>> cells;
    
    public Board(int size, List<List<Cell>> cells) {
        this.size = size;
        this.cells = cells;
    }
}
