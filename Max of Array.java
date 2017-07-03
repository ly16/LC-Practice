/*
Given an array with couple of float numbers. Return the max value of them.

Example
Given [1.0, 2.1, -3.3], return 2.1.
*/

public class Solution {
    /**
     * @param A a float array
     * @return a float number
     */
    public float maxOfArray(float[] A) {
        // Write your code here
        float max=A[0];
        for(int i=1;i<A.length;i++)
        {
            if(A[i]>=max)
            {
                max=A[i];
            }
        }
        return max;
    }
}
