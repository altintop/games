/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nail.solver;

import com.nail.domain.AlgoNode;
import com.nail.domain.PuzzleMap;
import com.nail.domain.MoveDirection;
import java.util.Collections;
import java.util.Comparator;
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

    public AlgoNode Solve() {
        //находим текущую вершину (с наименьшим значением F)
        AlgoNode currentNode = getSmallerFNodeFromOpenList();
        if (currentNode == null) {
            //открытый список кончился, а терминальную вершину не нашли
            return null;
        }
        if (currentNode.getH() == 0) {
            //нашли терминальную вершину
            return currentNode;
        }
        //удаляем тек. верш. из открытого списка
        openList.remove(currentNode);
        List<AlgoNode> neighbours = getNeighbourNodes(currentNode);//находим всех соседей у текущей вершины
        for (AlgoNode aNode : neighbours) {
            if (closeList.contains(aNode) || openList.contains(aNode)) { //если очередная соседняя вершина уже не находится в списках
                continue;
            } else {
                aNode.setParentNode(currentNode);
                aNode.setG(currentNode.getG() + 1);
                openList.add(aNode);
            }
        }
        return Solve();
    }

    private List<AlgoNode> getNeighbourNodes(AlgoNode node) {
        List<AlgoNode> lan = new LinkedList<>();
        for (int k = 0; k < 4; k++) {
            PuzzleMap neighbourMap = new PuzzleMap(node.getMap().getBoard());
            if (neighbourMap.zeroPuzzleMove(MoveDirection.values()[k])) {
                lan.add(new AlgoNode(neighbourMap));
            }
        }
        return lan;
    }

    private AlgoNode getSmallerFNodeFromOpenList() {
        Collections.sort(openList, new AlgoNodeComparable());
        if (openList.size() > 0) {
            return openList.get(0);
        } else {
            return null;
        }
    }
}

class AlgoNodeComparable implements Comparator<AlgoNode> {

    @Override
    public int compare(AlgoNode o1, AlgoNode o2) {
        return (o1.getF() > o2.getF() ? -1 : (o1.getF() == o2.getF() ? 0 : 1));
    }
}
