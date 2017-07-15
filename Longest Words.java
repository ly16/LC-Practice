/*
Given a dictionary, find all of the longest words in the dictionary.

Example
Given

{
  "dog",
  "google",
  "facebook",
  "internationalization",
  "blabla"
}
the longest words are(is) ["internationalization"].

Given

{
  "like",
  "love",
  "hate",
  "yes"
}
the longest words are ["like", "love", "hate"].


*/

class Solution {
    /**
     * @param dictionary: an array of strings
     * @return: an arraylist of strings
     */
    ArrayList<String> longestWords(String[] dictionary) {
        // write your code here
        int max=0;
        ArrayList<String> answer= new ArrayList<>();
        //find the max length
        for (int i=0; i<dictionary.length;i++) 
            if (dictionary[i].length()>max) max = dictionary[i].length();
        //return the answer
        for (int i=0; i<dictionary.length;i++)
            if (dictionary[i].length()==max) answer.add(dictionary[i]);
        return answer;
    }
}
