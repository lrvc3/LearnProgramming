import java.util.*;

class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int data){
        this.val = data;
        this.left = null;
        this.right = null;
    }
}

public class aInOrderTraversal {

    public static List<Integer> inorderIterative(TreeNode root){
        List<Integer> inorder = new ArrayList<>();
        if(root == null) return inorder;

        Stack<TreeNode> st = new Stack<TreeNode>();

        TreeNode current = root;

        while(current != null || !st.isEmpty()){
            
            while(current != null){
                st.push(current);
                current = current.left;
            }
            current = st.pop();
            inorder.add(current.val);
            current = current.right;
        }
        return inorder;
    }

    public static void inorderRecursive(TreeNode root){

        if(root == null) return;

        inorderRecursive(root.left);
        System.out.print(root.val + " ");
        inorderRecursive(root.right);
    }


    public static void main(String[] args){

    }
}
