/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nail.solver;

import com.nail.domain.AlgoNode;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author nail
 */
public class Solver {

    private List<AlgoNode> openList;
    private List<AlgoNode> closeList;
    
    public Solver(AlgoNode initNode) {
        openList = new LinkedList<>();
        closeList = new LinkedList<>();
        openList.add(initNode);
    }

    public List<AlgoNode> getOpenList() {
        return openList;
    }

    public void setOpenList(List<AlgoNode> openList) {
        this.openList = openList;
    }

    public List<AlgoNode> getCloseList() {
        return closeList;
    }

    public void setCloseList(List<AlgoNode> closeList) {
        this.closeList = closeList;
    }
    
    public void Solve(){
        
    }
    
    public List<AlgoNode> getNeighbourNodes(AlgoNode node){
        return null;
    }
}
