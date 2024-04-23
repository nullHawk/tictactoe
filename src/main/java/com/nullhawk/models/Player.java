package com.nullhawk.models;

import com.nullhawk.enums.PlayerType;

public class Player {
    private String name;
    private Symbol symbol;
    private PlayerType playerType;

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
}
