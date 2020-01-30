import java.util.Scanner;

public class ChangeDP {
    private static int getChange(int m) {
        //write your code here
    	int numberOfCoins = 0;
    	int DPMemo[] = new int[m+1];
    	int coin[] = new int[]{1,3,4};
    	if(m==0)
    		return 0;
    	for (int i = 1; i<= m ; i++){
    		DPMemo[i] = 2147483647;
    		for( int j=0;j<=2;j++){
    			if(i >= coin[j] ){
    				numberOfCoins = 1 + DPMemo[i-coin[j]];
    				if(numberOfCoins < DPMemo[i]){
    					DPMemo[i] = numberOfCoins;
    				}
    			}
    		}
    	}
        return DPMemo[m];
    }
    
    

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        System.out.println(getChange(m));

    }
}

