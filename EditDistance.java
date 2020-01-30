import java.util.*;

class EditDistance {
  public static int EditDistance(String s, String t) {
    //write your code here
	  int [][] distanceArr = new int[s.length()+1][t.length()+1];
	  for(int i = 0; i <= s.length(); i++){
		  distanceArr[i][0] = i;
	  }
	  for(int j = 0 ; j <= t.length(); j++){
		  distanceArr[0][j] = j;
	  }
	  for( int i = 1 ; i <= s.length(); i++){
		  for(int j=1 ; j <= t.length(); j++){
			  if(s.charAt(i-1) == t.charAt(j-1)){
				  distanceArr[i][j] = Math.min(distanceArr[i-1][j-1], Math.min(distanceArr[i-1][j]+1, distanceArr[i][j-1]+1));
			  }
			  else
				  distanceArr[i][j] = Math.min(distanceArr[i-1][j-1]+1, Math.min(distanceArr[i-1][j]+1, distanceArr[i][j-1]+1));   
		  }
	  }
	  
	  
    return distanceArr[s.length()][t.length()];
  }
  public static void main(String args[]) {
    Scanner scan = new Scanner(System.in);

    String s = scan.next();
    String t = scan.next();

    System.out.println(EditDistance(s, t));
  }

}
