package Topics.SegmentTrees;

class SegmentTree {
    private static int[] seg;

    public SegmentTree(int n) {
        seg = new int[4 * n];
    }

    public void build(int ind, int low, int high, int[] arr) {
        if (low == high) {
            seg[ind] = arr[low];
            return;
        }
        int mid = (low + high) / 2;
        build(2 * ind + 1, low, mid, arr);
        build(2 * ind + 2, mid + 1, high, arr);
        seg[ind] = Math.min(seg[2 * ind + 1], seg[2 * ind + 2]);
    }

    public int query(int ind, int low, int high, int l, int r) {
        // no overlap
        // low high l r or l r low high
        if (r < low || l > high) {
            return Integer.MAX_VALUE;
        }

        // complete overlap
        // l low high r
        if (low >= l && high <= r) {
            return seg[ind];
        }

        int mid = (low + high) / 2;
        int left = query(2 * ind + 1, low, mid, l, r);
        int right = query(2 * ind + 2, mid + 1, high, l, r);
        return Math.min(left, right);
    }

    // Point update
    public void update(int ind, int low, int high, int i, int val) {
        if (low == high) {
            seg[ind] = val;
            return;
        }

        int mid = (low + high) / 2;
        if (i <= mid) {
            update(2 * ind + 1, low, mid, i, val);
        } else {
            update(2 * ind + 2, mid + 1, high, i, val);
        }
        seg[ind] = Math.min(seg[2 * ind + 1], seg[2 * ind + 2]);
    }
}

public class Basic {

    public static void solve() {
        int[] arr = new int[] { 1, 4, 5, 7, 8, 9, 7, 2 };
        int n = arr.length;
        SegmentTree sg = new SegmentTree(n);
        sg.build(0, 0, n - 1, arr);
        // 0 1 2 3 4 5 6 7
        // 1, 4, 5, 7, 8, 9, 7, 2}
        // [0-3] => 1
        // [4-7] => 2
        // [4-6] => 7
        System.out.println(sg.query(0, 0, n - 1, 0, 3));
        System.out.println(sg.query(0, 0, n - 1, 4, 7));
        System.out.println(sg.query(0, 0, n - 1, 4, 6));

        // update ind:4 = 1
        sg.update(0, 0, n - 1, 4, 1);
        arr[4] = 1;
        // 0 1 2 3 4 5 6 7
        // 1, 4, 5, 7, 1, 9, 7, 2}
        // [4-7] => 1
        System.out.println(sg.query(0, 0, n - 1, 4, 7));

    }

    public static void main(String[] args) {
        solve();
    }
}
