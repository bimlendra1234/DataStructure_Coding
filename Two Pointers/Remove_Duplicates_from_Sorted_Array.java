import java.util.*;

class Solution {
    public int removeDuplicates(int[] nums) {
        /*
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
        */

        // ----------------------------------------------------------------------------

        // Optimal Approach using two pointer

        // TC: O(2N) one for start and one for end -> O(N)
        // SC: O(1)

        /*
        Approach
        1. maintain idx pointer where we will insert element after removing duplicate
        2. maintain start ptr, begining at start element or at 0th index
        3. do for loop, which maintain end pointer
            will traverse each element one by one
            if start element is == endElement, increase start by 1,
            if both are not same . add start element to idx and increase both start and idx
        4. at last since it is out of loop, so, place last start index element at the idx
            as while handling this loop already ende and it wont get processed.
        5. return idx
            as atlast we did idx++ and since it startted from 0.
        */
        int idx = 0;

        int start = 0;
        for(int next = 1; next < nums.length; next++) {
            int startElement = nums[start];
            int nextElement = nums[next];

            if(startElement == nextElement) {
                start++;
            }
            else{
                nums[idx++] = nums[start++]; 
            }
        }

        nums[idx++] = nums[start];

        return idx;
    }
}