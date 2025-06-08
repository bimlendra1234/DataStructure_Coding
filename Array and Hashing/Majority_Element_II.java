import java.util.*;

class Solution {
    public List<Integer> majorityElement(int[] nums) {

        /*
        // BrutForce Approach using HAshMap

        // TC: O(N)
        // SC: O(N)

        // Approach
        // 1. In hashmap put number and its count
        // 2. Create an array list
        // 3. In the above array list put all the key from HM tha has balue greater then n/3 
        // 4. return that array list

        // Doubt:
        // 1. List<Integer> res = new ArrayList<>();
        // 2. adding in res

        int n = nums.length;
        System.out.println("n/3: "+ n/3);
        Map<Integer,Integer> HM = new HashMap<>();

        for(int i=0; i <nums.length;i++) {
            HM.put(nums[i], HM.getOrDefault(nums[i],0)+1);
            // System.out.println(nums[i]);
        }

        List<Integer> res = new ArrayList<>();
        for(int key: HM.keySet()) {
            System.out.println("Key: "+ key +" " + HM.get(key));
            System.out.println("-----");
            if(HM.get(key) > n/3) {
                res.add(key);
            }
        }

        return res;
        */

        // -------------------------------------------------------------------------------------------------------

        // Optimal Approach using Boyer-Moore Voting Algorithm extended

        // TC: O(N)
        // SC: O(1)

        /*
        Approach
        1. find most two frequent element using Boyer-Moore Voting Algorithm
        2. Do the two pass of actual array
        3. the first pass of the Boyer-Moore Voting Algorithm only finds candidates that might be majority elements
            not necessirily greater then 3
        4. The Second pass verify the two majority element count that it is greater then n/3
            does a literal count of the candidate values in the array
            later this number is only applied when this count is greater then n/3
        5. create resultant arraylist and add this two number in it
            if its count is greater then n/3
        */

        /*
        Doubt
        How we can extend Boyer-Moore Voting Algorithm to find two majority element
        because initially we only found one majority element
        */

        int count1 = 0;
        int majorityElement1 = 0;
        int count2 = 0;
        int majorityElement2 = 0;

        // find most two frequent element
        // the first pass of the Boyer-Moore Voting Algorithm only finds candidates that might be majority elements
        for (int i = 0; i < nums.length; i++) {
            if (majorityElement1 == nums[i]) {
                count1++;
            }
            else if (majorityElement2 == nums[i]) {
                count2++;
            }
            else if (count1 == 0) {
                    majorityElement1 = nums[i];
                    count1++;
            }
            else if (count2 == 0) {
                    majorityElement2 = nums[i];
                    count2++;
            }
            else {
                count1--;
                count2--;
            }
        }

        // verify the two majority element count
        // This loop does a literal count of the candidate values in the array
        // later this number is only applied when this count is greater then n/3
        count1 = 0;
        count2 = 0;
        for(int num: nums) {
            if(num == majorityElement1) count1++;
            else if(num == majorityElement2) count2++;
        }
        
        List<Integer> res = new ArrayList<>();
        // only applied when this count is greater then n/3
        if(count1>nums.length/3) res.add(majorityElement1);
        if(count2>nums.length/3) res.add(majorityElement2);

        return res;
    }
}