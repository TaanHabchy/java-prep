import java.util.*;

class Solution {
    static int distanceFunc(int[] p1, int[] p2) {
        return (p1[0] * p1[0] + p1[1] * p1[1] - p2[0] * p2[0] - p2[1] * p2[1]);
    }

    static int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> queue = new PriorityQueue<int[]>((p2, p1) -> p1[0] * p1[0] + p1[1] * p1[1] - p2[0] * p2[0] - p2[1] * p2[1]);

        for (int[] point : points) {
            int dis = distanceFunc(point, new int[] {0,0});
            queue.add(point);
            if (queue.size() > k) {
                queue.poll();
            }
        }

        int[][] rv = new int[k][2];
        for (int i = 0; i < k; i++){
            rv[i] = queue.poll();
        }
        return rv;
}

    static void main() {
        int[][] returnArr = {{1,3}, {-2,2}};
        int[][] ans = Solution.kClosest(returnArr, 1);
        System.out.println(ans);
    }
}