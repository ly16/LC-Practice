/*
Given two integers a and b, an operator, choices:
+, -, *, /
Calculate a <operator> b.

Example
For a = 1, b = 2, operator = +, return 3.
For a = 10, b = 20, operator = *, return 200.
For a = 3, b = 2, operator = /, return 1. (not 1.5)
For a = 10, b = 11, operator = -, return -1.
*/
public class Calculator {
    /**
      * @param a, b: Two integers.
      * @param operator: A character, +, -, *, /.
      */
    public int calculate(int a, char operator, int b) {
        /* your code */
        switch(operator)
        {
            case '+': return a+b;
            case '-': return a-b;
            case '*': return a*b;
            case '/': return a/b;
            default: return 0;
        }
    }
}
