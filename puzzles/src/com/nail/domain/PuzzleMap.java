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
public class PuzzleMap {

    private final int boardSize = 4;

    public int getBoardSize() {
        return boardSize;
    }
    private Puzzle[][] board;
    
    @Override
    public int hashCode() {
        return board.hashCode();
    }

    @Override
    public boolean equals(Object o) {
        if (o == null) {
            return false;
        }
        if (!(o instanceof PuzzleMap)) {
            return false;
        }
        PuzzleMap mapo = (PuzzleMap) o;
        for(int i = 0; i < boardSize; i++)
            for(int j = 0; j < boardSize; j++){
                if(this.board[i][j].getNumber() != mapo.getBoard()[i][j].getNumber())
                    return false;
            }
        return true;
    }

    public PuzzleMap() {
        board = new Puzzle[boardSize][boardSize];
        for (int i = 0; i < boardSize; i++) {
            for (int j = 0; j < boardSize; j++) {
                board[i][j] = new Puzzle();
                board[i][j].setNumber(j + i*boardSize + 1);
            }
        }
        board[boardSize - 1][boardSize - 1].setNumber(0);
    }

    public PuzzleMap(Puzzle[][] board) {
        this.board = board;
    }

    public Puzzle[][] getBoard() {
        return board;
    }

    public void setBoard(Puzzle[][] board) {
        this.board = board;
    }

    public boolean isRightOrder() {
        for (int i = 0; i < boardSize; i++) {
            for (int j = 0; j < boardSize; j++) {
                if (board[i][j].getNumber() == (1 + j + i*boardSize)) {
                    continue;
                } else {
                    if ((1 + i*boardSize + j) == boardSize * boardSize && board[i][j].getNumber() == 0) {
                        return true;
                    }
                    return false;
                }
            }
        }
        return true;
    }

    public void randomMove() {
        CoordsPair zeroCoords = getZeroCoords();
        int randMoveDirection = (new Random()).nextInt(4); //[0..3]
        MoveDirection md = MoveDirection.values()[randMoveDirection];
        while (!zeroPuzzleMove(md)) {
            randMoveDirection = (new Random()).nextInt(4);//[0..3]
            md = MoveDirection.values()[randMoveDirection];
        }
    }

    //TODO : board на самом деле не меняется!
    public boolean zeroPuzzleMove(MoveDirection md) {
        CoordsPair zc = getZeroCoords();
        int iPos = zc.getI();
        int jPos = zc.getJ();
        switch (md) {
            case LEFT: {
                if (jPos - 1 > 0) {
                    board[iPos][jPos].setNumber(board[iPos][jPos - 1].getNumber());
                    board[iPos][jPos - 1].setNumber(0);
                }
                return true;
            }
            case UP: {
                if (iPos - 1 > 0) {
                    board[iPos][jPos].setNumber(board[iPos - 1][jPos].getNumber());
                    board[iPos - 1][jPos].setNumber(0);
                }
                return true;
            }
            case RIGHT: {
                if (jPos + 1 < boardSize) {
                    board[iPos][jPos].setNumber(board[iPos][jPos + 1].getNumber());
                    board[iPos][jPos + 1].setNumber(0);
                }
                return true;
            }
            case DOWN: {
                if (iPos + 1 < boardSize) {
                    board[iPos][jPos].setNumber(board[iPos + 1][jPos].getNumber());
                    board[iPos + 1][jPos].setNumber(0);
                }
                return true;
            }
            default:
                return false;
        }
    }

    public void generateInitialState() {
        int randMoveCount = (new Random()).nextInt(50) + 1;
        for (int i = 0; i < randMoveCount; i++) {
            randomMove();
        }
    }

    public CoordsPair getZeroCoords() {
        for (int i = 0; i < boardSize; i++) {
            for (int j = 0; j < boardSize; j++) {
                if (board[i][j].getNumber() == 0) {
                    return new CoordsPair(i, j);
                }
            }
        }
        return null;
    }
}
