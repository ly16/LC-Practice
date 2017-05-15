/*
Implement an ArrayListManager which can:

create(n). Create an ArrayList of integers contains [0, 1, 2, ... n-1]
clone(list). Clone a list. The cloned list should independent with the original list.
get(list, index). Get the element on the index position of the list.
set(list, index, val). Change the value the element of index position to given val.
remove(list, index). Remove the element on the index position.
indexOf(list, val). Find the first index of element that equals to val and return its index.
Please use the methods provided by ArrayList. See documents：ArrayList Document
*/

public class ArrayListManager {
   
    public static ArrayList<Integer> create(int n) {
        // Write your code here
        ArrayList<Integer> list=new ArrayList <Integer>();
        for(int i=0;i<n;i++)
        {
            list.add(i);
        }
        return list;
    }
    

  
    public static ArrayList<Integer> clone(ArrayList<Integer> list) {
        // Write your code here
        ArrayList<Integer> clonelist = new ArrayList<Integer>();
        for(Integer b:list)
        {
            clonelist.add(b);
        }
        return clonelist;
    }
    
 
    public static int get(ArrayList<Integer> list, int k) {
        // Write your code here
        return list.get(k);
    }
    
   
    public static void set(ArrayList<Integer> list, int k, int val) {
        // write your code here
        list.set(k, val);
    }
    
  
    public static void remove(ArrayList<Integer> list, int k) {
        // write tour code here
                list.remove(k);
    }
    
  
    public static int indexOf(ArrayList<Integer> list, int val) {
        // Write your code here
        if(list == null)
            return -1;
        return list.indexOf(val);
    }
}
