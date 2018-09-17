/*
Given an array, only rotation operation is allowed on array. We can rotate the array as many times as we want.
Return the maximum possible of summation of i*arr[i].

Examples :

Input: arr[] = {1, 20, 2, 10}
Output: 72
We can 72 by rotating array twice.
{2, 10, 1, 20}
20*3 + 1*2 + 10*1 + 2*0 = 72

Input: arr[] = {10, 1, 2, 3, 4, 5, 6, 7, 8, 9};
Output: 330
We can 330 by rotating array 9 times.
{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
0*1 + 1*2 + 2*3 ... 9*10 = 330
 */

public class MaxSum {

    public static void main(String[] ar){
        int []arr = {1,2,3,4,5,6,7,8,9,10};

        MaxSum obj= new MaxSum();
        System.out.println("Array is :");
        obj.printArray(arr,arr.length);
        System.out.println("Maximum sum: "+sum(arr));
    }

    /*Utility function to print array*/
    void printArray(int arr[],int n){
        for(int i=0;i<n;i++) {
            System.out.print(arr[i]+ " ");
        }
    }

    static int sum(int []arr){
        int curMax=0,arrSum=0,maxVal=0;
        for(int i=0;i<arr.length;i++){
            curMax += i*arr[i];
            arrSum += arr[i];
        }
        maxVal = curMax;
        int n= arr.length;
        for(int i=1;i<n;i++){
            curMax = curMax + arrSum - n*arr[n-i];
            if(curMax> maxVal){
                maxVal = curMax;
            }
        }
        return  maxVal;
    }

}
/*
Time Complexity : O(n)
Auxillary space: O(1)
 */

/*
Let us calculate initial value of i*arr[i] with no rotation
R0 = 0*arr[0] + 1*arr[1] +...+ (n-1)*arr[n-1]

After 1 rotation arr[n-1], becomes first element of array,
arr[0] becomes second element, arr[1] becomes third element
and so on.
R1 = 0*arr[n-1] + 1*arr[0] +...+ (n-1)*arr[n-2]

R1 - R0 = arr[0] + arr[1] + ... + arr[n-2] - (n-1)*arr[n-1]

After 2 rotations arr[n-2], becomes first element of array,
arr[n-1] becomes second element, arr[0] becomes third element
and so on.
R2 = 0*arr[n-2] + 1*arr[n-1] +...+ (n?1)*arr[n-3]

R2 - R1 = arr[0] + arr[1] + ... + arr[n-3] - (n-1)*arr[n-2] + arr[n-1]

If we take a closer look at above values, we can observe
below pattern

Rj - Rj-1 = arrSum - n * arr[n-j]

Where arrSum is sum of all array elements,
 */
