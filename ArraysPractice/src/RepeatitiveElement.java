import java.util.HashSet;
import java.util.Set;

/*
    We are given an array arr[] of size n. Numbers are from 1 to (n-1) in random order. The array has only one repetitive element. We need to find the repetitive element.

Examples :

Input  : a[] = {1, 3, 2, 3, 4}
Output : 3

Input  : a[] = {1, 5, 1, 2, 3, 4}
Output : 1
 */
public class RepeatitiveElement {

    public static void main(String[] args) {

        int arr[] = {2,3,4,8,6,3,10,8};

        Set<Integer> hashSet = new HashSet<Integer>();
        for(int i=0;i<arr.length;i++){
            if(hashSet.contains(arr[i])){
                System.out.print(arr[i]+" ");
            }else{
                hashSet.add(arr[i]);
            }
        }
    }

}
/*
    Time Complexity: O(n)
    Auxiliary Space: O(n)
 */
