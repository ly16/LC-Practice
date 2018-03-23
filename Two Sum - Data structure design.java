/*
Design and implement a TwoSum class. It should support the following operations: add and find.

add - Add the number to an internal data structure.
find - Find if there exists any pair of numbers which sum is equal to the value.

Example
add(1); add(3); add(5);
find(4) // return true
find(7) // return false

time = O(n) n is the size of list
space = O(n) n is the size of list and map
*/

public class TwoSum {
    // time = O(n), space = O(n)
    private List<Integer> list = new ArrayList<>();
    private Map<Integer, Integer> map = new HashMap<>();
    
    public void add(int number) {
        if (map.containsKey(number)) {
            map.put(number, map.get(number) + 1);
        } else {
            map.put(number, 1);
            list.add(number);
        }
    }

    public boolean find(int value) {
        for (int i = 0; i < list.size(); i++) {
            int num = list.get(i);
            int remain = value - num;
            if ((num == remain && map.get(num) >= 2) || 
            (num != remain && map.containsKey(remain))) {
                return true;
            }
        }
        return false;
    }
}
