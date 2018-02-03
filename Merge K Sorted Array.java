/*
Merge K sorted array into one big sorted array in ascending order.

Assumptions
The input arrayOfArrays is not null, none of the arrays is null either.

time = O(kn*log(k))   
space = O(k)  //heap
*/

public class Solution {
  public int[] merge(int[][] arrayOfArrays) {
    // Write your solution here
  	    PriorityQueue<Entry> minHeap = new PriorityQueue<Entry>(11, new MyComparator());
        int length = 0;
        for (int i = 0; i < arrayOfArrays.length; i++) {
            int[] array = arrayOfArrays[i];
            length += array.length;
            if (array.length != 0) {
                minHeap.offer(new Entry(i, 0, array[0]));
            }
        }
        int[] result = new int[length];
        int cur = 0;
        while (!minHeap.isEmpty()) {
            Entry tmp = minHeap.poll();
            result[cur++] = tmp.value;
            if (tmp.y + 1 < arrayOfArrays[tmp.x].length) {
                tmp.y++;
                tmp.value = arrayOfArrays[tmp.x][tmp.y];
                minHeap.offer(tmp);
            }
        }
        return result;
  }

    static class MyComparator implements Comparator<Entry> {
        @Override
        public int compare(Entry e1, Entry e2) {
            if (e1.value == e2.value) {
                return 0;
            }
            return e1.value < e2.value ? -1 : 1;
        }
    }

    static class Entry {
        int x;
        int y;
        int value;

        Entry(int x, int y, int value) {
            this.x = x;
            this.y = y;
            this.value = value;
        }
    }
  
}
