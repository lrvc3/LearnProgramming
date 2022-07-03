package Topics.SegmentTrees;

/**
 * https://codeforces.com/contest/339/problem/D
 * 
 * Input:
 2 4
 1 6 3 5
 1 4
 3 4
 1 2
 1 2
 Output:
 1
 3
 3
 3
 */

import java.util.Scanner;
public class Xenia {

    public static void build(int ind, int low, int high, int[] arr, int[] seg, boolean isOr) {
        if (low == high) {
            seg[ind] = arr[low];
            return;
        }

        int mid = (low + high) / 2;
        build(2 * ind + 1, low, mid, arr, seg, !isOr);
        build(2 * ind + 2, mid + 1, high, arr, seg, !isOr);
        if (isOr) {
            seg[ind] = (seg[2 * ind + 1] | seg[2 * ind + 2]);
        } else {
            seg[ind] = (seg[2 * ind + 1] ^ seg[2 * ind + 2]);
        }
    }

    public static void update(int ind, int low, int high, int i, int val, int[] seg, boolean isOr) {
        if (low == high) {
            seg[ind] = val;
            return;
        }

        int mid = (low + high) / 2;
        if (i <= mid) {
            update(2 * ind + 1, low, mid, i, val, seg, !isOr);
        } else {
            update(2 * ind + 2, mid + 1, high, i, val, seg, !isOr);
        }
        if (isOr) {
            seg[ind] = (seg[2 * ind + 1] | seg[2 * ind + 2]);
        } else {
            seg[ind] = (seg[2 * ind + 1] ^ seg[2 * ind + 2]);
        }
    }

    public static void main(String[] args) {
        double n;
        int q;
        Scanner sc = new Scanner(System.in);
        n = sc.nextDouble();
        q = sc.nextInt();
        int el = (int) Math.pow(2, n);
        int n1 = (int) n;

        int[] arr = new int[el];
        for (int i = 0; i < el; i++) {
            arr[i] = sc.nextInt();
        }
        int[] seg = new int[4 * el];
        if (n1 % 2 == 0) {
            build(0, 0, el - 1, arr, seg, false);
        } else {
            build(0, 0, el - 1, arr, seg, true);
        }

        for (int i = 0; i < q; i++) {
            int ind, val;
            ind = sc.nextInt();
            val = sc.nextInt();
            ind--; // converting to 0 based index
            if (n1 % 2 == 0) {
                update(0, 0, el - 1, ind, val, seg, false);
                arr[ind] = val;
            } else {
                update(0, 0, el - 1, ind, val, seg, true);
                arr[ind] = val;
                
            }
            System.out.println(seg[0]);
        }
        sc.close();
    }
}



// reference Codes:
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;
 
public class CF339D {
    public static void main(String[] args) throws Exception {
        Reader s = new Reader();
        int n = s.nextInt();
        int[] arr = new int[(int)Math.pow(2,n)];
        int m = s.nextInt();
        for (int i = 0; i < Math.pow(2, n); i++) {
            arr[i] = s.nextInt();
        }
        SegmentTreeMinimumRangeQuery st = new SegmentTreeMinimumRangeQuery();
        int[] sT = st.createSegmentTree(arr);
        for (int i = 0; i < m; i++) {
            int p = s.nextInt();
            int b = s.nextInt();
            st.updateSegmentTree(arr,sT,p - 1,b);
            System.out.println(sT[0]);
        }
 
    }
 
    static class Reader
    {
        final private int BUFFER_SIZE = 1 << 16;
        private DataInputStream din;
        private byte[] buffer;
        private int bufferPointer, bytesRead;
 
        public Reader()
        {
            din = new DataInputStream(System.in);
            buffer = new byte[BUFFER_SIZE];
            bufferPointer = bytesRead = 0;
        }
 
        public Reader(String file_name) throws IOException
        {
            din = new DataInputStream(new FileInputStream(file_name));
            buffer = new byte[BUFFER_SIZE];
            bufferPointer = bytesRead = 0;
        }
 
        public String readLine() throws IOException
        {
            byte[] buf = new byte[64]; // line length
            int cnt = 0, c;
            while ((c = read()) != -1)
            {
                if (c == '\n')
                    break;
                buf[cnt++] = (byte) c;
            }
            return new String(buf, 0, cnt);
        }
 
        public int nextInt() throws IOException
        {
            int ret = 0;
            byte c = read();
            while (c <= ' ')
                c = read();
            boolean neg = (c == '-');
            if (neg)
                c = read();
            do
            {
                ret = ret * 10 + c - '0';
            }  while ((c = read()) >= '0' && c <= '9');
 
            if (neg)
                return -ret;
            return ret;
        }
 
        public long nextLong() throws IOException
        {
            long ret = 0;
            byte c = read();
            while (c <= ' ')
                c = read();
            boolean neg = (c == '-');
            if (neg)
                c = read();
            do {
                ret = ret * 10 + c - '0';
            }
            while ((c = read()) >= '0' && c <= '9');
            if (neg)
                return -ret;
            return ret;
        }
 
