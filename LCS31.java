import java.util.*;

public class LCS31 {

    private int lcs3(int[] a, int[] b, int[] c,int m,int n,int o) {
        //Write your code here
    	
    	int L[][][] = new int[m+1][n+1][o+1]; 
  	  
	    for (int i=0; i<=m; i++) 
	    { 
	      for (int j=0; j<=n; j++) 
	      { 
	    	  for(int k=0;k<=o; k++){
	        if (i == 0 || j == 0 || k==0 ) 
	            L[i][j][k] = 0; 
	        else if (a[i-1] == b[j-1] && b[j-1] == c[k-1] ) 
	            L[i][j][k] = L[i-1][j-1][k-1] + 1; 
	        else
	            L[i][j][k] = max(L[i-1][j][k], L[i][j-1][k],L[i][j][k-1]); 
	      }
	      } 
	    } 
	  return L[m][n][o];
        //return Math.min(Math.min(a.length, b.length), c.length);
    }
    
    int max(int a, int b,int c) 
	  { 
	    //return (a > b)? ((a > c)? a : ((b>c)?b:c)) : (b>c)?b :c ;
    	if(a>b){
    		if(a>c)
    			return a;
    		else return c;
    	}
    	else {
    		if(b>c)return b;
    		else return c;
    	}
	  } 

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int an = scanner.nextInt();
        int[] a = new int[an];
        for (int i = 0; i < an; i++) {
            a[i] = scanner.nextInt();
        }
        int bn = scanner.nextInt();
        int[] b = new int[bn];
        for (int i = 0; i < bn; i++) {
            b[i] = scanner.nextInt();
        }
        int cn = scanner.nextInt();
        int[] c = new int[cn];
        for (int i = 0; i < cn; i++) {
            c[i] = scanner.nextInt();
        }
        LCS31 obj = new LCS31();
        System.out.println(obj.lcs3(a, b, c,a.length,b.length,c.length));
    }
}

