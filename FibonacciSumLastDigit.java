import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;

public class FibonacciSumLastDigit {
    private static long getFibonacciSumNaive(long n) {
        if (n <= 1)
            return n;

        long period = computePisanoPeriod(10);
        
        long remainder = n%period;
        long previous = 0;
        long current  = 1;
        long sum      = 1;

        for (long i = 0; i < remainder - 1; ++i) {
            long tmp_previous = previous;
            previous = current;
            current = tmp_previous + current;
            sum = (sum+current)%10;
        }
        
        if(remainder ==0 || remainder == 1)
        	return remainder%10;

        return sum % 10;
    }
    
private static long computePisanoPeriod(long m){
    	
    	long F0 = 0, F1 = 1, current=0;
    	long i = 0;
    	
    	/*do{
    		current = (F0+F1)%m;
    		F0 = F1;
    		F1 = current;
    		i++;
    		
    	}while(F0 != 0 && F1 !=1);
    	
    	return i-1;*/
    	
    	for(int j=0; j<m*m; j++){
    		current = (F0+F1)%m;
    		F0 = F1;
    		F1 = current;
    		
    		if(F0 == 0 && F1 ==1){
    			return j+1;
    		}
    		
    	}
    	return 0;
    	
    }
    
    public static void main(String[] args) {
        FastScanner scanner = new FastScanner(System.in);
        long n = scanner.nextLong();
        long s = getFibonacciSumNaive(n);
        System.out.println(s);
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
        long nextLong() {
            return Long.parseLong(next());
        }
    }
}