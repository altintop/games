/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nail.domain;

import java.util.Random;

/**
 *
 * @author nail
 */

public class Map {

    private final int boardSize = 4;
    private Puzzle[][] board;
    
    public Map() {
        board = new Puzzle[boardSize][boardSize];
        for(int i = 0; i < boardSize; i++)
            for(int j = 0; j < boardSize; j++)
            {
                board[i][j].setNumber(j+i+1);
            }
        board[boardSize-1][boardSize-1].setNumber(0);
    }
    
    public Map(Puzzle[][] board){
        this.board = board;
    }

    public Puzzle[][] getBoard() {
        return board;
    }

    public void setBoard(Puzzle[][] board) {
        this.board = board;
    }
    
    public boolean isRightOrder(){
        for(int i = 0; i < boardSize; i++){
            for(int j = 0; j < boardSize; j++){
                if(board[i][j].getNumber() == (1+ j + i))
                    continue;
                else {
                    if((1 + i + j) == boardSize*boardSize && board[i][j].getNumber() == 0)
                        return true;
                    return false;
                }
            }
        }
        return true;
    }
    
    public void randomMove(){
        for(int i = 0; i < boardSize; i++)
            for(int j = 0; j < boardSize; j++)
            {
                if(board[i][j].getNumber() == 0){
                    int randMoveDirection = (new Random()).nextInt(4) + 1;
                    MoveDirection md = MoveDirection.values()[randMoveDirection];
                    while(!zeroPuzzleMove(md, i, j)){
                        randMoveDirection = (new Random()).nextInt(4) + 1;
                        md = MoveDirection.values()[randMoveDirection];
                    }
                }
            }
    }
    
    public boolean zeroPuzzleMove(MoveDirection md, int iPos, int jPos) {
        switch(md){
            case LEFT:
            {
                if(jPos - 1 > 0) {
                    board[iPos][jPos].setNumber(board[iPos][jPos - 1].getNumber());
                    board[iPos][jPos - 1].setNumber(0);
                }
                return true;
            }
            case UP:
            {
                if(iPos - 1 > 0) {
                    board[iPos][jPos].setNumber(board[iPos - 1][jPos].getNumber());
                    board[iPos - 1][jPos].setNumber(0);
                }
                return true;
            }
            case RIGHT:
            {
                if(jPos + 1 < boardSize) {
                    board[iPos][jPos].setNumber(board[iPos][jPos + 1].getNumber());
                    board[iPos][jPos + 1].setNumber(0);
                }
                return true;
            }
            case DOWN:
            {
                if(iPos + 1 < boardSize) {
                    board[iPos][jPos].setNumber(board[iPos + 1][jPos].getNumber());
                    board[iPos + 1][jPos].setNumber(0);
                }
                return true;
            }
            default:
                return false;
        }
    }
    
    public void generateInitialState(){
        int randMoveCount = (new Random()).nextInt(50) + 1;
        for(int i = 0; i < randMoveCount; i++){
            randomMove();
        }
    }
    
}
