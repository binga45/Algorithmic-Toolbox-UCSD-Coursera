import java.util.*;

public class PrimitiveCalculator {
    private static List<Integer> optimal_sequence(int n) {
        List<Integer> sequence = new ArrayList<Integer>();
        int DPMemo[] = new int[n+1];
        int minops = 0;
        for(int i=2;i<=n;i++){
	        int min1 = DPMemo[i-1];
	        int min2 = 2147483647;
	        int min3 = 2147483647;
	        if(i %2 == 0){
	        	min2 = DPMemo[i/2];
	        }
	        if(i %3 == 0){
	        	min3 = DPMemo[i/3];
	        }
            DPMemo[i] = Math.min(min1, Math.min(min2, min3)) + 1;
        }
        construct_optimal_list(sequence,DPMemo,n);
       
        Collections.reverse(sequence);
        return sequence;
    }
    
    private static void construct_optimal_list(List<Integer> sequence, int[] DPMemo, int n) {
		// TODO Auto-generated method stub
    	
    	while(n >= 1){
	    	sequence.add(n);
	    	
	    	if(n %2 != 0 && n%3 !=0){
	    		n = n-1;
	    	}
	    	else if( n%2 ==0 && n%3 ==0){
	    		n = n/3;
	    	}
	    	else if(n%2 == 0){
	    		if(DPMemo[n/2] < DPMemo[n-1])
	    			n = n/2;
	    		else n = n-1;
	    	}
	    	else if(n%3 == 0){
	    		if(DPMemo[n/3] < DPMemo[n-1])
	    			n = n/3;
	    		else n = n-1;
	    	}
    	}
		
	}


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        List<Integer> sequence = optimal_sequence(n);
        System.out.println(sequence.size() - 1);
        for (Integer x : sequence) {
            System.out.print(x + " ");
        }
    }
}