        public double nextDouble() throws IOException
        {
            double ret = 0, div = 1;
            byte c = read();
            while (c <= ' ')
                c = read();
            boolean neg = (c == '-');
            if (neg)
                c = read();
 
            do {
                ret = ret * 10 + c - '0';
            }
            while ((c = read()) >= '0' && c <= '9');
 
            if (c == '.')
            {
                while ((c = read()) >= '0' && c <= '9')
                {
                    ret += (c - '0') / (div *= 10);
                }
            }
 
            if (neg)
                return -ret;
            return ret;
        }
 
        private void fillBuffer() throws IOException
        {
            bytesRead = din.read(buffer, bufferPointer = 0, BUFFER_SIZE);
            if (bytesRead == -1)
                buffer[0] = -1;
        }
 
        private byte read() throws IOException
        {
            if (bufferPointer == bytesRead)
                fillBuffer();
            return buffer[bufferPointer++];
        }
 
        public void close() throws IOException
        {
            if (din == null)
                return;
            din.close();
        }
    }
}
 
// https://codeforces.com/contest/339/submission/39754285
// https://codeforces.com/contest/339/submission/15388505
class SegmentTreeMinimumRangeQuery {
 
    int h;
    static boolean OR = false;
    static boolean XOR = true;
 
    public int[] createSegmentTree(int input[]) {
//        NextPowerOf2 np2 = new NextPowerOf2();
        //if input len is pow of 2 then size of
        //segment tree is 2*len - 1, otherwise
        //size of segment tree is next (pow of 2 for len)*2 - 1.
//        int nextPowOfTwo = np2.nextPowerOf2(input.length);
        int height = (int)Math.ceil(Math.log(input.length)/Math.log(2));
        h = height;
        int segmentTree[] = new int[(int)(Math.pow(2, height+1)-1)];
 
        for (int i = 0; i < segmentTree.length; i++) {
            segmentTree[i] = Integer.MAX_VALUE;
        }
        if(height % 2 != 0) {
            constructMinSegmentTree(segmentTree, input, 0, input.length - 1, 0,OR);
        }else{
            constructMinSegmentTree(segmentTree, input, 0, input.length - 1, 0,XOR);
 
        }
        return segmentTree;
 
    }
 
    /**
     * Updates segment tree for certain index by given delta
     */
    public void updateSegmentTree(int input[], int segmentTree[], int index, int delta) {
        input[index] = delta;
        if(h % 2 == 0) {
            updateSegmentTree(segmentTree, index, delta, 0, input.length - 1, 0,XOR);
        }else{
            updateSegmentTree(segmentTree, index, delta, 0, input.length - 1, 0,OR);
        }
    }
 
    /**
     * Updates segment tree for given range by given delta
     */
    public void updateSegmentTreeRange(int input[], int segmentTree[], int startRange, int endRange, int delta) {
        for (int i = startRange; i <= endRange; i++) {
            input[i] += delta;
        }
        updateSegmentTreeRange(segmentTree, startRange, endRange, delta, 0, input.length - 1, 0);
    }
 
    /**
     * Queries given range for minimum value.
     */
    public int rangeMinimumQuery(int[] segmentTree, int qlow, int qhigh, int len) {
        return rangeMinimumQuery(segmentTree, 0, len - 1, qlow, qhigh, 0);
    }
 
    /**
     * Updates given range by given delta lazily
     */
    public void updateSegmentTreeRangeLazy(int input[], int segmentTree[], int lazy[], int startRange, int endRange, int delta) {
        updateSegmentTreeRangeLazy(segmentTree, lazy, startRange, endRange, delta, 0, input.length - 1, 0);
    }
 
    /**
     * Queries given range lazily
     */
    public int rangeMinimumQueryLazy(int segmentTree[], int lazy[], int qlow, int qhigh, int len) {
        return rangeMinimumQueryLazy(segmentTree, lazy, qlow, qhigh, 0, len - 1, 0);
    }
 
    private void constructMinSegmentTree(int segmentTree[], int input[], int low, int high, int pos,boolean bool) {
        if (low == high) {
            segmentTree[pos] = input[low];
            return;
        }
        int mid = (low + high) / 2;
        constructMinSegmentTree(segmentTree, input, low, mid, 2 * pos + 1,!bool);
        constructMinSegmentTree(segmentTree, input, mid + 1, high, 2 * pos + 2,!bool);
        if(bool == OR){
            segmentTree[pos] = segmentTree[2 * pos + 1] | segmentTree[2 * pos + 2];
        }else{
            segmentTree[pos] = segmentTree[2 * pos + 1] ^ segmentTree[2 * pos + 2];
        }
    }
 
