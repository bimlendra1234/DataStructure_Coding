import java.util.*;

class Solution {
    public List<Integer> majorityElement(int[] nums) {

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
    }
}