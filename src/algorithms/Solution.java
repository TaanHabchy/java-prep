package algorithms;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;


class Graph {
    public HashMap<Integer, ArrayList> myGraph;

    Graph() {
        myGraph = new HashMap<>();
    }

    Set<Integer> entrySet(){
        return myGraph.keySet();
    }

    int length() {
        return myGraph.size();
    }

    // check to see if the vertex is here, if not then add
    void addVertex(Integer v){
        if (!myGraph.containsKey(v)){
            ArrayList<Integer> newArr = new ArrayList<>();
            myGraph.put(v, newArr);
        }
    }

    void addEdge(int v, int w){
        addVertex(v);
        addVertex(w);
        myGraph.get(v).add(w);
        myGraph.get(w).add(v);
    }

    void traverse(int startNode) {
        ArrayList<Integer> queue = new ArrayList<>();
        ArrayList<Integer> visited = new ArrayList<>();
        HashMap<Integer, Integer> distances = new HashMap<>();
        int distance = 0;

        queue.add(startNode);

        while (!queue.isEmpty()) {
            int node = queue.remove(0);
            visited.add(node);
            distance += 6;
            for (int i = 0; i < myGraph.get(node).size(); i++) {
                int temp = (int) myGraph.get(node).get(i);

                if (visited.contains(temp)){
                } else {
                    queue.add(temp);
                    visited.add(temp);
                }

            }
            System.out.println(node);
    }
    }

    void shortestDis(int start, int target) {
        ArrayList<Integer> queue = new ArrayList<>();
        ArrayList<Integer> visited = new ArrayList<>();

        queue.add(target);

        int distance = 0;
        while (!queue.isEmpty()) {
            int node = queue.remove(0);
            distance += 6;
            for (int i = 0; i < myGraph.get(node).size(); i++) {
                int temp = (int) myGraph.get(node).get(i);

                if (temp == start) {
                    System.out.println(distance + " for target " + target);
                    return;
                }
                if (visited.contains(temp)){
                } else {
                    queue.add(temp);
                    visited.add(temp);
                }

            }
        }
        System.out.println("-1 for target " + target);

    }
}

public class Solution {
    public static void main(String[] args) {
       Graph myGraph = new Graph();
       myGraph.addEdge(1,3);
       myGraph.addEdge(1,2);
       myGraph.addVertex(4);
       for (Integer i : myGraph.entrySet()){
           if (i == 1) {
               continue;
           }
           myGraph.shortestDis(1, i);
       }

    }
}
