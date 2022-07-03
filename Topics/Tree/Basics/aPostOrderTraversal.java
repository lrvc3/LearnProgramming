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

public class aPostOrderTraversal {

    public static void postOrderRecursive(TreeNode root) {
        if (root == null)
            return;

        postOrderRecursive(root.left);
        postOrderRecursive(root.right);
        System.out.print(root.val + " ");
    }

    public static List<Integer> postOrderIterative(TreeNode root) {

        List<Integer> post = new ArrayList<>();

        if (root == null)
            return post;

        Stack<TreeNode> st1 = new Stack<>();
        Stack<TreeNode> st2 = new Stack<>();

        st1.push(root);

        while (!st1.isEmpty()) {

            TreeNode node = st1.pop();
            st2.add(node);

            if (node.left != null)
                st1.push(node.left);
            if (node.right != null)
                st1.push(node.right);
        }

        while (!st2.isEmpty()) {
            post.add(st2.pop().val);
        }

        return post;
    }

    public static void main(String[] args) {

    }
}
