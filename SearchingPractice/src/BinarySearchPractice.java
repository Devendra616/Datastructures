import java.util.Arrays;

public class BinarySearchPractice {

    public static void main(String[] args) {
        int []arr = {6,-7,48,20,14,3,45,5};

        System.out.println("Item -7 found at :"+binarySearchIterative(arr,-7));
        System.out.println("Item 5 found at :"+binarySearchIterative(arr,5));
        System.out.println("Item 54 found at :"+binarySearchIterative(arr,54));

        System.out.println("----Recursive Search-----");
        System.out.println("Item -7 found at :"+binarySearchIterative(arr,-7));
        System.out.println("Item 5 found at :"+binarySearchIterative(arr,5));
        System.out.println("Item 54 found at :"+binarySearchIterative(arr,54));
    }

    private static int binarySearchIterative(int[] arr, int item){
        Arrays.sort(arr);//array must be sorted for binary search
        int high = arr.length;
        int low =0;
        int mid ;
//        higher value is not included
        while (low<high){
          mid = (low+high)/2;
          if(item == arr[mid]){
              return mid;
          }else if(item<arr[mid]){
              high = mid;
          }else {
//              since low is included and high is not included so low will be mid+1 to include it
              low=mid+1;
          }
        }
        return -1;
    }

    private static int binarySearchRecursive(int[] arr, int item){
        return binarySearch(arr,0,arr.length,item);
    }
    private static int binarySearch(int []arr,int low,int high,int item){
        if(low>=high){
            return -1;
        }
        int mid= (low+high)/2;
        if(arr[mid]==item){
            return mid;
        }else if(arr[mid]> item){
            return binarySearch(arr,0,mid,item);
        }else {
            return binarySearch(arr,mid+1,high,item);
        }
    }
}
