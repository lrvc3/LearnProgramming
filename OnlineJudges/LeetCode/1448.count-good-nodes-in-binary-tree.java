import java.util.LinkedList;
import java.util.Queue;

import javax.swing.tree.TreeNode;

/*
 * @lc app=leetcode id=1448 lang=java
 *
 * [1448] Count Good Nodes in Binary Tree
 */

// @lc code=start
/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode() {} TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) { this.val = val; this.left
 * = left; this.right = right; } }
 */
class Solution {

    /**
     * 
     * Testcase: [9,null,3,6]
     * 
     * 
     * [2,null,4,10,8,null,null,4] ans = 4
     * 
     * @param root
     * @return
     */

    class Pair {
        TreeNode root;
        int val;

        Pair(TreeNode root, int val) {
            this.root = root;
            this.val = val;
        }
    }

    public int goodNodes(TreeNode root) {
        if (root == null)
            return 0;
        int count = 0;
        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(root, root.val));
        while (!q.isEmpty()) {
            Pair p = q.poll();
            TreeNode t = p.root;
            if (t.val >= p.val) {
                count++;
            }
            if (t.left != null) {
                q.offer(new Pair(t.left, Math.max(t.left.val, p.val)));
            }
            if (t.right != null) {
                q.offer(new Pair(t.right, Math.max(t.right.val, p.val)));
            }
        }
        return count;
    }
}
// @lc code=end
