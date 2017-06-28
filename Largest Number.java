/*
Given a list of non negative integers, arrange them such that they form the largest number.
Example
Given [1, 20, 23, 4, 8], the largest formed number is 8423201.
*/
public class Solution {
    /**
     *@param num: A list of non negative integers
     *@return: A string
     */
    
    public String largestNumber(int[] num) {
        // write your code here
        String[] str= new String[num.length];
        for(int i=0; i<num.length; i++){
            str[i]= Integer.toString(num[i]);
        }
        Arrays.sort(str, new NumberComparator());

        StringBuilder sb= new StringBuilder();
        for (int i = 0; i < str.length; i++) {
            sb.append(str[i]);
        }
        String result = sb.toString();

        int index=0;
        while (index < result.length() && result.charAt(index) == '0') {
            index++;
        }
        if (index == result.length()) {
            return "0";
        }
        return result.substring(index);
    }
    
    class NumberComparator implements Comparator<String>{
        @Override
        public int compare(String str1, String str2){
            return (str2+str1).compareTo(str1+str2);
            //if (str1+str2).compareTo(str1+str2), result is smamllest
        }
    }
    
}
