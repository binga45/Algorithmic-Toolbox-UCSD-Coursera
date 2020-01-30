import java.util.*;
import java.io.*;
import java.lang.Math.*;
import java.math.BigInteger;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;

public class Fibonacci {
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

  public static void main(String args[]) {
    FastScanner in = new FastScanner(System.in);
    int n = in.nextInt();

    System.out.println(calc_fib(n));
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
