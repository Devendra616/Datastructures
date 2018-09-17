import java.util.LinkedList;

/*
    Check string is palindrome ignoring space, punctuation and case(Caps/Small). Use Stack
 */
public class CheckPalindrome {

    public static void main(String[] args) {

        String str1 = "Racecar";
        String str2 = "I did, did I?";
        String str3 = "hello";

        CheckPalindrome checkPalindrome = new CheckPalindrome();

        System.out.println(checkPalindrome.isPalindrome(str1));
        System.out.println(checkPalindrome.isPalindrome(str2));
        System.out.println(checkPalindrome.isPalindrome(str3));

    }

    public boolean isPalindrome(String str){

        LinkedList<Character> stack = new LinkedList<Character>();
        String lowerStr = str.toLowerCase();
        StringBuilder noPunchuation = new StringBuilder(str.length());
        for(int i=0;i<lowerStr.length();i++){
            char ch = lowerStr.charAt(i);
            if(ch>='a' && ch<='z'){
                stack.push(ch);
                noPunchuation.append(ch);
            }
        }


        StringBuilder reversed = new StringBuilder(stack.size());
        while (!stack.isEmpty()){
            reversed.append(stack.pop());
        }

        boolean test = reversed.toString().equals(noPunchuation.toString());
        return test;
    }
}
