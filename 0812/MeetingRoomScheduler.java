import java.util.*;

public class MeetingRoomScheduler {
    public static int minMeetingRooms(int[][] meetings) {
        Arrays.sort(meetings, Comparator.comparingInt(a -> a[0]));
        PriorityQueue<Integer> endTimes = new PriorityQueue<>();
        for (int[] m : meetings) {
            if (!endTimes.isEmpty() && endTimes.peek() <= m[0]) {
                endTimes.poll();
            }
            endTimes.offer(m[1]);
        }
        return endTimes.size();
    }

    public static void main(String[] args) {
        int[][] meetings = {{0,30},{5,10},{15,20}};
        System.out.println(minMeetingRooms(meetings)); // 2
    }
}
