/*
Given two integer arrays A1 and A2, sort A1 in such a way that the relative order among the elements will be same as 
those are in A2.
For the elements that are not in A2, append them in the right end of the A1 in an ascending order.

Assumptions:
A1 and A2 are both not null.
There are no duplicate elements in A2.

Examples:
A1 = {2, 1, 2, 5, 7, 1, 9, 3}, A2 = {2, 1, 3}, A1 is sorted to {2, 2, 1, 1, 3, 5, 7, 9}

time = O(mlog(m))
space = O(n + m)  Integer_array and map
*/

public class Solution {
    static class MyComparator implements Comparator<Integer> {
        private Map<Integer, Integer> map;
    public MyComparator (int[] array) {
            map = new HashMap<>();
            for (int i = 0; i < array.length; i++) {
                map.put(array[i], i);
            }
        }

        @Override
        public int compare(Integer i1, Integer i2) {
            Integer index1 = map.get(i1);
            Integer index2 = map.get(i2);
            if (index1 != null && index2 != null) {
                return index1.compareTo(index2);
            } else if (index1 == null && index2 == null) {
                return i1.compareTo(i2);
            }
            return index1 == null ? 1 : -1;
        }
    }
    public int[] sortSpecial(int[] A1, int[] A2) {
        // Write your solution here.
        Integer[] array1 = ToInteger(A1);
        Arrays.sort(array1, new MyComparator(A2));
        ToArray(array1, A1);  //todo
        return A1;
    }

    private Integer[] ToInteger(int[] A1) {
        Integer[] result = new Integer[A1.length];
        for (int i = 0; i < A1.length; i++) {
            result[i] = A1[i];
        }
        return result;
    }

    private void ToArray(Integer[] array1, int[] A1) {
        for (int i = 0; i < A1.length; i++) {
            A1[i] = array1[i];
        }
    }
}
