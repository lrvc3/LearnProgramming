package Topics.DynamicProgramming.DpOnTrees;

class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(){
        val = 0;
        left = null;
        right = null;
    }

    TreeNode(int z){
        val = z;
        left = null;
        right = null;
    }

    TreeNode(int x, TreeNode l, TreeNode r){
        val = x;
        left = l;
        right = r;
    }
}

public class DiameterOfBinaryTree {

    public static int solve(TreeNode root, int res ){

        if( root == null){
            return 0;
        }

        int left = solve(root.left, res);
        int right = solve(root.right, res);
        int tempAns = 1 + Math.max(left, right);
        int ans = Math.max(tempAns, 1 + left + right);
        res = Math.max(res, ans);
        return tempAns;
    }

    public static void main(String[] args) {
        
    }
}
