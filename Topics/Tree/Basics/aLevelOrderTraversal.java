import java.util.*;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class aLevelOrderTraversal {

    public static List<List<Integer>> levelOrderTraversal(TreeNode root){

        List<List<Integer>> levelOrder = new ArrayList<>();
        if(root == null) return levelOrder;

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while(!q.isEmpty()){
            int size = q.size();
            List<Integer> sublist = new ArrayList<>();
            
            for(int i = 0; i < size; i++){
                TreeNode node = q.poll();
                sublist.add(node.val);

                if(node.left != null) q.add(node.left);
                if(node.right != null) q.add(node.right);
            }
            
            levelOrder.add(sublist);

        }
        return levelOrder;
    }

    public static void main(String[] args) {
        
    }
}
