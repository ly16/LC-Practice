/*1. abcba  
2. no case sensitive 
3. no sign or space sensitive*/

public class Main {

    public static void main(String[] args) {

        String as="aB,c.b A";
        as=as.toLowerCase();//non-sensitive to case
        System.out.println(isPalindromeSimple(as));

    }

    public static boolean isPalindromeSimple(String s) {
        int i=0;
        int j=s.length()-1;
        while (i<j)
        {
            //no signs or space sensitive
            if(!Character.isLetterOrDigit(s.charAt(i)))
            {
                i++;
                continue;
            }
            if(!Character.isLetterOrDigit(s.charAt(j)))
            {
                j--;
                continue;
            }
            //compare characters accordingly
            if(s.charAt(i)!=s.charAt(j))
            {
                return false;
            }
            i++;
            j--;

        }
        return true;
    }
}
