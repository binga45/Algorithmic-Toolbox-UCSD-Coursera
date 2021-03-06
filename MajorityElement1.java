import java.util.*;
import java.io.*;

public class MajorityElement1 {
    private static int getMajorityElement(int[] a, int left, int right) {
    	int counter = 0;
        if (left == right) {
            return a[left];
        }
        else{
        	int mid = left + (right-left)/2;
        	int majorityLeft = getMajorityElement(a, left, mid);
        	int majorityRight = getMajorityElement(a, mid+1, right);
        	
        	if(majorityLeft != -1 && majorityLeft == majorityRight){
        		counter=0;
        		for(int i =left; i <= right; i++){
        			if(a[i] == majorityRight)
        				counter++;
        		}
        		if(counter > (left-right+1)/2)
        			return majorityRight;
        		else
        			return -1;
        	}
        		
        	else if(majorityLeft != -1 && majorityRight != -1){
        		for(int i =left; i <= right; i++){
        			if(a[i] == majorityLeft)
        				counter++;
        		}
        		if(counter > (left-right+1)/2)
        			return majorityLeft;
        		else{
        			counter=0;
        			for(int i =left; i <= right; i++){
            			if(a[i] == majorityRight)
            				counter++;
            		}
            		if(counter > (left-right+1)/2)
            			return majorityRight;
        		}
        			return -1;
        	}
        	else if(majorityLeft != -1){
        		for(int i =left; i <= right; i++){
        			if(a[i] == majorityLeft)
        				counter++;
        		}
        		if(counter > (left-right+1)/2)
        			return majorityLeft;
        		else
        			return -1;
        	}
        	else if(majorityRight != -1 ){
        	
        		for(int i =left; i <= right; i++){
        			if(a[i] == majorityRight)
        				counter++;
        		}
        		if(counter > (left-right+1)/2)
        			return majorityRight;
        		else
        			return -1;
        		
        	}
        	
        }
        //write your code here
        return -1;
    }

    public static void main(String[] args) {
        FastScanner scanner = new FastScanner(System.in);
        int n = scanner.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        if (getMajorityElement(a, 0, a.length-1) != -1) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }
    }
    static class FastScanner {
        BufferedReader br;
        StringTokenizer st;

        FastScanner(InputStream stream) {
            try {
                br = new BufferedReader(new InputStreamReader(stream));
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

