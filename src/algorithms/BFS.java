package algorithms;


import java.util.ArrayList;
import java.util.HashMap;
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
    }

    // a cycle exists if the neighbor has been visited already, and it's not the parent
    void shortestDis(int start, int target) {
        ArrayList<Integer> queue = new ArrayList<>();
        ArrayList<Integer> visited = new ArrayList<>();
        HashMap<Integer, Integer> parents = new HashMap<>();

        queue.add(start);

        int distance = 0;
        while (!queue.isEmpty()) {
            int node = queue.removeFirst();
            distance += 1;
            for (int i = 0; i < myGraph.get(node).size(); i++) {
                int temp = (int) myGraph.get(node).get(i);
                parents.put(temp, node);

                if (visited.contains(temp) && parents.get(temp) != temp){
                    System.out.println("cycle!");
                } else if (temp == target) {
                    System.out.println(distance + " for target " + target);
                    return;
                }
                else {
                    queue.add(temp);
                    visited.add(temp);
                }

            }
        }
        System.out.println("-1 for target " + target);

    }
}

public class BFS {
    public static void main(String[] args) {
       Graph myGraph = new Graph();
       myGraph.addEdge(1,3);
       myGraph.addEdge(1,2);
       myGraph.addEdge(2,3);
       myGraph.addEdge(3,4);
       myGraph.addEdge(4,5);
       myGraph.addVertex(4);
       for (Integer i : myGraph.entrySet()){
           if (i == 1) {
               continue;
           }
           myGraph.shortestDis(1, i);
       }

    }
}
