import java.util.Scanner;

public class Equal_Coins{
    public static void main(String[] args) {
        int t;
        Scanner sc = new Scanner(System.in);
        t = sc.nextInt();

        while(t-- != 0){
            long x, y;
            x = sc.nextLong();
            y = sc.nextLong();
            
            long res = 1 * x + 2 * y;
            if(x == 0 && y%2 == 0){
                System.out.println("YES");
                continue;
            }else if(x == 0 && y%2!=0){
                System.out.println("NO");
                continue;
            } 
            if(res % 2 == 0){
                System.out.println("YES");
            }else{
                System.out.println("NO");
            }

        }
        sc.close();
    }
}