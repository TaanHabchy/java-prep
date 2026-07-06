import structures.TreeNode;

import java.util.ArrayList;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    private ArrayList<Integer> firstLeaves = new ArrayList<>();
    private ArrayList<Integer> secondLeaves = new ArrayList<>();

    public boolean leafSimilar(TreeNode root1, TreeNode root2) {

        helper(root1, firstLeaves);
        helper(root2, secondLeaves);

        // compare arrays
        if (firstLeaves.size() != secondLeaves.size()){
            return false;
        }

        for (int i = 0; i < firstLeaves.size(); i++){
            if (firstLeaves.get(i) != secondLeaves.get(i)){
                return false;
            }
        }
        return true;
    }

    private void helper(TreeNode root, ArrayList<Integer> arr){
        System.out.println(root.val);
        if (root == null){
            return;
        }

        helper(root.left, arr);

        // if left and right are null, it's a leaf, add to array
        if (root.left == null && root.right == null){
            arr.add(root.val);
            return;
        }

        helper(root.right, arr);
    }
}