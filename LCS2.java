import java.util.*;

public class LCS2 {
	
	

    public int lcs2(int[] a, int[] b) {
        //Write your code here
    	List<Integer> sequence1 = new ArrayList<Integer>();
      	List<Integer> sequence2 = new ArrayList<Integer>();
    	int [][] distanceArr = new int[a.length+1][b.length+1];
  	  for(int i = 0; i <= a.length; i++){
  		  distanceArr[i][0] = i;
  	  }
  	  for(int j = 0 ; j <= b.length; j++){
  		  distanceArr[0][j] = j;
  	  }
  	  for( int i = 1 ; i <= a.length; i++){
  		  for(int j=1 ; j <= b.length; j++){
  			  if(a[i-1] == b[j-1]){
  				  distanceArr[i][j] = Math.min(distanceArr[i-1][j-1], Math.min(distanceArr[i-1][j]+1, distanceArr[i][j-1]+1));
  			  }
  			  else
  				  distanceArr[i][j] = Math.min(distanceArr[i-1][j-1]+1, Math.min(distanceArr[i-1][j]+1, distanceArr[i][j-1]+1));   
  		  }
  	  }
  	
  	computeOptimalSequence(distanceArr, a,b,a.length,b.length,sequence1,sequence2);
  	int count = 0;
  	//System.out.println("sequence1: ");
  	for(int i=0; i < sequence1.size(); i++){
  		System.out.print(sequence1.get(i) + " ");
  	}
  	System.out.println("======");
  	for(int i=0; i<sequence2.size();i++)
  		System.out.print(sequence2.get(i) + " ");
  	
  	for(int i=0; i < sequence1.size(); i++){
  		if(sequence1.get(i) - sequence2.get(i) == 0)
  			count++;
  		//System.out.print(sequence1.get(i) + " ");
  	}
//  	System.out.println("sequence2: ");
//  	for(int i=0; i < sequence2.size(); i++){
//  		if(sequence1.get(i) - sequence2.get(i) == 0)
//  			count++;
//  		System.out.print(sequence2.get(i) + " ");
//  		 
//  	}
  	  
      //return distanceArr[s.length()][t.length()];
    return count;
    }
    

    private  void computeOptimalSequence(int[][] distanceArr, int[] a, int[] b,int a1 ,int b1,List<Integer> sequence1, List<Integer> sequence2) {
		// TODO Auto-generated method stub
    	if(a1==0 && b1==0){
//    		sequence1.add(a[a1]);
//		    sequence2.add(b[b1]);
    		return;
    	}
    	
    	else if(a1 > 0  && distanceArr[a1][b1]== distanceArr[a1-1][b1] + 1){
    		sequence1.add(a[a1-1]);
    		sequence2.add(-2147483647);
    		computeOptimalSequence(distanceArr,a,b,a1-1,b1,sequence1,sequence2);
    	}
    	else if(b1 > 0 && distanceArr[a1][b1]== distanceArr[a1][b1-1] + 1){
    		sequence1.add(-2147483646);
    		sequence2.add(b[b1-1]);
    		computeOptimalSequence(distanceArr,a,b,a1,b1-1,sequence1,sequence2);
    	}
    	else if (a1>0 && b1>0 &&(distanceArr[a1][b1]== distanceArr[a1-1][b1-1] + 1 || distanceArr[a1][b1]== distanceArr[a1-1][b1-1]) ){
     		sequence1.add(a[a1-1]);
     		sequence2.add(b[b1-1]);
     		computeOptimalSequence(distanceArr,a,b,a1-1,b1-1,sequence1,sequence2);
     	}
    	 //if(a1 >0 && b1 >0 
    			 //&& distanceArr[a1][b1]== distanceArr[a1-1][b1-1]+1)
    	
    	return;
	}


	public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }

        int m = scanner.nextInt();
        int[] b = new int[m];
        for (int i = 0; i < m; i++) {
            b[i] = scanner.nextInt();
        }
        LCS2 obj = new LCS2();

        System.out.println(obj.lcs2(a, b));
    }
}

