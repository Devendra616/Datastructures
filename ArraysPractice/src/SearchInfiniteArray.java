/*
    Suppose you have a sorted array of infinite numbers, how would you search an element in the array?
    Let low be pointing to 1st element and high pointing to 2nd element of array, Now compare key with high index element,
->if it is greater than high index element then copy high index in low index and double the high index.
->if it is smaller, then apply binary search on high and low indices found.
 */
public class SearchInfiniteArray {
    public static void main(String[] args) {
        int arr[] = {2,3,4,5,8,9,10,12,15,18,20,28,30};
        int search = 8;
        int pos = binarySearch(arr,0,1,search);

        if(pos == -1){
            System.out.println("Element "+search+" not found ");
        } else{
            System.out.println("Element "+search+" found at "+pos);

        }

    }

    static int binarySearch(int []arr,int low, int high, int e){

        if(e < arr[low]){
            return  -1;
        }

        if(e > arr[high]){
            low = high+1;
            high = 2*high;
        }
        else {
            int mid = (low+high)/2;
            if(arr[mid] == e){
                return mid;
            }else if(e > arr[mid]){
                low = mid+1;
            } else{
                high = mid-1;
            }
        }
        return binarySearch(arr,low,high,e);
    }
}
