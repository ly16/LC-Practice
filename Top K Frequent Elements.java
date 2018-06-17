/*
Given a non-empty array of integers, return the k most frequent elements.
For example,
Given [1,1,1,2,2,3] and k = 2, return [1,2].

Note: 
You may assume k is always valid, 1 ≤ k ≤ number of unique elements.
Your algorithm's time complexity must be better than O(n log n), where n is the array's size.

heap medthod:
time = O(n + nlogk) = O(nlogk) put into the map and heap
space = O(n) for the heap

bucket sort:
time = O(n) for map
space = O(n) for the map and list
*/

// medthod1: heap version
class Solution {
    public List<Integer> topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> freqMap = new HashMap<>();
        for (int num : nums) {
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }
        PriorityQueue<Map.Entry<Integer, Integer>> minHeap = new PriorityQueue<>(k, new Comparator<Map.Entry<Integer, Integer>>() {
            @Override
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                if (o1.getValue().equals(o2.getValue())) {
                    return 0;
                }
                return o1.getValue() < o2.getValue() ? -1 : 1;
            }
        });
        for (Map.Entry<Integer, Integer> entry : freqMap.entrySet()) {
            int tmp = entry.getValue();
            if (minHeap.size() < k) {
                minHeap.add(entry);
            } else if (tmp > minHeap.peek().getValue()) {
                minHeap.poll();
                minHeap.add(entry);
            }
        }

        List<Integer> result = new ArrayList<>();
        while (minHeap.size() > 0) {
            result.add(minHeap.poll().getKey());
        }
        Collections.reverse(result);
        return result;
    }
}


// method2: Bucket Sort version
class Solution {
    public List<Integer> topKFrequent(int[] nums, int k) {
        List<Integer>[] record = new List[nums.length + 1];
        Map<Integer, Integer> freqMap = new HashMap<>();
        
        for (int num : nums) {
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }
        
        for (int key : freqMap.keySet()) {
            int freq = freqMap.get(key);
            if (record[freq] == null) {
                record[freq] = new ArrayList<>();
            }
            record[freq].add(key);
        }
        List<Integer> result = new ArrayList<>();
        for (int i = record.length - 1; i >= 0 && result.size() < k; i--) {
            if (record[i] != null) {
                result.addAll(record[i]);
            }
        }
        return result;
    }
}
