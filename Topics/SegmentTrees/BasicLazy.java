package Topics.SegmentTrees;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

/**
 *
5
1 2 3 4 5
3
1 0 4
2 1 3 2
1 0 4

15
21
 */

public class BasicLazy {

    // -----------MyScanner class for faster input----------
    public static class MyScanner {
        BufferedReader br;
        StringTokenizer st;

        public MyScanner() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }

        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }

    }

    // -----------PrintWriter for faster output---------------------------------
    public static PrintWriter out;

    public static void main(String[] args) {
        MyScanner sc = new MyScanner();
        out = new PrintWriter(new BufferedOutputStream(System.out));
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        SegmentTree st = new SegmentTree(n);
        st.build(0, 0, n - 1, arr);

        int q;
        q = sc.nextInt();
        for (int i = 0; i < q; i++) {
            int type = sc.nextInt();
            if (type == 1) {
                int l = sc.nextInt();
                int r = sc.nextInt();
                out.println(st.query(0, 0, n - 1, l, r));
            } else {
                int l = sc.nextInt();
                int r = sc.nextInt();
                int val = sc.nextInt();
                st.update(0, 0, n - 1, l, r, val);
            }
        }
        out.close();
    }
}

class SegmentTree {
    private int[] seg;
    private int[] lazy;

    public SegmentTree(int n) {
        seg = new int[4 * n];
        lazy = new int[4 * n];
    }

    public void build(int ind, int low, int high, int[] arr) {
        if (low == high) {
            seg[ind] = arr[low];
            return;
        }
        int mid = (low + high) / 2;
        build(2 * ind + 1, low, mid, arr);
        build(2 * ind + 2, mid + 1, high, arr);
        seg[ind] = seg[2 * ind + 1] + seg[2 * ind + 2];
    }

    public void update(int ind, int low, int high, int l, int r, int val) {
        // update the previous pending updates
        // and propogate downwards
        if (lazy[ind] != 0) {
            seg[ind] += (high - low + 1) * lazy[ind];
            // propogate the lazy update downwards
            // for the remaining children

            // low and high will be equal if its a leaf node
            if (low != high) {
                // we store what value needs to be updated for each child
                lazy[2 * ind + 1] += lazy[ind];
                lazy[2 * ind + 2] += lazy[ind];
            }

            // once we are done with the update, mark it 0
            lazy[ind] = 0;
        }

        // no overlap
        // we do nothing and simply return
        // l r low high or low high l r
        if (r < low || high < l) {
            return;
        }

        // complete overlap
        // l low high r
        if (low >= l && high <= r) {
            // we update the node
            seg[ind] += (high - low + 1) * val;
            // we propogate the update downwards
            if (low != high) {
                lazy[2 * ind + 1] += val;
                lazy[2 * ind + 2] += val;
            }
            return;
        }

        // parital overlap
        int mid = (low + high) >> 1;
        update(2 * ind + 1, low, mid, l, r, val);
        update(2 * ind + 2, mid + 1, high, l, r, val);
        seg[ind] = seg[2 * ind + 1] + seg[2 * ind + 2];
    }

    public int query(int ind, int low, int high, int l, int r) {

        // update if there is any pending udpates
        if (lazy[ind] != 0) {
            seg[ind] += (high - low + 1) * lazy[ind];
            // propogate the lazy update downwards
            // for the remaining children

            // low and high will be equal if its a leaf node
            if (low != high) {
                // we store what value needs to be updated for each child
                lazy[2 * ind + 1] += lazy[ind];
                lazy[2 * ind + 2] += lazy[ind];
            }

            // once we are done with the update, mark it 0
            lazy[ind] = 0;
        }

        // no overlap
        // we do nothing and simply return 0
        // l r low high or low high l r
        if (low > r || high < l) {
            return 0;
        }

        // complete overlap
        if (low >= l && high <= r) {
            return seg[ind];
        }

        // partial
        int mid = (low + high)/2;
        int left = query(2 * ind + 1, low, mid, l, r);
        int right = query(2 * ind + 2, mid+1, high, l, r);
        return left + right;
    }

}


class SegmentTreeMin {
    private int[] seg;
    private int[] lazy;

    public SegmentTreeMin(int n) {
        seg = new int[4 * n];
        lazy = new int[4 * n];
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

    public void update(int ind, int low, int high, int l, int r, int val) {
        // update the previous pending updates
        // and propogate downwards
        if (lazy[ind] != 0) {
            seg[ind] += lazy[ind];
            // propogate the lazy update downwards
            // for the remaining children

            // low and high will be equal if its a leaf node
            if (low != high) {
                // we store what value needs to be updated for each child
                lazy[2 * ind + 1] += lazy[ind];
                lazy[2 * ind + 2] += lazy[ind];
            }

            // once we are done with the update, mark it 0
            lazy[ind] = 0;
        }

        // no overlap
        // we do nothing and simply return
        // l r low high or low high l r
        if (r < low || high < l) {
            return;
        }

        // complete overlap
        // l low high r
        if (low >= l && high <= r) {
            // we update the node
            seg[ind] += (high - low + 1) * val;
            // we propogate the update downwards
            if (low != high) {
                lazy[2 * ind + 1] += val;
                lazy[2 * ind + 2] += val;
            }
            return;
        }

        // parital overlap
        int mid = (low + high) >> 1;
        update(2 * ind + 1, low, mid, l, r, val);
        update(2 * ind + 2, mid + 1, high, l, r, val);
        seg[ind] = Math.min(seg[2 * ind + 1], seg[2 * ind + 2]);
    }

    public int query(int ind, int low, int high, int l, int r) {

        // update if there is any pending udpates
        if (lazy[ind] != 0) {
            seg[ind] += lazy[ind];
            // propogate the lazy update downwards
            // for the remaining children

            // low and high will be equal if its a leaf node
            if (low != high) {
                // we store what value needs to be updated for each child
                lazy[2 * ind + 1] += lazy[ind];
                lazy[2 * ind + 2] += lazy[ind];
            }

            // once we are done with the update, mark it 0
            lazy[ind] = 0;
        }

        // no overlap
        // we do nothing and simply return 0
        // l r low high or low high l r
        if (low > r || high < l) {
            return Integer.MAX_VALUE;
        }

        // complete overlap
        if (low >= l && high <= r) {
            return seg[ind];
        }

        // partial
        int mid = (low + high)/2;
        int left = query(2 * ind + 1, low, mid, l, r);
        int right = query(2 * ind + 2, mid+1, high, l, r);
        return Math.min(left, right);
    }
}
