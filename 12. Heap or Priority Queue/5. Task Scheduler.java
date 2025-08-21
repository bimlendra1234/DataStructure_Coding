// Leetcode : 621. Task Scheduler

// TC: O(NLogN)
// SC: O(3N)


// *********
// Approach
/*
    1. Count frequencies in HM.
    2. Use PQ as "max-heap" : to find the task that has max freq on the top
    3. Maintain queue = [Freq, readyTime or ExecTime] for cooling tasks/ waiting task.
    4. Do the processing of task
        increment time
        Until PQ is not empty
            pop top elem from PQ
            reduce freq by 1
                if freq is still greater then 0 
                    calculate the newExecTime = currentTime +  cooling off time i.e n
                    push [newFreq, newExecTime] to queue : to denote it is waiting and will get cpu when CT = newExecTime
        Shift the task from wait queue to piority Queue 
            when quey have any elem and Execution task of top elem in queue = current time
    5. return currentTime
*/
class Solution {
    public int leastInterval(char[] tasks, int n) {
        // 1. Maintain the frequency Map
        Map<Character, Integer> HM = new HashMap<>();
        for(Character ch : tasks) {
            HM.put(ch, HM.getOrDefault(ch,0)+1);
        }

        // 2. Maintan the max heap : to find the task that has max freq on the top
        // task : int[] => freq and ET
        PriorityQueue<int[]> PQ = new PriorityQueue<>((a, b) -> b[0] - a[0]);
        for(Character ch : HM.keySet()) {
            int freq = HM.get(ch);
            int ExecTime = 0;
            PQ.offer(new int[]{freq, ExecTime});
        }

        // 3. maintain queue for waiting task, so here we will update ET accordingly
        Queue<int[]> queue = new LinkedList<>();
        int currentTime = 0;

        // 4. Do the processing of task
            // pop top elem from PQ
            // reduce freq
            // if freq is still greater then 0 
                // calculate the newExecTime = currentTime +  cooling off time i.e n
                // push [newFreq, newExecTime] to queue : to denote it is waiting and will get cpu when CT = newExecTime
        while(!queue.isEmpty() || ! PQ.isEmpty()) {
            currentTime++;
            if(!PQ.isEmpty()) {
                int[] task = PQ.poll();
                int newFreq = task[0]-1;
                if(newFreq > 0) {
                    int newExecTime = currentTime + n;
                    queue.offer(new int[]{newFreq, newExecTime});
                }
            }
            // Shift the task from wait queue to piority Queue 
                // when Execution task of top elem in queue = current time
            if (!queue.isEmpty() && queue.peek()[1] == currentTime) {
                PQ.offer(queue.poll());
            }
        }
        return currentTime;
    }
}