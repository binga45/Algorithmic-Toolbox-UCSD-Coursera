import java.util.*;

public class CollectingSignatures {

    private static int[] optimalPoints(Segment[] segments) {
        //write your code here
        int[] startpoints = new int[segments.length];
        int[] endpoints = new int[segments.length];
        for (int i = 0; i < segments.length; i++) {
            startpoints[i] = segments[i].start;
            endpoints[i] = segments[i].end;
        }
        return points;
    }

    private static class Segment {
        int start, end;

        Segment(int start, int end) {
            this.start = start;
            this.end = end;
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
        int[] points = optimalPoints(segments);
        System.out.println(points.length);
        for (int point : points) {
            System.out.print(point + " ");
        }
    }
}
 
