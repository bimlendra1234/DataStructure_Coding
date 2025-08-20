// Leetcode : 973. K Closest Points to Origin

// Approach using minHeap, storing distance and coordinate point
// Time complexity: O(k*logn) // offer n items + poll k items
// Space complexity: O(n)


// *********
// Approach
/*
    1. For each point calculate the distance to origin
    2. push the distance and point coordinate to min heap
        based on 1st index distance
    3. poll k min element from minHeap
        just include coordinate in the answer not the distance.
    4. return the answer
*/


// *********
// Code
class Solution {

    public int findDistance(int[] point, int[] origin) {
        int x1 = point[0];
        int y1 = point[1];

        int x2 = origin[0];
        int y2 = origin[1];

        int dx = x1-x2;
        int dy = y1-y2;
        int distance = (dx*dx)+(dy*dy);
        return distance;
    }

    public int[][] kClosest(int[][] points, int k) {
        
        PriorityQueue<int[]> minHeap = new PriorityQueue<>(Comparator.comparing(a -> a[0]));

        int[] origin = {0,0};

        for(int[] point : points) {
            int distance = findDistance(point, origin);
            minHeap.offer(new int[]{distance, point[0], point[1]});
        }

        int[][] res = new int[k][2];
        for (int i = 0; i < k; i++) {
            int[] point = minHeap.poll();
            res[i] = new int[]{point[1], point[2]};
        }
        return res;
    }
}