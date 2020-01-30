import java.math.BigInteger;
import java.util.*;

public class FibonacciHuge {
	
	
	// This is the method to obtain the pisano periof of Fn modulo m for any m
    private static long getPeriodFibonacciHugeNaive(long n, int m, BigInteger[] arr) {
        if (n <= 1)
            return n;

        BigInteger previous = BigInteger.valueOf(0);
        BigInteger current  =BigInteger.valueOf(1);
        arr[0] = BigInteger.valueOf(0);
        arr[1] = BigInteger.valueOf(1);
        

        for (int i = 2; i < arr.length; ++i) {
            BigInteger tmp_previous = previous;
            previous = current;
            current = tmp_previous.add( current);
            arr[(int)i] = current.mod(BigInteger.valueOf( m));
            //System.out.print(" " + arr[i]);
        }
        
        BigInteger former =BigInteger.valueOf(-1), prior = BigInteger.valueOf(-1);
        
        int period = 0;

        for(int i=2; i< arr.length; i++){
        	if(arr[i].equals(BigInteger.valueOf(1)) && former.equals(BigInteger.valueOf(0))){
        		period = i-1;
        		break;
        	}
        	former = arr[i];
        	
        }
        return period;
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long n = scanner.nextLong();
        int m = scanner.nextInt();
        BigInteger arr[] = new BigInteger[ (int)n+1];
        
        long period = getPeriodFibonacciHugeNaive(n, m, arr);
        if(period != 0){
	        long rem = n %period;
	        System.out.println(arr[(int)rem]);
        }
        else{
        	System.out.println(arr[(int)n] );
        }
        
    }
}

