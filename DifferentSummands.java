import java.util.*;

public class DifferentSummands {
    private static List<Integer> optimalSummands(int n) {
        List<Integer> summands = new ArrayList<Integer>();
        //write your code here
        int sum = 0;
        for(int i=1; i<=n; i++){
        	if(sum + i < n){
        		sum = sum+i;
        		summands.add(i);
        	}
        	else if(sum+i == n){
        		summands.add(i);
        		break;
        	}  
        	else {
        		sum = sum-i+1;
        	    summands.remove(new Integer(i-1));
        	    summands.add(n-sum);
        	    break;
        	}
        	    
        }
        return summands;
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        List<Integer> summands = optimalSummands(n);
        System.out.println(summands.size());
        for (Integer summand : summands) {
            System.out.print(summand + " ");
        }
    }
}

