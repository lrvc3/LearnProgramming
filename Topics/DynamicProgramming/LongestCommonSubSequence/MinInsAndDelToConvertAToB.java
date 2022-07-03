package Topics.DynamicProgramming.LongestCommonSubSequence;

public class MinInsAndDelToConvertAToB {

    public static int lcs(String a, String b, int n, int m){
        int[][] t = new int[n+1][m+1];
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= m; j++) {
                if(i==0 || j == 0){
                    t[i][j] = 0;
                }else if(a.charAt(i-1) == b.charAt(j-1)){
                    t[i][j] = 1 + t[i-1][j-1];
                }else{
                    t[i][j] = Math.max(t[i-1][j], t[i][j-1]);
                }
            }
        }

        return t[n][m];
    }

    public static void main(String[] args) {
        String a = "heap";
        String b = "pea";
        int n = a.length();
        int m = b.length();

        int lcsAB = lcs(a, b, n, m);

        int noOfDeletion = n - lcsAB;
        int noOfInsertion= m - lcsAB;

        System.out.println("Insertion: "+noOfInsertion + " Deletion: "+ noOfDeletion);
    }
}
/**
 * String a = "heap";
 * String b = "pea";
 * 
 * Insertions: 1 Deletion: 2
 * 
 * 
 * 
 */