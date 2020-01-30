import java.io.*;
import java.util.*;

public class QuickSort {
    private static Random random = new Random();

    private static int[] partition3(int[] a, int l, int r) {
      //write your code here
    	int x = a[l];
    	int j = l;
    	int e = l;
    	for(int i=l+1; i<=r; i++){
    		if(a[i]<x){
    			j++;
    			e++;
    			if(e != i){
	    			int t1 = a[j];
	    			a[j] = a[e];
	    			a[e] = t1;
    			}
    			int t = a[j];
    			a[j] = a[i];
    			a[i] = t;
    			
    			
    			
    		}
    		else if(a[i]==x){
    			e = e+1;
    			int t = a[e];
    			a[e] = a[i];
    			a[i] = t;	
    		}
    	}
    	int t = a[j];
    	a[j] = a[l];
    	a[l] = t;
      int m1 = j;
      int m2 = e;
      int[] m = {m1, m2};
      return m;
    }

    private static int partition2(int[] a, int l, int r) {
        int x = a[l];
        int j = l;
        for (int i = l + 1; i <= r; i++) {
            if (a[i] <= x) {
                j++;
                int t = a[i];
                a[i] = a[j];
                a[j] = t;
            }
        }
        int t = a[l];
        a[l] = a[j];
        a[j] = t;
        return j;
    }

    private static int[] randomizedQuickSort(int[] a, int l, int r) {
        if (l >= r) {
            return a;
        }
        int k = random.nextInt(r - l + 1) + l;
        int t = a[l];
        a[l] = a[k];
        a[k] = t;
        //use partition3
        //int m = partition2(a, l, r);
        int[] m= partition3(a,l,r);
        randomizedQuickSort(a, l, m[0] - 1);
        //randomizedQuickSort(a, m[0], m[1]);
        randomizedQuickSort(a, m[1] + 1, r);
        return a;
    }
    
    private static int[] randomizedQuickSortold(int[] a, int l, int r) {
        if (l >= r) {
            return a;
        }
        int k = random.nextInt(r - l + 1) + l;
        int t = a[l];
        a[l] = a[k];
        a[k] = t;
        //use partition3
        //int m = partition2(a, l, r);
        int m= partition2(a,l,r);
        randomizedQuickSort(a, l, m - 1);
        //randomizedQuickSort(a, m[0], m[1]);
        randomizedQuickSort(a, m + 1, r);
        return a;
    }

    public static void main(String[] args) {
        FastScanner scanner = new FastScanner(System.in);
        int n = scanner.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        randomizedQuickSort(a, 0, n - 1);
        for (int i = 0; i < n; i++) {
            System.out.print(a[i] + " ");
        }
//        int counter=0;
//        while(counter < 50){
//        	
//        	int testcount = random.nextInt(100);
//            int[] a = new int[testcount];
//            int [] b = new int[testcount];
//            int[] c =new int[testcount];
//            for(int i=0; i<testcount; i++){
//            	a[i] = random.nextInt(1000);
//            }
//            System.arraycopy(a, 0, b,0, a.length);
//            System.arraycopy(a, 0, c,0, a.length);
//            if(!Arrays.equals(randomizedQuickSortold(a, 0, testcount - 1), randomizedQuickSort(b, 0, testcount - 1))){
//            	System.out.println("original input is " + Arrays.toString(c));
//            	System.out.println("old output is " + Arrays.toString(a));
//            	System.out.println("new output is " + Arrays.toString(b));
//            	System.out.println("counter is "+counter );
//            	break;
//            }
//         counter++;   
//        	
//        }
        
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

