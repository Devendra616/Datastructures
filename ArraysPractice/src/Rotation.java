public class Rotation {

    public static void main(String[] args) {
        Rotation rotate = new Rotation();
        int arr[] = {1,2,3,4,5,6,7,8,9,10,11};
        System.out.println("Before rotation:");
        rotate.printArray(arr,arr.length);
        System.out.println("\nAfter rotation:");
        rotate.leftRotate(arr,3,arr.length);
        rotate.printArray(arr,arr.length);
    }

    /*Utility function to print array*/
    void printArray(int arr[],int n){
        for(int i=0;i<n;i++) {
            System.out.print(arr[i]+ " ");
        }
    }

    void leftRotate(int arr[],int d, int n){
        for(int i=0;i<d;i++){
            leftRotateByOne(arr,n);
        }
    }

    void leftRotateByOne(int arr[],int n){
        int temp = arr[0];
        for(int i=1;i<n;i++){
            arr[i-1] = arr[i];
        }
        arr[n-1] = temp;
    }
}

/*
   Time complexity :  O(n*d)
   Auxillary space: O(1)
 */

