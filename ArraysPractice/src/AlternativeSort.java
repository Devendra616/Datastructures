import java.util.Arrays;

/*
    Given an array of integers, print the array in such a way that the first element is first maximum and
    second element is first minimum and so on.

Examples :

Input : arr[] = {7, 1, 2, 3, 4, 5, 6}
Output : 7 1 6 2 5 3 4

Input : arr[] = {1, 6, 9, 4, 3, 7, 8, 2}
Output : 9 1 8 2 7 3 6 4
 */
public class AlternativeSort {

    public static void main(String[] args) {
        int arr[] =  {7, 1, 2, 3, 4, 5, 6};
        Arrays.sort(arr);
        int n = arr.length;
        int i =0, j= n-1;
        while(i < j){
            System.out.print(arr[j--]+ " "+arr[i++]+" ");
        }
        if(n%2 == 1){ //if odd length then print mid element once
            System.out.print(arr[i]);
        }

    }

}

/*
    Time Complexity: O(n Log n) for sorting
    Auxiliary Space : O(1)

 */
