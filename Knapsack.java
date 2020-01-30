import java.util.*;

public class Knapsack {
    static int optimalWeight(int W, int[] w) {
        //write you code here
//        int result = 0;
//        for (int i = 0; i < w.length; i++) {
//          if (result + w[i] <= W) {
//            result += w[i];
//          }
//        }
        //return result;
    	int [][] Value = new int[w.length+1][W+1];
  	  for(int i = 0; i <= w.length; i++){
  		  Value[i][0] = 0;
  	  }
  	  for(int j = 0 ; j <= W; j++){
  		  Value[0][j] = 0;
  	  }
  	  for( int i = 1 ; i <= w.length; i++){
  		  for(int j=1 ; j <= W; j++){
  			  int value=0;
  			  Value[i][j] = Value[i-1][j];
  			if(w[i-1]<=j){
  				value=Value[i-1][j-w[i-1]]+w[i-1];
  				if(Value[i][j]<value)
  					Value[i][j]=value;
  			}
  		  }
  	  }
  	  
  	  
      return Value[w.length][W];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int W, n;
        W = scanner.nextInt();
        n = scanner.nextInt();
        int[] w = new int[n];
        for (int i = 0; i < n; i++) {
            w[i] = scanner.nextInt();
        }
        System.out.println(optimalWeight(W, w));
    }
}

