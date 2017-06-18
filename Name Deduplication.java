/*
Given a list of names, remove the duplicate names. Two name will be treated as the same name if they are equal ignore 
the case.

Return a list of names without duplication, all names should be in lowercase, and keep the order in the original list.
Example
Given:

["James", "james", "Bill Gates", "bill Gates", "Hello World", "HELLO WORLD", "Helloworld"]
return:

["james", "bill gates", "hello world", "helloworld"]

*/
public class Solution {
    /**
     * @param names a string array
     * @return a string array
     */
    public List<String> nameDeduplication(String[] names) {
        // Write your code here
        List<String> result = new ArrayList<String>();
        HashMap<String, Integer> mp = new HashMap<String, Integer>();
        for (int i = 0; i < names.length; ++i) {
            String str = names[i].toLowerCase();
            //when mp is empty, put str
            if (!mp.containsKey(str)) {
                mp.put(str, 1);
                result.add(str);
            }
        }
        return result;
    }
}
