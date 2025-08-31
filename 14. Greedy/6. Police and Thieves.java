// Geeks For Geeks : Police and Thieves: https://www.geeksforgeeks.org/problems/police-and-thieves--141631/1

// *********
// Complexity
// TC: O(n) → single pass
// SC: O(1) → only counters used


// *********
// Approach
/*
    1. Use two pointers to track current police and thief positions.
    2. For each police-thief pair:
        - If distance ≤ k → increment count, move both pointers.
        - Else if thief is left of police → move thief pointer right.
        - Else (police is left of thief) → move police pointer right.
    3. Repeat until one pointer exceeds array bounds.
    4. Return total count of thieves caught.
*/


// *********
// Code
class Solution {
    public int catchThieves(char[] arr, int k) {
        // code here
        
        int n = arr.length;
        
        // point the pointer to police and thieves
        int p = -1;
        int t = -1;
        for(int i = 0; i < n; i++) {
            if(p == -1 && arr[i] == 'P') {
                p = i;
            }
            if(t == -1 && arr[i] == 'T') {
                t = i;
            }
            if(p != -1 && t != -1) {
                break;
            }
        }
        
        // if there is no any police or thieves, nothing need to be caught
        if(p == -1 || t == -1) {
            return 0;
        }
        
        int thievesCatched = 0;
        while(p < n && t < n) {
            if(Math.abs(p-t) <= k) {
                // police can catch thieves
                thievesCatched++;
                // increment to other police
                p++;
                while(p < n && arr[p] != 'P') {
                    p++;
                }
                // increment to other thieves
                t++;
                while(t < n && arr[t] != 'T') {
                    t++;
                }
            }
            
            else if(t < p) {
                // this thief can be catched , go to next thief
                t++;
                while(t < n && arr[t] != 'T') {
                    t++;
                }
            }
            
            else {
                //  p < t : may be next police can catch as current police cant catch
                p++;
                while(p < n && arr[p] != 'P') {
                    p++;
                }
            }
        }
        return thievesCatched;
    }
}