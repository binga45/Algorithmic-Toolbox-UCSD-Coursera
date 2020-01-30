import java.util.*;


public class LCS22 {
	
	private static Random random = new Random();
    private static int lcs2(int[] a, int[] b) {
        //Write your code here
    	int [][] AlScore = new int[a.length+1][b.length+1];
    	
    	for(int i=0; i<=a.length; i++)
    		AlScore[i][0] = 0;
    	for(int j=0; j<=b.length; j++)
    		AlScore[0][j] = 0;
    	for(int i=1; i<=a.length; i++){
    		for(int j=1; j<=b.length; j++){
    			if(a[i-1] == b[j-1]){
    				AlScore[i][j] = Math.max(AlScore[i-1][j-1]+1, Math.max(AlScore[i][j-1], AlScore[i-1][j]));
    			}
    			else
    				AlScore[i][j] = Math.max(AlScore[i-1][j-1], Math.max(AlScore[i][j-1], AlScore[i-1][j]));
    		}
    	}
        return AlScore[a.length][b.length];
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
  
        System.out.println(lcs2(a, b));
        
        
/*        LCS2 obj = new LCS2();
        int counter=0;
        while(counter<=50){
        	int n=5,m=6;
        	int[] a = new int[n];
        	int[] b = new int[m];
        	for (int i = 0; i < n; i++) {
                a[i] = random.nextInt(100);
            }

            //int m = scanner.nextInt();
            //int[] b = new int[m];
            for (int i = 0; i < m; i++) {
                b[i] = random.nextInt(100);
            }
        	if(obj.lcs2(a,b) != lcs2(a,b)){
        		System.out.println("counter is " + counter);
        		System.out.println("a's are " + Arrays.toString(a));
	        	System.out.println("b's are " + Arrays.toString(b));
	        	System.out.println("oldscore is " + obj.lcs2(a,b));
	        	System.out.println("new score is " + lcs2(a,b));
	        	break;
        	}
        	counter++;
        }*/
    }
}

