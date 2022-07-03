import java.util.Scanner;

public class CodeChef{
    public static void main(String[] args) {
        int t;
        Scanner sc = new Scanner(System.in);
        t = sc.nextInt();

        while(t-- != 0){
            int x, y, a, b, k;

            x = sc.nextInt();
            y = sc.nextInt();
            a = sc.nextInt();
            b = sc.nextInt();
            k = sc.nextInt();
            long petrol = x + a*k;
            long diesel = y + b*k; 
            

            if(petrol == diesel){
                System.out.println("SAME PRICE");
            }else if( petrol > diesel){
                System.out.println("DIESEL");
            }else{
                System.out.println("PETROL");
            }
        }
        sc.close();
    }
}