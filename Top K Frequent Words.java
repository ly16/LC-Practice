/*
Given a composition with different kinds of words, return a list of the top K most frequent words in the composition.

Assumptions

the composition is not null and is not guaranteed to be sorted
K >= 1 and K could be larger than the number of distinct words in the composition, in this case, just return all the distinct words
Return

a list of words ordered from most frequent one to least frequent one (the list could be of size K or smaller than K)
Examples

Composition = ["a", "a", "b", "b", "b", "b", "c", "c", "c", "d"], top 2 frequent words are [“b”, “c”]
Composition = ["a", "a", "b", "b", "b", "b", "c", "c", "c", "d"], top 4 frequent words are [“b”, “c”, "a", "d"]
Composition = ["a", "a", "b", "b", "b", "b", "c", "c", "c", "d"], top 5 frequent words are [“b”, “c”, "a", "d"]

time:
insert O((n-k)log(k))
heapify O(k)
time = O(k + (n-k)log(k))

space:
hashMap: O(n)
MinHeap: O(k)
space = O(n+k) = O(n)
*/


public class Solution {
  public String[] topKFrequent(String[] combo, int k) {
    // Write your solution here.
    if (combo.length == 0) {
      return new String[0];
    }
    Map<String, Integer> freqMap = getMap(combo);
    PriorityQueue<Map.Entry<String, Integer>> minHeap = new PriorityQueue<>(k, new Comparator<Map.Entry<String, Integer>>() {
      @Override
      public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
        if (o1.getValue() == o2.getValue()) {
          return 0;
        } 
        return o1.getValue() < o2.getValue() ? -1 : 1;
      }
    });
    for (Map.Entry<String, Integer> entry : freqMap.entrySet()) {
      if (minHeap.size() < k) {
        minHeap.offer(entry);
      } else if (entry.getValue() > minHeap.peek().getValue()) {
        minHeap.poll();
        minHeap.offer(entry);
      }
    }
    return freqArray(minHeap);
  }
  private Map<String, Integer> getMap(String[] combo) {
    Map<String, Integer> freqMap = new HashMap<>();
    for (String s : combo) {
      Integer freq = freqMap.get(s);
      if (freq != null) {
        freqMap.put(s, freq + 1);
      } else {
        freqMap.put(s, 1);
      }
    }
    return freqMap;
  }
  private String[] freqArray(PriorityQueue<Map.Entry<String, Integer>> minHeap) {
    String[] array = new String[minHeap.size()];
    for (int i = minHeap.size() - 1; i >= 0; i--) {
      array[i] = minHeap.poll().getKey();
    }
    return array;
  }
}
