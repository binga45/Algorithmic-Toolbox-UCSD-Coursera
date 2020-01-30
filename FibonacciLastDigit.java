import java.math.BigInteger;
import java.util.*;

public class FibonacciLastDigit {
    private static int getFibonacciLastDigitNaive(int n) {
        if (n <= 1)
            return n;

        int previous = 0;
        int current  = 1;

        for (int i = 0; i < n - 1; ++i) {
            int tmp_previous = previous;
            previous = current;
            current = (tmp_previous + current)%10;
        }

        return current;
        
        /*else{
		  	BigInteger[] series = new BigInteger[n+1];
		  	series[0]=BigInteger.ZERO;
		  	if(n>=1)
		  		series[1]=BigInteger.ONE;
		  	if(n>=2){
		  		//series[2] = BigInteger.ONE;
		  		for ( int i=2; i<=n; i++){
		  		//System.out.println(Integer.toString(i-1) + " " + series[i-1]+ " " + Integer.toString(i-2) +" " + series[i-2] );
		  			series[i]= series[i-1].add(series[i-2]);
		  		}
		  	}
		  	return series[n];
	  }*/
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int c = getFibonacciLastDigitNaive(n);
        System.out.println(c);
    }
}

