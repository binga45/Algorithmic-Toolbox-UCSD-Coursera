import java.util.Comparator;
import java.util.Scanner;
import java.util.TreeSet;

public class PointsAndSegments1 {
	
	private static class Segment{
		int start;
		int finish;
		
		Segment(int start, int finish){
			this.start = start;
			this.finish = finish;
		}
		
		 @Override
	        public String toString() {
	            return "[" + start +
	                    ", " + finish +
	                    ']';
	        }
		
	}
	
	 private static class OrderStart implements Comparator<Segment> {
	        public int compare(Segment p, Segment q) {
	            return Integer.compare(p.start, q.start);
	        }
	    }

	    private static class OrderFinish implements Comparator<Segment> {
	        public int compare(Segment p, Segment q) {
	            return Integer.compare(p.finish, q.finish);
	        }
	    }

    private static int[] fastCountSegments(int[] starts, int[] ends, int[] points) {
        int[] cnt = new int[points.length];
        //write your code here
        //TreeSet <Segment> pointsSortedByStart = new TreeSet<>(new OrderStart());
        TreeSet <Segment> pointsSortedByStart = new TreeSet<>((a,b)->a.start-b.start);
        //TreeSet <Segment> pointsSortedByStart = new TreeSet<>(Comparator.comparing((Segment)->Segment.start));
        for(int i=0; i<starts.length; i++){
        	pointsSortedByStart.add(new Segment(starts[i],ends[i]));
        }
        for(int i=0; i< points.length; i++){
        	TreeSet <Segment> pointsSortedByFinish = new TreeSet<>(new OrderFinish());
        	Segment search = new Segment(points[i],points[i]);
        	pointsSortedByFinish.addAll(pointsSortedByStart.headSet(search,true));
        	cnt[i] = pointsSortedByFinish.tailSet(search, true).size();
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
        int[] cnt = naiveCountSegments(starts, ends, points);
        for (int x : cnt) {
            System.out.print(x + " ");
        }
    }
}

