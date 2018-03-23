/*
Prime factorize a given integer.

Example
Given 10, return [2, 5].
Given 660, return [2, 2, 3, 5, 11].

time = O(sqrt(n))
space = O(logn) for the new list
*/


public class Solution {
    public List<Integer> primeFactorization(int num) {
        // time = O(sqrt(n)), space = O(logn) for the result list
        List<Integer> result = new ArrayList<>();
        if (num <= 1) {
            return result;
        }
        int upper = (int) Math.sqrt(num);
        for (int i = 2; i <= upper && i > 1; i++) {
            while (num % i == 0) {
                num /= i;
                result.add(i);
            }
        }
        if (num > 1) {
            result.add(num);
        }
        return result;
    }
}
