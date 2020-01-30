import java.util.*;
import java.io.*;

public class CarFueling {
    static int computeMinRefills(int dist, int tank, int[] stops) {
    	int currentRefill = 0, numRefills = 0, lastRefill = 0; 
    	int [] updatedStops = new int[stops.length+2];
    	System.arraycopy(stops, 0, updatedStops,1, stops.length);
    	updatedStops[updatedStops.length-1] = dist;
    	if(stops[0] > tank)
    		return -1;
    	else if(dist < tank)
    		return 0;
    	else{
    		while(currentRefill <= stops.length){
    			lastRefill = currentRefill;
    			while(currentRefill <= stops.length && updatedStops[currentRefill+1]-updatedStops[lastRefill] <= tank)
    				currentRefill = currentRefill + 1;
    			if(currentRefill <= stops.length)
    				numRefills = numRefills + 1;
    			if(currentRefill == lastRefill)
    				return -1;	
    		}
    		return numRefills;
    	}
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int dist = scanner.nextInt();
        int tank = scanner.nextInt();
        int n = scanner.nextInt();
        int stops[] = new int[n];
        for (int i = 0; i < n; i++) {
            stops[i] = scanner.nextInt();
        }

        System.out.println(computeMinRefills(dist, tank, stops));
    }
}
