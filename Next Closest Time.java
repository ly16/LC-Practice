/*
Given a time represented in the format "HH:MM", form the next closest time by reusing the current digits. 
There is no limit on how many times a digit can be reused.

You may assume the given input string is always valid. For example, "01:34", "12:09" are all valid. 
"1:34", "12:9" are all invalid.

Example 1:
Input: "19:34"
Output: "19:39"
Explanation: The next closest time choosing from digits 1, 9, 3, 4, is 19:39, which occurs 5 minutes later.  
It is not 19:33, because this occurs 23 hours and 59 minutes later.

Example 2:
Input: "23:59"
Output: "22:22"
Explanation: The next closest time choosing from digits 2, 3, 5, 9, is 22:22. 
It may be assumed that the returned time is next day's time since it is smaller than the input time numerically.

time = O(n^n)
space = O(n)
*/

class Solution {
    int diff = Integer.MAX_VALUE;
    String result ="";
    public String nextClosestTime(String time) {
        Set<Integer> set = new HashSet<>();
        set.add(Integer.parseInt(time.substring(0, 1)));
        set.add(Integer.parseInt(time.substring(1, 2)));
        set.add(Integer.parseInt(time.substring(3, 4)));
        set.add(Integer.parseInt(time.substring(4, 5)));

        if (set.size() == 1) {
            return time;
        }

        List<Integer> digits = new ArrayList<>(set);
        int minute = Integer.parseInt(time.substring(0, 2)) * 60 + Integer.parseInt(time.substring(3));

        dfs(digits, "", 0, minute);
        return result;
    }

    private void dfs(List<Integer> digits, String cur, int pos, int target) {
        if (pos == 4) {
            int m = Integer.parseInt(cur.substring(0, 2)) * 60 + Integer.parseInt(cur.substring(2));
            if (m == target) {
                return;
            }
            int d = m - target > 0 ? m - target : 1440 + m - target;    // 60*24 = 1440
            if (d < diff) {
                diff = d;
                result = cur.substring(0, 2) + ":" + cur.substring(2);
            }
            return;
        }

        for (int i = 0; i < digits.size(); i++) {
            if (pos == 0 && digits.get(i) > 2) {
                continue;
            } else if (pos == 1 && Integer.parseInt(cur) * 10 + digits.get(i) > 23) {
                continue;
            } else if (pos == 2 && digits.get(i) > 5) {
                continue;
            } else if (pos == 3 && Integer.parseInt(cur.substring(2)) * 10 + digits.get(i) > 59) {
                continue;
            }
            dfs(digits, cur + digits.get(i), pos + 1, target);
        }
    }
}
