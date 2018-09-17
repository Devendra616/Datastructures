import java.util.Arrays;

public class QuickSort {

    public static void main(String[] args) {
        int[] x = { 9, 2, 4, 7, 3, 7, 10 };
        System.out.println(Arrays.toString(x));
        quickSort(x,0,x.length-1);
        System.out.println(Arrays.toString(x));
    }

    public static void quickSort(int[] arr,int low, int high){

        if(arr == null || arr.length == 0){
            return;
        }
        partition(arr,low,high);
    }

    public static void partition(int[] arr,int low, int high){

        int l = low;
        int h = high;
        int middle = (low+high)/2;

        int pivot = arr[middle];

   /* In each iteration, we will identify a number from left side which
    is greater then the pivot value, and a number from right side which is less then the pivot value.
    Once search is complete, we can swap both numbers.
    */
        int temp;
        while(l<=h){

            while (arr[l] < pivot){
                l++;
            }
            while (arr[h]> pivot){
                h--;
            }
            if(l <= h){ //swap
                temp = arr[l];
                arr[l]=arr[h];
                arr[h] = temp;

                l++; //move index to next position
                h--;
            }
        }//end of while loop

        //call partition recursively
        if(low<h) {
            partition(arr,low,h);
        }
        if(l<high){
            partition(arr,l,high);
        }
    }
}

/*
    inPlace sorting - doesn't require any extra array space
    Divide and Conquer Algo
    Time Complexity : Average : O(nlog n)  ----- log base 2
                      Worst : O(n*n)
    Unstable Sorting - similar elements may change place
 */
