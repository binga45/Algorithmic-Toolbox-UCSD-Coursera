import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;

public class GCD {
  private static int gcd_naive(int a, int b) {
    if(b==0)
    	return a;
    else{
    	return gcd_naive(b,a%b);
    }
  }

  public static void main(String args[]) {
    FastScanner scanner = new FastScanner(System.in);
    int a = scanner.nextInt();
    int b = scanner.nextInt();

    System.out.println(gcd_naive(a, b));
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
