/*
Implement int sqrt(int x).
Compute and return the square root of x.

Example
sqrt(3) = 1
sqrt(4) = 2
sqrt(5) = 2
sqrt(10) = 3

time = O(logn)
space = O(1)
*/

public class Solution {
    public int sqrt(int x) {
        // time = O(logn), space = O(1)
        // last occurance
        if (x < 0) {
            return -1;
        }
        if (x == 0 || x == 1) {
            return x;
        }
        int left = 1;
        int right = x;
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            if (1L * mid * mid <= x) {
                left = mid;
            } else {
                right = mid;
            }
        }
        if (1L * right * right <= x) {
            return right;
        }
        return left;
    }
}
