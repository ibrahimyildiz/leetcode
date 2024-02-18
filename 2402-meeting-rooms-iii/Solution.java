import java.util.Arrays;
import java.util.PriorityQueue;

class Solution {
    public int mostBooked(int n, int[][] meetings) {
        Arrays.sort(meetings, (a, b) -> a[0] - b[0]);

        PriorityQueue<int[]> busyRooms = new PriorityQueue<>((a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);
        PriorityQueue<Integer> idleRooms = new PriorityQueue<>();

        int[] count = new int[n];
        int mostBookedRoom = 0;
    
        for (int i = 0; i < n; i++) {
            idleRooms.offer(i);
        }

        for (int[] meeting : meetings) {
            int start = meeting[0], end = meeting[1];
            int roomId;

            while (!busyRooms.isEmpty() && busyRooms.peek()[0] <= start) {
                idleRooms.offer(busyRooms.poll()[1]);
            }

            if (!idleRooms.isEmpty()) {
                roomId = idleRooms.poll();
                busyRooms.offer(new int[] {end, roomId});
            } else {
                int[] busyRoom = busyRooms.poll();
                roomId = busyRoom[1];
                busyRooms.offer(new int[] {busyRoom[0] + end - start, roomId});
            }
            count[roomId]++;
        }
    
        for (int i = 0; i < n; i++) {
            if (count[mostBookedRoom] < count[i]) {
                mostBookedRoom = i;
            }
        }

        return mostBookedRoom;
    }

    public static void main(String[] args) {
        // Example usage:
        Solution solution = new Solution();
        int n = 3;
        int[][] meetings = {{1,20},{2,10},{3,5},{4,9},{6,8}};
        int result = solution.mostBooked(n, meetings);
        System.out.println(result); // 1
    }
}