/*
    Problem Link: https://leetcode.com/problems/find-bottom-left-tree-value/description/
    Topic: Graphs - level order traversal using bfs + height of the tree
    Solution Video Link:
    Time Complexity:
    Space Complexity:
	Difficulty: Medium

	// Todo add better approach:https://leetcode.com/problems/find-bottom-left-tree-value/discuss/98786/Verbose-Java-Solution-Binary-tree-level-order-traversal
	Better approach mentioned later:

*/

// My Submission:




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

	public int heightOfTree(TreeNode root) {

		if (root == null) {
			return 0;
		}

		int left = heightOfTree(root.left);
		int right = heightOfTree(root.right);

		return 1 + Math.max(left, right);
	}

	public int findBottomLeftValue(TreeNode root) {
		if (root == null) {
			return 0;
		}
		int height = heightOfTree(root);
		int ans = 0;
		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(root);
		int level = 1;
		while (!queue.isEmpty()) {
			// Queue will have all the levels orderwise nodes
			// So getting the size becomes necessary for level order traversal
			int cnt = queue.size();
			for (int i = 0; i < cnt; i++) {
				TreeNode node = queue.poll();
				if (height == level) {
					ans = node.val;
					break;
				}
				if (node.left != null) {
					queue.add(node.left);
				}
				if (node.right != null) {
					queue.add(node.right);
				}
			}
			level++;
		}
		return ans;
	}
}

import java.io.*;
import java.util.*;

public class b_eFindBottomLeftmostTreeValue {
	public static void main (String[] args) {

		try {
			System.setIn(new FileInputStream("input.txt"));
			System.setOut(new PrintStream(new FileOutputStream("output.txt")));
		} catch (Exception e) {
			System.err.println("Error");
		}

		//taking input using Scanner class
		Scanner sc = new Scanner(System.in);

		//taking total testcases
		int T = sc.nextInt();
		while (T-- > 0) {

		}

	}
}