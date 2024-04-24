package com.nullhawk.models;

import com.nullhawk.enums.PlayerType;
import java.util.Scanner;

public class Player {
    private String name;
    private Symbol symbol;
    private PlayerType playerType;
    private static Scanner scanner = new Scanner(System.in);

    public Player(String name, Symbol symbol, PlayerType playerType) {
        this.name = name;
        this.symbol = symbol;
        this.playerType = playerType;
    }

    public String getName() {
        return this.name;
    }

    public PlayerType getPlayerType() {
        return this.playerType;
    }

    public Symbol getSymbol() {
        return this.symbol;
    }

    public Move makeMove(Board board){
        // TODO: Ask the user were they want to place the symbol.
        System.out.println("Please enter the row number where you want to make a move?");
        int row = scanner.nextInt();

        System.out.println("Please enter the column number where you want to make a move?");
        int col = scanner.nextInt();


        return new Move(new Cell(row, col), this);
    }
}
