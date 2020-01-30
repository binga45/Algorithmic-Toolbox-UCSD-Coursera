import java.util.*;

public class Inversions {

    private static long getNumberOfInversions(int[] a, int[] b, int left, int right) {
        long numberOfInversions = 0;
        if (right > left ) {
            
        
        int ave = left + (right-left) / 2;
        numberOfInversions = getNumberOfInversions(a, b, left, ave);
        numberOfInversions += getNumberOfInversions(a, b, ave+1, right);
        //write your code here
        numberOfInversions += merge(a,b,left,ave+1,right);
        
        }
        return numberOfInversions;
    }
    
    static int merge(int arr[], int temp[], int left, int mid, int right){
    	int i,j,k;
    	int invCount = 0;
    	i = left; // index of the left array
    	j = mid; // index of the right array
    	k = left; // index of the resultant array
    	while( (i<= mid-1) && (j <= right)){
    		if(arr[i] <= arr[j]){
    			temp[k++] = arr[i++];
    		}
    		else{
    			temp[k++] = arr[j++];
    			invCount = invCount + (mid - i);
    		}
    	}
    	while(i <= mid-1)
    		temp[k++]= arr[i++];
    	while(j <= right)
    		temp[k++] = arr[j++];
    	for(i=left;i<=right;i++){
    		arr[i] = temp[i];
    	}
    	
    	return invCount;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        int[] b = new int[n];
        System.out.println(getNumberOfInversions(a, b, 0, a.length-1));
    }
}

