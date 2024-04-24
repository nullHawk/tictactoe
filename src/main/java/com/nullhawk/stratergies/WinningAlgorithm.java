package com.nullhawk.stratergies;

import java.util.HashMap;

import com.nullhawk.models.Move;
import com.nullhawk.models.Board;

public class WinningAlgorithm {

    // row number -> hashmap for that row
    HashMap<Integer, HashMap<Character, Integer>> rowMaps = new HashMap<>();
    HashMap<Integer, HashMap<Character, Integer>> colMaps = new HashMap<>();
    HashMap<Character,Integer> leftDiagonalMap = new HashMap<>();
    HashMap<Character,Integer> rightDiagonalMap = new HashMap<>();

    public boolean checkWinner(Board board, Move move){
        int row = move.getCell().getRow();
        int col = move.getCell().getRow();
        Character character = move.getPlayer().getSymbol().getSymbol();

        //Row
        if(!rowMaps.containsKey(row)){
            rowMaps.put(row, new HashMap<>());
        }

        HashMap<Character, Integer> currentRowMap = rowMaps.get(row);

        if(!rowMaps.containsKey(currentRowMap)){
            currentRowMap.put(character, 1);
        }else{
            currentRowMap.put(character, currentRowMap.get(character) + 1);
        }

        if(currentRowMap.get(character) == board.getSize()){
            return true;
        }


        //column
        if(!colMaps.containsKey(row)){
            colMaps.put(row, new HashMap<>());
        }

        HashMap<Character, Integer> currentColMap = rowMaps.get(col);

        if(!colMaps.containsKey(currentColMap)){
            currentColMap.put(character, 1);
        }else{
            currentColMap.put(character, currentColMap.get(character) + 1);
        }

        if(currentColMap.get(character) == board.getSize()){
            return true;
        }

        //left diagonal
        if(row == col){
            if(leftDiagonalMap.containsKey(character)){
                leftDiagonalMap.put(character, 1);
            }else{
                leftDiagonalMap.put(character, leftDiagonalMap.get(character) + 1);
            }

            if(leftDiagonalMap.get(character) == board.getSize()){
                return true;
            }
        }

        //right diagonal
        if(row + col == board.getSize() - 1){
            if(rightDiagonalMap.containsKey(character)){
                rightDiagonalMap.put(character, 1);
            }else{
                rightDiagonalMap.put(character, rightDiagonalMap.get(character) + 1);
            }

            if(rightDiagonalMap.get(character) == board.getSize()){
                return true;
            }
        }
        return false;
    }
}
