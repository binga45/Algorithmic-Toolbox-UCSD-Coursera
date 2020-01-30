import java.util.*;
import java.lang.Math;

public class LargestNumber {
    private static String largestNumber(String[] a) {
        //write your code here
        String result = "";
        String maxdigit = null;
        int maxValue = -2147483648;
        List<String> digits = new ArrayList<String>(Arrays.asList(a));
        int counter = 0;
        while(true){
        	maxdigit = null;
        	maxValue = -2147483648;
        	if(counter == a.length)
        		break;
	        for (String digit : digits){
//	        	if(Integer.parseInt(String.valueOf(digit.charAt(0))) > maxValue){
//	        		maxdigit = digit;
//	        		//maxValue = (int) (Integer.parseInt(digit)/Math.pow(10, digit.length()-1));
//	        		maxValue = Integer.parseInt(String.valueOf(digit.charAt(0)));
//	        	}
//	        	else if(Integer.parseInt(String.valueOf(digit.charAt(0))) == maxValue) {
//	        	       if(maxdigit.length() >=2 && digit.length()>=2){
//	        	    	   if(Integer.parseInt(String.valueOf(digit.charAt(1))) >  Integer.parseInt(String.valueOf(maxdigit.charAt(1)))){
//	        	    			   maxdigit = digit;
//	        	    			   maxValue = Integer.parseInt(String.valueOf(digit.charAt(0)));
//	        	    	   }
//	        	       }
//	        	       else if(maxdigit.length() >=2){
//	        	    	   maxdigit = digit;   
//	        	    	   maxValue = Integer.parseInt(String.valueOf(digit.charAt(0)));
//	        	       }	   
//	        	}
	        	if(Integer.parseInt(String.valueOf(digit.charAt(0))) > maxValue){
	        		maxdigit = digit;
	        		maxValue = Integer.parseInt(String.valueOf(digit.charAt(0)));
	        	}
	        	else if(Integer.parseInt(String.valueOf(digit.charAt(0))) == maxValue) {
	        		Integer m1 = new Integer(maxdigit+digit);
	        		Integer m2 = new Integer(digit + maxdigit);
	        		if(m2 > m1){
	        			maxdigit = digit;
	        			maxValue = Integer.parseInt(String.valueOf(digit.charAt(0)));
	        		}
	        	}
	        	
	        	
	        }
	        result = result + maxdigit;
	        counter++;
	        digits.remove(maxdigit);
	        //System.out.print("digits length is" + digits.size());
        }
        return result;
    }
        	
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        String[] a = new String[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.next();
        }
        System.out.println(largestNumber(a));
    }
}

