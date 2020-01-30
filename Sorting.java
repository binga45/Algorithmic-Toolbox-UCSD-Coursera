import java.io.*;
import java.util.*;

public class Sorting {
    private static Random random = new Random();

    private static int[] partition3(int[] a, int l, int r) {
      //write your code here
      int temp=0;
      if(a[l] > a[r]){
    	  temp = a[l];
    	  a[l] = a[r];
    	  a[r] = temp;
      }
    	  
      int m1 = l+1;
      int m2 = r-1;
      
      int[] m = {l+1, r-1};
      for(int i=l+1; i<=m2; i++){
    	  if(a[i] < a[m1-1]){
    		  temp = a[m[0]];
    		  a[m[0]] = a[i];
    		  a[i] = temp;
    		  m[0] = m[0] +1;
    	  }
    	  else if(a[i] >= a[m2 + 1]){
    		  while(a[m[1]] > a[m2+1] && i < m[1])
    			  m[1] -=1;
    		  temp = a[i];
    		  a[i] = a[m[1]];
    		  a[m[1]] = temp;
    		  m[1] -=1;
    		  if(a[i] < a[m1-1]){
    			  temp = a[m[0]];
    			  a[m[0]] = a[i];
    			  a[i] = temp;
    			  m[0] +=1;
    		  }
    		  
    		  
    	  }
      }
      m[0] -=1;
      m[1] +=1;
      temp = a[m1-1];
      a[m1-1] = a[m[0]];
      a[m[0]] = temp;
      temp = a[m2+1];
      a[m2+1]= a[m[1]];
      a[m[1]] = temp;
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

    private static void randomizedQuickSort(int[] a, int l, int r) {
        if (l >= r) {
            return;
        }
        int k = random.nextInt(r - l + 1) + l;
        int t = a[l];
        a[l] = a[k];
        a[k] = t;
        //use partition3
        int []m = partition3(a, l, r);
        randomizedQuickSort(a, l, m[0] - 1);
        randomizedQuickSort(a, m[0] + 1, m[1]-1);
        randomizedQuickSort(a, m[1] + 1, r);
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

	