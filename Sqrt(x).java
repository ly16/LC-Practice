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


class Solution {
    public int mySqrt(int x) {
        // assume x >= 0
        // last occurence
        if (x == 0) {
            return 0;
        }
        long left = 1, right = x;
        while (left + 1 < right) {
            long mid = left + (right - left) / 2;
            if (mid * mid == x) {
                return (int) mid;
            } else if (mid * mid < x) {
                left = mid;
            } else {
                right = mid;
            }
        }
        
        if (right * right < x) {
            return (int) right;
        } else {
            return (int) left;
        }
    }
}
