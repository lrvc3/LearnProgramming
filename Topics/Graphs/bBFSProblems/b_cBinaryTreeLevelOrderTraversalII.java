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
import java.io.*;
import java.util.*;

/*
  Link: https://leetcode.com/problems/binary-tree-level-order-traversal/
  Difficulty: Medium

  Input: root = [3,9,20,null,null,15,7]
  Output: [[15,7],[9,20],[3]]
*/


// Simple BFS
class Solution {

  public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root == null){
            return res;
        }

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while(!q.isEmpty()){
            int cnt = q.size();
            List<Integer> level = new ArrayList<>();
            for (int i = 0; i < cnt; i++) {
                TreeNode node = q.poll();
                if(node.left != null){
                    q.add(node.left);
                }

                if(node.right != null){
                    q.add(node.right);
                }
                level.add(node.val);

            }
            res.add(0, level);
        }
        
        return res;
    }

}





public class b_cBinaryTreeLevelOrderTraversalII {
  public static void main (String[] args) {

    try {
      System.setIn(new FileInputStream("input.txt"));
      System.setOut(new PrintStream(new FileOutputStream("output.txt")));
    } catch (Exception e) {
      System.err.println("Error");
    }

    //taking input using Scanner class
    Scanner sc = new Scanner(System.in);


  }
}