import java.util.PriorityQueue;

class Solution {
    public int furthestBuildingSolution1(int[] heights, int bricks, int ladders) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        for (int i = 0; i < heights.length-1; i++) {
            int diff = heights[i+1] - heights[i];

            if(diff > 0) {
                pq.offer(diff);

                if(pq.size() > ladders) {
                    bricks -= pq.poll();
                }
    
                if(bricks < 0) {
                    return i;
                }
            }
        }

        return heights.length - 1;
    }

    public int furthestBuildingSolution2(int[] heights, int bricks, int ladders) {
        PriorityQueue<Integer> p = new PriorityQueue<>((a, b) -> b - a);
        
        int i = 0, diff = 0;
        for (i = 0; i < heights.length - 1; i++) {
            diff = heights[i + 1] - heights[i];
            
            if (diff <= 0) {
                continue;
            }

            bricks -= diff;
            p.offer(diff);

            if (bricks < 0) {
                bricks += p.poll();
                ladders--;
            }

            if (ladders < 0) {
                break;
            }
        }
        
        return i;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] heights = {2,7,9,12};
        int bricks = 5;
        int ladders = 1;
        int result1 = solution.furthestBuildingSolution1(heights, bricks, ladders);
        int result2 = solution.furthestBuildingSolution2(heights, bricks, ladders);
        System.out.println(result1); // 3
        System.out.println(result2); // 3
    }
}