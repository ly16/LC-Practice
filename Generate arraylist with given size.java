/*
Generate an arrayList with given size, initialize the array list with numbers from 1 to size.
eg
Given size = 4. return an array list that contains numbers from 1 to 4: [1,2,3,4]
*/

public class Solution {
    /**
     * @param size an integer
     * @return an array list
     */
    public ArrayList<Integer> generate(int size) {
        // Write your code here
        ArrayList<Integer> list= new ArrayList<Integer>();
        for(int i=1;i<=size;i++){
            list.add(i);
        }
        return list;
    }
}
