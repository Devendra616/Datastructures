import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

/*
    check palindrome using queue and stack jdk
    Push each element in stack and queue and pop elements from stack comparing with queue top element

 */
public class Palindrome {

    public static void main(String[] args) {

        String test1="I did, did I?";
        String test2 = "Racecar";
        String test3="hello";

        Palindrome palindrome = new Palindrome();
        System.out.println(palindrome.isPalindrome(test1));
        System.out.println(palindrome.isPalindrome(test2));
        System.out.println(palindrome.isPalindrome(test3));
    }

    public boolean isPalindrome(String string){
        String lowercase = string.toLowerCase();
        Queue queue = new ArrayDeque();
        Stack<Character> stack = new Stack<Character>();
        int i=0;char ch;
        while (i<lowercase.length()){
            ch = lowercase.charAt(i);
            if(ch>='a'&&ch<='z'){
                ((ArrayDeque) queue).add(ch);
                stack.push(ch);
            }
            i++;
        }

        while (queue.size()>0){
            if(!stack.pop().equals(queue.remove())){
                return false;
            }
        }
        return true;


    }
}
