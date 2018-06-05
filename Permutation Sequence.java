/*
The set [1,2,3,...,n] contains a total of n! unique permutations.
By listing and labeling all of the permutations in order, we get the following sequence for n = 3:

"123"
"132"
"213"
"231"
"312"
"321"
Given n and k, return the kth permutation sequence.

Note:
Given n will be between 1 and 9 inclusive.
Given k will be between 1 and n! inclusive.

Example 1:
Input: n = 3, k = 3
Output: "213"

Example 2:
Input: n = 4, k = 9
Output: "2314"

explanation:
发现数学规律。
首先先捋捋这道题要干啥，给了我们n还有k，在数列 1，2，3，... , n构建的全排列中，返回第k个排列。
题目告诉我们：对于n个数可以有n!种排列；那么n-1个数就有(n-1)!种排列。
那么对于n位数来说，如果除去最高位不看，后面的n-1位就有 (n-1)!种排列。
所以，还是对于n位数来说，每一个不同的最高位数，后面可以拼接(n-1)!种排列。
所以你就可以看成是按照每组(n-1)!个这样分组。 
利用 k/(n-1)! 可以取得最高位在数列中的index。这样第k个排列的最高位就能从数列中的index位取得，此时还要把这个数从数列中删除。
然后，新的k就可以有k%(n-1)!获得。循环n次即可。
同时，为了可以跟数组坐标对其，令k先--。


time = O(n^n) n scan * n remove from list
space = O(n) for the list
*/

class Solution {
    public String getPermutation(int n, int k) {
        if (n <= 0 || k <= 0) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        // the index is from 0, so k--
        k--;
        // factor (n-1)!
        int factor = 1;
        for (int i = 2; i < n; i++) {
            factor *= i;
        }
        // build a list to check remaining
        List<Integer> num = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            num.add(i);
        }
        
        // 1 to n-1, n-1 times
        for (int i = n - 1; i > 0; i--) {
            int index = k / factor;
            sb.append(num.get(index));
            num.remove(index);
            k = k % factor;     //remaining
            factor = factor / i;    //(n-1)! to (n-2)!
        }
        sb.append(num.get(0));
        return sb.toString();
    }
}
