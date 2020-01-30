import java.io.*;
import java.util.*;
import static java.lang.Math.*;

public class Closest {
	private static Random random = new Random();
    static class Point implements Comparable<Point> {
        long x, y;

        public Point(long x, long y) {
            this.x = x;
            this.y = y;
        }
        
        public long getX(){
        	return this.x;
        }
        
        public long getY(){
        	return this.y;
        }

        @Override
        public int compareTo(Point o) {
            return o.y == y ? Long.signum(x - o.x) : Long.signum(y - o.y);
        }
    }
    
    static class XSort implements Comparator<Point> 
    { 
        public int compare(Point m1, Point m2) 
        { 
            return Long.signum(m1.getX()-m2.getX()); 
        } 
    } 
    static double naiveMinDistance(int[] x, int y[]){
    	double distance = 290390;
    	for(int i=0;i<x.length; i++){
    		for(int j=i+1; j<x.length; j++){
    			double dist = computeEuclidean(x[i],x[j],y[i],y[j]);
    			if(dist < distance)
    				distance=dist;
    		}
    	}
    	return distance;
    }

    static double minimalDistance(int[] x, int y[]) {
        double ans = Double.POSITIVE_INFINITY;
        //write your code here
        //Arrays.sort(x);
        //Arrays.sort(y);
        List<Point> sortByX = new ArrayList<Point>();
        XSort xs = new XSort();
        for(int i=0; i<x.length;i++){
        	sortByX.add(new Point(x[i],y[i]));
        }
        Collections.sort(sortByX, xs);
        for(int i=0; i<sortByX.size(); i++){
        	x[i] = (int)sortByX.get(i).getX();
        	y[i] = (int) sortByX.get(i).getY();
        }
        Point[] closest = closestPairs(x,y,0,x.length-1);
        //System.out.println(closest[0].x+" "+closest[1].x +" "+closest[0].y + " "+ closest[1].y);
        return computeEuclidean(closest[0].x,closest[1].x,closest[0].y,closest[1].y);
    }
    
    static Point[] closestPairs(int[] x, int[] y, int start, int end){
    	if(end-start+1 <=3){
    		Point [] a = computeClosestPair(x,y,start, end);
    		return a;
    	}
    	int mid = start + (end-start)/2;
    	Point [] left = closestPairs(x,y,start,mid);
    	Point[] right = closestPairs(x,y,mid+1,end);
    	double delta = -290390;
    	double leftDistance = computeEuclidean(left[0].x,left[1].x,left[0].y,left[1].y);
    	double rightDistance = computeEuclidean(right[0].x,right[1].x,right[0].y,right[1].y);
    	delta = leftDistance > rightDistance ? rightDistance : leftDistance;
    	Point[] returnPoints = leftDistance > rightDistance ? right : left;
    	List<Point> leftDeltaDistant = computeDeltaDistant(x,y,start,mid,mid,delta);
    	List<Point> rightDeltaDistant = computeDeltaDistant(x,y,mid+1,end,mid,delta);
    	leftDeltaDistant.addAll(rightDeltaDistant);
    	Collections.sort(leftDeltaDistant);
    	double sdelta = 290390, dist=0;
    	Point[] Sset = new Point[2];
    	for(int i = 0; i < leftDeltaDistant.size();i++){
    		int count = 1;
    		while(count<=7 && i+count < leftDeltaDistant.size() ){
    			dist = computeEuclidean(leftDeltaDistant.get(i).x, leftDeltaDistant.get(i+count).x, leftDeltaDistant.get(i).y, leftDeltaDistant.get(i+count).y);
    			if(dist < sdelta){
    				Sset[0] = new Point(leftDeltaDistant.get(i).x,leftDeltaDistant.get(i).y);
    				Sset[1] = new Point(leftDeltaDistant.get(i+count).x,leftDeltaDistant.get(i+count).y);
    				sdelta = dist;
    			}
    			count++;
    		}
    		
    	}
    	if(delta < sdelta)
    		return returnPoints;
    	else
    		return Sset;
    	
    }
    
//    static Point[] computeclosestPair(List<Point> leftDeltaDistant, int currentindex, double delta){
//    	
//    }
    
    static List<Point> computeDeltaDistant(int [] x, int[] y, int start, int end, int mid,double delta){
    	List<Point> deltaDistant = new ArrayList<Point>();
    	double distance;
    	int j=0;
    	for(int i=start; i<=end; i++){
    		if(computeEuclidean(x[i],(x[mid]+x[mid+1])/2.0,y[i],y[i])<=delta){
    			deltaDistant.add(new Point(x[i],y[i]));
    		}
    	}
    	return deltaDistant;
    }
    
   static  Point[] computeClosestPair(int[] x, int[] y, int start, int end){
	   double minimumDist = 214748367;
	   Point[] Points = new Point[2];
 	   for(int i=start; i<=end; i++){
		   for(int j=i+1; j<=end; j++){
			   double dist = computeEuclidean(x[i],x[j],y[i],y[j]);
			   if(dist < minimumDist){
				   minimumDist = dist;
				   Points[0] = new Point(x[i],y[i]);
				   Points[1] = new Point(x[j],y[j]);
			   }
				   
		   }
	   }
 	   return Points;
   }
   
   static double computeEuclidean(double x1, double x2, double y1, double y2){
	   
	   return Math.sqrt(Math.pow((x1-x2),2) + Math.pow((y1-y2),2));
	   
   }

    public static void main(String[] args) throws Exception {
        reader = new BufferedReader(new InputStreamReader(System.in));
        writer = new PrintWriter(System.out);
        int n=nextInt();
        int[] x = new int[n];
        int[] y = new int[n];
        for (int i = 0; i < n; i++) {
            x[i] = nextInt();
            y[i] = nextInt();
        }
    System.out.println(minimalDistance(x, y));
// Below is the implementation of stress testing
       /* int counter=0;
	        while(counter < 50){
	        //int n = random.nextInt(100);;
	        int n=5;
	        int[] x = new int[n];
	        int[] y = new int[n];
	        for (int i = 0; i < n; i++) {
	            x[i] = random.nextInt(100);
	            y[i] = random.nextInt(100);
	        }
	        if(minimalDistance(x, y) != naiveMinDistance(x,y)){
	        	System.out.println("counter is " + counter);
	        	System.out.println("x's are " + Arrays.toString(x));
	        	System.out.println("y's are " + Arrays.toString(y));
	        	System.out.println("minimal distance is " + minimalDistance(x, y));
	        	System.out.println("naive minimal distance is " + naiveMinDistance(x, y));
	        	break;
	        }
	        //System.out.println(minimalDistance(x, y));
	        counter++;
	        }*/
        writer.close();
    }

    static BufferedReader reader;
    static PrintWriter writer;
    static StringTokenizer tok = new StringTokenizer("");


    static String next() {
        while (!tok.hasMoreTokens()) {
            String w = null;
            try {
                w = reader.readLine();
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (w == null)
                return null;
            tok = new StringTokenizer(w);
        }
        return tok.nextToken();
    }

    static int nextInt() {
        return Integer.parseInt(next());
    }
}


