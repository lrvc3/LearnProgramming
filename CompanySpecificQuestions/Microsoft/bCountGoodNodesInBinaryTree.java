
/*
 * Problem Link: https://leetcode.com/problems/count-good-nodes-in-binary-tree/
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

// Pre-order Traversal

class Solution {
    int good;
    public int goodNodes(TreeNode root) {
        good = 0;
        cal(root, Integer.MIN_VALUE);
        return good;
    }
    void cal(TreeNode root, int max){
        if(root == null) return;
        if(root.val >= max) good++;
        max = Math.max(max, root.val);
        cal(root.left, max);
        cal(root.right, max);
    }
}