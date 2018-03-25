/*
recursive:
time = O(logn)
space = O(logn)

non-recursive:
time = O(logn)
space = O(1)
*/


// Method 1
public class Solution {
    public double myPow(double x, int n) {
        // time = O(logn), space = O(1)
        if (x == 0) {
            return 0;
        }
        if (n == 0) {
            return 1;
        }
        
        boolean isNegative = false;
        if (n < 0) {
            x = 1 / x;
            isNegative = true;
            // Avoid overflow when n == Integer.MIN_VALUE
            n = -(n + 1); 
        }
        double half = myPow(x, n / 2);
        double ans = half * half;
        
        if (n % 2 == 1) {
            ans *= x;
        }
        
        if (isNegative) {
            ans *= x;
        }
        return ans;
    }
}



// Method 2
public class Solution {
    public double myPow(double x, int n) {
        // time = O(logn), space = O(1)
        if (x == 0) {
            return 0;
        }
        if (n == 0) {
            return 1;
        }
        
        boolean isNegative = false;
        if (n < 0) {
            x = 1 / x;
            isNegative = true;
            // Avoid overflow when n == Integer.MIN_VALUE
            n = -(n + 1); 
        }
        
        double ans = 1;
        double pow = x;
        while (n != 0) {
            if (n % 2 == 1) {
                ans *= pow;
            }
            pow *= pow;
            n /= 2;
        }
        
        if (isNegative) {
            ans *= x;
        }
        return ans;
    }
}
