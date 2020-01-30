import java.util.Scanner;

public class PlacingParentheses {
    private static long getMaximValue(String exp) {
      //write your code here
    	int n = exp.length()/2;
    	long[] digits = new long[n+1];
    	char[] symbols = new char[n];
    	int j=0;
    	for( j=0;j<n+1;j++){
    		digits[j]= Character.getNumericValue(exp.charAt(2*j));
    		if(2*j+1<=2*n){
    			symbols[j]= exp.charAt(2*j+1);
    		}
    	}
    	long [][]m = new long[n+1][n+1];
    	long [][]M = new long[n+1][n+1];
    	for(int i=0;i<n+1;i++){
    		m[i][i] = digits[i];
    		M[i][i] = digits[i];
    	}
    	for(int s=1; s<=n; s++){
    		for(int i=0;i<=n-s;i++){
    			j= i+s;
    			long a[] = new long[2];
    			a = minAndMax(i,j,digits,symbols,m,M,a);
    			m[i][j]=a[0];
    		    M[i][j]=a[1];
    		}
    	}
      return M[0][n];
    }
    
    private static long[] minAndMax(int i,int j,long[] digits,char[] symbols,long[][] m, long[][] M,long[] arr){
    	long min=+2147483647;
    	long max=-2147483647;
    	long a,b,c,d=0;
    	//long arr[] = new long[2];
    	for(int k=i;k<=j-1;k++){
    		a = eval(M[i][k],M[k+1][j],symbols[k]);
    		b = eval(M[i][k],m[k+1][j],symbols[k]);
    		c = eval(m[i][k],M[k+1][j],symbols[k]);
    		d = eval(m[i][k],m[k+1][j],symbols[k]);
    		min = Math.min(min,Math.min(a,Math.min(b, Math.min(c, d))));
    		max = Math.max(max,Math.max(a,Math.max(b, Math.max(c, d))));
    		arr[0]=min;
    		arr[1]=max;
    	}
    	return arr;
    }

    private static long eval(long a, long b, char op) {
        if (op == '+') {
            return a + b;
        } else if (op == '-') {
            return a - b;
        } else if (op == '*') {
            return a * b;
        } else {
            assert false;
            return 0;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String exp = scanner.next();
        System.out.println(getMaximValue(exp));
    }
}

