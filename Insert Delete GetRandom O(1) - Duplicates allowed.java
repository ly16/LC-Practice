 /*
Design a data structure that supports all following operations in average O(1) time.
Note: Duplicate elements are allowed.
insert(val): Inserts an item val to the collection.
remove(val): Removes an item val from the collection if present.
getRandom: Returns a random element from current collection of elements. 
The probability of each element being returned is linearly related to the number of same value the collection contains.

Example:
// Init an empty collection.
RandomizedCollection collection = new RandomizedCollection();

// Inserts 1 to the collection. Returns true as the collection did not contain 1.
collection.insert(1);

// Inserts another 1 to the collection. Returns false as the collection contained 1. Collection now contains [1,1].
collection.insert(1);

// Inserts 2 to the collection, returns true. Collection now contains [1,1,2].
collection.insert(2);

// getRandom should return 1 with the probability 2/3, and returns 2 with the probability 1/3.
collection.getRandom();

// Removes 1 from the collection, returns true. Collection now contains [1,2].
collection.remove(1);

// getRandom should return 1 and 2 both equally likely.
collection.getRandom();

 
 time = O(1) average
 space = O(n)
 */
 
 class RandomizedCollection {
    class NumberAndIndex {
        public int number, index;
        public NumberAndIndex(int number, int index) {
            this.number = number;
            this.index = index;
        }
    }
    private Map<Integer, List<Integer>> map;
    private java.util.Random rand = new java.util.Random();
    private List<NumberAndIndex> nums;
    /** Initialize your data structure here. */
    public RandomizedCollection() {
        map = new HashMap<>();
        nums = new ArrayList<>();
    }
    
    /** Inserts a value to the collection. Returns true if the collection did not already contain the specified element. */
    public boolean insert(int val) {
        // not exist
        boolean exist = map.containsKey(val);
        if (!exist) {
            map.put(val, new ArrayList<Integer>());
        }
        // existed
        List<Integer> indeces = map.get(val);  
        // update indeces in map and arraylist nums
        indeces.add(nums.size());
        nums.add(new NumberAndIndex(val, nums.size() - 1));
        return !exist;
    }
    
    /** Removes a value from the collection. Returns true if the collection contained the specified element. */
    public boolean remove(int val) {
        if (!map.containsKey(val)) {
            return false;
        }
        // find the target
        List<Integer> indeces = map.get(val);
        int targetIndex = indeces.get(indeces.size() - 1);
        NumberAndIndex lastIndex = nums.get(nums.size() - 1);
        // last overwrite the target, and remove the last one = remove the target index
        nums.set(targetIndex, lastIndex);
        nums.remove(nums.size() - 1);
        map.get(lastIndex.number).set(lastIndex.index)
    }
    
    /** Get a random element from the collection. */
    public int getRandom() {
        return nums.get(rand.nextInt(nums.size())).number;
    }
}

/**
 * Your RandomizedCollection object will be instantiated and called as such:
 * RandomizedCollection obj = new RandomizedCollection();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
