/*
Implement strStr function in O(n + m) time.
strStr return the first index of the target string in a source string. 
The length of the target string is m and the length of the source string is n.
If target does not exist in source, just return -1.

Example
Given source = abcdef, target = bcd, return 1.

time = O(n + m)
space = O(1)
*/

public class Solution {
    private final int BASE = 1000000;
    public int strStr2(String source, String target) {
        // write your code here
        if (source == null || target == null) {
            return -1;
        }
        if (source.length() - target.length() < 0) {
            return -1;
        }
        int m = target.length();
        if (m == 0) {
            return 0;
        }
        
        // for remove the earliest element
        int power = 1;
        for (int i = 0; i < m; i++) {
            power = (power * 31) % BASE;
        }
        
        // for target hashCode
        int targetCode = 0;
        for (int i = 0; i < m; i++) {
            targetCode = (targetCode * 31 + target.charAt(i)) % BASE;
        }
        
        // Looking for target in source
        int hashCode = 0;
        for (int i = 0; i < source.length(); i++) {
            hashCode = (hashCode * 31 + source.charAt(i)) % BASE;
            if (i < m - 1) {
                continue;
            }
            
            if (i >= m) {
                hashCode -=  (source.charAt(i - m) * power) % BASE;
                if (hashCode < 0) {
                    hashCode += BASE;
                }
            }
            
            if (hashCode == targetCode) {
                if (source.substring(i - m + 1, i + 1).equals(target)) {
                    return i - m + 1;
                }
            }
        }
        return -1;
    }
}
