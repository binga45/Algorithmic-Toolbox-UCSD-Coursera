import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.*;


public class FibonacciSumSquares {
//    private static long getFibonacciSumSquaresNaive(long n) {
//        if (n <= 1)
//            return n;
//
//        long previous = 0;
//        long current  = 1;
//        long sum      = 1;
//
//        for (long i = 0; i < n - 1; ++i) {
//            long tmp_previous = previous;
//            previous = current;
//            current = tmp_previous + current;
//            sum += current * current;
//        }
//
//        return sum % 10;
//    }
    private static BigInteger calc_fib(int n) {
  	  if(n==0)return BigInteger.valueOf(0);
  	  else if(n==1) return BigInteger.valueOf(1);
  	  else{
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
  	  }

      
    }
    public static void main(String[] args) {
        FastScanner scanner = new FastScanner(System.in);
        int n = scanner.nextInt();
        BigInteger s = calc_fib(n).mod(BigInteger.valueOf(10));
        
        BigInteger s1 = calc_fib(n+1).mod(BigInteger.valueOf(10));
        
        System.out.println((s.multiply(s1)).mod(BigInteger.valueOf(10)));
    }
    static class FastScanner {
        BufferedReader br;
        StringTokenizer st;

        FastScanner(InputStream stream) {
            try {
                br = new BufferedReader(new
                    InputStreamReader(stream));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        String next() {
            while (st == null || !st.hasMoreTokens()) {
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
    }
}

