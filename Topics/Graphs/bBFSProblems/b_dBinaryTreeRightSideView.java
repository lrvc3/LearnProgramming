/*
    Problem Link: https://leetcode.com/problems/binary-tree-right-side-view/
    Topic: Graphs - BFS
    Solution Video Link:
    Time Complexity:
    Space Complexity:
    Difficulty: Medium

Input: root = [1,2,3,null,5,null,4]
Output: [1,3,4]

Input: root = [1,null,3]
Output: [1,3]

Second solution is good as well.

*/

import java.io.*;
import java.util.*;


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

// My Solution:
class Solution {
	public List<Integer> rightSideView(TreeNode root) {
		List<Integer> res = new ArrayList<>();

		if (root == null) {
			return res;
		}

		Queue<TreeNode> q = new LinkedList<>();
		q.add(root);
		while (!q.isEmpty()) {
			int cnt = q.size();
			TreeNode lastNode = q.peek();
			for (int i = 0; i < cnt; i++) {
				lastNode = q.peek();
				TreeNode node = q.poll();
				if (node.left != null) {
					q.add(node.left);
				}
				if (node.right != null) {
					q.add(node.right);
				}
			}

			res.add(lastNode.val);
		}
		return res;
	}
}

/*
The core idea of this algorithm:

1.Each depth of the tree only select one node.
2. View depth is current size of result list.
(1) the traverse of the tree is NOT standard pre-order traverse. It checks the RIGHT node first and then the LEFT
(2) the line to check currDepth == result.size() makes sure the first element of that level will be added to the result list
(3) if reverse the visit order, that is first LEFT and then RIGHT, it will return the left view of the tree.
*/


// DFS Solution:
public class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        rightView(root, result, 0);
        return result;
    }
    
    public void rightView(TreeNode curr, List<Integer> result, int currDepth){
        if(curr == null){
            return;
        }
        if(currDepth == result.size()){
            result.add(curr.val);
        }
        
        // We first visit the right node. as that would be the first node
        // from the right in the right view in a level
        rightView(curr.right, result, currDepth + 1);
        rightView(curr.left, result, currDepth + 1);
        
    }
}

public class b_dBinaryTreeRightSideView {
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