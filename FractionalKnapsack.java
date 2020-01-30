import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Scanner;

public class FractionalKnapsack {
    private static double getOptimalValue(int capacity, int[] values, int[] weights) {
        double value = 0;
        //write your code here
        FractionalKnapsack[] items = new FractionalKnapsack[values.length];
        for(int i=0;i<items.length;i++){
        	items[i]= new FractionalKnapsack(weights[i],values[i],i);
        }
        InsertionSort(items);
         for(int j=0;j<values.length;j++){
        	 if(items[j].weight <= capacity){
        		 value+= items[j].opt*items[j].weight;
        		 capacity=capacity-items[j].weight;
        	 }
        	 else{
        		 value+=capacity*items[j].opt;
        		 capacity=0;
        		 break;
        	 }
         }
         //DecimalFormat df = new DecimalFormat(#.####);
         //df.setRoundingMode(RoundingMode.CEILING);
         //return df.format(value);
        //return (double) Math.round(value*100.0000)/100.0000;
        return value;
    }

    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int capacity = scanner.nextInt();
        int[] values = new int[n];
        int[] weights = new int[n];
        for (int i = 0; i < n; i++) {
            values[i] = scanner.nextInt();
            weights[i] = scanner.nextInt();
        }
        System.out.println(getOptimalValue(capacity, values, weights));
    }
    
    /* class Items {
    	int id;
    	int weight,val;
    	double opt;
    	public Items(int weight,int val, int id){
    		this.id=id;
    		this.weight = weight;
    		this.val = val;
    		this.opt = (double) weight/val;
    	}
    	
    } */
    int id;
	int weight,val;
	double opt;
	public FractionalKnapsack(int weight,int val, int id){
		this.id=id;
		this.weight = weight;
		this.val = val;
		this.opt = (double) val/weight;
	}
    
    public static void InsertionSort(FractionalKnapsack[] items){
    	for(int i=0;i<items.length;i++){
    		for(int j=i;j>0;j--){
    			if(items[j].opt > items[j-1].opt){
    				FractionalKnapsack temp = items[j];
    				items[j] = items[j-1];
    				items[j-1] = temp;
    			}
    		}
    	}
    	
    }
    
} 
