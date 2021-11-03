import java.io.*;
import java.util.*;

// Print 1 to N

class AprintOnetoN {
	public static void main (String[] args) {

		try {
			System.setIn(new FileInputStream("input.txt"));
			System.setOut(new PrintStream(new FileOutputStream("output.txt")));
		} catch (Exception e) {
			System.err.println("Error");
		}
	    
	    //taking input using Scanner class
		Scanner sc=new Scanner(System.in);
		
		//taking total testcases
		int T=sc.nextInt();
		while(T-->0)
		{
		    //creating an object of class Print
		    Solution obj=new Solution();
		    int N;
		    
		    //input N
		    N=sc.nextInt();
		    
		    //calling printNos() methdo
		    //of class Print
		    obj.printNos(N);
		    System.out.println();
		    
		}
		
	}
}

class Solution
{
    
  public void printNos(int N)
    {
        if(N == 1){
            System.out.print(1 + " ");
            return;
        }
        
        printNos(N-1);
        System.out.print(N + " ");
    }
}

