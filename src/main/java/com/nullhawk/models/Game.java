package com.nullhawk.models;

import com.nullhawk.enums.*;
import com.nullhawk.exceptions.InvalidMoveException;
import com.nullhawk.stratergies.WinningAlgorithm;

import java.util.List;
import java.util.ArrayList;

public class Game {
    private Board board;
    private List<Player> players;
    private int nextPlayerMoveIndex;
    private Player Winner;
    private List<Move> moves;
    private GameState gameState;
    private WinningAlgorithm winningAlgorithm;

    public Game(int dimmension, List<Player> players) {
        this.board = new Board(dimmension);
        this.players = players;
        this.moves = new ArrayList<>();
        this.nextPlayerMoveIndex = 0;
        this.Winner = null;
        this.gameState = GameState.IN_PROGRESS;
        this.winningAlgorithm = new WinningAlgorithm();
    }

    public Board getBoard() {
        return board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }

    public int getNextPlayerMoveIndex() {
        return nextPlayerMoveIndex;
    }

    public void setNextPlayerMoveIndex(int nextPlayerMoveIndex) {
        this.nextPlayerMoveIndex = nextPlayerMoveIndex;
    }

    public Player getWinner() {
        return Winner;
    }

    public void setWinner(Player winner) {
        Winner = winner;
    }

    public List<Move> getMoves() {
        return moves;
    }

    public void setMoves(List<Move> moves) {
        this.moves = moves;
    }

    public GameState getGameState() {
        return gameState;
    }

    public void setGameState(GameState gameState) {
        this.gameState = gameState;
    }

    public void printBoard(){
        this.board.printBoard();
    }

    private boolean validateMove(Move move){
        int row = move.getCell().getRow();
        int col = move.getCell().getColumn();

        if(row < 0 || row >= this.board.getSize() || col < 0 || col >= this.board.getSize()){
            return false;
        }

        return board.getCell(row, col).getState() == CellState.EMPTY;
    }

    public void makeMove(Game game) throws InvalidMoveException{
        Player currentPlayer = this.players.get(this.nextPlayerMoveIndex);

        // Move that currentPlayer wants to make
        Move move = currentPlayer.makeMove(board);

        // TODO: Game will validate the move before 
        if(!validateMove(move)){
            throw new InvalidMoveException("Invalid move made by " + currentPlayer.getName());
        }

        int row = move.getCell().getRow();
        int col = move.getCell().getColumn();
        Cell cellToChange = board.getBoard().get(row).get(col);
        cellToChange.setState(CellState.FILLED);
        cellToChange.setPlayer(currentPlayer);

        Move finalMove = new Move(cellToChange, currentPlayer);
        moves.add(finalMove);
        nextPlayerMoveIndex = (nextPlayerMoveIndex + 1) % players.size();

        //Check if the current move is winning move or not
        if(winningAlgorithm.checkWinner(board, finalMove)){
            this.Winner = currentPlayer;
            this.gameState = GameState.ENDED;
        }
    }


}
