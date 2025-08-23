class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {

        /*
         * Brute Force Approach
        1. create a new array of size m+n
        2. copy all the elements of nums1 and nums2 to that new array in sorted order
        4. copy all the elements of that new array to nums1
        5. return nums1

        TC: O(N+M)
        SC: O(N+M) // for new array
        Note: this is not in-place solution
         */

        /*
         * leet code 88. Merge Sorted Array
         * You are given two integer arrays nums1 and nums2, sorted in non-decreasing order, 
                and two integers m and n, representing the number of elements in nums1 and nums2 respectively.
         * Merge nums1 and nums2 into a single array sorted in non-decreasing order.
         
         * The final sorted array should not be returned by the function, but instead be stored inside the array nums1. 
                To accommodate this, nums1 has a length of m + n, where the first m elements denote the elements that should be merged, 
                and the last n elements are set to 0 and should be ignored. nums2 has a length of n.
         * Note that the merging process must be done in-place.
         
         * Example 1:
         * Input: nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
         * Output: [1,2,2,3,5,6]
         * Explanation: The arrays we are merging are [1,2,3] and [2,5,6].
         * The result of the merge is [1,2,2,3,5,6], with the merged elements in nums1.
         */

        // Optimal Approach using two pointed method starting from the last

        // TC: O(N+M)
        // SC: O(1)

        /*
        Approach
        1. maintain one left pointer pointing to last element of nums1 i.e m-1
        2. maintain othere right pointer pointing to last element of nums2 i.e n-1
        3. maintain third pointer pointing to last index of our res array i.e nums1

        4. until both left and right is greater then 0
            which ever is greater (let say right) put that element to the idx position
            and decrease that element index (let say right--)
            also decrease idx-- so that we will set other element there next time.
        5. when left all element exhausted and only right element is still there
            place right element at idx 
            decrease right--
            also decrease idx--
        6.. when right all element exhausted and only left element is still there
            place left element at idx
            decrease left--
            also decrease idx--
        */

        /*
        Doubt
        for a long time i was placing the element from the first index
            which may override the existing array and array may be unsorted

        best sol: from begining start placing the element from last index of nums1
            by comparing which one is greater
            and put that greater element at the last idx of nums1 array
        */

        int left = m-1;
        int right = n-1;
        int idx = nums1.length-1;

        while(left >= 0 && right >= 0) {
            if(nums1[left] >= nums2[right]) {
                nums1[idx] = nums1[left];
                left--;
                idx--;
            }
            else if(nums2[right] > nums1[left]) {
                nums1[idx] = nums2[right];
                right--;
                idx--;
            }
        }

        // when left all element exhausted and only right element is still there
        while(right >= 0) {
            nums1[idx] = nums2[right];
            right--;
            idx--;
        }

        // when right all element exhausted and only left element is still there
        while(left >= 0) {
            nums1[idx] = nums1[left];
            left--;
            idx--;
        }
    }
}