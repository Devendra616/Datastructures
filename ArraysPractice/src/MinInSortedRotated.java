/*
A sorted array is rotated at some unknown point, find the minimum element in it.

Examples:

Input: {5, 6, 1, 2, 3, 4}
Output: 1

Input: {1, 2, 3, 4}
Output: 1

Input: {2, 1}
Output: 1

 */
public class MinInSortedRotated {
    public static void main(String[] args) {
        int arr[] = {7,8,2,3,4,5,6};
        System.out.println("Minimum element is "+ min(arr));
    }

    static int min(int []arr){
        int minimum = arr[0];
        for(int i=1;i<arr.length;i++){
            if(arr[i]<minimum){
                minimum = arr[i];
                return minimum;
            }
        }
        return minimum;
    }
}
