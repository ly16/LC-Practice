/*
Given a permutation which contains no repeated number, 
find its index in all the permutations of these numbers, which are ordered in lexicographical order. 
The index begins at 1.

Example
Given [1,2,4], return 1.


steps:
        [3,7,4,9,1]
smaller [1,2,1,1] put the smaller into the current position
3,7,4,1,x               => 1*1!
3,7,1,x,x               => 1*2!
3,1,x,x,x or 3,4,x,x,x  => 2*3!
1,x,x,x,x               => 1*4!


time = O(n^2)
space = O(1)
*/

public class Solution {
    public long permutationIndex(int[] A) {
        // write your code here
        if (A == null || A.length == 0) {
            return 0;
        }
        long permutation = 1;
        long result = 0;
        for (int i = A.length - 2; i >= 0; i--) {
            int smaller = 0;
            for (int j = i + 1; j < A.length; j++) {
                if (A[j] < A[i]) {
                    smaller++;
                }
            }
            result += smaller * permutation;
            permutation *= (A.length - i);
        }
        return result + 1;
    }
}
