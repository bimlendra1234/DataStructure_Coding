// Leetcode: 981. Time Based Key-Value Store

import java.util.*;

// Approach using hashmap and Binarysearch
// TC for set : O(1)
// SC for set : O(N)
// TC for get : O(logM) => M = valList.size()
// SC for get : O(1)


// *********
// Approach
/*
1. Use hashmap <String key, composite value> 
        composite value contains string value and int timestamp
2. during setter
    if key not in HM 
        put key with empty arraylist of composite value
        later get arraylist using key and put composite value inside it
3. during getter
    if key do not exist return empty string
    if key exist
        get the arraylist
        perform BS in that arraylist and findvalue for timestamp same, if not same then less(in increasing order)
            If mid <= target: 
                save result and 
                continue till we get mid == target
                    in this we will save max possible value near target if not found same
            If mid > target
                right side is of no use
                check on the left side
*/


// *********
// Doubt
/*
1. Binary search, Logic to save result and moving pointer
=> sol
        if(midTimeStamp <= targetTimeStamp) {
            // if my mid is smallet then or equal to target 
            // shift toward right i.e bigger value till we reach mid == target

            // This value is valid (could be exact or closest smaller one). 
            // Save it. But continue searching to the right to see if there’s a closer match.
            res = midTimeStampVal;
            left = mid+1;
        }
        else {
            // if mid is bigger then target
                // i will need to search in smaller side that is left side

            // This value is too big. Need to look on the left side.
            right = mid-1;
            }
*/


// *********
// Code

// class defined by me: composite value that will be stored in HM
class TimsStampedValue {
    String value;
    int timeStamp;

    public TimsStampedValue(String value, int timeStamp) {
        this.timeStamp = timeStamp;
        this.value = value;
    }
}

class TimeMap {
    Map<String, ArrayList<TimsStampedValue>> HM;
    public TimeMap() {
        HM = new HashMap<>();
    }

    // external function created by me
    private String binarySearchInValList(ArrayList<TimsStampedValue> valList, int timestamp){
        int targetTimeStamp = timestamp;
        int left = 0;
        int right = valList.size()-1;
        String res = "";

        while(left <= right) {
            int mid = left + (right-left)/2;

            TimsStampedValue midTSV = valList.get(mid);
            int midTimeStamp = midTSV.timeStamp;
            String midTimeStampVal = midTSV.value;

            if(midTimeStamp <= targetTimeStamp) {
                res = midTimeStampVal;
                left = mid+1;
            }
            else {
                right = mid-1;
            }
        }
        return res;
    }
    
    public void set(String key, String value, int timestamp) {
        if(!HM.containsKey(key)) {
            HM.put(key, new ArrayList<>());
        }
        // now i need to find and add newlt created composite value that i defined above
        HM.get(key).add(new TimsStampedValue(value, timestamp));
    }
    
    public String get(String key, int timestamp) {

        if(!HM.containsKey(key)) {
            return "";
        }
        // get the arraylist based on key
        // do the BS in that arrayList

        ArrayList<TimsStampedValue> valList = HM.get(key);
        String res = binarySearchInValList(valList, timestamp);
        return res;
    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */