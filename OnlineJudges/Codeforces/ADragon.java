package OnlineJudges.Codeforces;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Map;
import java.util.TreeMap;
import java.util.StringTokenizer;

public class ADragon {
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
        int s = sc.nextInt();
        int n = sc.nextInt();
        boolean flag = true;
        Map<Integer, Integer> hm = new TreeMap<>();
        for (int i = 0; i < n; i++) {
            int dragonStrength = sc.nextInt();
            int bonus = sc.nextInt();
            hm.put(dragonStrength, bonus);
        }
        for (Map.Entry<Integer,Integer> entry : hm.entrySet()) {
            if(s <= entry.getKey()){
                out.println("NO");
                flag = false;
                break;
            }
            s += entry.getValue();
        }

        if (flag) {
            out.println("YES");
        }
        out.close();
        
    }
}
