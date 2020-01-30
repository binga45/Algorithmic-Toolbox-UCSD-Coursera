import java.math.BigInteger;
import java.util.*;

public class DotProduct {
    private static BigInteger maxDotProduct(int[] a, int[] b) {
        //write your code here
        BigInteger result = BigInteger.ZERO;
        Arrays.sort(a);
        Arrays.sort(b);
        for (int i = 0; i < a.length; i++) {
            result = result.add( BigInteger.valueOf(a[i]).multiply(BigInteger.valueOf(b[i])));
        }
        return result;
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

