import java.util.*;

class Solution {
    public int removeDuplicates(int[] nums) {

        // BrutForce Approach using Linked HashSet

        // TC: O(N)
        // SC: O(N) for linked hashset

        // *********
        // Approach
        // 1. insert all element in the linked hashset in order
        // 2. traversed linked hashset one by one and put each in nums array
        // 3. finally returned the index of nums. till which it is filled

        // *********
        // Doubt
        // Initially i used hashSet but it do not preserve insertion order
        // so i used LinkedHashSet as it preserve insertion order
        // preserve insertion order was required because in nums after duplicate removal
            // element order need to be preserved 

        // ******** 
        // HashSet doesn't maintain insertion order.
        // Set<Integer> HS = new HashSet<>();
        // So use below as
        // LinkedHashSet doesn maintain insertion order.
        Set<Integer> HS = new LinkedHashSet<>();

        for(int i = 0; i < nums.length; i++) {
            HS.add(nums[i]);
        }

        int idx = 0;
        for(int val : HS) {
            nums[idx++] = val;
        }
        return idx;
    }
}