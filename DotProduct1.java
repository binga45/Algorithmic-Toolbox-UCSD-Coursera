import java.util.Arrays;
import java.util.Scanner;

public class DotProduct1 {
    private static long maxDotProduct(int[] a, int[] b) {
        //write your code here
        long result = 0;
        int max_a,max_b=0;
        //Arrays.sort(a);
        //Arrays.sort(b);
        for (int i = 0; i < a.length; i++) {
        	max_a = getMaximumIndex(a);
        	max_b = getMaximumIndex(b);
            result += a[max_a] * b[max_b];
        }
        return result;
    }
    public static int getMaximumIndex(int[] a){
    	int index=0;
    	for(int i=0;i<a.length;i++){
    		if (a[index]<a[i])
    				index=i;
    	}
    	return index;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        int[] b = new int[n];
        for (int i = 0; i < n; i++) {
            b[i] = scanner.nextInt();
        }
        System.out.println(maxDotProduct(a, b));
    }
}

