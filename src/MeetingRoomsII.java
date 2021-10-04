import java.util.*;

class MeetingRoomsII {
    /*Idea:
    1. Sort meetings by start time
    2. Push the first meeting in a min heap of end times.
    3. Iterate through meetings. If the earliest ending meeting has ended when the current meeting starts,
    i.e. heap.root.end <= current meeting's start, pop from heap.
    4. Push this meeting in the heap
    5. Required number of rooms = Heap size at the end
    * */
    public int minMeetingRooms(int[][] meetings) {
        if (meetings.length == 0)
            return 0;
        Map<Character,Integer> set=new HashMap<>();

        Arrays.sort(meetings,(a,b)->(a[0]-b[0]));
        Queue<Integer> minHeap = new PriorityQueue<>();
        minHeap.add(meetings[0][1]);
        for (int i = 1; i < meetings.length; i++) {
            if (minHeap.peek() <= meetings[i][0])
                minHeap.poll();
            minHeap.add(meetings[i][1]);
        }
        return minHeap.size();
    }

    public static void main(String[] args) {
        MeetingRoomsII ob = new MeetingRoomsII();
        System.out.println(ob.minMeetingRooms(new int[][]{{0, 30}, {5, 10}, {15, 20}}) == 2);
        System.out.println(ob.minMeetingRooms(new int[][]{{7, 10}, {2, 4}}) == 1);
        System.out.println(ob.minMeetingRooms(new int[][]{{2, 15}, {36, 45}, {9, 29}, {16, 23}, {4, 9}}) == 2);
        System.out.println(ob.minMeetingRooms(new int[][]{{10, 16}, {11, 13}, {14, 17}}) == 2);
        System.out.println(ob.minMeetingRooms(new int[][]{}) == 0);
        System.out.println(ob.minMeetingRooms(new int[][]{{10,16}}) == 1);
    }
}