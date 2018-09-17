/*
Let AB are the two parts of the input array where A = arr[0..d-1] and B = arr[d..n-1].
The idea of the algorithm is :

Reverse A to get ArB, where Ar is reverse of A.
Reverse B to get ArBr, where Br is reverse of B.
Reverse all to get (ArBr) r = BA.
 */


public class RotationWithReverse {

    public static void main(String[] args) {
        RotationWithReverse obj = new RotationWithReverse();
        int arr[] = {1,2,3,4,5,6,7,8,9,10};
        System.out.println("Before rotation:");
        obj.printArray(arr,arr.length);
        System.out.println("\nAfter rotation:");
        obj.leftRotate(arr,13);
        obj.printArray(arr,arr.length);
    }

    static void printArray(int arr[],int n){
        for(int i=0;i<n;i++) {
            System.out.print(arr[i]+ " ");
        }
        System.out.println();
    }

    static void reverseArray(int ar[],int start, int end){
        int temp;
        while (start < end){
            temp = ar[start];
            ar[start] =  ar[end];
            ar[end]= temp;
            start++;
            end--;
        }
    }

    static void leftRotate(int ar[],int d){
        d=d% ar.length; //when d > length of array
        int n = ar.length;
        reverseArray(ar,0,d-1);
        reverseArray(ar,d,n-1);
        reverseArray(ar,0,n-1);
    }
}

/*
    Time complexity : O(n)
    Auxillary space: O(1)
 */



