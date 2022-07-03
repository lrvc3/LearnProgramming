package OnlineJudges.Codeforces;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class APuzzles {
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
// 4 6
// 0   1  2  3 4  5 
// 10 12 10  7 5  22
/**
 * n = 4
 * m = 6
 * 
 * 5 7 10 10 12 22
 * 
 * 
 * @param n
 * @param m
 * @param nums
 * @return
 */

        public static int solve(int n, int m, int[] nums){
            Arrays.sort(nums);
            int miniDiff = Integer.MAX_VALUE;
            // m - n  is the number of possbile combinations
            // since we have already sorted the value, we can check the first and the last element in the range.
            for (int i = 0; i <= (m - n); i++) {
                miniDiff = Math.min(miniDiff,  nums[i + n - 1] - nums[i]);
            }
            return miniDiff;
        }

        public static void main(String[] args) {
            MyScanner sc = new MyScanner();
            out = new PrintWriter(new BufferedOutputStream(System.out));
            int noOfStudents = sc.nextInt();
            int noOfPuzzles = sc.nextInt();
            int[] puzzles = new int[noOfPuzzles];
            for (int j = 0; j < noOfPuzzles; j++) {
                puzzles[j] = sc.nextInt();                
            }
            int res = solve(noOfStudents, noOfPuzzles, puzzles);
            out.println(res);
            out.close();
        }
}
