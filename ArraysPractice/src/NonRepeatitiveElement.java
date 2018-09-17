/*
    Given an array of integers. All numbers occur twice except one number which occurs once. Find the number in O(n) time & constant extra space.

Example :

Input:  ar[] = {7, 3, 5, 4, 5, 3, 4}
Output: 7
 */

import java.util.Enumeration;
import java.util.Hashtable;

/* Hashing
    1) Traverse all elements and put them in a hash table. Element is used as key and count of occurrences is used as value in hash table.
2) Traverse the array again and print the element with count 1 in hash table.
This solution works in O(n) time, but requires extra space.
 */
public class NonRepeatitiveElement {

    public static void main(String[] args) {
         int arr[] = {2,4,2,6,4,7,3,7};

        Hashtable<Integer,Integer> ht  = new Hashtable<>();
        for(int i=0;i<arr.length;i++){
            int newVal =1;
            if(ht.containsKey(arr[i])){
                newVal = ht.get(arr[i])+1;
            }
            ht.put(arr[i],newVal);
        }
        int key;
        Enumeration elements;
        elements = ht.keys();
        int value;
        while (elements.hasMoreElements()){
            key = (int)elements.nextElement();
            value = ht.get(key);
            if(value== 1){
                System.out.print(key + " ");
            }
        }
    }

}
/*
    Time Complexity: O(n)
    Space: O(n) unique keys
 */