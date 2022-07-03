import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

/**
 * A_YoungPhys
 */
public class A_YoungPhys {
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
        int n = 0;
        MyScanner sc = new MyScanner();
        out = new PrintWriter(new BufferedOutputStream(System.out));
        n = sc.nextInt();
        int suma = 0;
        int sumB = 0;
        int sumC = 0;
        while (n-- > 0) {
            int a = 0, b = 0, c = 0;
            a = sc.nextInt();
            b = sc.nextInt();
            c = sc.nextInt();
            suma += a;
            sumB += b;
            sumC += c;
        }
        if (sumB == 0 && sumC == 0 && suma == 0) {
            out.println("YES");
        } else {
            out.println("NO");
        }
        out.close();
    }
}