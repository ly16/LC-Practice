/*
A robot is located at the top-left corner of a m x n grid.
The robot can only move either down or right at any point in time. 
The robot is trying to reach the bottom-right corner of the grid.
How many possible unique paths are there?

Example
Given m = 3 and n = 3, return 6.
Given m = 4 and n = 5, return 35.
*/


public class Solution {
    /**
     * @param n, m: positive integer (1 <= n ,m <= 100)
     * @return an integer
     */
    public int uniquePaths(int m, int n) {
        // write your code here 
        int [][] result= new int [m][n];
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(i==0 || j==0){
                    result[i][j]=1;
                }else{
                    result[i][j]=result[i-1][j]+ result[i][j-1];
                }
            }
        }
        return result[m-1][n-1];
    }
}
