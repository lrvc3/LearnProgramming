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
class Solution {
    
    public List<List<Integer>> levelOrder(TreeNode root) {
    	// Resultant List
        List<List<Integer>> res = new ArrayList<>();  

        if (root == null) return res;  


        Queue<TreeNode> queue = new LinkedList<>();  
        queue.add(root);  

        while (!queue.isEmpty()) {  

          List<Integer> level = new ArrayList<>();  
          // Queue will have all the levels orderwise nodes
          // So getting the size becomes necessary for level order traversal
          int cnt = queue.size();  
          for (int i = 0; i < cnt; i++) {  
            TreeNode node = queue.poll();  
            level.add(node.val);  
            if (node.left != null) {  
              queue.add(node.left);  
            }
            if (node.right != null) {  
              queue.add(node.right);  
            }  
          }  
          res.add(level);   
        }  
        return res;
    }
}


public class b_aBinaryLevelOrderTraversal {
	public static void main (String[] args) {

		try {
			System.setIn(new FileInputStream("input.txt"));
			System.setOut(new PrintStream(new FileOutputStream("output.txt")));
		} catch (Exception e) {
			System.err.println("Error");
		}
	    
	    //taking input using Scanner class
		Scanner sc=new Scanner(System.in);
		
		//taking total testcases
		int T=sc.nextInt();
		while(T-->0)
		{
		    
		}
		
	}
}

/*
	
Input: root = [3,9,20,null,null,15,7]
Output: [[3],[9,20],[15,7]]
*/