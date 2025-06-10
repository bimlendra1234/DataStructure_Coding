class Solution {
    public boolean isPalindrome(String s) {
        // Optimal approach using two pointer

        // TC: O(N) 
        // SC: O(1)

        /*
        Approach
        1. maintain two pointer one at left most element and other at right most element
        2. if any character is non alphanumeric increment left or right pointer and continue
            because there can be case when two consecutive element can be non alphanumeric
            so after checking all it will execute below code
        3. convert both character to lower case,
        4. if both are not same then return false that is not palindrome
        5. if same then left++ and right--
            so that it can check other character
        6. finally if all checked and false is not returned
            then return true at last that means valid palindrome.
        */

        /*
        Doubt
        How to remove non-alpha numeric character and convert to lower case

        sol: Character.isLetterOrDigit()
        use like this: Character.isLetterOrDigit(s.charAt(left))
        not like this: s.charAt(left).isLetterOrDigit()
        ---------------------------------------------------------
        sol: Character.toLowerCase()
        use like this: Character.toLowerCase(s.charAt(left))
        not like this: s.charAt(left).toLowerCase()
        */

        int left = 0;
        int right = s.length()-1;
        while(left<right) {
            if(!(Character.isLetterOrDigit(s.charAt(left)))) {
                left++;
                // becoz next character might be non alphanumeric
                // so it will be again checked here and below coe wont get executed
                continue;
            }
            if(!(Character.isLetterOrDigit(s.charAt(right)))) {
                right--;
                continue;
            }
            char leftChar = Character.toLowerCase(s.charAt(left));
            char rightChar = Character.toLowerCase(s.charAt(right));
            if(leftChar != rightChar) {
                return false;
            } else {
                left++;
                right--;
            }
        }
        return true;
    }
}