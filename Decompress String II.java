/*
Given a string in compressed form, decompress it to the original string. The adjacent repeated characters in the original string are compressed to have the character followed by the number of repeated occurrences.

Assumptions
The string is not null
The characters used in the original string are guaranteed to be ‘a’ - ‘z’
There are no adjacent repeated characters with length > 9

Examples
“a1c0b2c4” → “abbcccc”

time = O(n)
space = O(1)  // except a new char array
*/

public class Solution {
    public String decompress(String input) {
        // Write your solution here.
        if (input == null || input.length() == 0) {
            return input;
        }
        char[] array = input.toCharArray();
        return deLong(array, deShort(array));
    }

    private int deShort(char[] array) {
        int slow = 0;
        for (int fast = 0; fast < array.length; fast += 2) {
            int digit = getDigit(array[fast + 1]);
            if (digit >= 0 && digit <= 2) {
                for (int i = 0; i < digit; i++) {
                    array[slow++] = array[fast];
                }
            } else {
                array[slow++] = array[fast];
                array[slow++] = array[fast + 1];
            }
        }
        return slow;
    }

    private String deLong(char[] array, int length) {
        int newLength = length;
        for (int i = 0; i < length; i++) {
            int digit = getDigit(array[i]);
            if (digit > 2 && digit <= 9) {
                newLength += digit - 2;
            }
        }
        char[] result = new char[newLength];
        int slow = length - 1;
        int fast = newLength - 1;
        while (slow >= 0) {
            int digit = getDigit(array[slow]);
            if (digit > 2 && digit <= 9) {
                slow--;
                for (int j = 0; j < digit; j++) {
                    result[fast--] = array[slow];
                }
                slow--;
            } else {
                result[fast--] = array[slow--];
            }
        }
        return new String(result);
    }

    private int getDigit(char ch) {
        return ch - '0';
    }
}
