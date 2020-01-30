import java.util.Scanner;

public class LCS3 {
	
	
	  int lcs( int[] X, int[] Y, int m, int n ) 
	  { 
	    int L[][] = new int[m+1][n+1]; 
	  
	    for (int i=0; i<=m; i++) 
	    { 
	      for (int j=0; j<=n; j++) 
	      { 
	        if (i == 0 || j == 0) 
	            L[i][j] = 0; 
	        else if (X[i-1] == Y[j-1]) 
	            L[i][j] = L[i-1][j-1] + 1; 
	        else
	            L[i][j] = max(L[i-1][j], L[i][j-1]); 
	      } 
	    } 
	  return L[m][n]; 
	  } 
	  
	  int max(int a, int b) 
	  { 
	    return (a > b)? a : b; 
	  } 
	  
	  public static void main(String[] args) {
	        Scanner scanner = new Scanner(System.in);
	        int n = scanner.nextInt();
	        int[] a = new int[n];
	        for (int i = 0; i < n; i++) {
	            a[i] = scanner.nextInt();
	        }

	        int m = scanner.nextInt();
	        int[] b = new int[m];
	        for (int i = 0; i < m; i++) {
	            b[i] = scanner.nextInt();
	        }
	        LCS3 obj = new LCS3();

	        System.out.println(obj.lcs(a, b,a.length,b.length));
	    }

}
