/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nail.gui;

import com.nail.domain.AlgoNode;
import com.nail.domain.PuzzleMap;
import com.nail.solver.Solver;

/**
 *
 * @author nail
 */
public class GoGoClass {
    public static void main(String args[]) {
        PuzzleMap newMap = new PuzzleMap();
        newMap.generateInitialState();
        AlgoNode initNode = new AlgoNode(newMap);
        initNode.print();
        
        Solver solver = new Solver(initNode);
        AlgoNode termNode = solver.Solve();
        termNode.print();
    }
}
