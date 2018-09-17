/*
To handle multiple queries of array rotation. Print the array by iterating the elements.
 */

public class EfficientRotation {

    public static void main(String[] args) {
        int arr[] = {1,2,3,4,5,6,7,8,9};
        int n = arr.length;
        leftRotate(arr,0);
        System.out.println();
        leftRotate(arr,2);
        System.out.println();
        leftRotate(arr,15);
        System.out.println();
    }

    static void leftRotate(int []ar,int d){
        int n = ar.length;
        for(int i=d;i<n+d;i++){
            System.out.print(ar[i%n]+" ");
        }
    }

}
/*
    Time complexity : O(n) for printing
                      O(1) for locating
    Auxillary space : O(1)
 */