/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nail.domain;

/**
 *
 * @author nail
 */
public class AlgoNode {

    private AlgoNode parentNode;
    private int g;
    private int h;
    private PuzzleMap map;

    @Override
    public int hashCode() {
        return map.hashCode();
    }

    @Override
    public boolean equals(Object o) {
        if (o == null) {
            return false;
        }
        if (!(o instanceof AlgoNode)) {
            return false;
        }
        AlgoNode ano = (AlgoNode) o;
        return this.map.equals(ano.map);
    }

    public AlgoNode(PuzzleMap map) {
        this.map = map;
        calcHCoeff();
    }

    public AlgoNode(PuzzleMap map, AlgoNode parentNode) {
        this.map = map;
        this.parentNode = parentNode;
    }

    public PuzzleMap getMap() {
        return map;
    }

    public void setMap(PuzzleMap map) {
        this.map = map;
    }

    public AlgoNode getParentNode() {
        return parentNode;
    }

    public void setParentNode(AlgoNode parentNode) {
        this.parentNode = parentNode;
    }

    public int getG() {
        return g;
    }

    public void setG(int g) {
        this.g = g;
    }

    public int getH() {
        return h;
    }

    public int getF() {
        return g + h;
    }
    
    public void calcHCoeff(){
        for(int i = 0; i < map.getBoardSize(); i++)
            for(int j = 0; j < map.getBoardSize(); j++){
                if(map.getBoard()[i][j].getNumber() != j + i*map.getBoardSize() + 1)
                    this.h += 1;
            }
    }
    
    public void print(){
        System.out.println("AlgoNode!");
        for(int i = 0; i < map.getBoardSize(); i++){
            for(int j = 0; j < map.getBoardSize(); j++){
                System.out.print(String.valueOf(map.getBoard()[i][j].getNumber()) + " ");
            }
            System.out.print("\n");
        }
    }
}
