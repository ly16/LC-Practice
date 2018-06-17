/*
Description
Implement a data structure, provide two interfaces:
add(number). Add a new number in the data structure.
topk(). Return the top k largest numbers in this data structure. k is given when we create the data structure.

Example:
s = new Solution(3);
>> create a new data structure.
s.add(3)
s.add(10)
s.topk()
>> return [10, 3]
s.add(1000)
s.add(-99)
s.topk()
>> return [1000, 10, 3]
s.add(4)
s.topk()
>> return [1000, 10, 4]
s.add(100)
s.topk()
>> return [1000, 100, 10]

time = O(logk) for the add
space = O(k) for the minHeap
*/

public class Solution {
    private PriorityQueue <Integer> minHeap;
    private int maxSize;
    public Solution(int k) {
        // do intialization if necessary
        maxSize = k;
        minHeap = new PriorityQueue<>();
    }


    public void add(int num) {
        // write your code here
        if (minHeap.size() < maxSize) {
            minHeap.offer(num);
        } else if (num > minHeap.peek()) {
            minHeap.poll();
            minHeap.offer(num);
        }
        // if num is less than peek, do nothing
        return;
    }

    public List<Integer> topk() {
        // write your code here
        List<Integer> result = new ArrayList<Integer>();
        for (Integer i : minHeap) {
            result.add(i);
        }
        Collections.sort(result, Collections.reverseOrder());
        return result;
    }
}
