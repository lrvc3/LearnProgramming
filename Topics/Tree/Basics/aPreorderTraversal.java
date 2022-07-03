import java.util.*;

class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode(int data){
        this.val = data;
        this.left = null;
        this.right = null;
    }
}
public class aPreorderTraversal {

    // recursive Version

    public static void printPreOrderRecursive(TreeNode root) {
        if (root == null)
            return;

        System.out.println(root.val);
        printPreOrderRecursive(root.left);
        printPreOrderRecursive(root.right);
    }

    public static List<Integer> preOrderIterative(TreeNode root){
        List<Integer> pre = new ArrayList<>();
        if(root == null) return pre;

        Stack<TreeNode> st = new Stack<>();
        st.push(root);

        while(!st.isEmpty()){
            TreeNode node = st.pop();
            pre.add(node.val);

            if(node.right!=null){
                st.push(node.right);
            }
            if(node.left !=null){
                st.push(node.left);
            }
        }
        return pre;
    }

    public static void main(String[] args) {

    }
}