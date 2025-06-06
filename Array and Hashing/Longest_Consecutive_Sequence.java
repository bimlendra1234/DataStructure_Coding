import java.util.Arrays;

class Solution {
    public int longestConsecutive(int[] nums) {

        // BrutForce Approach
        // with sorting and and for each element calculating its longest common sequences and taking maximum one

        // TC: O(N^2)
        // SC: O(1)

        // Approach:
        // 1. Sort the array
        // 2. for each element compare all the rest remaining element next to it
        // 3. in for loop for each element , let 1 be maxLongSeq and next target number is nums[i]+1
        // 4. in second loop, If next element is same as nums[i]+1 then increment maxLongSeq
        //        also increment NextSeq to find the continuation next number
        // 5. if number is not same as NextSeq, update final LongestCommonSeq and end that iteration
        // 6. finally after all iteration update LongestCommonSeq and return it


        if(nums.length == 1) return 1;
        if(nums.length == 0) return 0;

        Arrays.sort(nums);

        int LongestCommonSeq = 0;
        for(int i = 0; i < nums.length-1; i++) {
            // longest from 0;
            int maxLongSeq = 1;
            int NextSeq = nums[i]+1;
            for(int j = i+1; j< nums.length;j++) {
                if(nums[j] == NextSeq) {
                    maxLongSeq++;
                    NextSeq++;
                }
                else {
                    LongestCommonSeq = Math.max(LongestCommonSeq, maxLongSeq);
                    continue;
                }
            }
            LongestCommonSeq = Math.max(LongestCommonSeq, maxLongSeq);
        }
        return LongestCommonSeq;
    }
}