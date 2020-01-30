import java.util.*;

public class CoveringSegments  {

    private static List<Integer> optimalPoints(Segment[] segments) {
        //write your code here
    	List<Integer> points = new ArrayList<Integer>();
    	List<Integer> endIndices = new ArrayList<Integer>();
    	Map<Segment, Boolean> visited = new HashMap<Segment,Boolean>();
        for(int i=0;i<segments.length;i++)
        	endIndices.add(segments[i].end);
        int lastMin = -2147483648;
        List<Segment> segmentsList1 = Arrays.asList(segments);
        List<Segment> segmentsList = new ArrayList<Segment>(Arrays.asList(segments));
        int minIndex=0;
        while(true){
	        //Arrays.sort(segments);
        	//Collections.sort(segmentsList);
        	 if(endIndices.size() ==0 || segmentsList.size()==0|| lastMin == Collections.min(endIndices))
 	        	break;
        	//if(endIndices.size() > 0){
    		minIndex = endIndices.indexOf(Collections.min(endIndices));
        	points.add(endIndices.get(minIndex).intValue());
        	//}
	       
	        lastMin = Collections.min(endIndices);
	    	for(int j=0;j<segmentsList.size();j++){
		        if(segmentsList.get(j).start <= lastMin && segmentsList.get(j).end >= lastMin){
		        	visited.put(segmentsList.get(j), true);
		        	//segmentsList.remove(segments[j]);
		        	endIndices.remove(new Integer(segmentsList.get(j).end));
		        }  
	    	}
	    	//endIndices.remove(new Integer(endIndices.get(minIndex).intValue()));  
	    	for(int j=0;j<segments.length;j++){
	    		//System.out.println(visited);
	    		//if(visited != null && visited.get(segments[j]) != null && visited.get(segments[j]))
	    		if(visited != null && Boolean.TRUE.equals(visited.get(segments[j])))
	    			segmentsList.remove(segments[j]);
	    		//System.out.println(segmentsList.get(j).start);
	    	}
        }
       return points;
    }
    
    
    

    private static class Segment implements Comparable {
        int start, end;

        Segment(int start, int end) {
            this.start = start;
            this.end = end;
        }
        public int getStart(){
        	return start;
        }
        @Override
        public int compareTo(Object o) {
             return this.getStart()-((Segment)o).getStart();
        }
        
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        Segment[] segments = new Segment[n];
        for (int i = 0; i < n; i++) {
            int start, end;
            start = scanner.nextInt();
            end = scanner.nextInt();
            segments[i] = new Segment(start, end);
        }
        List<Integer> points = optimalPoints(segments);
        System.out.println(points.size());
        for (int point : points) {
            System.out.print(point + " ");
        }
    }
}
 
