import java.math.BigInteger;
import java.util.*;

public class FibonacciHuge1 {
	
	
	// This is the method to obtain the pisano period of Fn modulo m for any m
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
        /*long previous = 0;
        long current  = 1;

        for (int i = 0; i < remainder - 1; ++i) {
            long tmp_previous = previous;
            previous = current;
            current = (tmp_previous%m) + (current)%m;
        }
        return current;
*/
        
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
        long m = scanner.nextLong();
        
        
        long output = getFibonacciHugeNaive(n, m);
        System.out.println(output);
        
        
    }
    
    
}

