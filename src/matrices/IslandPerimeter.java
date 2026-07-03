package matrices;

import java.util.*;

class IslandPerimeter {

    static int bfs(int[][]grid, int r, int c){

        int colLength = grid[0].length;
        int rowLength = grid.length;
        int rv = 0;

        Deque<int[]> q = new ArrayDeque<>();
        q.add(new int[] {r,c});
        Set<String> v = new HashSet<>();

        int[][] directions = {new int[] {-1,0}, new int[] {0,1}, new int[] {1,0}, new int[] {0,-1}};

        while (!q.isEmpty()){
            // check all the neighbors of rc, if nbr is 0 add 1 to p, else add nbr to q

            int[] curr = q.poll();
            int row = curr[0];
            int col = curr[1];
            v.add(row+ ","+col);

            if (row == 0){
                rv++;
            } if (row == rowLength-1){
                rv++;
            }
            if (col == 0){
                rv++;
            }
            if (col == colLength - 1){
                rv++;
            }


            for (int[] d : directions){
                int x = d[0] + row;
                int y = d[1] + col;
                if (x < rowLength && x >= 0 && y < colLength && y>=0) {
                    if (grid[x][y] == 0) {
                        rv++;
                    } else if (!v.contains(x+","+y)){
                        q.add(new int[] {x, y});
                        v.add(x + "," + y);

                    }
                }
            }
        }
        return rv;
    }
    static int islandPerimeter(int[][] grid) {
        int length = grid.length;
        int colLength = grid[0].length;
        for (int row = 0; row < length; row++){
            for (int col = 0; col < colLength; col++){
                if (grid[row][col] == 1){
                    return IslandPerimeter.bfs(grid, row, col);
                }
            }
        }
        return 0;
    }
    static void main() {
        int[][] returnArr = {{0},{1}};
        int x = IslandPerimeter.islandPerimeter(returnArr);
        System.out.println(x);
    }
}