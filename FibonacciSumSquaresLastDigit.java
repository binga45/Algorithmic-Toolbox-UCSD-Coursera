import java.math.BigInteger;
import java.util.*;

public class FibonacciSumSquaresLastDigit {
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
    private static long getFibonacciHugeNaive(long n, long m) {
        if (n <= 1)
            return n;

        long period = computePisanoPeriod(m);
        
        long remainder = n%period;
        
        long F0=0, F1=1;
        
        long current=remainder;
        
        for(int i=0; i< remainder-1; i++){
        	current = (F0+F1)%m;
        	F0 = F1;
        	F1 = current;
        }
        
        return current;
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
        Scanner scanner = new Scanner(System.in);
        long n = scanner.nextLong();
        long c = getFibonacciHugeNaive(n,10);
        long d = getFibonacciHugeNaive(n+1,10);
        System.out.println((c*d)%10);
    }
}


