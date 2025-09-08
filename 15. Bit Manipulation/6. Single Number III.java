// Leetcode : 260. Single Number III

// BrutForce approach using hashMap
class Solution {
    public int[] singleNumber(int[] nums) {
        
        Map<Integer, Integer> HM = new HashMap<>();
        for(int i = 0 ; i < nums.length; i++) {
            HM.put(nums[i], HM.getOrDefault(nums[i],0)+1);
        }

        int[] res = new int[2];
        int i = 0;
        for(int key : HM.keySet()) {
            int val = HM.get(key);
            if(val == 1) {
                res[i++] = key;
            }
        }
        return res;
    }
}

// ----------------------------------------------------