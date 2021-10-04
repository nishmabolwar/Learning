import java.util.Arrays;

public class Demo {
    public static void main(String args[]){
        Interval in=new Interval(0,30);
        System.out.println(canAttendMeetings(new Interval[]{new Interval(0,30),
                new Interval(5,10),new Interval(15,20)}));
        System.out.println(canAttendMeetings(new Interval[]{new Interval(7,10),
                new Interval(2,4)}));
        System.out.println(canAttendMeetings(new Interval[]{new Interval(1,5),
                new Interval(3,14),new Interval(6,10),new Interval(9,12)}));

    }

    public static class Interval {
      int start;
    int end;
     Interval() { start = 0; end = 0; }
     Interval(int s, int e) { start = s; end = e; }}

    public static int canAttendMeetings(Interval[] intervals) {
        Arrays.sort(intervals,(a,b)->Integer.compare(a.start,b.start));
        int room=0;
        for(int i=0; i<intervals.length-1; i++){
            if(intervals[i].end>intervals[i+1].start){
                room++;
            }
        }

        return room;
    }


}
