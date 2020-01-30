import java.util.*;
import java.util.Scanner;
import java.util.*;
import java.io.*;
import java.lang.Math.*;
import java.math.BigInteger;

public class LCM {
  private static BigInteger lcm_naive(int a, int b) {
	  if(b==0 || a==0)
	    	return BigInteger.valueOf(0);
	    else{
	    	return (BigInteger.valueOf(a).multiply(BigInteger.valueOf(b))).divide(BigInteger.valueOf(gcd_naive(b,a%b)));
	    }
  }
  
  private static int gcd_naive(int a, int b) {
	    if(b==0)
	    	return a;
	    else{
	    	return gcd_naive(b,a%b);
	    }
	  }


  public static void main(String args[]) {
    Scanner scanner = new Scanner(System.in);
    int a = scanner.nextInt();
    int b = scanner.nextInt();

    System.out.println(lcm_naive(a, b));
  }
}
