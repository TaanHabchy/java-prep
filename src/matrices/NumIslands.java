package matrices;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class NumIslands {
    static int numIslands(char[][] grid) {

        int numIslands = 0;
        ArrayDeque<int[]> queue = new ArrayDeque<>();
        // ArrayDeque<int[]> islandQueue = new ArrayDeque<>();
        Set<String> visited = new HashSet<>();
        int rowLength = grid.length;
        int colLength = grid[0].length;
        int[][] directions = {new int[] {-1, 0}, new int[] {0, 1}, new int[] {1, 0}, new int[] {0,-1}};

        queue.offer(new int[] {0,0});
        visited.add(0+","+0);
        boolean onIsland = false;

        while (!queue.isEmpty()) {

            int[] curr = queue.poll();
            int row = curr[0];
            int col = curr[1];

            if (grid[row][col] == '1' && !onIsland){
                onIsland = true;
//                numIslands++;
            } else if (grid[row][col] == '0'){
                onIsland = false;
            }

            boolean isAlone = true;
            for (int[] dir : directions){
                int nbrX = row + dir[0];
                int nbrY = col + dir[1];



                if (nbrX < 0 || nbrX >= rowLength || nbrY < 0 || nbrY >= colLength){
                    continue;
                }

                // if a 1 is surrounded by 0's, it's an island
                if (grid[nbrX][nbrY] == '1' && grid[row][col] == '1'){
                    System.out.println("is not alone");
                    isAlone = false;
                }

                if (visited.contains(nbrX+","+nbrY)){
                    continue;
                }

                if (grid[nbrX][nbrY] == '0'){
                    queue.addLast(new int[] {nbrX, nbrY});
                    visited.add(nbrX+","+nbrY);
                } else {
                    if (onIsland) {
                        queue.addFirst(new int[] {nbrX, nbrY});
                    } else {
                        queue.offer(new int[] {nbrX, nbrY});
                    }
                    visited.add(nbrX+","+nbrY);
                }
            }
            if (isAlone && grid[row][col] != '0') {
                numIslands++;
            }
        }
        return numIslands;
    }

    static void main() {
        char[][] grid = {
                {'1', '1', '1', '1', '0'},
                {'1', '1', '0', '1', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '0', '0', '0'}
        };
        System.out.println(NumIslands.numIslands(grid));
    }
}