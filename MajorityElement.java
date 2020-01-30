import java.util.*;
import java.io.*;

public class MajorityElement {
    private static int getMajorityElement(int[] a, int left, int right) {
        if (left == right) {
            return a[left];
        }
          /* if (left + 1 == right) {
            return a[left];
        } */
        //write your code here
        int count = 0,count1=0,count2=0;
        int mid = left + (right-left)/2;
        int majorityLeft = getMajorityElement(a,left,mid);
        int majorityRight = getMajorityElement(a,mid+1,right);
        if(majorityLeft == -1 && majorityRight == -1)
        	return -1;
        else if(majorityLeft == -1 && majorityRight != -1){
        	count = 0;
        	for(int i=left;i<=right;i++){
        		if(a[i] == majorityRight)
        			count++;
        	}
        	//count +=  (left-mid-1)/2 ;
        	if(count >= 1 + (int) Math.ceil((right-left)/2.0))
        	return majorityRight;
        	else return -1;
        }
        	
        else if(majorityLeft != -1 && majorityRight == -1){
        	count = 0;
    	for(int i=left;i<=right;i++){
    		if(a[i] == majorityLeft)
    			count++;
    	}
    	//count +=  (mid-right)/2 ;
    	if(count >= 1 + (int) Math.ceil((right-left)/2.0))
    	return majorityLeft;
    	else return -1;
    }
        else if(majorityLeft != -1 && majorityRight != -1){
        	count1 = 0; count2=0;
        	for(int i=left;i<=right;i++){
        		if(a[i] == majorityRight)
        			count1++;
        	}
        	//count1 +=  (left-mid-1)/2 ;
        	for(int i=left;i<=right;i++){
        		if(a[i] == majorityLeft)
        			count2++;
        	}
        	//count2 +=  (mid-right)/2 ;
        	if(count2 >= 1 + (int) Math.ceil((right-left)/2.0) )
        		return majorityLeft;
        	else if(count1 >= 1 + (int) Math.ceil((right-left)/2.0))
        		return majorityRight;
        	else return -1;
        }
        
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