    private void updateSegmentTree(int segmentTree[], int index, int delta, int low, int high, int pos, boolean bool) {
 
        //if index to be updated is less than low or higher than high just return.
        if (index < low || index > high) {
            return;
        }
 
        //if low and high become equal, then index will be also equal to them and update
        //that value in segment tree at pos
        if (low == high) {
            segmentTree[pos] = delta;
            return;
        }
        //otherwise keep going left and right to find index to be updated
        //and then update current tree position if min of left or right has
        //changed.
        int mid = (low + high) / 2;
        updateSegmentTree(segmentTree, index, delta, low, mid, 2 * pos + 1, !bool);
        updateSegmentTree(segmentTree, index, delta, mid + 1, high, 2 * pos + 2, !bool);
        if(bool == XOR){
            segmentTree[pos] = segmentTree[2 * pos + 1] ^ segmentTree[2 * pos + 2];
        }else{
            segmentTree[pos] = segmentTree[2 * pos + 1] | segmentTree[2 * pos + 2];
        }
    }
 
    private void updateSegmentTreeRange(int segmentTree[], int startRange, int endRange, int delta, int low, int high, int pos) {
        if (low > high || startRange > high || endRange < low) {
            return;
        }
 
        if (low == high) {
            segmentTree[pos] += delta;
            return;
        }
 
        int middle = (low + high) / 2;
        updateSegmentTreeRange(segmentTree, startRange, endRange, delta, low, middle, 2 * pos + 1);
        updateSegmentTreeRange(segmentTree, startRange, endRange, delta, middle + 1, high, 2 * pos + 2);
        segmentTree[pos] = Math.min(segmentTree[2 * pos + 1], segmentTree[2 * pos + 2]);
    }
 
    private int rangeMinimumQuery(int segmentTree[], int low, int high, int qlow, int qhigh, int pos) {
        if (qlow <= low && qhigh >= high) {
            return segmentTree[pos];
        }
        if (qlow > high || qhigh < low) {
            return Integer.MAX_VALUE;
        }
        int mid = (low + high) / 2;
        return Math.min(rangeMinimumQuery(segmentTree, low, mid, qlow, qhigh, 2 * pos + 1),
                rangeMinimumQuery(segmentTree, mid + 1, high, qlow, qhigh, 2 * pos + 2));
    }
 
    private void updateSegmentTreeRangeLazy(int segmentTree[],
                                            int lazy[], int startRange, int endRange,
                                            int delta, int low, int high, int pos) {
        if (low > high) {
            return;
        }
 
        //make sure all propagation is done at pos. If not update tree
        //at pos and mark its children for lazy propagation.
        if (lazy[pos] != 0) {
            segmentTree[pos] += lazy[pos];
            if (low != high) { //not a leaf node
                lazy[2 * pos + 1] += lazy[pos];
                lazy[2 * pos + 2] += lazy[pos];
            }
            lazy[pos] = 0;
        }
 
        //no overlap condition
        if (startRange > high || endRange < low) {
            return;
        }
 
        //total overlap condition
        if (startRange <= low && endRange >= high) {
            segmentTree[pos] += delta;
            if (low != high) {
                lazy[2 * pos + 1] += delta;
                lazy[2 * pos + 2] += delta;
            }
            return;
        }
 
        //otherwise partial overlap so look both left and right.
        int mid = (low + high) / 2;
        updateSegmentTreeRangeLazy(segmentTree, lazy, startRange, endRange,
                delta, low, mid, 2 * pos + 1);
        updateSegmentTreeRangeLazy(segmentTree, lazy, startRange, endRange,
                delta, mid + 1, high, 2 * pos + 2);
        segmentTree[pos] = Math.min(segmentTree[2 * pos + 1], segmentTree[2 * pos + 2]);
    }
 
    private int rangeMinimumQueryLazy(int segmentTree[], int lazy[], int qlow, int qhigh,
                                      int low, int high, int pos) {
 
        if (low > high) {
            return Integer.MAX_VALUE;
        }
 
        //make sure all propagation is done at pos. If not update tree
        //at pos and mark its children for lazy propagation.
        if (lazy[pos] != 0) {
            segmentTree[pos] += lazy[pos];
            if (low != high) { //not a leaf node
                lazy[2 * pos + 1] += lazy[pos];
                lazy[2 * pos + 2] += lazy[pos];
            }
            lazy[pos] = 0;
        }
 
        //no overlap
        if (qlow > high || qhigh < low) {
            return Integer.MAX_VALUE;
        }
 
        //total overlap
        if (qlow <= low && qhigh >= high) {
            return segmentTree[pos];
        }
 
        //partial overlap
        int mid = (low + high) / 2;
        return Math.min(rangeMinimumQueryLazy(segmentTree, lazy, qlow, qhigh,
                low, mid, 2 * pos + 1),
                rangeMinimumQueryLazy(segmentTree, lazy, qlow, qhigh,
                        mid + 1, high, 2 * pos + 2));
 
    }
}