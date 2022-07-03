package OnlineJudges.Codeforces;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class AIWannaBeTheGuy {
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
        int nLevels = sc.nextInt();
        int x = sc.nextInt();
        Set<Integer> t = new HashSet<>();
        for (int i = 0; i < x; i++) {
            int val = sc.nextInt();
            t.add(val);
        }
        int y = sc.nextInt();
        for (int i = 0; i < y; i++) {
            int val = sc.nextInt();
            t.add(val);
        }
        if( t.size() == nLevels){
            out.println("I become the guy.");
        }else{
            out.println("Oh, my keyboard!");
        }
        out.close();
        
    }
}
