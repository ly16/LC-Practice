/*
Implement a least recently used cache. It should provide set(), get() operations. 
If not exists, return null (Java), false (C++).


time = O(1)
space = O(n)
*/

public class Solution<K, V> {
  // limit is the max capacity of the cache
  static class Node<K, V> {
  	Node<K, V> next;
    Node<K, V> prev;
    K key;
    V value;
    
    Node(K key, V value) {
    	this.key = key;
      this.value = value;
    }
    void update (K key, V value) {
    	this.key = key;
      this.value = value;
    }
  }
  private final int limit;
  private Node<K, V> head;
  private Node<K, V> tail;
  private Map<K, Node<K, V>> map;
  public Solution(int limit) {
    this.limit = limit;
    this.map = new HashMap<K, Node<K, V>>();
  }
  
  public void set(K key, V value) {
    Node<K, V> node = null;
    if (map.containsKey(key)) {
    	node = map.get(key);
      node.value = value;
      remove(node);
    } else if (map.size() < limit) {
    	node = new Node<K, V>(key, value);
    } else {
    	node = tail;
      remove(node);
      node.update(key, value);
    }
    append(node);
  }
  
  public V get(K key) {
    Node<K, V> node = map.get(key);
    if (node == null) {
    	return null;
    }
    remove(node);
    append(node);
    return node.value;
  }
  
  private Node<K, V> remove(Node<K, V> node) {
  	map.remove(node.key);
    if (node.prev != null) {
    	node.prev.next = node.next;
    }
    if (node.next != null) {
    	node.next.prev = node.prev;
    }
    if (node == head) {
    	head = head.next;
    }
    if (node == tail) {
    	tail = tail.prev;
    }
    node.next = node.prev = null;
    return node;
  }
  
  private Node<K, V> append(Node<K, V> node) {
  	map.put(node.key, node);
    if (head == null) {
    	head = tail = node;
    } else {
    	node.next = head;
      head.prev = node;
      head = node;
    }
    return node;
  }
}



// leetcode version
class LRUCache {
    private class Node {
        Node prev;
        Node next;
        int key;
        int value;
        
        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
        
        void update(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }
    
    private final int capacity;
    private Node head;
    private Node tail;
    private Map<Integer, Node> map;
    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();
    }
    
    
    public int get(int key) {
        Node node = map.get(key);
        if (node == null) {
            return -1;
        }
        remove(node);
        append(node);
        return node.value;
    }
    
    public void append(Node node) {
        map.put(node.key, node);
        if (head == null) {
            head = tail = node;
        } else {
            node.next = head;
            head.prev = node;
            head = node;
        }
    }
    
    public void remove(Node node) {
        map.remove(node.key);
        if (node.prev != null) {
            node.prev.next = node.next;
        }
        if (node.next != null) {
            node.next.prev = node.prev;
        }
        if (node == head) {
            head = head.next;
        }
        if (node == tail) {
            tail = tail.prev;
        }
        node.prev = node.next = null;
    }
    
    public void put(int key, int value) {
        Node node = null;
        if (map.containsKey(key)) {
            node = map.get(key);
            node.value = value;
            remove(node);
        } else if (map.size() < capacity){
            node = new Node(key, value);
        } else {
            node = tail;
            remove(node);
            node.update(key, value);
        }
        append(node);
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
