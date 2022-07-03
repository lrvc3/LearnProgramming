package Topics.SegmentTrees;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class SergaAndBrackets {

    class Node {
        int open;
        int close;
        int full;

        public Node() {
            open = 0;
            close = 0;
            full = 0;
        }

        public Node(int o, int c, int f) {
            open = o;
            close = c;
            full = f;
        }
    }

    class SegmentTree {
        Node[] seg;

        public SegmentTree(int n) {
            seg = new Node[4 * n];
        }

        private Node performMerge(Node left, Node right) {
            Node ans = new Node(0, 0, 0);

            ans.open = left.open + right.open - (Math.min(left.open, right.close));
            ans.close = left.close + right.close - (Math.min(left.open, right.close));
            ans.full = left.full + right.full + Math.min(left.open, right.close);
            return ans;
        }

        public void build(int ind, int low, int high, String s) {
            if (low == high) {
                seg[ind] = new Node(s.charAt(low) == '(' ? 1 : 0, s.charAt(low) == ')' ? 1 : 0, 0);
                return;
            }

            int mid = (low + high) / 2;
            build(2 * ind + 1, low, mid, s);
            build(2 * ind + 2, mid + 1, high, s);
            seg[ind] = performMerge(seg[2 * ind + 1], seg[2 * ind + 2]);
        }

        public Node query(int ind, int low, int high, int l, int r) {
            // l r low high || low high l r
            if (r < low || high < l) {
                return new Node();
            }

            // l low high r
            if (low >= l && high <= r) {
                return seg[ind];
            }
            int mid = (low + high) / 2;
            Node left = query(2 * ind + 1, low, mid, l, r);
            Node right = query(2 * ind + 2, mid + 1, high, l, r);
            return performMerge(left, right);
        }
    }

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
        String s = "";
        MyScanner sc = new MyScanner();
        out = new PrintWriter(new BufferedOutputStream(System.out));
        s = sc.nextLine();
        int n = s.length();
        int q;
        q = sc.nextInt();
        SergaAndBrackets sb = new SergaAndBrackets();
        SegmentTree tree = sb.new SegmentTree(n);
        tree.build(0, 0, n - 1, s);
        // 0 1 2 3 4 5 6 7 8 9 10 11
        // 1 2 3 4 5 6 7 8 9 10 11 12
        // ( ) ) ( ( ) ) ( ( ) ) (
        // ())(())(())(
        while (q-- > 0) {
            int l = 0, r = 0;
            l = sc.nextInt();
            r = sc.nextInt();
            l--;
            r--;
            Node res = tree.query(0, 0, n - 1, l, r);
            out.println(res.full * 2);
        }
        out.close();
    }
}
