import java.io.*;
import java.util.*;

public class PointsAndSegments {
	private static Random random = new Random();
	/**
	 case 1:

6 21

6 12

8 10

0 2

0 4

-6 -2

-4 -2

-7 -6 -5 -4 -3 -2 -1 0 1 2 3 4 5 6 7 8 9 10 11 12 13

correct output: 0 1 1 2 2 2 0 2 2 2 1 1 0 1 1 2 2 2 1 1 0

case 2:

3 11

0 2

-6 -4

-4 -2

-7 -6 -5 -4 -3 -2 -1 0 1 2 3

correct output: 0 1 1 2 1 1 0 1 1 1 0
	 **/
    private static int[] fastCountSegments(int[] starts, int[] ends, int[] points) {
        int[] cnt = new int[points.length];
        //write your code here
        Arrays.sort(starts);
        Arrays.sort(ends);
        for(int i=0; i <points.length; i++){
        	cnt[i] = binarySearch(points[i],starts,true) +binarySearch(points[i],ends,false)-ends.length;
        }
        return cnt;
    }
    
    private static int binarySearch(int a, int[] stars, boolean flag){
    	int l = 0, r = stars.length-1;
    	int count = 0; 		
    		/*while(l<=r){
    			int m = l + (r-l)/2;
    			if (starts[m] == a) 
                    return m+1; 
                // If x greater, ignore left half 
                if (starts[m] < a) 
                    l = m + 1; 
                // If x is smaller, ignore right half 
                else
                    r = m - 1; 
    		}
    		return -1;*/	
    	while(count <=r && stars[count]<=a){
	    		if(stars[count]==a && !flag){
	    			count++;
	    			break;
	    		}
	    			count++;
    	}
    	if(flag){
    			return count;
    	}
    	else{
    		//if(count-1 <=r && count-1>=l && starts[count-1]==a)
    		if(count != 0 && stars[count-1]==a)
    			return stars.length-count+1;
    		else
    			return stars.length-count;
    	}
    }
    
    private static int[] fastCountSegments1(int[] starts, int[] ends, int[] points) {
    	//write your code here
        int[] cnt = new int[points.length];
        List<Resultant> finalList = new ArrayList<Resultant>();
        List<Integer> cnt2 = new ArrayList<Integer>();//used for finding the index of points as per input points array.
        
        for(int i=0; i<points.length; i++)
        	cnt2.add(points[i]);
        for(int i=0; i<starts.length; i++){
        	finalList.add(new Resultant(starts[i],'l'));
        }
        for(int i=0; i<ends.length;i++){
        	finalList.add(new Resultant(ends[i],'r'));
        }
        for(int i=0; i<points.length;i++){
        	finalList.add(new Resultant(points[i],'p'));
        }
        Collections.sort(finalList);
        int lcount = 0;
        int rcount = 0;
        int prevvalue = -2147483648;
        int j=-2147483648;
        for(int i=0; i <finalList.size(); i++){
        	if(finalList.get(i).code == 'l'){
        		lcount++;
        	}
        	if(finalList.get(i).code == 'r'){
        		rcount++;
        		/*if(prevvalue == finalList.get(i).value )
        			cnt[j]++;*/
        	}
        	if(finalList.get(i).code == 'p'){
//Since list's indexOf provides only the first index, we have to update the values of same points at other indices 
        		if(prevvalue==finalList.get(i).value){
        			for(int k = 0; k<cnt.length;k++){
        				if(points[k]==prevvalue)
        					cnt[k] = cnt[j];
        			}
        		}
        		cnt[cnt2.indexOf((finalList.get(i).value))]=(lcount-rcount)>=0?(lcount-rcount):0;
        		prevvalue = finalList.get(i).value;
        		j = cnt2.indexOf((finalList.get(i).value));
        	}
        	
        }
        return cnt;
    }

    private static int[] naiveCountSegments(int[] starts, int[] ends, int[] points) {
        int[] cnt = new int[points.length];
        for (int i = 0; i < points.length; i++) {
            for (int j = 0; j < starts.length; j++) {
                if (starts[j] <= points[i] && points[i] <= ends[j]) {
                    cnt[i]++;
                }
            }
        }
        return cnt;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n, m;
        n = scanner.nextInt();
        m = scanner.nextInt();
        int[] starts = new int[n];
        int[] ends = new int[n];
        int[] points = new int[m];
        for (int i = 0; i < n; i++) {
            starts[i] = scanner.nextInt();
            ends[i] = scanner.nextInt();
        }
        for (int i = 0; i < m; i++) {
            points[i] = scanner.nextInt();
        }
        //use fastCountSegments
        int[] cnt = fastCountSegments1(starts, ends, points);
        for (int x : cnt) {
            System.out.print(x + " ");
        }
        
      /*//stress testing implemented below
       int counter=0;
      while(counter < 50){
      	
      	int pointscount = random.nextInt(100);
      	int segmentscount = random.nextInt(100);
          int[] starts = new int[segmentscount];
          int [] ends = new int[segmentscount];
          int[] points =new int[pointscount];
          for(int i=0; i<segmentscount; i++){
          	starts[i] = random.nextInt(1000);
          	ends[i] = random.nextInt(1000-starts[i])+starts[i];
          }
          
          for(int i=0; i<pointscount; i++){
            	points[i] = random.nextInt(1000);
            	
            }
          if(!Arrays.equals(naiveCountSegments(starts,ends,points), fastCountSegments1(starts, ends, points))){
          	System.out.println("original points are " + Arrays.toString(points));
          	System.out.println("starts are " + Arrays.toString(starts));
          	System.out.println("ends are " + Arrays.toString(ends));
          	
          	System.out.println("new output is " + Arrays.toString(fastCountSegments1(starts,ends,points)));
          	System.out.println("counter is "+counter );
          	break;
          }
       counter++;   
      	
      }*/
    }
}

class Resultant implements Comparable{
	int value;
	char code;
	Resultant(int value, char code){
		this.value = value;
		this.code = code;
	}
	public int getValue(){
    	return value;
    }
	public char getCode(){
    	return code;
    }
	@Override
    public int compareTo(Object o) {
         int result =  this.getValue()-((Resultant)o).getValue();
         if(result==0)
        	 result =  this.getCode()-((Resultant)o).getCode();
         return result;
    }
}

