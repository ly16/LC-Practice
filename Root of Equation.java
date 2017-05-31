/*
Given an equation: ax2 + bx + c = 0. Find the root of the equation.

If there are two roots, return a list with two roots in it.
If there are only one root, return a list with only one root in it.
If there are no root for the given equation, return an empty list.


Example
Given a = 1, b = -2, c = 1. return [1].

Given a = 1, b = -3, c = 2. return [1, 2]. The first one should smaller than the second.

Given a = 1, b = 1, c = 1. return [].

*/
public class Solution {
    /**
     * @param a, b, c: parameters of the equation
     * @return a double array, contains at most two root
     */
    public double[] rootOfEquation(double a, double b, double c) {
        // Write your code here
        double delta= b*b-4*a*c;
        
        if(delta<0){
            return new double[0];
        }else if(delta==0){
            double[] root= new double[1];
            root[0]=-b/(2.0*a);
            return root;
        }else{
            double delta1=Math.sqrt(delta);
            double[] root= new double[2];
            root[0]= (-b-delta1)/(2.0*a);
            root[1]= (-b+delta1)/(2.0*a);
            // smaller root comes out first
            if(root[0]>root[1]){
                double temp=root[0];
                root[0]=root[1];
                root[1]=temp;
            }
            
            return root;
        }
        
    }
}
