import java.util.Arrays;
import java.util.PriorityQueue;

public class NonInterval {

    public static void main(String args[]){
       // eraseOverlapIntervals(new int[][]{{1,100},{11,22},{1,11},{2,12}});

       // eraseOverlapIntervals(new int[][]{{1,2},{3,4},{5,6},{7,8}});

        minMeetingRooms(new int[][]{{0, 30},{5, 10},{15, 20}});
    }


    public static int eraseOverlapIntervals(int[][] intervals) {

        if(intervals.length == 0) return 0;
        Arrays.sort(intervals,(a, b)->(a[1]-b[1]));
        int end = intervals[0][1];
        int count = 1;
        for(int i=1;i<intervals.length;i++){
            if(intervals[i][0]>=end){
                count++;
                end = intervals[i][1];
            }
        }
        return intervals.length-count;
    }

    public static int minMeetingRooms(int[][] intervals) {
        if(intervals == null || intervals.length == 0) return 0;
        Arrays.sort(intervals,(a, b)->(a[0]-b[0]));
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int room = 0;
        for(int i = 0; i < intervals.length; i++){
            pq.offer(intervals[i][1]);
            if(intervals[i][0] < pq.peek())  room++;
            else{
                pq.poll();
            }
        }
        return room;
    }
}
