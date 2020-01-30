import java.util.Scanner;

public class KnapSack1 {
    static int optimalWeight(int W, int[] w) {
        //write you code here
//        int result = 0;
//        for (int i = 0; i < w.length; i++) {
//          if (result + w[i] <= W) {
//            result += w[i];
//          }
//        }
        //return result;
    	int [] Value = new int[W+1];
  	  for(int i = 0; i <= W; i++){
  		  Value[i] = 0;
  		  for( int j= 1 ; j <= w.length; j++){
		  			int value=0;
		  			if(w[j-1]<=i){
		  				value=Value[i-w[j-1]]+w[j-1];
		  				if(Value[i]<value)
		  					Value[i]=value;
		  			}
		  			
		  		  }
		  	  }
  	  return Value[W];
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

