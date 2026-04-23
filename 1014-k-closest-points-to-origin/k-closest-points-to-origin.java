import java.util.*;
class Solution {
    public int squaredDis(int[] p) {
        return p[0] * p[0] + p[1] * p[1];
    }

    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a, b) ->
            squaredDis(b) - squaredDis(a)
        );

        for (int[] p : points) {
            maxHeap.offer(p);
            if (maxHeap.size() > k)
                maxHeap.poll();
        }

        int[][] res = new int[k][2];
        for (int i = 0; i < k; i++)
            res[i] = maxHeap.poll();
        return res;
    }
}