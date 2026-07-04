import structures.TreeNode;

import java.util.*;
import java.util.stream.IntStream;

class Solution {

    static void helper(TreeNode root, int rv, boolean left){
        System.out.println("rv: " + rv);
        if (root == null){
            return;
        }
        if (left){
            rv += root.val;
        }

        helper(root.left, rv, true);
        helper(root.right, rv, false);
    }
    static int sumOfLeftLeaves(TreeNode root) {
        int rv = 0;
        helper(root, rv, false);
        return rv;
    }


    static void main() {
        int[] rarr = new int[] {1,2,3,4};

        TreeNode root = new TreeNode(
                3,
                new TreeNode(9),
                new TreeNode(
                        20,
                        new TreeNode(15),
                        new TreeNode(7)
                )
        );

        int ra = Solution.sumOfLeftLeaves(root);

    }
}