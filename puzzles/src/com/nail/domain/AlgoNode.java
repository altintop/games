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
    private int f;
    private Map map;
    
    public AlgoNode(Map map){
        this.map = map;
    }
    
    public AlgoNode(Map map, AlgoNode parentNode){
        this.map = map;
        this.parentNode = parentNode;
    }

    public Map getMap() {
        return map;
    }

    public void setMap(Map map) {
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

    public void setH(int h) {
        this.h = h;
    }

    public int getF() {
        return f;
    }

    public void setF(int f) {
        this.f = f;
    }
}
